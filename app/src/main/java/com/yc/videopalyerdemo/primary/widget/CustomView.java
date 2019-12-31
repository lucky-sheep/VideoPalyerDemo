package com.yc.videopalyerdemo.primary.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Environment;
import android.view.View;

import java.io.File;

/**
 * Created by yc on 2019-10-18
 * 自定义 View 绘制图片
 **/
public class CustomView extends View {

    Paint paint = new Paint();
    Bitmap bitmap;

    public CustomView(Context context) {
        super(context);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        bitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory().getPath() + File.separator + "11.jpg");  // 获取bitmap
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 不建议在onDraw做任何分配内存的操作
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0, 0, paint);
        }
    }
}
