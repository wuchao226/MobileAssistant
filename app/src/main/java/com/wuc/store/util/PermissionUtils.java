package com.wuc.store.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.Observable;

/**
 * @author: wuchao
 * @date: 2018/11/29 17:53
 * @desciption:
 */
public class PermissionUtils {

    public static Observable<Boolean> requestPermission(FragmentActivity activity, String... permission) {
        RxPermissions rxPermissions = new RxPermissions(activity);
        return rxPermissions.request(permission);
    }

    public static Observable<Boolean> requestPermission(Fragment fragment, String... permission) {
        RxPermissions rxPermissions = new RxPermissions(fragment);
        return rxPermissions.request(permission);
    }
}
