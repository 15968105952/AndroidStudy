package com.lahm.learndaemon.designpatterns.bulider;

/**
 * ================================================
 * Description: 定义具体的产品类（Product）：电脑
 * <p>
 * Created by mz on 2020/8/27 16:55
 * ================================================
 */
public class Computer {

    private String mCPU;
    private String mMemory;
    private String mHD;

    public String getmCPU() {
        return mCPU;
    }

    public String getmMemory() {
        return mMemory;
    }

    public String getmHD() {
        return mHD;
    }


    public void setCPU(String CPU) {
        mCPU = CPU;
    }

    public void setMemory(String memory) {
        mMemory = memory;
    }

    public void setHD(String HD) {
        mHD = HD;
    }
}
