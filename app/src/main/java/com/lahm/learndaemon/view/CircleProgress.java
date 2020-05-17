package com.lahm.learndaemon.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.lahm.learndaemon.utils.Utility;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Copyright (C), 2018-2018
 * FileName:
 * Author:       肖冲
 * Date:         2019/3/7 10:59
 * Description: 圆形进度条
 */
public class CircleProgress extends AppCompatTextView {
   Handler handler=new android.os.Handler(){
       @Override
       public void handleMessage(Message msg) {
           invalidate();
       }
       };

    public CircleProgress(Context context) {
        super(context);
        init();
    }

    public CircleProgress(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircleProgress(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    Paint mTextPaint; //文字画笔
    Paint mProgressPaint; //进度条画笔

    int progressBgColor; //进度的背景颜色
    int progressColor;//进度颜色
    private int progress;
    private String txt_progress;

    private int radis_point = Utility.dip2px(getContext(), 4);
    private int ring_width = Utility.dip2px(getContext(), 2);


    private void init() {
        mTextPaint = getPaint();
        mTextPaint.setAntiAlias(true);

        mProgressPaint = new Paint();
        mProgressPaint.setAntiAlias(true);
        mProgressPaint.setStyle(Paint.Style.STROKE);
        mProgressPaint.setStrokeWidth(ring_width);

        progressBgColor = Color.parseColor("#E6E6E6");
        progressColor = getCurrentTextColor();

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int cX = width / 2;
        int cY = height / 2;
        int radiu = cX - radis_point - ring_width / 2;
        //画环背景
        mProgressPaint.setColor(progressBgColor);
        canvas.drawCircle(cX, cY, radiu, mProgressPaint);

        //画进度颜色
        RectF rectF = new RectF(radis_point + ring_width / 2, radis_point + ring_width / 2, width - radis_point - ring_width / 2, height - radis_point - ring_width / 2);
        mProgressPaint.setColor(progressColor);
        float sweepAngle = progress * 1f / MAX_PROGRESS * 360;
        canvas.drawArc(rectF, -90, sweepAngle, false, mProgressPaint);
//        canvas.drawArc(rectF, -90, 360, true, mProgressPaint);

        double angle = (Math.PI * (90 - sweepAngle) / 180);


        //画进度的圆点
        float cx = cX + (float) (radiu * Math.cos(angle));
        float cy = cY - (float) (radiu * Math.sin(angle));
        canvas.drawCircle(cx, cy, radis_point, mTextPaint);

        //画 文字
        txt_progress = progress + "″";
        float textW = mTextPaint.measureText(txt_progress);
        float textH = (mTextPaint.getFontMetrics().descent - mTextPaint.getFontMetrics().ascent) / 2;
        float textX = width / 2 - textW / 2;
        float textY = height / 2 + textH / 2;

        canvas.drawText(txt_progress, 0, txt_progress.length(), textX, textY, mTextPaint);
    }

    private static final int MAX_PROGRESS = 20;

    Timer timer;
    TimerTask timerTask;

    public int getProgress() {
        return progress;
    }

    public void start() {
        //开启一个线程去绘制界面
        if (timer != null) timer.cancel();
        if (timerTask != null) timerTask.cancel();

        progress = 0;
        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                if (progress >= MAX_PROGRESS) {
                    if(listener!=null)listener.onMaxProgress();
                    stop();
                    return;
                }
                if (!pausing) {//是否暂停
//                    invalidate();
                    handler.sendEmptyMessage(100);
                    progress++;
                }
            }
        };
        postInvalidate();
        timer.schedule(timerTask, 1000, 1000);
    }

    public void stop() {
        if (timerTask != null)
            timerTask.cancel();
        if (timer != null)
            timer.cancel();
    }

    private boolean pausing = false;  //是否暂停状态

    //暂停或者播放当前进度
    public void togglePause() {
        pausing = !pausing;
    }

    /**
     * 是否是暂停状态
     *
     * @return
     */
    public boolean isPause() {
        return pausing;
    }

    public void setProgress(int progress) {
        this.progress = progress;
        invalidate();
    }

    public void reset() {
        stop();
        setProgress(0);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (timerTask != null) timerTask.cancel();
        timerTask = null;
        if (timer != null) timer.cancel();
        timer = null;
        if(null!=handler){
            handler.removeMessages(100);
            handler=null;
        }
    }

    private onProgressListener listener ;

    public void setOnProgressListener(onProgressListener listener) {
        this.listener = listener;
    }

    public interface onProgressListener{
        void onMaxProgress();

    }
}
