package com.lahm.learndaemon.designpatterns.bulider;

/**
 * ================================================
 * Description:定义指挥者类（Director）：老板委派任务给装机人员
 * <p>
 * Created by mz on 2020/8/27 16:58
 * ================================================
 */
public class Director {
    private Builder mBuild = null;

    public Director(Builder build) {
        this.mBuild = build;
    }

    //指挥装机人员组装电脑
    public void Construct(String cpu, String memory, String hd) {
        mBuild.buildCPU(cpu);
        mBuild.buildMemory(memory);
        mBuild.buildHD(hd);
    }
}
