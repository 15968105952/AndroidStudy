package com.lahm.learndaemon.designpatterns.observer;

/**
 * ================================================
 * Description:
 * <p>
 * Created by mz on 2020/8/27 15:37
 * ================================================
 */
public class ObserverTest {
    public static void main(String[] args) {
        Observable observable=new Postman();

        Observer observer1=new Boy("小明");
        Observer observer2=new Boy("小白");
        Observer observer3=new Girl("小花");
        observable.add(observer1);
        observable.add(observer2);
        observable.add(observer3);

        observable.notify("快递到了,请下楼领取.");
    }
}
