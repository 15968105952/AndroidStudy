package com.lahm.learndaemon.entity;

import java.util.List;

/**
 * Author: Lusheast
 * E-mail：lusheast@163.cn
 * Date: on 2019-05-28 17:02
 * Desc:
 */
public class LearnRecordBean {



        /**
         * courseLessonList : [{"courseLessonId":125,"courseName":"2019/5/30--2019/5/31 初中初二物理创新班(15:20--15:40)","coverPath":"/datadrive/ruidacloud/upload/course/coverPic/2019/05/30/21771752r9j4xlH3gqM0j5774233W08h-43ab44b0e3df11e88daacf5232774662_f630e48b82db4aeab98fa2ff9ae2aaee_thumb.jpg","coureseId":46,"findType":2,"courseLessonName":"2019/5/30初中初二物理创新班(15:20--15:40)"},{"courseLessonId":17,"courseName":"免费六级英语基础培训--微讲堂","coverPath":"/datadrive/ruidacloud/upload/course/coverPic/2019/05/24/07p0742V0N4M0OZG13b83546Lqu9bC6N-24.jpg","coureseId":5,"findType":1,"courseLessonName":"免费六级英语基础课程--口语"}]
         * allStudyTime : 105
         * denDrogramList : [{"studySumTime":0,"days":"2019-05-28"},{"studySumTime":20,"days":"2019-05-29"},{"studySumTime":0,"days":"2019-05-30"},{"studySumTime":85,"days":"2019-05-31"},{"studySumTime":0,"days":"2019-06-01"},{"studySumTime":0,"days":"2019-06-02"},{"studySumTime":0,"days":"2019-06-03"}]
         * todayStudyTime : 105
         * AverageTime : 26
         */

        private int allStudyTime;
        private int todayStudyTime;
        private int AverageTime;
        private List<CourseLessonListBean> courseLessonList;
        private List<DenDrogramListBean> denDrogramList;

        public int getAllStudyTime() {
            return allStudyTime;
        }

        public void setAllStudyTime(int allStudyTime) {
            this.allStudyTime = allStudyTime;
        }

        public int getTodayStudyTime() {
            return todayStudyTime;
        }

        public void setTodayStudyTime(int todayStudyTime) {
            this.todayStudyTime = todayStudyTime;
        }

        public int getAverageTime() {
            return AverageTime;
        }

        public void setAverageTime(int AverageTime) {
            this.AverageTime = AverageTime;
        }

        public List<CourseLessonListBean> getCourseLessonList() {
            return courseLessonList;
        }

        public void setCourseLessonList(List<CourseLessonListBean> courseLessonList) {
            this.courseLessonList = courseLessonList;
        }

        public List<DenDrogramListBean> getDenDrogramList() {
            return denDrogramList;
        }

        public void setDenDrogramList(List<DenDrogramListBean> denDrogramList) {
            this.denDrogramList = denDrogramList;
        }

        public static class CourseLessonListBean {
            /**
             * courseLessonId : 125
             * courseName : 2019/5/30--2019/5/31 初中初二物理创新班(15:20--15:40)
             * coverPath : /datadrive/ruidacloud/upload/course/coverPic/2019/05/30/21771752r9j4xlH3gqM0j5774233W08h-43ab44b0e3df11e88daacf5232774662_f630e48b82db4aeab98fa2ff9ae2aaee_thumb.jpg
             * coureseId : 46
             * findType : 2
             * courseLessonName : 2019/5/30初中初二物理创新班(15:20--15:40)
             */

            private int courseLessonId;
            private String courseName;
            private String coverPath;
            private int coureseId;
            private int findType;
            private String courseLessonName;
            private int iscompose;

            public int getIscompose() {
                return iscompose;
            }

            public void setIscompose(int iscompose) {
                this.iscompose = iscompose;
            }

            public int getCourseLessonId() {
                return courseLessonId;
            }

            public void setCourseLessonId(int courseLessonId) {
                this.courseLessonId = courseLessonId;
            }

            public String getCourseName() {
                return courseName;
            }

            public void setCourseName(String courseName) {
                this.courseName = courseName;
            }

            public String getCoverPath() {
                return coverPath;
            }

            public void setCoverPath(String coverPath) {
                this.coverPath = coverPath;
            }

            public int getCoureseId() {
                return coureseId;
            }

            public void setCoureseId(int coureseId) {
                this.coureseId = coureseId;
            }

            public int getFindType() {
                return findType;
            }

            public void setFindType(int findType) {
                this.findType = findType;
            }

            public String getCourseLessonName() {
                return courseLessonName;
            }

            public void setCourseLessonName(String courseLessonName) {
                this.courseLessonName = courseLessonName;
            }
        }

        public static class DenDrogramListBean {
            /**
             * studySumTime : 0
             * days : 2019-05-28
             */

            private int studySumTime;
            private String days;

            public int getStudySumTime() {
                return studySumTime;
            }

            public void setStudySumTime(int studySumTime) {
                this.studySumTime = studySumTime;
            }

            public String getDays() {
                return days;
            }

            public void setDays(String days) {
                this.days = days;
            }
        }
}
