package com.example.administrator.photosflicker.utils;

import com.example.administrator.photosflicker.PhotosFlickerApp;
import com.example.administrator.photosflicker.R;
import com.example.administrator.photosflicker.interfaces.RestAPI;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 24.12.2016.
 */

public class RestAPICommunicator {


    private Retrofit retrofit;
    private static RestAPICommunicator newInstance;
    private RestAPICommunicator () {
        init();
    }

    private void init() {

        final String userId = PhotosFlickerApp.getAppContext().getString(R.string.user_id);
        final String apiKey = PhotosFlickerApp.getAppContext().getString(R.string.api_key);

        Interceptor additionalQueriesInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                HttpUrl url = request.url()
                        .newBuilder()
                        .addQueryParameter(Constants.USER_ID, userId)
                        .addQueryParameter(Constants.API_KEY, apiKey)
                        .addQueryParameter(Constants.FORMAT, Constants.JSON)
                        .addQueryParameter(Constants.NO_JSON_CALLBACK, "1")
                        .build();

                request = request
                        .newBuilder()
                        .url(url)
                        .build();

                return chain.proceed(request);
            }
        };

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(additionalQueriesInterceptor)
                .build();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.END_POINT)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static RestAPICommunicator getInstance() {
        if(newInstance == null) {
            newInstance = new RestAPICommunicator();
        }
        return newInstance;
    }

    public RestAPI getCalls() {
       return retrofit.create(RestAPI.class);
    }

}
