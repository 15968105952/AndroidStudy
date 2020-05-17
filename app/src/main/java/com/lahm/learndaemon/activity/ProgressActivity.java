package com.lahm.learndaemon.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lahm.learndaemon.R;
import com.lahm.learndaemon.view.CircleProgress;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProgressActivity extends BaseActivity {
    @BindView(R.id.progress)
    CircleProgress progress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        ButterKnife.bind(this);
        progress.start();
        progress.setOnProgressListener(new CircleProgress.onProgressListener() {
            @Override
            public void onMaxProgress() {

            }
        });
    }
}
