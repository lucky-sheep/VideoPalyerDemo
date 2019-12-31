package com.yc.videopalyerdemo.primary.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Environment;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.yc.videopalyerdemo.R;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yc on 2019-10-18
 **/
public class VideoPlay1Activity extends AppCompatActivity {

    @BindView(R.id.image_view)
    ImageView imageView;
    @BindView(R.id.surface_view)
    SurfaceView surfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }


    /**
     * 1. ImageView 绘制图片
     */
    private void createBitmap() {

        Bitmap bitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory().getPath() + File.separator + "videoplay.jpg");
        imageView.setImageBitmap(bitmap);
    }

    /**
     *2. SurfaceView 绘制图片
     */
    private void createSurfaceview() {
        SurfaceView surfaceView = (SurfaceView) findViewById(R.id.surface_view);
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {

                if (surfaceHolder == null) {
                    return;
                }

                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setStyle(Paint.Style.STROKE);

                Bitmap bitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory().getPath() + File.separator + "11.jpg");  // 获取bitmap
                Canvas canvas = surfaceHolder.lockCanvas();  // 先锁定当前surfaceView的画布
                canvas.drawBitmap(bitmap, 0, 0, paint); //执行绘制操作
                surfaceHolder.unlockCanvasAndPost(canvas); // 解除锁定并显示在界面上
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });
    }
}
