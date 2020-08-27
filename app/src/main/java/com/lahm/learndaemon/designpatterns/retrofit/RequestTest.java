package com.lahm.learndaemon.designpatterns.retrofit;

/**
 * ================================================
 * Description:
 * <p>
 * Created by mz on 2020/8/27 9:24
 * ================================================
 */
public class RequestTest {
    public static void main(String[] args) {
        // 创建接口实现类,代理对象搞定
        Api api = Retrofit.create(Api.class);

        System.out.println(api.getClass().getName());

        String result = api.getTest("cxj");
        String result1 = api.postTest("cxj");

        System.out.println("result = " + result+result1);
    }
}
