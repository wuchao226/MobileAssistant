package com.wuc.store.injection.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author: wuchao
 * @date: 2018/11/9 14:22
 * @desciption: Activity级别 自定义scope限定作用域
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerScope {
}
