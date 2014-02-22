package com.andy.routes.utils;

import android.content.Context;
import android.widget.Toast;

public class Utilities
{
    public static void showShortToast(Context context, String message) {
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public static void showLongToast(Context context, String message) {
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        toast.show();
    }
}
