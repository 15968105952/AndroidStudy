package com.lahm.learndaemon.activity.reflex;

import android.util.Log;

public class Person {
    public int getAge() {
        return age;
    }

    private int age;
    private String name;
    private String sex;

    private String say(String what) {
        Log.i(Person.class.getSimpleName(), what);
        return what;
    }
}
