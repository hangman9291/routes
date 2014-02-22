package com.andy.routes.utils;

public class Log
{
    private static final boolean verbose = true;

    public static void info(String className, String message) {
        if (verbose)
            android.util.Log.i(className, message);
    }

    public static void ex(String className, String message, Exception e) {
        if (verbose)
            android.util.Log.e(className, message, e);
    }
}
