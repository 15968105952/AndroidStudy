package com.lahm.learndaemon.designpatterns.observer;

/**
 * ================================================
 * Description:
 * <p>
 * Created by mz on 2020/8/27 15:34
 * ================================================
 */
interface Observable {
    void add(Observer observer);//添加观察者

    void remove(Observer observer);//删除观察者

    void notify(String message);//通知观察者
}