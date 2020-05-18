package com.lahm.learndaemon.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.lahm.learndaemon.R;
import com.lahm.learndaemon.view.CircleProgress;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProgressActivity extends BaseActivity {
    @BindView(R.id.progress)
    CircleProgress progress;
    @BindView(R.id.tv_start)
    TextView tvStart;
    @BindView(R.id.tv_pause)
    TextView tvPause;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        ButterKnife.bind(this);
        progress.setOnProgressListener(new CircleProgress.onProgressListener() {
            @Override
            public void onMaxProgress() {

            }
        });
        setPauseState();
    }

    private void setPauseState() {
        if(progress.isPause()){
            tvPause.setText("开始");
        }else {
            tvPause.setText("暂停");
        }
    }

    @OnClick({R.id.tv_start, R.id.tv_pause})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_start:
                progress.start();
                tvStart.setVisibility(View.GONE);
                break;
            case R.id.tv_pause:
                progress.togglePause();
                setPauseState();
                break;
        }
    }
}
