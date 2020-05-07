package com.lahm.learndaemon.entity;

import java.util.List;

public class TestBean {
    /**
     * success : true
     * statusCode : 0
     * errorMsg : null
     * msg : null
     * content : [{"courseLessonId":411393,"courseLessonSn":null,"courseLessonName":"课次1","broadcastRoomId":null,"startDate":null,"startTime":"2020-04-01 14:25:00","endTime":"2020-04-01 17:25:00","courseGenseeId":null,"courseVideoId":null,"roomId":null,"teacherId":null,"status":1,"orderNum":null,"createBy":null,"createTime":"2020-04-01 14:11:38","updateBy":null,"updateTime":null,"isdelete":null,"courseId":410602,"courseStatus":null,"assistantToken":null,"studentToken":null,"teacherToken":null,"studentClientToken":null,"teacherJoinUrl":null,"studentJoinUrl":null,"masterTeacher":"颜雯雅","assistantName":null,"defaultVideo":null,"mp4":null,"vid":null,"genseeStatus":null,"teachingMethod":2,"roomUrl":null,"viewTime":null,"findType":null,"courseName":null,"subjectId":null,"backLook":false,"roomStatus":2,"playBackList":null,"recordVideoList":null,"studentCode":null},{"courseLessonId":411394,"courseLessonSn":null,"courseLessonName":"课次2","broadcastRoomId":null,"startDate":null,"startTime":"2020-04-02 14:25:00","endTime":"2020-04-02 17:25:00","courseGenseeId":null,"courseVideoId":null,"roomId":null,"teacherId":null,"status":1,"orderNum":null,"createBy":null,"createTime":"2020-04-01 14:11:38","updateBy":null,"updateTime":null,"isdelete":null,"courseId":410602,"courseStatus":null,"assistantToken":null,"studentToken":null,"teacherToken":null,"studentClientToken":null,"teacherJoinUrl":null,"studentJoinUrl":null,"masterTeacher":"颜雯雅","assistantName":null,"defaultVideo":null,"mp4":null,"vid":null,"genseeStatus":null,"teachingMethod":2,"roomUrl":null,"viewTime":null,"findType":null,"courseName":null,"subjectId":null,"backLook":false,"roomStatus":2,"playBackList":null,"recordVideoList":null,"studentCode":null},{"courseLessonId":411395,"courseLessonSn":null,"courseLessonName":"课次3","broadcastRoomId":null,"startDate":null,"startTime":"2020-04-03 14:25:00","endTime":"2020-04-03 17:25:00","courseGenseeId":null,"courseVideoId":null,"roomId":null,"teacherId":null,"status":1,"orderNum":null,"createBy":null,"createTime":"2020-04-01 14:11:38","updateBy":null,"updateTime":null,"isdelete":null,"courseId":410602,"courseStatus":null,"assistantToken":null,"studentToken":null,"teacherToken":null,"studentClientToken":null,"teacherJoinUrl":null,"studentJoinUrl":null,"masterTeacher":"颜雯雅","assistantName":null,"defaultVideo":null,"mp4":null,"vid":null,"genseeStatus":null,"teachingMethod":2,"roomUrl":null,"viewTime":null,"findType":null,"courseName":null,"subjectId":null,"backLook":false,"roomStatus":2,"playBackList":null,"recordVideoList":null,"studentCode":null},{"courseLessonId":411396,"courseLessonSn":null,"courseLessonName":"课次4","broadcastRoomId":null,"startDate":null,"startTime":"2020-04-04 14:25:00","endTime":"2020-04-04 17:25:00","courseGenseeId":null,"courseVideoId":null,"roomId":null,"teacherId":null,"status":1,"orderNum":null,"createBy":null,"createTime":"2020-04-01 14:11:38","updateBy":null,"updateTime":null,"isdelete":null,"courseId":410602,"courseStatus":null,"assistantToken":null,"studentToken":null,"teacherToken":null,"studentClientToken":null,"teacherJoinUrl":null,"studentJoinUrl":null,"masterTeacher":"颜雯雅","assistantName":null,"defaultVideo":null,"mp4":null,"vid":null,"genseeStatus":null,"teachingMethod":2,"roomUrl":null,"viewTime":null,"findType":null,"courseName":null,"subjectId":null,"backLook":false,"roomStatus":2,"playBackList":null,"recordVideoList":null,"studentCode":null}]
     * totalCount : null
     */

    private boolean success;
    private String statusCode;
    private Object errorMsg;
    private Object msg;
    private Object totalCount;
    private List<ContentBean> content;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Object getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(Object errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public Object getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Object totalCount) {
        this.totalCount = totalCount;
    }

    public List<ContentBean> getContent() {
        return content;
    }

    public void setContent(List<ContentBean> content) {
        this.content = content;
    }

    public static class ContentBean {
        /**
         * courseLessonId : 411393
         * courseLessonSn : null
         * courseLessonName : 课次1
         * broadcastRoomId : null
         * startDate : null
         * startTime : 2020-04-01 14:25:00
         * endTime : 2020-04-01 17:25:00
         * courseGenseeId : null
         * courseVideoId : null
         * roomId : null
         * teacherId : null
         * status : 1
         * orderNum : null
         * createBy : null
         * createTime : 2020-04-01 14:11:38
         * updateBy : null
         * updateTime : null
         * isdelete : null
         * courseId : 410602
         * courseStatus : null
         * assistantToken : null
         * studentToken : null
         * teacherToken : null
         * studentClientToken : null
         * teacherJoinUrl : null
         * studentJoinUrl : null
         * masterTeacher : 颜雯雅
         * assistantName : null
         * defaultVideo : null
         * mp4 : null
         * vid : null
         * genseeStatus : null
         * teachingMethod : 2
         * roomUrl : null
         * viewTime : null
         * findType : null
         * courseName : null
         * subjectId : null
         * backLook : false
         * roomStatus : 2
         * playBackList : null
         * recordVideoList : null
         * studentCode : null
         */

        private int courseLessonId;
        private Object courseLessonSn;
        private String courseLessonName;
        private Object broadcastRoomId;
        private Object startDate;
        private String startTime;
        private String endTime;
        private Object courseGenseeId;
        private Object courseVideoId;
        private Object roomId;
        private Object teacherId;
        private int status;
        private Object orderNum;
        private Object createBy;
        private String createTime;
        private Object updateBy;
        private Object updateTime;
        private Object isdelete;
        private int courseId;
        private Object courseStatus;
        private Object assistantToken;
        private Object studentToken;
        private Object teacherToken;
        private Object studentClientToken;
        private Object teacherJoinUrl;
        private Object studentJoinUrl;
        private String masterTeacher;
        private Object assistantName;
        private Object defaultVideo;
        private Object mp4;
        private Object vid;
        private Object genseeStatus;
        private int teachingMethod;
        private Object roomUrl;
        private Object viewTime;
        private Object findType;
        private Object courseName;
        private Object subjectId;
        private boolean backLook;
        private int roomStatus;
        private Object playBackList;
        private Object recordVideoList;
        private int studentCode;

        public int getCourseLessonId() {
            return courseLessonId;
        }

        public void setCourseLessonId(int courseLessonId) {
            this.courseLessonId = courseLessonId;
        }

        public Object getCourseLessonSn() {
            return courseLessonSn;
        }

        public void setCourseLessonSn(Object courseLessonSn) {
            this.courseLessonSn = courseLessonSn;
        }

        public String getCourseLessonName() {
            return courseLessonName;
        }

        public void setCourseLessonName(String courseLessonName) {
            this.courseLessonName = courseLessonName;
        }

        public Object getBroadcastRoomId() {
            return broadcastRoomId;
        }

        public void setBroadcastRoomId(Object broadcastRoomId) {
            this.broadcastRoomId = broadcastRoomId;
        }

        public Object getStartDate() {
            return startDate;
        }

        public void setStartDate(Object startDate) {
            this.startDate = startDate;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public Object getCourseGenseeId() {
            return courseGenseeId;
        }

        public void setCourseGenseeId(Object courseGenseeId) {
            this.courseGenseeId = courseGenseeId;
        }

        public Object getCourseVideoId() {
            return courseVideoId;
        }

        public void setCourseVideoId(Object courseVideoId) {
            this.courseVideoId = courseVideoId;
        }

        public Object getRoomId() {
            return roomId;
        }

        public void setRoomId(Object roomId) {
            this.roomId = roomId;
        }

        public Object getTeacherId() {
            return teacherId;
        }

        public void setTeacherId(Object teacherId) {
            this.teacherId = teacherId;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public Object getOrderNum() {
            return orderNum;
        }

        public void setOrderNum(Object orderNum) {
            this.orderNum = orderNum;
        }

        public Object getCreateBy() {
            return createBy;
        }

        public void setCreateBy(Object createBy) {
            this.createBy = createBy;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(Object updateBy) {
            this.updateBy = updateBy;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public Object getIsdelete() {
            return isdelete;
        }

        public void setIsdelete(Object isdelete) {
            this.isdelete = isdelete;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public Object getCourseStatus() {
            return courseStatus;
        }

        public void setCourseStatus(Object courseStatus) {
            this.courseStatus = courseStatus;
        }

        public Object getAssistantToken() {
            return assistantToken;
        }

        public void setAssistantToken(Object assistantToken) {
            this.assistantToken = assistantToken;
        }

        public Object getStudentToken() {
            return studentToken;
        }

        public void setStudentToken(Object studentToken) {
            this.studentToken = studentToken;
        }

        public Object getTeacherToken() {
            return teacherToken;
        }

        public void setTeacherToken(Object teacherToken) {
            this.teacherToken = teacherToken;
        }

        public Object getStudentClientToken() {
            return studentClientToken;
        }

        public void setStudentClientToken(Object studentClientToken) {
            this.studentClientToken = studentClientToken;
        }

        public Object getTeacherJoinUrl() {
            return teacherJoinUrl;
        }

        public void setTeacherJoinUrl(Object teacherJoinUrl) {
            this.teacherJoinUrl = teacherJoinUrl;
        }

        public Object getStudentJoinUrl() {
            return studentJoinUrl;
        }

        public void setStudentJoinUrl(Object studentJoinUrl) {
            this.studentJoinUrl = studentJoinUrl;
        }

        public String getMasterTeacher() {
            return masterTeacher;
        }

        public void setMasterTeacher(String masterTeacher) {
            this.masterTeacher = masterTeacher;
        }

        public Object getAssistantName() {
            return assistantName;
        }

        public void setAssistantName(Object assistantName) {
            this.assistantName = assistantName;
        }

        public Object getDefaultVideo() {
            return defaultVideo;
        }

        public void setDefaultVideo(Object defaultVideo) {
            this.defaultVideo = defaultVideo;
        }

        public Object getMp4() {
            return mp4;
        }

        public void setMp4(Object mp4) {
            this.mp4 = mp4;
        }

        public Object getVid() {
            return vid;
        }

        public void setVid(Object vid) {
            this.vid = vid;
        }

        public Object getGenseeStatus() {
            return genseeStatus;
        }

        public void setGenseeStatus(Object genseeStatus) {
            this.genseeStatus = genseeStatus;
        }

        public int getTeachingMethod() {
            return teachingMethod;
        }

        public void setTeachingMethod(int teachingMethod) {
            this.teachingMethod = teachingMethod;
        }

        public Object getRoomUrl() {
            return roomUrl;
        }

        public void setRoomUrl(Object roomUrl) {
            this.roomUrl = roomUrl;
        }

        public Object getViewTime() {
            return viewTime;
        }

        public void setViewTime(Object viewTime) {
            this.viewTime = viewTime;
        }

        public Object getFindType() {
            return findType;
        }

        public void setFindType(Object findType) {
            this.findType = findType;
        }

        public Object getCourseName() {
            return courseName;
        }

        public void setCourseName(Object courseName) {
            this.courseName = courseName;
        }

        public Object getSubjectId() {
            return subjectId;
        }

        public void setSubjectId(Object subjectId) {
            this.subjectId = subjectId;
        }

        public boolean isBackLook() {
            return backLook;
        }

        public void setBackLook(boolean backLook) {
            this.backLook = backLook;
        }

        public int getRoomStatus() {
            return roomStatus;
        }

        public void setRoomStatus(int roomStatus) {
            this.roomStatus = roomStatus;
        }

        public Object getPlayBackList() {
            return playBackList;
        }

        public void setPlayBackList(Object playBackList) {
            this.playBackList = playBackList;
        }

        public Object getRecordVideoList() {
            return recordVideoList;
        }

        public void setRecordVideoList(Object recordVideoList) {
            this.recordVideoList = recordVideoList;
        }

//        public Object getStudentCode() {
//            return studentCode;
//        }
//
//        public void setStudentCode(Object studentCode) {
//            this.studentCode = studentCode;
//        }
    }
}
