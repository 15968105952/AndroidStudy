package com.lahm.learndaemon.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lahm.learndaemon.R;
import com.lahm.learndaemon.view.RotationChartView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RotationChartActivity extends BaseActivity {

    @BindView(R.id.rotation_chart_view)
    RotationChartView rotationChartView;
    @BindView(R.id.rg)
    RadioGroup rg;
    private int[] imgIds = new int[]{R.mipmap.a1, R.mipmap.a2,
            R.mipmap.a3, R.mipmap.a4, R.mipmap.a5, R.mipmap.a6};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotation_chart);
        ButterKnife.bind(this);
        //将需要的imageview添加到viewgroup中
        for (int i = 0; i < imgIds.length; i++) {
            ImageView imageView = new ImageView(RotationChartActivity.this);
            imageView.setBackgroundResource(imgIds[i]);
            rotationChartView.addView(imageView);
        }
        //添加xml
        View inflate = View.inflate(RotationChartActivity.this, R.layout.view_my, null);
        rotationChartView.addView(inflate, 1);
        for (int i = 0; i < rotationChartView.getChildCount(); i++) {
            RadioButton radioButton = new RadioButton(RotationChartActivity.this);
            radioButton.setId(i);
            if (i == 0)
                radioButton.setChecked(true);
            rg.addView(radioButton);
        }

        //自定义viewpager设置监听
        rotationChartView.setCheckListener(new RotationChartView.CheckListener() {
            @Override
            public void getPositon(int position) {
                rg.check(position);
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rotationChartView.moveToIndex(checkedId);
            }
        });

    }
}
