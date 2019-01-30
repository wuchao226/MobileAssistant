package com.wuc.store.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/**
 * Created by CWQ on 2017/6/7.
 */

public class AppDownloadInfo implements Parcelable {

    private String host;
    private String apk;

    private String downloadUrl;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getApk() {
        return apk;
    }

    public void setApk(String apk) {
        this.apk = apk;
    }

    public String getDownloadUrl() {
        downloadUrl = TextUtils.isEmpty(downloadUrl) ? this.getHost() + this.getApk() : downloadUrl;
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.host);
        dest.writeString(this.apk);
        dest.writeString(this.downloadUrl);
    }

    public AppDownloadInfo() {
    }

    protected AppDownloadInfo(Parcel in) {
        this.host = in.readString();
        this.apk = in.readString();
        this.downloadUrl = in.readString();
    }

    public static final Creator<AppDownloadInfo> CREATOR = new Creator<AppDownloadInfo>() {
        @Override
        public AppDownloadInfo createFromParcel(Parcel source) {
            return new AppDownloadInfo(source);
        }

        @Override
        public AppDownloadInfo[] newArray(int size) {
            return new AppDownloadInfo[size];
        }
    };
}
