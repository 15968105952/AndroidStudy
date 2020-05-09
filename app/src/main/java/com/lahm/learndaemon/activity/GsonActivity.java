package com.lahm.learndaemon.activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lahm.learndaemon.R;
import com.lahm.learndaemon.activity.reflex.Person;
import com.lahm.learndaemon.entity.TestBean;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class GsonActivity extends BaseActivity {

    private MediaPlayer mediaPlayer;
    private String TAG = GsonActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);

    }

    public void reflex(View view) {
        //测试gson解析
        testGson();

    }

    private void testGson() {
        TestBean innerBean = new TestBean();
        innerBean.age = 18;
        innerBean.name = "test1";
        innerBean.sex = "boy";
        innerBean.array = new String[2];
        innerBean.array[0] = "array1";
        innerBean.array[1] = "array2";
        innerBean.list = new ArrayList<>();
        innerBean.list.add("list1");
        innerBean.list.add("list2");
        innerBean.map = new HashMap<>();
        innerBean.map.put("map1", "map1");
        innerBean.map.put("map2", "map2");

        TestBean testBean = new TestBean();
        testBean.age = 20;
        testBean.name = "testBean";
        testBean.sex = "girl";
        testBean.bean = innerBean;

        String testStr = new Gson().toJson(testBean);
        Log.d("test", "str: " + testStr);
        testStr = "{\"ceshi\":\"bean没有的数据\",\"age\":\"这是年龄\",\"is_success\":true,\"sex\":\"girl\",\"bean\":{\"age\":18.8,\"var1\":\"a\",\"var2\":\"b\",\"var3\":[],\"is_success\":1,\"array\":{},\"list\":[\"list1\",\"list2\"],\"sex\":\"boy\",\"map\":\"\",\"name\":\"test1\"},\"name\":\"test2\"}";

        TestBean resultBean = new Gson().fromJson(testStr, TestBean.class);
        Log.d("test", "result bean: " + resultBean);
        Toast.makeText(GsonActivity.this,String.valueOf(resultBean.name),Toast.LENGTH_SHORT).show();
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
            Toast.makeText(GsonActivity.this, age.toString(), Toast.LENGTH_SHORT).show();
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
            Toast.makeText(GsonActivity.this, data, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
