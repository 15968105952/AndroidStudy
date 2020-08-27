package com.lahm.learndaemon.designpatterns.bulider;

/**
 * ================================================
 * Description:定义抽象建造者（Builder）：组装电脑的过程
 * <p>
 * Created by mz on 2020/8/27 16:56
 * ================================================
 */
public abstract class Builder {
    public abstract void buildCPU(String cpu);//组装CPU

    public abstract void buildMemory(String memory);//组装内存

    public abstract void buildHD(String hd);//组装硬盘

    public abstract Computer create();//返回组装好的电脑
}
