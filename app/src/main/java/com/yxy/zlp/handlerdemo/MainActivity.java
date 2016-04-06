package com.yxy.zlp.handlerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private ThreadLocal<Integer> mIntegerThreadLocal = new ThreadLocal<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIntegerThreadLocal.set(0);
        Log.d(TAG, "In Main Thread, mIntegerThreadLocal = " + mIntegerThreadLocal.get());

        new Thread("Thread 1") {
            @Override
            public void run(){
                mIntegerThreadLocal.set(1);
                Log.d(TAG, "In Thread 1, mIntegerThreadLocal = " + mIntegerThreadLocal.get());
            }
        }.start();

        new Thread("Thread 2") {
            @Override
            public void run() {
                Log.d(TAG, "In Thread 2, mIntegerThreadLocal = " + mIntegerThreadLocal.get());
            }
        }.start();

    }



}
