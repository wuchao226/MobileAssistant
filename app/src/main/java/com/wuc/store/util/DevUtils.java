package com.wuc.store.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;

import com.blankj.utilcode.util.Utils;

import java.util.Locale;

/**
 * @author: wuchao
 * @date: 2018/11/2 11:35
 * @desciption: 设备相关工具类
 */
public class DevUtils {

    /**
     * 获取唯一标识码
     */
    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String getIMEI() {
        TelephonyManager tm =
                (TelephonyManager) Utils.getApp().getSystemService(Context.TELEPHONY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //noinspection ConstantConditions
            return tm.getImei();
        }
        //noinspection ConstantConditions
        return tm.getDeviceId();
    }

    /**
     * 获取手机的型号 设备名称。
     *
     * @return
     */
    public static String getModel() {
        String model = Build.MODEL;
        if (model != null) {
            model = model.trim().replaceAll("\\s*", "");
        } else {
            model = "";
        }
        return model;
    }

    /**
     * 获取当前系统语言
     *
     * @return
     */
    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    /**
     * 源码控制版本号
     *
     * @return
     */
    public static String getBuildVersionIncremental() {
        return Build.VERSION.INCREMENTAL;
    }

    /**
     * SDK版本号
     *
     * @return
     */
    public static int getBuildVersionSDK() {
        return Build.VERSION.SDK_INT;
    }
}
