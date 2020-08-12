/**
  * Copyright 2020 bejson.com 
  */
package com.lahm.learndaemon.entity;
import java.util.List;

/**
 * Auto-generated: 2020-07-21 13:21:51
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class QuestionList {

    private String questionId;
    private String questionTitle;
    private int questionTypeId;
    private String questionTypeName;
    private int mark;
    private int sort;
    private List<String> userAnswer;
    private String questionSort;
    private String analysis;
    private int answerNum;
    private List<Option> option;
    private String difficulty;
    private int photograph;
    private int score;
    private int estimateDuration;
    private String status;
    private List<String> child;
    public void setQuestionId(String questionId) {
         this.questionId = questionId;
     }
     public String getQuestionId() {
         return questionId;
     }

    public void setQuestionTitle(String questionTitle) {
         this.questionTitle = questionTitle;
     }
     public String getQuestionTitle() {
         return questionTitle;
     }

    public void setQuestionTypeId(int questionTypeId) {
         this.questionTypeId = questionTypeId;
     }
     public int getQuestionTypeId() {
         return questionTypeId;
     }

    public void setQuestionTypeName(String questionTypeName) {
         this.questionTypeName = questionTypeName;
     }
     public String getQuestionTypeName() {
         return questionTypeName;
     }

    public void setMark(int mark) {
         this.mark = mark;
     }
     public int getMark() {
         return mark;
     }

    public void setSort(int sort) {
         this.sort = sort;
     }
     public int getSort() {
         return sort;
     }

    public void setUserAnswer(List<String> userAnswer) {
         this.userAnswer = userAnswer;
     }
     public List<String> getUserAnswer() {
         return userAnswer;
     }

    public void setQuestionSort(String questionSort) {
         this.questionSort = questionSort;
     }
     public String getQuestionSort() {
         return questionSort;
     }

    public void setAnalysis(String analysis) {
         this.analysis = analysis;
     }
     public String getAnalysis() {
         return analysis;
     }

    public void setAnswerNum(int answerNum) {
         this.answerNum = answerNum;
     }
     public int getAnswerNum() {
         return answerNum;
     }

    public void setOption(List<Option> option) {
         this.option = option;
     }
     public List<Option> getOption() {
         return option;
     }

    public void setDifficulty(String difficulty) {
         this.difficulty = difficulty;
     }
     public String getDifficulty() {
         return difficulty;
     }

    public void setPhotograph(int photograph) {
         this.photograph = photograph;
     }
     public int getPhotograph() {
         return photograph;
     }

    public void setScore(int score) {
         this.score = score;
     }
     public int getScore() {
         return score;
     }

    public void setEstimateDuration(int estimateDuration) {
         this.estimateDuration = estimateDuration;
     }
     public int getEstimateDuration() {
         return estimateDuration;
     }

    public void setStatus(String status) {
         this.status = status;
     }
     public String getStatus() {
         return status;
     }

    public void setChild(List<String> child) {
         this.child = child;
     }
     public List<String> getChild() {
         return child;
     }

}