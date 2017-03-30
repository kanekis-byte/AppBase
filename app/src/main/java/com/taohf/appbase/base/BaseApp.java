package com.taohf.appbase.base;

import android.app.Application;
import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Application
 * Created by hongfei.tao on 2017/3/30 19:14.
 */
public class BaseApp extends Application {

    private static BaseApp sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static BaseApp getInstance() {
        return sInstance;
    }

    /**
     * 将相对值转换成像素值
     */
    public int dip2px(int dip) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, getResources().getDisplayMetrics());
    }

    /**
     * 获取手机的状态栏高度
     */
    public int getStatusHeight() {
        Resources resources = Resources.getSystem();
        int resId = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (resId > 0)
            return resources.getDimensionPixelSize(resId);

        return 0;
    }


}
