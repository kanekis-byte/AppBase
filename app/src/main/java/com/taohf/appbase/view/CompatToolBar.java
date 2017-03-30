package com.taohf.appbase.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * 填充到状态栏的ToolBar
 * Created by hongfei.tao on 2017/3/30 19:08.
 */
public class CompatToolBar extends Toolbar {

    private boolean mLayoutReady = false;

    public CompatToolBar(Context context) {
        super(context);
    }

    public CompatToolBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CompatToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        if (!mLayoutReady) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                if ((getSystemUiVisibility() & (SYSTEM_UI_FLAG_LAYOUT_STABLE | SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN))
                        == (SYSTEM_UI_FLAG_LAYOUT_STABLE | SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)) {

                    int statusHeight = getStatusHeight();
                    ViewGroup.LayoutParams layoutParams = getLayoutParams();
                    layoutParams.height = getHeight() + statusHeight;
                    setPadding(0, statusHeight, 0, 0);

                }
            }
        }
    }

    private int getStatusHeight() {
        Resources resources = Resources.getSystem();
        int resId = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (resId > 0)
            return resources.getDimensionPixelSize(resId);

        return 0;
    }

}
