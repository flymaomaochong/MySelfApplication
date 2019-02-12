package com.seleapplication.example.myselfapplication.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.seleapplication.example.myselfapplication.BaseActivity;
import com.seleapplication.example.myselfapplication.R;
import com.seleapplication.example.myselfapplication.utils.CommonUtils;

import java.io.File;

public class PhotoActivity extends BaseActivity implements View.OnClickListener{

    private TextView tv_take;
    private TextView tv_album;
    private ImageView iv_picture;


    @Override
    protected int getResLayout() {
        return R.layout.activity_photo;



    }

    @Override
    protected void initView() {
        tv_take =(TextView)findViewById(R.id.tv_take);
        tv_album =(TextView)findViewById(R.id.tv_album);
        iv_picture =(ImageView)findViewById(R.id.iv_picture);
    }

    @Override
    protected void initEvent() {
        checkPermission();
        tv_take.setOnClickListener(this);
        tv_album.setOnClickListener(this);


    }


    private class Animal{
       protected String name;
        protected int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    private class Dog extends Animation {
        protected String name;
        protected int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }



    }







    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_take:
                takePhoto();
                break;
            case R.id.tv_album:
                openAlbum();
                break;
        }
    }
    private boolean checkPermission(){
        if(Build.VERSION.SDK_INT>23){
            if(ActivityCompat.checkSelfPermission(mContext, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(mActivity,new String[]{Manifest.permission.CAMERA},100);
                return false;
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==100&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
            CommonUtils.showToast(mContext,"您已经获得拍照权限");
        }
    }

    private void takePhoto(){
        if(!checkPermission()){
            CommonUtils.showToast(mContext,"请授予权限");
            return;
        }
        Intent intent_camera=new Intent();
//        intent_camera.setType("image/*");
//        intent_camera.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent_camera.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        intent_camera.putExtra(MediaStore.EXTRA_OUTPUT, Uri.parse(Environment.getExternalStorageDirectory()+ File.separator+ "tem.jpg"));//将拍取的照片保存到指定URI
        startActivityForResult(intent_camera,200);
    }

    private void openAlbum(){
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_PICK);
        intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent,100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==200){
            if(data!=null){
              Log.i("图片地址",data.getData()+"") ;
              Log.i("图片地址",data.getDataString()+"") ;

            }
        }
        if(requestCode==100){
            if(data!=null){
                Log.i("图片地址",data.getDataString()) ;
                iv_picture.setImageURI(data.getData());
            }
        }
    }

}
