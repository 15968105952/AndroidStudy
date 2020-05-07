package com.lahm.learndaemon.activity.reflex;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.lahm.learndaemon.R;
import com.lahm.learndaemon.activity.BaseActivity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflexActivity extends BaseActivity {

    private MediaPlayer mediaPlayer;
    private String TAG = ReflexActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflex);

    }

    public void reflex(View view) {
        getPersonMethod();
        getAndSetAge();

    }

    private void getAndSetAge() {
        Person person = new Person();
        //获取字节码
        Class<? extends Person> aClass = person.getClass();
        //2.获取私有属性
        try {
            Field age = aClass.getDeclaredField("age");
            age.setAccessible(true);
            Log.i(TAG, "age:" + age);
            Toast.makeText(ReflexActivity.this, age.toString(), Toast.LENGTH_SHORT).show();
            //3.改变私有属性的值
            age.set(person, 18);
            Log.i(TAG, "age:" + person.getAge());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getPersonMethod() {
        Person person = new Person();
        //反射步骤
        try {
            //1.获取字节码
            Class aClass = Class.forName("com.lahm.learndaemon.activity.reflex.Person");
//            Class<? extends Person> aClass = person.getClass();
            //2.获得方法
            //获得私有方法 aClass.getDeclaredMethod
            //获得共有方法 aClass.getMethod
            Method method = aClass.getDeclaredMethod("say", String.class);
            method.setAccessible(true);
            //调用方法
            String data = (String) method.invoke(person, "测试反射");
            Toast.makeText(ReflexActivity.this, data, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
