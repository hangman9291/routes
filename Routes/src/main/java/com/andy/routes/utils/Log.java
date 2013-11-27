package com.andy.routes.utils;

public class Log
{
    public static void info(String className, String message)
    {
        android.util.Log.i(className, message);
    }
}
