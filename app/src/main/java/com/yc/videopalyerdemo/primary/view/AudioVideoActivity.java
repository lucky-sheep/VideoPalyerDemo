package com.yc.videopalyerdemo.primary.view;

import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.yc.videopalyerdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yc on 2019-12-30
 **/
public class AudioVideoActivity extends AppCompatActivity implements SurfaceHolder.Callback{

    @BindView(R.id.surface_view)
    SurfaceView surfaceView;

    SurfaceHolder surfaceHolder;
    CameraManager cameraManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_video);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Log.w("MainActivity", "enter surfaceCreated method");
        // 目前设定的是，当surface创建后，就打开摄像头开始预览

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }

    @OnClick(R.id.go_muxer)
    public void onViewClicked() {

    }
}
