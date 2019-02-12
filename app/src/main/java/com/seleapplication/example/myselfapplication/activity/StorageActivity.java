package com.seleapplication.example.myselfapplication.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.TextView;

import com.seleapplication.example.myselfapplication.BaseActivity;
import com.seleapplication.example.myselfapplication.R;
import com.seleapplication.example.myselfapplication.utils.CommonUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by 13653 on 2019/1/18.
 */

public class StorageActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv_storage_write;
    private TextView tv_storage_read;
    private TextView tv_cache_write;
    private TextView tv_cache_read;
    private final String starogePath = Environment.getExternalStorageDirectory() + "";
//    private final String cachePath =getExternalCacheDir()+ "";
//    private final String cachePath = getExternalCacheDir()+"";

    private final String data = "白居易（唐代）翻译鉴赏\n" +
            "汉皇重色思倾国，御宇多年求不得。\n" +
            "杨家有女初长成，养在深闺人未识。\n" +
            "天生丽质难自弃，一朝选在君王侧。\n" +
            "回眸一笑百媚生，六宫粉黛无颜色。\n" +
            "春寒赐浴华清池，温泉水滑洗凝脂。\n" +
            "侍儿扶起娇无力，始是新承恩泽时。\n" +
            "云鬓花颜金步摇，芙蓉帐暖度春宵。\n" +
            "春宵苦短日高起，从此君王不早朝。\n" +
            "承欢侍宴无闲暇，春从春游夜专夜。\n" +
            "后宫佳丽三千人，三千宠爱在一身。\n" +
            "金屋妆成娇侍夜，玉楼宴罢醉和春。\n" +
            "姊妹弟兄皆列土，可怜光彩生门户。\n" +
            "遂令天下父母心，不重生男重生女。\n" +
            "骊宫高处入青云，仙乐风飘处处闻。\n" +
            "缓歌慢舞凝丝竹，尽日君王看不足。\n" +
            "渔阳鼙鼓动地来，惊破霓裳羽衣曲。\n" +
            "九重城阙烟尘生，千乘万骑西南行。\n" +
            "翠华摇摇行复止，西出都门百余里。\n" +
            "六军不发无奈何，宛转蛾眉马前死。\n" +
            "花钿委地无人收，翠翘金雀玉搔头。\n" +
            "君王掩面救不得，回看血泪相和流。\n" +
            "黄埃散漫风萧索，云栈萦纡登剑阁。\n" +
            "峨嵋山下少人行，旌旗无光日色薄。\n" +
            "蜀江水碧蜀山青，圣主朝朝暮暮情。\n" +
            "行宫见月伤心色，夜雨闻铃肠断声。\n" +
            "天旋地转回龙驭，到此踌躇不能去。\n" +
            "马嵬坡下泥土中，不见玉颜空死处。\n" +
            "君臣相顾尽沾衣，东望都门信马归。\n" +
            "归来池苑皆依旧，太液芙蓉未央柳。\n" +
            "芙蓉如面柳如眉，对此如何不泪垂。\n" +
            "春风桃李花开日，秋雨梧桐叶落时。\n" +
            "西宫南内多秋草，落叶满阶红不扫。\n" +
            "梨园弟子白发新，椒房阿监青娥老。\n" +
            "夕殿萤飞思悄然，孤灯挑尽未成眠。\n" +
            "迟迟钟鼓初长夜，耿耿星河欲曙天。\n" +
            "鸳鸯瓦冷霜华重，翡翠衾寒谁与共。\n" +
            "悠悠生死别经年，魂魄不曾来入梦。\n" +
            "临邛道士鸿都客，能以精诚致魂魄。\n" +
            "为感君王辗转思，遂教方士殷勤觅。\n" +
            "排空驭气奔如电，升天入地求之遍。\n" +
            "上穷碧落下黄泉，两处茫茫皆不见。\n" +
            "忽闻海上有仙山，山在虚无缥渺间。\n" +
            "楼阁玲珑五云起，其中绰约多仙子。\n" +
            "中有一人字太真，雪肤花貌参差是。\n" +
            "金阙西厢叩玉扃，转教小玉报双成。\n" +
            "闻道汉家天子使，九华帐里梦魂惊。\n" +
            "揽衣推枕起徘徊，珠箔银屏迤逦开。\n" +
            "云鬓半偏新睡觉，花冠不整下堂来。\n" +
            "风吹仙袂飘飖举，犹似霓裳羽衣舞。\n" +
            "玉容寂寞泪阑干，梨花一枝春带雨。\n" +
            "含情凝睇谢君王，一别音容两渺茫。\n" +
            "昭阳殿里恩爱绝，蓬莱宫中日月长。\n" +
            "回头下望人寰处，不见长安见尘雾。\n" +
            "惟将旧物表深情，钿合金钗寄将去。\n" +
            "钗留一股合一扇，钗擘黄金合分钿。\n" +
            "但教心似金钿坚，天上人间会相见。\n" +
            "临别殷勤重寄词，词中有誓两心知。\n" +
            "七月七日长生殿，夜半无人私语时。\n" +
            "在天愿作比翼鸟，在地愿为连理枝。\n" +
            "天长地久有时尽，此恨绵绵无绝期。\n";

    @Override
    protected int getResLayout() {
        return R.layout.activity_storage;
    }

    @Override
    protected void initView() {
        tv_storage_write = (TextView) findViewById(R.id.tv_storage_write);
        tv_storage_read = (TextView) findViewById(R.id.tv_storage_read);
        tv_cache_write = (TextView) findViewById(R.id.tv_cache_write);
        tv_cache_read = (TextView) findViewById(R.id.tv_cache_read);
    }

    @Override
    protected void initEvent() {
        tv_storage_write.setOnClickListener(this);
        tv_storage_read.setOnClickListener(this);
        tv_cache_write.setOnClickListener(this);
        tv_cache_read.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_storage_write:
                requestPermission();
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        while (1==1){
                            try {
                                storageWrite();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            if(1==2){
                                break;
                            }
                        }
                    }
                }.start();



                break;
            case R.id.tv_storage_read:
                requestPermission();
                try {
                    storageRead();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.tv_cache_write:
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        while (1==1){
                            try {
                                cacheWrite();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            if(1==2){
                                break;
                            }
                        }
                    }
                }.start();

                break;
            case R.id.tv_cache_read:
                try {
                    cacheRead();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void storageWrite() throws IOException {
        File file = new File(starogePath, "myNewFile.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        byte[] bytes = (data + "这里是内存\n" + "路径为：" + file.getAbsolutePath()).getBytes();
        fos.write(bytes);
        fos.close();
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                CommonUtils.showToast(mContext, "内存写数据完成");
//            }
//        });

    }

    private void storageRead() throws IOException {
        StringBuilder sb = new StringBuilder();
        File file = new File(starogePath, "myNewFile.txt");
        FileInputStream fis = new FileInputStream(file);

        if (!file.exists()) {
            CommonUtils.showToast(mContext, "没有找到该文件");
            return;
        }
        byte[] bytes = new byte[fis.available()];

        for (int m = 0; m < fis.available(); m++) {
            int i = fis.read(bytes);
            sb.append(new String(bytes, 0, i));
        }
        CommonUtils.showToast(mContext, "读数据完成");
        Intent intent = new Intent(mContext, ContentActivity.class);
        intent.putExtra("content", sb.toString());
        startActivity(intent);
    }

    private void cacheWrite() throws IOException {
        File file = new File(getExternalCacheDir(), "myNewFile.txt");
        FileOutputStream fos = new FileOutputStream(file);
        byte[] bytes = (data + "这里是缓存" + file.getAbsolutePath()).getBytes();
        if (!file.exists()) {
            file.createNewFile();
        }
        fos.write(bytes);
        fos.close();
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                CommonUtils.showToast(mContext, "缓存写数据完成");
//            }
//        });
    }

    private void cacheRead() throws IOException {
        File file = new File(getExternalCacheDir(), "myNewFile.txt");
        FileInputStream fis = new FileInputStream(file);
        if (!file.exists()) {
            CommonUtils.showToast(mContext, "文件不存在");
            return;
        }
        StringBuilder sb = new StringBuilder();
        byte[] bytes = new byte[fis.available()];
        int len;
        for (int i = 0; i < fis.available(); i++) {
            len = fis.read(bytes);
            sb.append(new String(bytes, 0, len));
        }
        Intent intent = new Intent(mContext, ContentActivity.class);
        intent.putExtra("content", sb.toString());
        startActivity(intent);
    }

    private void requestPermission() {
        if (Build.VERSION.SDK_INT > 23) {
            if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {//获得读写内存的权限
            CommonUtils.showToast(mContext, "您已经获得读写权限");
        }
    }


}
