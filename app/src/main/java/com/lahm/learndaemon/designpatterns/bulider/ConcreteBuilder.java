package com.lahm.learndaemon.designpatterns.bulider;

/**
 * ================================================
 * Description:创建具体的建造者（ConcreteBuilder）:装机人员
 * <p>
 * Created by mz on 2020/8/27 16:57
 * ================================================
 */
public class ConcreteBuilder extends Builder {
    //创建产品实例
    private Computer mComputer = new Computer();

    @Override
    public void buildCPU(String cpu) {
        mComputer.setCPU(cpu);
        System.out.println(mComputer.getmCPU());
    }

    @Override
    public void buildMemory(String memory) {
        mComputer.setMemory(memory);
        System.out.println(mComputer.getmMemory());
    }

    @Override
    public void buildHD(String hd) {
        mComputer.setHD(hd);
        System.out.println(mComputer.getmHD());
    }

    @Override
    public Computer create() {
        return mComputer;
    }
}
