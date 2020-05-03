package com.lahm.learndaemon.activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.lahm.learndaemon.R;

public class RingActivity extends BaseActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ring);

        //设置播放响铃音乐
        mediaPlayer = MediaPlayer.create(this, R.raw.call_ring);
        mediaPlayer.start();
    }

    public void stop(View view){
        mediaPlayer.stop();
        finish();
    }
}
