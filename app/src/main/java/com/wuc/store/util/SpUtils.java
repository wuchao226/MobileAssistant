package com.wuc.store.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.alibaba.fastjson.JSON;
import com.wuc.store.common.Constant;

/**
 * @author: wuchao
 * @date: 2018/11/2 13:44
 * @desciption: SP 工具类
 */
public class SpUtils {
    /**
     * 提示：
     * Activity.getPreferences(int model)生成 Activity名.xml  用于Activity内部存储
     * PreferenceManager.getDefaultSharedPreferences(Context)生成 包名_preferences.xml
     * Context.getSharedPreferences(String name,int model)生成name.xml
     */
    private static SharedPreferences mPreferences =
            UiUtils.getContext().getSharedPreferences(Constant.TABLE_PREFS, Context.MODE_PRIVATE);

    private static SharedPreferences.Editor mEditor = mPreferences.edit();

    /*
     * 向SP存入指定key对应的数据
     * 其中value可以是String、boolean、float、int、long等各种基本类型的值
     */

    public static void putBoolean(String key, boolean value) {
        mEditor.putBoolean(key, value);
        mEditor.commit();
    }

    public static void putFloat(String key, float value) {
        mEditor.putFloat(key, value);
        mEditor.commit();
    }

    public static void putInt(String key, int value) {
        mEditor.putInt(key, value);
        mEditor.commit();
    }

    public static void putLong(String key, long value) {
        mEditor.putLong(key, value);
        mEditor.commit();
    }

    /**
     * 存储json对象
     *
     * @param key
     * @param object
     */
    public static void putObject(String key, Object object) {
        String jsonStr = JSON.toJSONString(object);
        putString(key, jsonStr);
    }

    public static void putString(String key, String value) {
        mEditor.putString(key, value);
        mEditor.commit();
    }

    /**
     * 清空SP里所以数据
     */
    public static void clear() {
        mEditor.clear();
        mEditor.commit();
    }

    /**
     * 删除SP里指定key对应的数据项
     *
     * @param key
     */
    public static void remove(String key) {
        mEditor.remove(key);
        mEditor.commit();
    }

    public static boolean getBoolean(String key, boolean defValue) {
        return mPreferences.getBoolean(key, defValue);
    }

    public static boolean getBoolean(String key) {
        return mPreferences.getBoolean(key, false);
    }

    public static float getFloat(String key, float defValue) {
        return mPreferences.getFloat(key, defValue);
    }

    public static int getInt(String key, int defValue) {
        return mPreferences.getInt(key, defValue);
    }

    public static long getLong(String key, long defValue) {
        return mPreferences.getLong(key, defValue);
    }

    /**
     * 通过类名获取对象
     *
     * @param key
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T getObject(String key, Class<T> tClass) {
        String jsonStr = getString(key, "");
        if (!"".equals(jsonStr)) {
            return JSON.parseObject(jsonStr, tClass);
        } else {
            return null;
        }
    }

    /**
     * 获取SP数据里指定key对应的value。如果key不存在，则返回默认值defValue。
     *
     * @param key
     * @param defValue
     * @return
     */
    public static String getString(String key, String defValue) {
        return mPreferences.getString(key, defValue);
    }

    public static String getString(String key) {
        return mPreferences.getString(key, "");
    }

    /**
     * 判断SP是否包含特定key的数据
     *
     * @param key
     * @return
     */
    public static boolean contains(String key) {
        return mPreferences.contains(key);
    }
}
