package com.ttrpstudio.ttool.util;

import android.content.Context;

import com.ttrpstudio.ttool.act.AppMain;

/**
 * Created by TOKYONTH on 2018/4/24/024.
 */

public class Dip2px {
    public static int Dip2px(float dpValue, Context context) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
