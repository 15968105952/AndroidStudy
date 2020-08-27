package com.lahm.learndaemon.designpatterns.observer;

/**
 * ================================================
 * Description:
 * <p>
 * Created by mz on 2020/8/27 15:33
 * ================================================
 */
public class Girl implements Observer{
    private String name;//名字

    public Girl(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {//女孩的具体反应
        System.out.println(name + ",收到了信息:" + message + "让男朋友去取快递~");
    }
}
