package com.lahm.learndaemon.activity.reflex;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.lahm.learndaemon.R;
import com.lahm.learndaemon.activity.BaseActivity;

import java.lang.reflect.Method;

public class ReflexActivity extends BaseActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflex);

    }

    public void reflex(View view) {
        Person person = new Person();
        //反射步骤
        try {
            //1.获取字节码
            Class aClass = Class.forName("com.lahm.learndaemon.activity.reflex.Person");
//            Class<? extends Person> aClass = person.getClass();
            //2.获得方法
            Method method = aClass.getMethod("say", String.class);
            //调用方法
            String data = (String) method.invoke(person, "测试反射");
            Toast.makeText(ReflexActivity.this,data,Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
