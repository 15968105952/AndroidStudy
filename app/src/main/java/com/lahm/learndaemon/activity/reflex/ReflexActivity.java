package com.lahm.learndaemon.activity.reflex;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.google.gson.reflect.TypeToken;
import com.lahm.learndaemon.R;
import com.lahm.learndaemon.activity.BaseActivity;
import com.lahm.learndaemon.entity.TestBean;
import com.lahm.learndaemon.utils.GsonUtil;

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
        //未成功，show方法无法反射调用
        showToast();
        String httpResult="{\"success\":true,\"statusCode\":\"0\",\"errorMsg\":null,\"msg\":null,\"content\":[{\"courseLessonId\":411393,\"courseLessonSn\":null,\"courseLessonName\":\"课次1\",\"broadcastRoomId\":null,\"startDate\":null,\"startTime\":\"2020-04-01 14:25:00\",\"endTime\":\"2020-04-01 17:25:00\",\"courseGenseeId\":null,\"courseVideoId\":null,\"roomId\":null,\"teacherId\":null,\"status\":1,\"orderNum\":null,\"createBy\":null,\"createTime\":\"2020-04-01 14:11:38\",\"updateBy\":null,\"updateTime\":null,\"isdelete\":null,\"courseId\":410602,\"courseStatus\":null,\"assistantToken\":null,\"studentToken\":null,\"teacherToken\":null,\"studentClientToken\":null,\"teacherJoinUrl\":null,\"studentJoinUrl\":null,\"masterTeacher\":\"颜雯雅\",\"assistantName\":null,\"defaultVideo\":null,\"mp4\":null,\"vid\":null,\"genseeStatus\":null,\"teachingMethod\":2,\"roomUrl\":null,\"viewTime\":null,\"findType\":null,\"courseName\":null,\"subjectId\":null,\"backLook\":false,\"roomStatus\":2,\"playBackList\":null,\"recordVideoList\":null,\"studentCode\":null},{\"courseLessonId\":411394,\"courseLessonSn\":null,\"courseLessonName\":\"课次2\",\"broadcastRoomId\":null,\"startDate\":null,\"startTime\":\"2020-04-02 14:25:00\",\"endTime\":\"2020-04-02 17:25:00\",\"courseGenseeId\":null,\"courseVideoId\":null,\"roomId\":null,\"teacherId\":null,\"status\":1,\"orderNum\":null,\"createBy\":null,\"createTime\":\"2020-04-01 14:11:38\",\"updateBy\":null,\"updateTime\":null,\"isdelete\":null,\"courseId\":410602,\"courseStatus\":null,\"assistantToken\":null,\"studentToken\":null,\"teacherToken\":null,\"studentClientToken\":null,\"teacherJoinUrl\":null,\"studentJoinUrl\":null,\"masterTeacher\":\"颜雯雅\",\"assistantName\":null,\"defaultVideo\":null,\"mp4\":null,\"vid\":null,\"genseeStatus\":null,\"teachingMethod\":2,\"roomUrl\":null,\"viewTime\":null,\"findType\":null,\"courseName\":null,\"subjectId\":null,\"backLook\":false,\"roomStatus\":2,\"playBackList\":null,\"recordVideoList\":null,\"studentCode\":null},{\"courseLessonId\":411395,\"courseLessonSn\":null,\"courseLessonName\":\"课次3\",\"broadcastRoomId\":null,\"startDate\":null,\"startTime\":\"2020-04-03 14:25:00\",\"endTime\":\"2020-04-03 17:25:00\",\"courseGenseeId\":null,\"courseVideoId\":null,\"roomId\":null,\"teacherId\":null,\"status\":1,\"orderNum\":null,\"createBy\":null,\"createTime\":\"2020-04-01 14:11:38\",\"updateBy\":null,\"updateTime\":null,\"isdelete\":null,\"courseId\":410602,\"courseStatus\":null,\"assistantToken\":null,\"studentToken\":null,\"teacherToken\":null,\"studentClientToken\":null,\"teacherJoinUrl\":null,\"studentJoinUrl\":null,\"masterTeacher\":\"颜雯雅\",\"assistantName\":null,\"defaultVideo\":null,\"mp4\":null,\"vid\":null,\"genseeStatus\":null,\"teachingMethod\":2,\"roomUrl\":null,\"viewTime\":null,\"findType\":null,\"courseName\":null,\"subjectId\":null,\"backLook\":false,\"roomStatus\":2,\"playBackList\":null,\"recordVideoList\":null,\"studentCode\":null},{\"courseLessonId\":411396,\"courseLessonSn\":null,\"courseLessonName\":\"课次4\",\"broadcastRoomId\":null,\"startDate\":null,\"startTime\":\"2020-04-04 14:25:00\",\"endTime\":\"2020-04-04 17:25:00\",\"courseGenseeId\":null,\"courseVideoId\":null,\"roomId\":null,\"teacherId\":null,\"status\":1,\"orderNum\":null,\"createBy\":null,\"createTime\":\"2020-04-01 14:11:38\",\"updateBy\":null,\"updateTime\":null,\"isdelete\":null,\"courseId\":410602,\"courseStatus\":null,\"assistantToken\":null,\"studentToken\":null,\"teacherToken\":null,\"studentClientToken\":null,\"teacherJoinUrl\":null,\"studentJoinUrl\":null,\"masterTeacher\":\"颜雯雅\",\"assistantName\":null,\"defaultVideo\":null,\"mp4\":null,\"vid\":null,\"genseeStatus\":null,\"teachingMethod\":2,\"roomUrl\":null,\"viewTime\":null,\"findType\":null,\"courseName\":null,\"subjectId\":null,\"backLook\":false,\"roomStatus\":2,\"playBackList\":null,\"recordVideoList\":null,\"studentCode\":null}],\"totalCount\":null}";
        TestBean resultBean = GsonUtil.fromJson(
                httpResult,  // 这里需要将获取到的json再次进行格式化
                new TypeToken<TestBean>() {
                });
//        TestBean  resultBean = new Gson().fromJson(httpResult, TestBean.class);
        Toast.makeText(ReflexActivity.this,resultBean.getContent().get(0).getCourseLessonName(),Toast.LENGTH_SHORT).show();

    }

    private void showToast() {
        View inflate = LayoutInflater.from(ReflexActivity.this).inflate(R.layout.ui_toast, null);
        MyToast myToast = new MyToast(ReflexActivity.this, inflate);
        myToast.show();
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
