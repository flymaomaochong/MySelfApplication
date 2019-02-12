package com.seleapplication.example.myselfapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by 13653 on 2019/1/18.
 */

public abstract class BaseActivity extends Activity {
    protected Context mContext;
    protected Activity mActivity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResLayout());
        this.mContext=getBaseContext();
        this.mActivity=BaseActivity.this;
        Log.i("声明周期","onCreate");
        initView();
        initEvent();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("声明周期","onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("声明周期","onStart");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("声明周期","onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("声明周期","onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("声明周期","onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("声明周期","onDestroy");
    }

    protected abstract void initView();
    protected abstract void initEvent();
    protected  abstract int getResLayout();
}
