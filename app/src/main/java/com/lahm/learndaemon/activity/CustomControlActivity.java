package com.lahm.learndaemon.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.lahm.learndaemon.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomControlActivity extends BaseActivity {

    @BindView(R.id.tv_axisRecord)
    TextView tvAxisRecord;
    @BindView(R.id.tv_switch)
    TextView tvSwitch;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_control);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.tv_axisRecord, R.id.tv_switch, R.id.tv_water_ripple, R.id.tv_rotation_chart})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_axisRecord:
                startActivity(AxisRecordActivity.class);
                break;
            case R.id.tv_switch:
                startActivity(SwitchActivity.class);
                break;
            case R.id.tv_water_ripple:
                startActivity(WaterRippleActivity.class);
                break;
            case R.id.tv_rotation_chart:
                startActivity(RotationChartActivity.class);
                break;
        }
    }

    private void startActivity(Class<? extends BaseActivity> activityClass) {
        startActivity(new Intent(CustomControlActivity.this, activityClass));
    }
}
