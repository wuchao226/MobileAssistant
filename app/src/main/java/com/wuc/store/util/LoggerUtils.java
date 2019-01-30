package com.wuc.store.util;

import com.orhanobut.logger.Logger;

/**
 * @author: wuchao
 * @date: 2018/10/29 10:59
 * @desciption: Logger日志拦截封装
 */
public class LoggerUtils {

    private static final int VERBOSE = 1;
    private static final int DEBUG = 2;
    private static final int INFO = 3;
    private static final int WARN = 4;
    private static final int ERROR = 5;
    private static final int NOTHING = 6;

    //控制log等级
    private static int LEVEL = VERBOSE;

    public static void v(String tag, String message) {
        if (LEVEL <= VERBOSE) {
            Logger.t(tag).v(message);
        }
    }

    public static void v(String message) {
        if (LEVEL <= VERBOSE) {
            Logger.v(message);
        }
    }


    public static void d(String tag, Object message) {
        if (LEVEL <= DEBUG) {
            Logger.t(tag).d(message);
        }
    }

    public static void d(Object message) {
        if (LEVEL <= DEBUG) {
            Logger.d(message);
        }
    }

    public static void i(String tag, String message) {
        if (LEVEL <= INFO) {
            Logger.t(tag).i(message);
        }
    }

    public static void i(String message) {
        if (LEVEL <= INFO) {
            Logger.i(message);
        }
    }

    public static void w(String tag, String message) {
        if (LEVEL <= WARN) {
            Logger.t(tag).w(message);
        }
    }

    public static void w(String message) {
        if (LEVEL <= WARN) {
            Logger.w(message);
        }
    }

    public static void json(String tag, String message) {
        if (LEVEL <= WARN) {
            Logger.t(tag).json(message);
        }
    }

    public static void json(String message) {
        if (LEVEL <= WARN) {
            Logger.json(message);
        }
    }

    public static void e(String tag, String message) {
        if (LEVEL <= ERROR) {
            Logger.t(tag).e(message);
        }
    }

    public static void e(String message) {
        if (LEVEL <= ERROR) {
            Logger.e(message);
        }
    }
}
