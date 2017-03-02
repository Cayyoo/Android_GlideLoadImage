# Glide加载图片


 使用Glide自有方法、自定义方法加载图片。
 Glide可加载Gif图片

1、加载Gif图片
```java
Glide.with(context).load(R.mipmap.cartoon).asGif().into(imageView_normal);//.asGif()可省略，Glide可自己判断图片格式
```

2、自有属性加载圆形图片
 ```java
 //加载圆形图片
  Glide.with(context).load(R.mipmap.cartoon).asBitmap().into(new BitmapImageViewTarget(imageView_circle) {
      @Override
      protected void setResource(Bitmap resource) {
          RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
          roundedBitmapDrawable.setCircular(true);
          imageView_circle.setImageDrawable(roundedBitmapDrawable);
      }
  });
 ```
 
![img](https://github.com/ykmeory/GlideLoadImage/blob/master/img.jpg "screenshot")
