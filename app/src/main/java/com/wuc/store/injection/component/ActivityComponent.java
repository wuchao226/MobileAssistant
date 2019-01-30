package com.wuc.store.injection.component;

import android.app.Activity;
import android.content.Context;

import com.wuc.store.injection.module.ActivityModule;
import com.wuc.store.injection.scope.ActivityScope;

import dagger.Component;

/**
 * @author: wuchao
 * @date: 2018/11/8 23:10
 * @desciption: Activity级别Component
 */
@ActivityScope
@Component(modules = ActivityModule.class, dependencies = AppComponent.class)
public interface ActivityComponent {

    /**
     * Activity
     *
     * @return Activity
     */
    Activity getActivity();

    /**
     * 获取全局的context
     *
     * @return context
     */
    Context getContext();
}
