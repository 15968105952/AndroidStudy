package com.lahm.learndaemon.activity.breakpointresume;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.lahm.learndaemon.R;
import com.lahm.learndaemon.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class BreakpointResumeActivity extends BaseActivity implements View.OnClickListener, DownLoad.IProgress{
    private String path = "http://video.dameiketang.com/mkt2016%2F%E9%83%91%E7%82%9C%E4%B8%9C%2F%E5%A4%B4%E7%9A%AE%E5%B8%B8%E8%A7%81%E9%97%AE%E9%A2%981.mp4";
    //private DownLoad downLoad;
    private ProgressBar pBar;
    private OkManager downLoad;
    private String TAG=BreakpointResumeActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakpoint_resume);
        downLoad = new OkManager(path,this, BreakpointResumeActivity.this);
        initView();
        checkPermission();
    }

    private void checkPermission() {
        //1、 哪些权限需要申请
        List<String> permissionList = new ArrayList<>();
        List<String> permissions = new ArrayList<>();
        permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        for (String permission : permissions) {
            if (ActivityCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                //权限没有申请 添加到要申请的权限列表中
                permissionList.add(permission);
            }
        }
        if (!permissionList.isEmpty()) {
            ActivityCompat.requestPermissions(this, permissionList.toArray(new String[permissionList.size()]), 1);
        } else {
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            List<String> deniedPermissions = new ArrayList<>();
            if (grantResults.length > 0) {
                for (int i = 0; i < grantResults.length; i++) {
                    int grantResult = grantResults[i];
                    if (grantResult != PackageManager.PERMISSION_GRANTED) {
                        deniedPermissions.add(permissions[i]);
                    }
                }
            }
        }
    }

    private void initView() {
        Button start = (Button) findViewById(R.id.start);
        Button stop = (Button) findViewById(R.id.stop);
        pBar = (ProgressBar) findViewById(R.id.progress);
        pBar.setMax(100);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start:
                downLoad.start();
                break;
            case R.id.stop:
                downLoad.stop();
                break;
        }
    }
    //显示进度条
    @Override
    public void onProgress(int progress) {
        pBar.setProgress(progress);
    }
}
