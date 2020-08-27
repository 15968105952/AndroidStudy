package com.lahm.learndaemon.designpatterns.retrofit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ================================================
 * Description:
 * <p>
 * Created by mz on 2020/8/27 8:59
 * ================================================
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Post {
    // 请求地址
    String value();
}
