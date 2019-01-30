package com.wuc.store.common;

import android.app.Application;
import android.view.View;

import com.blankj.utilcode.util.Utils;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * @author: wuchao
 * @date: 2018/10/27 11:48
 * @desciption:
 */
public class AppApplication extends Application {

    private static AppApplication instance;

    public static AppApplication getContext() {
        return instance;
    }

    private View mView;

    public View getView() {
        return mView;
    }

    public void setView(View view) {
        mView = view;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Utils.init(this);
        Logger.addLogAdapter(new AndroidLogAdapter());
    }
}
