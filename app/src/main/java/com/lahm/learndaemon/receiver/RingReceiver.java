package com.lahm.learndaemon.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.lahm.learndaemon.activity.RingActivity;

public class RingReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v("RingReceiver","响铃");
        Log.v("RingReceiver","intent.getAction()");
        if ("com.example.android27_zhangkai_alarm_notification.RING".equals(intent.getAction())){
            Log.v("RingReceiver","开始");
            Intent intent1=new Intent(context, RingActivity.class);
            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent1);
        }
    }
}
