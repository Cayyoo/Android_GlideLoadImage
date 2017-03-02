package com.example.glideloadimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.glideloadimage.utils.GlideImgManager;

/**
 * 使用Glide自有方法、自定义方法加载图片。
 * Glide可加载Gif图片
 */
public class MainActivity extends AppCompatActivity {
    //百度logo
    private String urlImg="http://nuuneoi.com/uploads/source/playstore/cover.jpg";

    //UI控件的声明
    private ImageView imageView_round, imageView_circle, imageView_circleSmall, imageView_normal;

    //图片的网址
    private String url = "http://img4.imgtn.bdimg.com/it/u=3183769340,575656580&fm=206&gp=0.jpg";

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //调用初始化UI控件的方法
        initView();
        //调用加载图片的方法
        loadImage();
    }

    private void loadImage() {
        //普通加载,可现实gif格式图片
        //GlideImgManager.glideLoader(context,url,R.mipmap.ic_launcher,R.mipmap.ic_launcher,imageView_normal);
        Glide.with(context).load(R.mipmap.cartoon).asGif().into(imageView_normal);//.asGif()可省略，Glide可自己判断图片格式


        //加载圆形图片
        Glide.with(context).load(R.mipmap.cartoon).asBitmap().into(new BitmapImageViewTarget(imageView_circle) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                roundedBitmapDrawable.setCircular(true);
                imageView_circle.setImageDrawable(roundedBitmapDrawable);
            }
        });

        //调用自定义的工具类，来加载圆形图片
        GlideImgManager.glideLoader(context, url, R.mipmap.ic_launcher, R.mipmap.ic_launcher, imageView_circleSmall, 0);

        //调用自定义的工具类，加载圆角的图片
        GlideImgManager.glideLoader(context, url, R.mipmap.ic_launcher, R.mipmap.ic_launcher,imageView_round, 1);
    }

    private void initView() {
        imageView_round = (ImageView) findViewById(R.id.imageView_round);
        imageView_circle = (ImageView) findViewById(R.id.imageView_circle);
        imageView_circleSmall = (ImageView) findViewById(R.id.imageView_circle_small);
        imageView_normal = (ImageView) findViewById(R.id.imageView_normal);
    }
}