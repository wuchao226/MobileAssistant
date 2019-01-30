package com.wuc.store.bean;

import java.util.List;

/**
 * Created by CWQ on 2017/6/14.
 */

public class SubjectDetail {

    private String phoneBigIcon;

    private List<AppInfo> listApp;

    public String getPhoneBigIcon() {
        return phoneBigIcon;
    }

    public void setPhoneBigIcon(String phoneBigIcon) {
        this.phoneBigIcon = phoneBigIcon;
    }

    public List<AppInfo> getListApp() {
        return listApp;
    }

    public void setListApp(List<AppInfo> listApp) {
        this.listApp = listApp;
    }
}
