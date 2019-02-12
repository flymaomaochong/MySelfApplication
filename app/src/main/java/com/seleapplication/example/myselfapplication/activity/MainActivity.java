package com.seleapplication.example.myselfapplication.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.seleapplication.example.myselfapplication.BaseActivity;
import com.seleapplication.example.myselfapplication.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv_storage, tv_photo, tv_net, tv_adapter,
            tv_layout, tv_database, tv_self_widget;

    @Override
    protected int getResLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        tv_storage = (TextView) findViewById(R.id.tv_storage);
        tv_photo = (TextView) findViewById(R.id.tv_photo);
        tv_net = (TextView) findViewById(R.id.tv_net);
        tv_adapter = (TextView) findViewById(R.id.tv_adapter);
        tv_layout = (TextView) findViewById(R.id.tv_layout);
        tv_database = (TextView) findViewById(R.id.tv_database);
        tv_self_widget = (TextView) findViewById(R.id.tv_self_widget);


    }

    @Override
    protected void initEvent() {
        tv_storage.setOnClickListener(this);
        tv_photo.setOnClickListener(this);
        tv_net.setOnClickListener(this);
        tv_adapter.setOnClickListener(this);
        tv_layout.setOnClickListener(this);
        tv_database.setOnClickListener(this);
        tv_self_widget.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_storage:
                Intent intent_storage=new Intent(mContext,StorageActivity.class);
                startActivity(intent_storage);
                break;
            case R.id.tv_photo:
                Intent intent_photo=new Intent(mContext,PhotoActivity.class);
                startActivity(intent_photo);
                break;
            case R.id.tv_net:
                break;
            case R.id.tv_adapter:
                break;
            case R.id.tv_layout:
                break;
            case R.id.tv_database:
                break;
            case R.id.tv_self_widget:
                break;

        }
    }
}
