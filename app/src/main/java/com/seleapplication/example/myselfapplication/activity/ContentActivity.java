package com.seleapplication.example.myselfapplication.activity;

import android.widget.TextView;

import com.seleapplication.example.myselfapplication.BaseActivity;
import com.seleapplication.example.myselfapplication.R;

/**
 * Created by 13653 on 2019/1/18.
 */

public class ContentActivity extends BaseActivity {

    private TextView tv_content;

    @Override
    protected int getResLayout() {
        return R.layout.activity_content;
    }

    @Override
    protected void initView() {
        tv_content = (TextView) findViewById(R.id.tv_content);
    }

    @Override
    protected void initEvent() {
        String content = getIntent().getStringExtra("content");
        tv_content.setText(content);

    }
}
