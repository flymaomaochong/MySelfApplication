package com.seleapplication.example.myselfapplication.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by 13653 on 2019/1/18.
 */

public class CommonUtils {
    public static void showToast(Context context,String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }



}
