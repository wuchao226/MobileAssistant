package com.wuc.store.injection.module;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * @author: wuchao
 * @date: 2018/11/8 23:01
 * @desciption: Activity 级别 module
 */
@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    public Activity provideActivity() {
        return mActivity;
    }
}
