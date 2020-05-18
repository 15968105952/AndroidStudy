package com.lahm.learndaemon.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.lahm.learndaemon.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MultithreadingActivity extends BaseActivity {

    private static final String TAG = MultithreadingActivity.class.getSimpleName();
    @BindView(R.id.bt_multithreading_not_synchronized)
    Button btMultithreadingNotSynchronized;
    @BindView(R.id.bt_multithreading_synchronized)
    Button btMultithreadingSynchronized;
    private Person person;
    private Thread thread1;
    private Thread thread2;
    private Thread thread3;
    int ticket = 100;
    private boolean isSynchronized=true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multithreading);
        ButterKnife.bind(this);
        person = new Person();
        startThread();
    }

    @OnClick({R.id.bt_multithreading_not_synchronized, R.id.bt_multithreading_synchronized})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_multithreading_not_synchronized:
                isSynchronized = false;
                startThread();
                break;
            case R.id.bt_multithreading_synchronized:
                isSynchronized = true;
                startThread();
                break;
        }
    }

    private void startThread() {
        ticket = 100;
        thread1 = new Thread(person);
        thread2 = new Thread(person);
        thread3 = new Thread(person);
        thread1.start();
        thread2.start();
        thread3.start();
    }

    class Person implements Runnable {
        Object object = new Object();

        @Override
        public void run() {
            if (isSynchronized) {
                synchronized (object) {
                    saleTicket();
                }
            } else {
                saleTicket();
            }
        }
    }

    private void saleTicket() {
        while (true) {
            if (ticket > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Log.i(TAG, Thread.currentThread().getName() + ":" + ticket);
                ticket--;
            }
//            else {
//                thread1.interrupt();
//                thread2.interrupt();
//                thread3.interrupt();
//            }
        }
    }
}
