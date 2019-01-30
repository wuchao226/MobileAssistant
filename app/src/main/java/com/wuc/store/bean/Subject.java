package com.wuc.store.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by CWQ on 2017/6/14.
 */

public class Subject implements Parcelable {

    /**
     * adType : 0
     * ads : 0
     * adsType : 0
     * displayType : 0
     * external : false
     * featuredType : 2
     * h5BigIcon : AppStore/0a9d147895976e344062e88bde984f59b8640640a
     * id : 3129
     * info :
     * listApp : []
     * mtDisplayEffect : 0
     * mtPosition : 0
     * mticon : AppStore/0c117f42002474a9c2f7db400a843d17550adac8e
     * mticonHigh : 0
     * mticonWidth : 0
     * position : 0
     * priority : 12
     * rId : 0
     * relatedId : 168553
     * title : 文艺值up
     * uid : 8a259
     * updateTime : 0
     * webViewPicHeight : 0
     * webViewPicWidth : 0
     */

    private int adType;
    private int ads;
    private int adsType;
    private int displayType;
    private boolean external;
    private int featuredType;
    private String h5BigIcon;
    private int id;
    private String info;
    private int mtDisplayEffect;
    private int mtPosition;
    private String mticon;
    private int mticonHigh;
    private int mticonWidth;
    private int position;
    private int priority;
    private int rId;
    private int relatedId;
    private String title;
    private String uid;
    private int updateTime;
    private int webViewPicHeight;
    private int webViewPicWidth;

    public int getAdType() {
        return adType;
    }

    public void setAdType(int adType) {
        this.adType = adType;
    }

    public int getAds() {
        return ads;
    }

    public void setAds(int ads) {
        this.ads = ads;
    }

    public int getAdsType() {
        return adsType;
    }

    public void setAdsType(int adsType) {
        this.adsType = adsType;
    }

    public int getDisplayType() {
        return displayType;
    }

    public void setDisplayType(int displayType) {
        this.displayType = displayType;
    }

    public boolean isExternal() {
        return external;
    }

    public void setExternal(boolean external) {
        this.external = external;
    }

    public int getFeaturedType() {
        return featuredType;
    }

    public void setFeaturedType(int featuredType) {
        this.featuredType = featuredType;
    }

    public String getH5BigIcon() {
        return h5BigIcon;
    }

    public void setH5BigIcon(String h5BigIcon) {
        this.h5BigIcon = h5BigIcon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getMtDisplayEffect() {
        return mtDisplayEffect;
    }

    public void setMtDisplayEffect(int mtDisplayEffect) {
        this.mtDisplayEffect = mtDisplayEffect;
    }

    public int getMtPosition() {
        return mtPosition;
    }

    public void setMtPosition(int mtPosition) {
        this.mtPosition = mtPosition;
    }

    public String getMticon() {
        return mticon;
    }

    public void setMticon(String mticon) {
        this.mticon = mticon;
    }

    public int getMticonHigh() {
        return mticonHigh;
    }

    public void setMticonHigh(int mticonHigh) {
        this.mticonHigh = mticonHigh;
    }

    public int getMticonWidth() {
        return mticonWidth;
    }

    public void setMticonWidth(int mticonWidth) {
        this.mticonWidth = mticonWidth;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getRId() {
        return rId;
    }

    public void setRId(int rId) {
        this.rId = rId;
    }

    public int getRelatedId() {
        return relatedId;
    }

    public void setRelatedId(int relatedId) {
        this.relatedId = relatedId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(int updateTime) {
        this.updateTime = updateTime;
    }

    public int getWebViewPicHeight() {
        return webViewPicHeight;
    }

    public void setWebViewPicHeight(int webViewPicHeight) {
        this.webViewPicHeight = webViewPicHeight;
    }

    public int getWebViewPicWidth() {
        return webViewPicWidth;
    }

    public void setWebViewPicWidth(int webViewPicWidth) {
        this.webViewPicWidth = webViewPicWidth;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.adType);
        dest.writeInt(this.ads);
        dest.writeInt(this.adsType);
        dest.writeInt(this.displayType);
        dest.writeByte(this.external ? (byte) 1 : (byte) 0);
        dest.writeInt(this.featuredType);
        dest.writeString(this.h5BigIcon);
        dest.writeInt(this.id);
        dest.writeString(this.info);
        dest.writeInt(this.mtDisplayEffect);
        dest.writeInt(this.mtPosition);
        dest.writeString(this.mticon);
        dest.writeInt(this.mticonHigh);
        dest.writeInt(this.mticonWidth);
        dest.writeInt(this.position);
        dest.writeInt(this.priority);
        dest.writeInt(this.rId);
        dest.writeInt(this.relatedId);
        dest.writeString(this.title);
        dest.writeString(this.uid);
        dest.writeInt(this.updateTime);
        dest.writeInt(this.webViewPicHeight);
        dest.writeInt(this.webViewPicWidth);
    }

    public Subject() {
    }

    protected Subject(Parcel in) {
        this.adType = in.readInt();
        this.ads = in.readInt();
        this.adsType = in.readInt();
        this.displayType = in.readInt();
        this.external = in.readByte() != 0;
        this.featuredType = in.readInt();
        this.h5BigIcon = in.readString();
        this.id = in.readInt();
        this.info = in.readString();
        this.mtDisplayEffect = in.readInt();
        this.mtPosition = in.readInt();
        this.mticon = in.readString();
        this.mticonHigh = in.readInt();
        this.mticonWidth = in.readInt();
        this.position = in.readInt();
        this.priority = in.readInt();
        this.rId = in.readInt();
        this.relatedId = in.readInt();
        this.title = in.readString();
        this.uid = in.readString();
        this.updateTime = in.readInt();
        this.webViewPicHeight = in.readInt();
        this.webViewPicWidth = in.readInt();
    }

    public static final Creator<Subject> CREATOR = new Creator<Subject>() {
        @Override
        public Subject createFromParcel(Parcel source) {
            return new Subject(source);
        }

        @Override
        public Subject[] newArray(int size) {
            return new Subject[size];
        }
    };
}
