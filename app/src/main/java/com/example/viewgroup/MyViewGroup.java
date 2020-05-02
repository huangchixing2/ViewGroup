package com.example.viewgroup;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/**
 * 1 去判断是否需要拦截事件
 *
 * 2 在当前ViewGroup中找到用户真正点击的view
 *
 * 3 分发事件到view上
 */

/**
 * Created by Administrator on 2020/5/2.
 */
public class MyViewGroup extends FrameLayout {
    public MyViewGroup(@NonNull Context context) {
        super(context);
    }

    public MyViewGroup(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewGroup(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyViewGroup(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(MainActivity.LOG, "MyViewGroup: dispatchTouchEvent: ");
        super.dispatchTouchEvent(ev);
        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(MainActivity.LOG, "MyViewGroup: onInterceptTouchEvent: ");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(MainActivity.LOG, "MyViewGroup: onTouchEvent: ");
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d(MainActivity.LOG, "MyViewGroup: onTouchEvent: 手指按下");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d(MainActivity.LOG, "MyViewGroup: onTouchEvent: 手指移动");
                break;
            case MotionEvent.ACTION_UP:
                Log.d(MainActivity.LOG, "MyViewGroup: onTouchEvent: 手指抬起");
                break;
        }
        super.onTouchEvent(event);
        return true;
    }
}
