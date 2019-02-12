package com.seleapplication.example.myselfapplication.activity;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.seleapplication.example.myselfapplication.BaseActivity;
import com.seleapplication.example.myselfapplication.R;

public class ToastActivity extends BaseActivity implements View.OnClickListener{


    private TextView tv_common_toast;
    private TextView tv_picture_toast;

    @Override
    protected int getResLayout() {
        return R.layout.activity_toast;
    }

    @Override
    protected void initView() {
        tv_common_toast =(TextView)findViewById(R.id.tv_common_toast);
        tv_picture_toast =(TextView)findViewById(R.id.tv_picture_toast);
    }

    @Override
    protected void initEvent() {
        tv_common_toast.setOnClickListener(this);
        tv_picture_toast.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_common_toast:
                Toast.makeText(mContext,"普通吐司",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_picture_toast:

                break;
        }

    }


}
