package com.lahm.learndaemon.designpatterns.retrofit;

/**
 * ================================================
 * Description:
 * <p>
 * Created by mz on 2020/8/27 9:17
 * ================================================
 */
interface Api {
    /**
     * @param name 用户名
     */
    @Post("/postTest")
    public String postTest(String name);

    @Get("/getTest")
    public String getTest(String name);
}