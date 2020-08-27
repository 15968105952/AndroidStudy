package com.lahm.learndaemon.designpatterns.bulider;

/**
 * ================================================
 * Description:
 * <p>
 * Created by mz on 2020/8/27 16:59
 * ================================================
 */
public class BuliderTest {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();//创建建造者实例，（装机人员）
        Director direcror = new Director(builder);//创建指挥者实例，并分配相应的建造者，（老板分配任务）
        direcror.Construct("i7-6700", "三星DDR4", "希捷1T");//组装电脑
    }
}
