package com.lahm.learndaemon.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;

import com.example.hiapad.myapplication.IMyAidlInterface;
import com.lahm.learndaemon.R;

public class AidlActivity extends BaseActivity {
    //aidl测试
        private IMyAidlInterface mybinder;
    ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
           mybinder= IMyAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl);
        //aidl测试
        Intent intent=new Intent();
        intent.setAction("com.example.hiapad.myapplication.MyService");
        intent.setPackage("com.example.hiapad.myapplication");
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);
    }

    public void setAlarmOnce(View view){
        try {
            mybinder.pay();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }





}
