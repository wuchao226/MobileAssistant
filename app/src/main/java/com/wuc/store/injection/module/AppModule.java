package com.wuc.store.injection.module;

import android.content.Context;

import com.wuc.store.common.AppApplication;

import dagger.Module;
import dagger.Provides;

/**
 * @author: wuchao
 * @date: 2018/11/8 23:04
 * @desciption: Application 级别 module
 */
@Module
public class AppModule {
    private AppApplication mApplication;

    public AppModule(AppApplication application) {
        this.mApplication = application;
    }

    @Provides
    public Context provideAppContext() {
        return mApplication.getApplicationContext();
    }
}
