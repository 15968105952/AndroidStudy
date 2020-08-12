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
import com.lahm.learndaemon.entity.JsonRootBean;
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

//        String testStr = new Gson().toJson(testBean);
//        Log.d("test", "str: " + testStr);
//        testStr = "{\"ceshi\":\"bean没有的数据\",\"age\":\"这是年龄\",\"is_success\":true,\"sex\":\"girl\",\"bean\":{\"age\":18.8,\"var1\":\"a\",\"var2\":\"b\",\"var3\":[],\"is_success\":1,\"array\":{},\"list\":[\"list1\",\"list2\"],\"sex\":\"boy\",\"map\":\"\",\"name\":\"test1\"},\"name\":\"test2\"}";
//        TestBean resultBean = new Gson().fromJson(testStr, TestBean.class);
//        Log.d("test", "result bean: " + resultBean);
//        Toast.makeText(GsonActivity.this, String.valueOf(resultBean.name), Toast.LENGTH_SHORT).show();
        String  testStr = "{\n" +
                "        \"testPaperId\": 1,\n" +
                "        \"testPaperName\": \"2019-2020学年浙江省杭州市小学一年级(上) 期末语文试卷\",\n" +
                "        \"testDuration\": 120,\n" +
                "        \"paperReportIds\": \"\",\n" +
                "        \"testPaperNo\": \"\",\n" +
                "        \"periodName\": \"\",\n" +
                "        \"subjectId\": \"\",\n" +
                "        \"subjectName\": \"\",\n" +
                "        \"versionName\": \"\",\n" +
                "        \"stageName\": \"\",\n" +
                "        \"year\": \"\",\n" +
                "        \"difficultyName\": \"\",\n" +
                "        \"testPaperTypeName\": \"\",\n" +
                "        \"testTypeName\": \"\",\n" +
                "        \"nodeList\": [\n" +
                "            {\n" +
                "                \"nodeId\": 2,\n" +
                "                \"nodeTitle\": \"第二小节\",\n" +
                "                \"nodeSort\": 2,\n" +
                "                \"nodeScore\": 20.0,\n" +
                "                \"questionList\": [\n" +
                "                    {\n" +
                "                        \"questionId\": \"T202007080003\",\n" +
                "                        \"questionTitle\": \"<html><body><header><meta name='viewport' content='width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no'></header><span style='font-weight:bold;'>#</span><span style='font-weight:bold;'>试题内容</span><span style='font-weight:bold;'>#</span></br><span style='font-family:楷体;'>下</span><span style='font-size:21px;'>图</span><span style='font-weight:bold;'>是</span><span style='font-style:italic;'>哪</span><span style='text-decoration: underline;'>个</span><span style='text-decoration: line-through;'>产</span><span style='color:#0000FF;'>品</span></body></html>\",\n" +
                "                        \"questionTypeId\": 7,\n" +
                "                        \"questionTypeName\": \"组合题\",\n" +
                "                        \"mark\": 1,\n" +
                "                        \"sort\": 0,\n" +
                "                        \"userAnswer\": [],\n" +
                "                        \"questionSort\": \"\",\n" +
                "                        \"analysis\": \"<html><body><header><meta name='viewport' content='width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no'></header><span style='font-weight:bold;'>#</span><span style='font-weight:bold;'>试题分析</span><span style='font-weight:bold;'>#</span><span style=''>此图片是</span><span style=''>百一</span><span style=''>测评的产品</span><span style=''>Logo</span><span style=''>。</span></body></html>\",\n" +
                "                        \"answerNum\": 0,\n" +
                "                        \"option\": [],\n" +
                "                        \"difficulty\": \"较易（1）\",\n" +
                "                        \"photograph\": 1,\n" +
                "                        \"score\": 15.0,\n" +
                "                        \"estimateDuration\": 2.0,\n" +
                "                        \"status\": \"\",\n" +
                "                        \"child\": [\n" +
                "                            {\n" +
                "                                \"questionId\": \"T202007130014\",\n" +
                "                                \"questionTitle\": \"<html><body><header><meta name='viewport' content='width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no'></header><span style='font-family:黑体;font-weight:bold;'>#</span><span style='font-family:黑体;font-weight:bold;'>试题内容</span><span style='font-family:黑体;font-weight:bold;'>#</span></br><span style='font-family:黑体;'>问题</span><span style='font-family:黑体;'>1</span></body></html>\",\n" +
                "                                \"questionTypeId\": 1,\n" +
                "                                \"questionTypeName\": \"单选题\",\n" +
                "                                \"mark\": 0,\n" +
                "                                \"sort\": \"\",\n" +
                "                                \"userAnswer\": [],\n" +
                "                                \"questionSort\": 0,\n" +
                "                                \"analysis\": \"<html><body><header><meta name='viewport' content='width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no'></header><span style='font-family:黑体;font-weight:bold;'>#</span><span style='font-family:黑体;font-weight:bold;'>试题分析</span><span style='font-family:黑体;font-weight:bold;'>#</span></br><span style='font-family:黑体;font-weight:bold;'>Xxx</span></br><span style='font-family:黑体;font-weight:bold;'>Zzz</span></br><span style='font-family:黑体;font-weight:bold;'>Ccc</span></br><span style='font-family:黑体;font-weight:bold;'>vvv</span></body></html>\",\n" +
                "                                \"answerNum\": 1,\n" +
                "                                \"option\": [\n" +
                "                                    {\n" +
                "                                        \"key\": \"A\",\n" +
                "                                        \"val\": \"<html><body><header><meta name='viewport' content='width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no'></header><span style='font-family:黑体;font-weight:bold;'>#</span><span style='font-family:黑体;'>A</span></body></html>\"\n" +
                "                                    },\n" +
                "                                    {\n" +
                "                                        \"key\": \"B\",\n" +
                "                                        \"val\": \"<html><body><header><meta name='viewport' content='width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no'></header><span style='font-family:黑体;font-weight:bold;'>#</span><span style='font-family:黑体;'>B</span></body></html>\"\n" +
                "                                    },\n" +
                "                                    {\n" +
                "                                        \"key\": \"C\",\n" +
                "                                        \"val\": \"<html><body><header><meta name='viewport' content='width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no'></header><span style='font-family:黑体;font-weight:bold;'>#</span><span style='font-family:黑体;'>C</span></body></html>\"\n" +
                "                                    },\n" +
                "                                    {\n" +
                "                                        \"key\": \"D\",\n" +
                "                                        \"val\": \"<html><body><header><meta name='viewport' content='width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no'></header><span style='font-family:黑体;font-weight:bold;'>#</span><span style='font-family:黑体;'>D</span></body></html>\"\n" +
                "                                    }\n" +
                "                                ],\n" +
                "                                \"difficulty\": \"较易（1）\",\n" +
                "                                \"photograph\": 1,\n" +
                "                                \"score\": 1.5,\n" +
                "                                \"estimateDuration\": \"\",\n" +
                "                                \"status\": \"\",\n" +
                "                                \"child\": []\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        ]\n" +
                "    }";

        JsonRootBean jsonRootBean = new Gson().fromJson(testStr, JsonRootBean.class);
        Log.d("test", "result bean: " + jsonRootBean);
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
