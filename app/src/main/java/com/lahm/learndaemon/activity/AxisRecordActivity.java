package com.lahm.learndaemon.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.lahm.learndaemon.R;
import com.lahm.learndaemon.entity.LearnRecordBean;
import com.lahm.learndaemon.utils.DateUtils;
import com.lahm.learndaemon.view.ScoreTrend;

import java.util.ArrayList;
import java.util.List;

public class AxisRecordActivity extends BaseActivity {
    private String TAG = AxisRecordActivity.class.getSimpleName();
    private List<LearnRecordBean.CourseLessonListBean> mDatas = new ArrayList();
    List<String> yList = new ArrayList<>();
    List<String> xList = new ArrayList<>();
    List<String> xWeek = new ArrayList<>();
    int score[] = new int[7];
    int realscore[] = new int[7];
    private ScoreTrend lineChart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_axis_record);
        lineChart = findViewById(R.id.scoreTrend);
        setLineChart();
        setData();

    }

    private void setData() {
        String json = "{\n" +
                "        \"courseLessonList\": [\n" +
                "            {\n" +
                "                \"courseLessonId\": 26,\n" +
                "                \"courseLessonName\": \"课时\",\n" +
                "\t\t\t\t\"courseName\":课程名称,\n" +
                "\t\t\t\t\"coverPath\":\"/...\",\n" +
                "\t\t\t\t\"coureseId\":0,\n" +
                "\t\t\t\t\"findType\":0\n" +
                "            },\n" +
                "            {\n" +
                "                \"courseLessonId\": 27,\n" +
                "                \"courseLessonName\": \"测试\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"allStudyTime\": 50,\n" +
                "        \"denDrogramList\": [\n" +
                "            {\n" +
                "                \"studySumTime\": 1000,\n" +
                "                \"days\": \"2019-04-20\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"studySumTime\": 2000,\n" +
                "                \"days\": \"2019-04-21\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"studySumTime\": 500,\n" +
                "                \"days\": \"2019-04-22\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"studySumTime\": 3000,\n" +
                "                \"days\": \"2019-04-23\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"studySumTime\": 0,\n" +
                "                \"days\": \"2019-04-24\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"studySumTime\": 4000,\n" +
                "                \"days\": \"2019-04-25\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"studySumTime\": 450,\n" +
                "                \"days\": \"2019-04-26\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"todayStudyTime\": 50,\n" +
                "        \"AverageTime\": 25\n" +
                "    }";
        LearnRecordBean learnRecordData = new Gson().fromJson(json, LearnRecordBean.class);
        List<LearnRecordBean.DenDrogramListBean> denDrogramList = learnRecordData.getDenDrogramList();
        List<LearnRecordBean.CourseLessonListBean> courseLessonList = learnRecordData.getCourseLessonList();
        mDatas.clear();
        if (courseLessonList != null && courseLessonList.size() > 0) {
            if (courseLessonList.size() < 3) {
                mDatas.addAll(courseLessonList);
            } else {
                for (int i = 0; i < 3; i++) {
                    mDatas.add(courseLessonList.get(i));
                }
            }
        }
        xList.clear();
        xWeek.clear();
        for (int i = 0; i < denDrogramList.size(); i++) {
            int studySumTime = denDrogramList.get(i).getStudySumTime();
            score[i] = (int) Math.ceil((double) studySumTime / 60);
            realscore[i] = (int) Math.ceil((double) studySumTime / 60);
            String[] days = denDrogramList.get(i).getDays().split("-");
            xList.add(days[1] + "-" + days[2]);
            String dateToWeek = DateUtils.dateToWeek(denDrogramList.get(i).getDays());
            xWeek.add(dateToWeek);
        }
        lineChart.setXScore(xList);
        lineChart.setXWeekScore(xWeek);
        lineChart.setScore(score);
        lineChart.setRealScore(realscore);
        lineChart.invalidate();
    }

    private void setLineChart() {
        yList.add("0");
        yList.add("10");
        yList.add("20");
        yList.add("30");
        yList.add("40");
        yList.add("50");
        yList.add("60");
        yList.add("24h");
        lineChart.setYScore(yList);
    }
}
