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
public class NodeList {

    private int nodeId;
    private String nodeTitle;
    private int nodeSort;
    private int nodeScore;
    private List<QuestionList> questionList;
    public void setNodeId(int nodeId) {
         this.nodeId = nodeId;
     }
     public int getNodeId() {
         return nodeId;
     }

    public void setNodeTitle(String nodeTitle) {
         this.nodeTitle = nodeTitle;
     }
     public String getNodeTitle() {
         return nodeTitle;
     }

    public void setNodeSort(int nodeSort) {
         this.nodeSort = nodeSort;
     }
     public int getNodeSort() {
         return nodeSort;
     }

    public void setNodeScore(int nodeScore) {
         this.nodeScore = nodeScore;
     }
     public int getNodeScore() {
         return nodeScore;
     }

    public void setQuestionList(List<QuestionList> questionList) {
         this.questionList = questionList;
     }
     public List<QuestionList> getQuestionList() {
         return questionList;
     }

}