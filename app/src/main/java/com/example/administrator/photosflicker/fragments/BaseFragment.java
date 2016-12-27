package com.example.administrator.photosflicker.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.administrator.photosflicker.interfaces.RequestListener;
import com.example.administrator.photosflicker.interfaces.RestAPI;
import com.example.administrator.photosflicker.utils.RestAPICommunicator;

/**
 * Created by Administrator on 26.12.2016.
 */

public class BaseFragment extends Fragment {

    protected RequestListener requestListener;
    protected RestAPI calls;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        calls = RestAPICommunicator.getInstance().getCalls();
        requestListener = (RequestListener) getActivity();

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        /**
         * Setting empty click to avoid clicking on fragments laying under current
         */
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // do nothing
            }
        });
    }
}
