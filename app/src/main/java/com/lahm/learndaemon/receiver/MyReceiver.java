package com.lahm.learndaemon.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if ("SendNotify".equals(intent.getAction())) {
            Toast.makeText(context, "收到广播" + "-----》", Toast.LENGTH_SHORT).show();
        }
    }
}
