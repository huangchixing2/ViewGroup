package com.example.viewgroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

/**
 * 1 验证事件传递流程
 * 2 验证cancel事件
 * 3 验证viewgroup事件拦截
 *
 */

/**
 * 事件默认传递流程
 * MainActivity: dispatchTouchEvent -> MyViewGroup: dispatchTouchEvent -> MyViewGroup: onInterceptTouchEvent
 * -> MyView: dispatchTouchEvent-> MyView :onTouchEvent -> MyViewGroup:onTouchEvent->
 * MainActivity: onTouchEvent
 *
 * 同一事件序列，如果子view（包括viewgroup）没有处理该事件（没有消费事件）那么后续事件就不会再传递到子
 * view中
 * MainActivity: dispatchTouchEvent -> MainActivity:onTouchEvent
 *
 */

public class MainActivity extends AppCompatActivity {

    public static final String LOG = "TouchDemo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("hcx", "onCreate: MainActivity------");
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("hcx", " MainActivity---dispatchTouchEvent---");
        Log.d(LOG, "MainActivity: dispatchTouchEvent: ");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(LOG, "MainActivity: onTouchEvent: ");
        return super.onTouchEvent(event);
    }
}
