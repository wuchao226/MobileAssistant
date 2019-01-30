package com.wuc.store.bean.requestbean;

/**
 * Created by CWQ on 2017/6/13.
 */

public class AppUpdateParam {

    private String packageName;
    private String versionCode;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }
}
