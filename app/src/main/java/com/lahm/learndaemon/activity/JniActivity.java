package com.lahm.learndaemon.activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.lahm.learndaemon.R;

public class JniActivity extends BaseActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jni);

    }

    public void  jni(View view){
        Toast.makeText(JniActivity.this,sayHello(),Toast.LENGTH_SHORT).show();
    }
    static {//导入libhello.so 文件。 这里面只写hello就可以
        System.loadLibrary("hello");
    }

    public native String sayHello();
}
