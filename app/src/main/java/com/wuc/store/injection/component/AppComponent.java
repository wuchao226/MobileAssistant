package com.wuc.store.injection.component;

import android.content.Context;

import com.wuc.store.injection.module.AppModule;
import com.wuc.store.injection.scope.PerScope;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author: wuchao
 * @date: 2018/11/8 23:07
 * @desciption: Application 级别 component。提供全局的单例的Context对象
 */
@Singleton
@PerScope
@Component(modules = AppModule.class)
public interface AppComponent {
    /**
     * 提供全局单例的Context对象
     *
     * @return context
     */
    Context getApplicationContext();
}
