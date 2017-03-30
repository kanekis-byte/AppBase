package com.taohf.appbase.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.taohf.appbase.R;

/**
 * 跟状态栏一致的View
 * Created by hongfei.tao on 2017/3/30 19:31.
 */
public class StatusBarView extends View {

    private Paint mPaint;
    @ColorInt
    private int mDefaultColor = ContextCompat.getColor(getContext(), R.color.colorPrimaryDark);
    private int mWidth;
    private int mHeight;

    public StatusBarView(Context context) {
        super(context);
    }

    public StatusBarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StatusBarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private int getSize(int defaultSize, int measureSpec) {
        int size = defaultSize;

        int mode = MeasureSpec.getMode(measureSpec);
        int measureSize = MeasureSpec.getSize(measureSpec);

        switch (mode) {
            case MeasureSpec.UNSPECIFIED:
            case MeasureSpec.AT_MOST:
                size = getStatusHeight();
                break;
            case MeasureSpec.EXACTLY:
                size = measureSize;
                break;
        }

        return size;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        mWidth = getSize(getResources().getDisplayMetrics().widthPixels, widthMeasureSpec);
        mHeight = getSize(getStatusHeight(), heightMeasureSpec);

        setMeasuredDimension(mWidth, mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mPaint == null)
            mPaint = new Paint();

        mPaint.setColor(mDefaultColor);

        canvas.drawRect(0, 0, mWidth, mHeight, mPaint);
    }

    private int getStatusHeight() {
        Resources resources = Resources.getSystem();
        int resId = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (resId > 0)
            return resources.getDimensionPixelSize(resId);

        return 0;
    }

    /**
     * 设置这一块view的颜色
     *
     * @param resId 资源ID
     */
    public void setStatusBarColor(@ColorRes int resId) {
        mDefaultColor = ContextCompat.getColor(getContext(), resId);

        postInvalidate();
    }

}
