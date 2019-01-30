package com.wuc.store.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by CWQ on 2017/6/4.
 */

public class AppInfoDetail extends AppInfo {


    /**
     * appTags : []
     * categoryId : 15,19
     * changeLog : 【全新内容】
     * detailHeaderImage :
     * introduction : 《王者荣耀》
     * keyWords : ;王者;荣耀;王者荣耀;moba;超神;lol
     * permissionIds : 1,2,6,8,30,31,35,38,40,44,46,53,67,74,81,82,86,100,102,104,114,119,120,141,144,145,154
     * ratingScore : 3.5
     * web :
     */

    private String categoryId;
    private String changeLog;
    private String detailHeaderImage;
    private String introduction;
    private String keyWords;
    private String permissionIds;
    private double ratingScoreX;
    private String web;

    private List<AppInfo> sameDevAppInfoList;
    private List<AppInfo> relateAppInfoList;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getChangeLog() {
        return changeLog;
    }

    public void setChangeLog(String changeLog) {
        this.changeLog = changeLog;
    }

    public String getDetailHeaderImage() {
        return detailHeaderImage;
    }

    public void setDetailHeaderImage(String detailHeaderImage) {
        this.detailHeaderImage = detailHeaderImage;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(String permissionIds) {
        this.permissionIds = permissionIds;
    }

    public double getRatingScoreX() {
        return ratingScoreX;
    }

    public void setRatingScoreX(double ratingScoreX) {
        this.ratingScoreX = ratingScoreX;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public List<AppInfo> getSameDevAppInfoList() {
        return sameDevAppInfoList;
    }

    public void setSameDevAppInfoList(List<AppInfo> sameDevAppInfoList) {
        this.sameDevAppInfoList = sameDevAppInfoList;
    }

    public List<AppInfo> getRelateAppInfoList() {
        return relateAppInfoList;
    }

    public void setRelateAppInfoList(List<AppInfo> relateAppInfoList) {
        this.relateAppInfoList = relateAppInfoList;
    }
}
