package com.example.administrator.photosflicker.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.administrator.photosflicker.utils.Constants;

import java.text.MessageFormat;

/**
 * Created by Administrator on 24.12.2016.
 */

public class Photo implements Parcelable {

    private long id;
    private String secret;
    private int server;
    private int farm;
    private String title;
    private int isprimary;
    private int ispublic;
    private int isfriend;
    private int isfamily;

    protected Photo(Parcel in) {
        id = in.readLong();
        secret = in.readString();
        server = in.readInt();
        farm = in.readInt();
        title = in.readString();
        isprimary = in.readInt();
        ispublic = in.readInt();
        isfriend = in.readInt();
        isfamily = in.readInt();
    }

    public static final Creator<Photo> CREATOR = new Creator<Photo>() {
        @Override
        public Photo createFromParcel(Parcel in) {
            return new Photo(in);
        }

        @Override
        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };

    public String composeUrl() {
        return String.format(Constants.PHOTOS_URL, farm, server, id, secret, Constants.LARGE_SIZE);
    }

    public long getId() {
        return id;
    }

    public String getSecret() {
        return secret;
    }

    public int getServer() {
        return server;
    }

    public int getFarm() {
        return farm;
    }

    public String getTitle() {
        return title;
    }

    public int getIsprimary() {
        return isprimary;
    }

    public int getIspublic() {
        return ispublic;
    }

    public int getIsfriend() {
        return isfriend;
    }

    public int getIsfamily() {
        return isfamily;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", secret='" + secret + '\'' +
                ", server=" + server +
                ", farm=" + farm +
                ", title='" + title + '\'' +
                ", isprimary=" + isprimary +
                ", ispublic=" + ispublic +
                ", isfriend=" + isfriend +
                ", isfamily=" + isfamily +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(secret);
        dest.writeInt(server);
        dest.writeInt(farm);
        dest.writeString(title);
        dest.writeInt(isprimary);
        dest.writeInt(ispublic);
        dest.writeInt(isfriend);
        dest.writeInt(isfamily);
    }
}
