package com.lahm.learndaemon.activity.reflex;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MyToast {
    Context mContext;

    private Toast mToast;
    private Field field;
    private Object obj;
    private Method showMethod, hideMethod;

    public MyToast(Context c, View v) {
        this.mContext = c;
        mToast = new Toast(mContext);
        mToast.setView(v);

        reflectionTN();
    }

    public void show() {
        try {
            showMethod.invoke(obj, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cancel() {
        try {
            hideMethod.invoke(obj, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void reflectionTN() {
        try {
            field = mToast.getClass().getDeclaredField("mTN");
            field.setAccessible(true);
            obj = field.get(mToast);
            showMethod = obj.getClass().getDeclaredMethod("show", null);
            hideMethod = obj.getClass().getDeclaredMethod("hide", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
