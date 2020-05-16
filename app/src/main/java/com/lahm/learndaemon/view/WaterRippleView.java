package com.lahm.learndaemon.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class WaterRippleView extends View {
    float radius = 0;
    private float cx;//圆心的x轴位置
    private float cy;//圆心的y轴位置
    /**
     * 二个相临波浪中心点的最小距离
     */
    private static final int DIS_SOLP = 13;
    private ArrayList<Wave> wList=new ArrayList<>();
    private Paint paint;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            flushData();
            // 刷新页面
            invalidate();
            // 循环动画
            if (isRuning) {
                handler.sendEmptyMessage(80);
            }
        }
    };
    private boolean isRuning;

    public WaterRippleView(Context context) {
        super(context);
        init();
    }

    public WaterRippleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        radius = 0;
        paint = new Paint();
        //抗锯齿
        paint.setAntiAlias(true);
        // 圆边
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(radius / 3);
        paint.setAlpha(255);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            cx = getWidth() / 2;
            cy = getHeight() / 2;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < wList.size(); i++) {
            Wave wave = wList.get(i);
            canvas.drawCircle(wave.cx, wave.cy, wave.r, wave.p);

        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                cx = event.getX();
                cy = event.getY();
//                init();
//                handler.sendEmptyMessage(80);
                addPoint(cx, cy);
                break;
        }
        return true;
    }

    private void addPoint(float cx, float cy) {
        if(wList.size()==0){
            addPoint2List(cx, cy);
            //第一次启动
            isRuning=true;
            handler.sendEmptyMessage(80);
        }else {
            // 取出集合中最后一个对象
            Wave w = wList.get(wList.size() - 1);

            // 防止圆环过于密集
            if (Math.abs(w.cx - cx) > DIS_SOLP || Math.abs(w.cy - cy) > DIS_SOLP) {
                addPoint2List(cx, cy);
            }

        }
    }

    private void addPoint2List(float cx, float cy) {
        Wave wave=new Wave();
        wave.cx=cx;
        wave.cy=cy;
        Paint pa = new Paint();
        pa.setColor(colors[(int) (Math.random() * 4)]);
        pa.setAntiAlias(true);
        pa.setStyle(Paint.Style.STROKE);

        wave.p = pa;

        wList.add(wave);
    }

    private int[] colors = new int[] { Color.BLUE, Color.RED, Color.YELLOW,
            Color.GREEN };

    /**
     * 定义一个波浪
     *
     * @author leo
     */
    private class Wave {
        // 圆心
        float cx;
        float cy;

        // 画笔
        Paint p;
        // 半径
        int r;
    }

    /**
     * 刷新数据
     */
    private void flushData() {

        for (int i = 0; i < wList.size(); i++) {

            Wave w = wList.get(i);

            // 如果透明度为 0 从集合中删除
            int alpha = w.p.getAlpha();
            if (alpha == 0) {
                wList.remove(i); // 删除i 以后，i的值应该再减1
                // 否则会漏掉一个对象，不过，在此处影响不大，效果上看不出来。
                continue;
            }

            alpha -= 5;
            if (alpha < 5) {
                alpha = 0;
            }
            // 降低透明度
            w.p.setAlpha(alpha);

            // 扩大半径
            w.r = w.r + 3;
            // 设置半径厚度
            w.p.setStrokeWidth(w.r / 3);
        }

        /*
         * 如果集合被清空，就停止刷新动画
         */
        if (wList.size() == 0) {
            isRuning = false;
        }
    }
}
