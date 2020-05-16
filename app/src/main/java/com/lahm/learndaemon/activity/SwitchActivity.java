package com.lahm.learndaemon.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.lahm.learndaemon.R;
import com.lahm.learndaemon.view.SwitchView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SwitchActivity extends BaseActivity {


    @BindView(R.id.switch_view)
    SwitchView switchView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
        ButterKnife.bind(this);
        switchView.setSwitchListener(new SwitchView.SwitchListener() {
            @Override
            public void isOpen(boolean isOpen) {
                if(isOpen){
                    Toast.makeText(SwitchActivity.this,"已打开",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(SwitchActivity.this,"已关闭",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
