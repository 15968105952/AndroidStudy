package com.lahm.learndaemon.designpatterns.retrofit;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ================================================
 * Description:
 * <p>
 * Created by mz on 2020/8/27 9:24
 * ================================================
 */
public class Retrofit {
    /**
     * 创建代理对象
     *
     * @param service
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T create(Class<T> service) {
        return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class<?>[]{service},
                new MInvocationHandler());
    }

    static class MInvocationHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            boolean annotationPresent = method.isAnnotationPresent(Post.class);
            if (annotationPresent) {
                Post annotation = method.getAnnotation(Post.class);
                String value = annotation.value();
                System.out.println("是一个Post请求,并且返回的路径是:" + value + "\n");
            }
            boolean annotationPresent1 = method.isAnnotationPresent(Get.class);
            if (annotationPresent1) {
                Get annotation = method.getAnnotation(Get.class);
                String value = annotation.value();
                System.out.println("是一个Get请求,并且返回的路径是:" + value + "\n");
            }

            // 返回方法的结果
            return "hello";
        }

    }
}
