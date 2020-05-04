package com.lahm.learndaemon.activity.reflex;

import android.util.Log;

public class Person {
    public String say(String what){
        Log.i(Person.class.getSimpleName(),what);
        return  what;
    }
}
