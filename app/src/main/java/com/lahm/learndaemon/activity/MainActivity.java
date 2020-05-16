package com.lahm.learndaemon.activity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.lahm.learndaemon.R;
import com.lahm.learndaemon.activity.breakpointresume.BreakpointResumeActivity;
import com.lahm.learndaemon.activity.reflex.ReflexActivity;
import com.lahm.learndaemon.adapter.TextTagAdapter;
import com.lahm.learndaemon.entity.ImpressTagEntity;
import com.lahm.learndaemon.view.TagFlowLayout;
import com.lahm.learndaemon.view.TaoFlowLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private List<String> list = new ArrayList<>();
    private List<ImpressTagEntity> impressTagEntities = new ArrayList<>();
    private List<Class<? extends BaseActivity>> classes = new ArrayList<>();
    private TagFlowLayout tag_flow_layout;
    private TextTagAdapter textTagAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tag_flow_layout = findViewById(R.id.tag_flow_layout);
        addList();
        setAdapter();
        addBean();
    }

    private void addBean() {
        for (int i = 0; i < list.size(); i++) {
            ImpressTagEntity impressTagEntity = new ImpressTagEntity();
            impressTagEntity.setEnName(list.get(i));
            impressTagEntities.add(impressTagEntity);
        }
        if (null != impressTagEntities && impressTagEntities.size() > 0)
            Log.i(TAG, impressTagEntities.size() + "");
        textTagAdapter.notifyDataChanged();
    }

    private void setAdapter() {
        textTagAdapter = new TextTagAdapter(MainActivity.this, impressTagEntities);
        tag_flow_layout.setAdapter(textTagAdapter);
        tag_flow_layout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, TaoFlowLayout parent) {
                startActivity(new Intent(MainActivity.this, classes.get(position)));
                return false;
            }
        });
    }

    private void addList() {
        list.add("AIDL");
        classes.add(AidlActivity.class);
        list.add("闹钟和进程保活");
        classes.add(AlarmClockActivity.class);
        list.add("JNI开发");
        classes.add(JniActivity.class);
        list.add("断点续传");
        classes.add(BreakpointResumeActivity.class);
        list.add("反射");
        classes.add(ReflexActivity.class);
        list.add("Gson兼容后台数据返回类型不一致");
        classes.add(GsonActivity.class);
        list.add("自定义控件");
        classes.add(CustomControlActivity.class);
    }

    public static boolean isAPPALive(Context mContext, String packageName) {
        boolean isAPPRunning = false;
        // 获取activity管理对象
        ActivityManager activityManager = (ActivityManager) mContext.getSystemService(Context.ACTIVITY_SERVICE);
        // 获取所有正在运行的app
        List<ActivityManager.RunningAppProcessInfo> appProcessInfoList = activityManager.getRunningAppProcesses();
        // 遍历，进程名即包名
        for (ActivityManager.RunningAppProcessInfo appInfo : appProcessInfoList) {
            if (packageName.equals(appInfo.processName)) {
                isAPPRunning = true;
                break;
            }
        }
        return isAPPRunning;
    }
}
