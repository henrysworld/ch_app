package com.ch.ch_library.utils;

import android.util.Log;

/**
 * Created by chenhe on 2015/10/21.
 */
public class CLog {
    /**
     * This flag to indicate the log is enabled or disabled.
     * by:chenhe at:2015/10/21
     */
    private static boolean isLogEnable = true;

    /**
     * Disable the log output.
     * by:chenhe at:2015/10/21
     */
    public static void disableLog() {
        isLogEnable = false;
    }

    /**
     * Enable the log output.
     * by:chenhe at:2015/10/21
     */
    public static void enableLog() {
        isLogEnable = true;
    }

    /**
     * Debug
     * by:chenhe at:2015/10/21
     *
     * @param tag
     * @param msg
     */
    public static void d(String tag, String msg) {
        if (isLogEnable) {
            StackTraceElement stackTraceElement = java.lang.Thread.currentThread().getStackTrace()[3];
            Log.d(tag, rebuildMsg(stackTraceElement, msg));
        }
    }

    /**
     * Information
     * by:chenhe at:2015/10/21
     *
     * @param tag
     * @param msg
     */
    public static void i(String tag, String msg) {
        if (isLogEnable) {
            StackTraceElement stackTraceElement = java.lang.Thread.currentThread().getStackTrace()[3];
            Log.i(tag, rebuildMsg(stackTraceElement, msg));
        }
    }

    /**
     * Verbose
     * by:chenhe at:2015/10/21
     *
     * @param tag
     * @param msg
     */
    public static void v(String tag, String msg) {
        if (isLogEnable) {
            StackTraceElement stackTraceElement = java.lang.Thread.currentThread().getStackTrace()[3];
            Log.v(tag, rebuildMsg(stackTraceElement, msg));
        }
    }

    /**
     * Warning
     * by:chenhe at:2015/10/21
     *
     * @param tag
     * @param msg
     */
    public static void w(String tag, String msg) {
        if (isLogEnable) {
            StackTraceElement stackTraceElement = java.lang.Thread.currentThread().getStackTrace()[3];
            Log.w(tag, rebuildMsg(stackTraceElement, msg));
        }
    }

    /**
     * Error
     * by:chenhe at:2015/10/21
     *
     * @param tag
     * @param msg
     */
    public static void e(String tag, String msg) {
        if (isLogEnable) {
            StackTraceElement stackTraceElement = java.lang.Thread.currentThread().getStackTrace()[3];
            Log.e(tag, rebuildMsg(stackTraceElement, msg));
        }
    }

    /**
     * Rebuild Log Msg
     * by:chenhe at:2015/10/21
     *
     * @param msg
     * @return
     */
    private static String rebuildMsg(StackTraceElement stackTraceElement, String msg) {
        StringBuffer sb = new StringBuffer();
        sb.append(stackTraceElement.getFileName());
        sb.append(" (");
        sb.append(stackTraceElement.getLineNumber());
        sb.append(") ");
        sb.append(stackTraceElement.getMethodName());
        sb.append(": ");
        sb.append(msg);
        return sb.toString();
    }
}
