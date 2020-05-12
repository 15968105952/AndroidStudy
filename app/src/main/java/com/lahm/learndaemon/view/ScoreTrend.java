package com.lahm.learndaemon.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.lahm.learndaemon.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Lusheast
 * E-mail：lusheast@163.cn
 * Date: on 2019-05-29 14:27
 * Desc:
 */
public class ScoreTrend extends View {

    private float viewWith;
    private float viewHeight;

    private float brokenLineWith = 0.5f;

    private int brokenLineColor = 0xff02bbb7;
    private int straightLineColor = 0xffe2e2e2;//0xffeaeaea
    private int textNormalColor = 0xff7e7e7e;

    private int maxScore = 60;
    private int minScore = 0;

    private int monthCount = 7;
    private int selectMonth = 7;//选中的月份

    private List<String> mYTextList = new ArrayList<>();
    private List<String> mXTextList = new ArrayList<>();
    private List<String> mXWeekTextList = new ArrayList<>();
    private int[] score = new int[]{0, 10, 40, 20, 30, 60, 30};
    private int[] mRealscore = new int[]{0, 10, 40, 20, 30, 60, 30};


    private List<Point> scorePoints;

    private int textSize = dipToPx(15);

    //折线画笔
    private Paint brokenPaint;
    //直线的画笔
    private Paint straightPaint;
    //绘制文字的画笔
    private Paint textPaint;

    private Path brokenPath;


    private Context mContext;
    private float height;

    public ScoreTrend(Context context) {
        super(context);
        initConfig(context, null);
        init();
    }

    public ScoreTrend(Context context, AttributeSet attrs) {
        super(context, attrs);
        initConfig(context, attrs);
        init();
    }

    public ScoreTrend(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initConfig(context, attrs);
        init();

    }

    /**
     * 初始化布局配置
     *
     * @param context
     * @param attrs
     */
    private void initConfig(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ScoreTrend);
        this.mContext = context;
        maxScore = a.getInt(R.styleable.ScoreTrend_max_score, 60);
        minScore = a.getInt(R.styleable.ScoreTrend_min_score, 0);
        brokenLineColor = a.getColor(R.styleable.ScoreTrend_broken_line_color, brokenLineColor);

        a.recycle();

    }

    private void init() {
        brokenPath = new Path();

        brokenPaint = new Paint();
        brokenPaint.setAntiAlias(true);
        brokenPaint.setStyle(Paint.Style.STROKE);
        brokenPaint.setStrokeWidth(dipToPx(brokenLineWith));
        brokenPaint.setStrokeCap(Paint.Cap.ROUND);

        straightPaint = new Paint();
        straightPaint.setAntiAlias(true);
        straightPaint.setStyle(Paint.Style.STROKE);
        straightPaint.setStrokeWidth(brokenLineWith);
        straightPaint.setColor((straightLineColor));
        straightPaint.setStrokeCap(Paint.Cap.ROUND);


        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor((textNormalColor));
        textPaint.setTextSize(dipToPx(15));


    }

    private void initData() {
        scorePoints = new ArrayList<>();
        float maxScoreYCoordinate = viewHeight * 0.02f;
        float minScoreYCoordinate = height;

        Log.v("test", "initData:maxScoreYCoordinate " + maxScoreYCoordinate);

        float newWith = viewWith - (viewWith * 0.15f) * 2;//分隔线距离最左边和最右边的距离是0.15倍的viewWith
        int coordinateX;

        for (int i = 0; i < score.length; i++) {
            Log.v("ScoreTrend", "initData: " + score[i]);
            Point point = new Point();
            coordinateX = (int) (newWith * ((float) (i) / (monthCount - 1)) + (viewWith * 0.15f));
            point.x = coordinateX;
            if (score[i] > maxScore) {
                score[i] = maxScore;
            } else if (score[i] < minScore) {
                score[i] = minScore;
            }
//            point.y = (int) (((float) (maxScore - score[i]) / (maxScore - minScore)) * (minScoreYCoordinate - maxScoreYCoordinate) + maxScoreYCoordinate);

            if (score[i] >= maxScore) {
                //学习时间等于最大值
                point.y = (int) (height/7);
            } else {
                //正常，按比例
                point.y = (int) (((float) (maxScore - score[i]) / (maxScore - minScore)) * height);
            }
            scorePoints.add(point);
           Log.i("scorePoint","point.x"+point.x+","+"point.y"+point.y);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewWith = w;
        viewHeight = h;
        height = viewHeight * 0.7f;
        initData();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //绘制X轴
        drawXLine(canvas);
        //绘制文字
        drawText(canvas);
        //绘制折线
        drawBrokenLine(canvas);
        drawPoint(canvas);


    }

    //绘制X轴
    private void drawXLine(Canvas canvas) {
        // 实例化路径
        Path mPath = new Path();
        mPath.reset();
        // 定义路径的起点
        straightPaint.setColor(mContext.getResources().getColor(R.color.color_text_999));
        mPath.moveTo(viewWith * 0.15f, height);
        mPath.lineTo(viewWith * 0.9f, height);
        canvas.drawPath(mPath, straightPaint);
    }

    //绘制文本
    private void drawText(Canvas canvas) {
        //文本字体大小
        textPaint.setTextSize(dipToPx(12));
        //文本字体颜色
        textPaint.setColor(textNormalColor);
        //Y轴文字
        for (int i = 0; i < mYTextList.size(); i++) {
            if (i == 7) {
                canvas.drawText(
                        mYTextList.get(i),
                        viewWith * 0.15f - dipToPx(20),
                        viewHeight * 0.05f,
                        textPaint);
            } else {
                canvas.drawText(
                        mYTextList.get(i),
                        viewWith * 0.15f - dipToPx(20),
                        (height / 7) * (7 - i),
                        textPaint);
            }
//            if (i == 0) {
//                canvas.drawText(
//                        mYTextList.get(i),
//                        viewWith * 0.15f - dipToPx(20),
//                        height,
//                        textPaint);
//            } else if (i != 0 && i != 7) {
//                canvas.drawText(
//                        mYTextList.get(i),
//                        viewWith * 0.15f - dipToPx(20),
//                        height - (height) /7 * i+ dipToPx(8),
//                        textPaint);
//            }
//
//            if (i == 7) {
//                canvas.drawText(
//                        mYTextList.get(7),
//                        viewWith * 0.15f - dipToPx(20),
//                        viewHeight * 0.05f,
//                        textPaint);
//            }
        }

        textPaint.setColor(0xff7c7c7c);

        float newWith = viewWith - (viewWith * 0.15f) * 2;//分隔线距离最左边和最右边的距离是0.15倍的viewWith
        float coordinateX;//分隔线X坐标
        textPaint.setTextSize(dipToPx(12));
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(textNormalColor);
        textSize = (int) textPaint.getTextSize();
        //X轴文字
        for (int i = 0; i < mXTextList.size(); i++) {
            coordinateX = newWith * ((float) (i) / (monthCount - 1)) + (viewWith * 0.15f);
            //绘制日期
            canvas.drawText(mXTextList.get(i), coordinateX, height + dipToPx(4) + textSize + dipToPx(5), textPaint);
            canvas.drawText(mXWeekTextList.get(i), coordinateX, viewHeight * 0.8f + dipToPx(4) + textSize + dipToPx(5), textPaint);
            textPaint.setColor(textNormalColor);

        }

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.getParent().requestDisallowInterceptTouchEvent(true);//一旦底层View收到touch的action后调用这个方法那么父层View就不会再调用onInterceptTouchEvent了，也无法截获以后的action

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                onActionUpEvent(event);
                this.getParent().requestDisallowInterceptTouchEvent(false);
                break;
            case MotionEvent.ACTION_CANCEL:
                this.getParent().requestDisallowInterceptTouchEvent(false);
                break;
        }
        return true;
    }

    private void onActionUpEvent(MotionEvent event) {
        boolean isValidTouch = validateTouch(event.getX(), event.getY());
        //坐标点击统计
        if (isValidTouch) {
            invalidate();
        }
    }

    //是否是有效的触摸范围
    private boolean validateTouch(float x, float y) {

        //曲线触摸区域
        for (int i = 0; i < scorePoints.size(); i++) {
            // dipToPx(8)乘以2为了适当增大触摸面积
            if (x > (scorePoints.get(i).x - dipToPx(8) * 2) && x < (scorePoints.get(i).x + dipToPx(8) * 2)) {
                if (y > (scorePoints.get(i).y - dipToPx(8) * 2) && y < (scorePoints.get(i).y + dipToPx(8) * 2)) {
                    selectMonth = i + 1;
                    return true;
                }
            }
        }

        //月份触摸区域
        //计算每个月份X坐标的中心点
        float monthTouchY = height - dipToPx(3);//减去dipToPx(3)增大触摸面积

        float newWith = viewWith - (viewWith * 0.15f) * 2;//分隔线距离最左边和最右边的距离是0.15倍的viewWith
        float validTouchX[] = new float[mXTextList.size()];
        for (int i = 0; i < mXTextList.size(); i++) {
            validTouchX[i] = newWith * ((float) (i) / (monthCount - 1)) + (viewWith * 0.15f);
        }

        if (y > monthTouchY) {
            for (int i = 0; i < validTouchX.length; i++) {
                Log.v("ScoreTrend", "validateTouch: validTouchX:" + validTouchX[i]);
                if (x < validTouchX[i] + dipToPx(8) && x > validTouchX[i] - dipToPx(8)) {
                    Log.v("ScoreTrend", "validateTouch: " + (i + 1));
                    selectMonth = i + 1;
                    return true;
                }
            }
        }

        return false;
    }


    //绘制折线穿过的点
    protected void drawPoint(Canvas canvas) {
        if (scorePoints == null) {
            return;
        }
        brokenPaint.setStrokeWidth(dipToPx(1));
        for (int i = 0; i < scorePoints.size(); i++) {
            brokenPaint.setColor(brokenLineColor);
            brokenPaint.setStyle(Paint.Style.STROKE);

            brokenPaint.setColor(Color.WHITE);
            brokenPaint.setStyle(Paint.Style.FILL);
            if (i == selectMonth - 1) {
                brokenPaint.setColor(mContext.getResources().getColor(R.color.color_red10));
                canvas.drawCircle(scorePoints.get(i).x, scorePoints.get(i).y, dipToPx(15f), brokenPaint);
                brokenPaint.setColor(mContext.getResources().getColor(R.color.color_red20));
                canvas.drawCircle(scorePoints.get(i).x, scorePoints.get(i).y, dipToPx(8f), brokenPaint);
                brokenPaint.setColor(mContext.getResources().getColor(R.color.color_red));
                canvas.drawCircle(scorePoints.get(i).x, scorePoints.get(i).y, dipToPx(4), brokenPaint);

                //绘制浮动文本背景框
                drawFloatTextBackground(canvas, scorePoints.get(i).x, scorePoints.get(i).y - dipToPx(15f), i);

                textPaint.setColor(0xffffffff);
                //绘制浮动文字
                String contentText = String.valueOf(mRealscore[i]);
                canvas.drawText(contentText, scorePoints.get(i).x, scorePoints.get(i).y - dipToPx(15f) - textSize, textPaint);

                brokenPath.reset();
                brokenPaint.setColor(mContext.getResources().getColor(R.color.app_color));
                brokenPaint.setStyle(Paint.Style.STROKE);

                Path mPath = new Path();
                mPath.reset();
                // 定义路径的起点
                straightPaint.setColor(mContext.getResources().getColor(R.color.app_color));
                mPath.moveTo(scorePoints.get(i).x, scorePoints.get(i).y);
                mPath.lineTo(scorePoints.get(i).x, height);
                canvas.drawPath(mPath, straightPaint);
            }
//            brokenPaint.setColor(0xffffffff);
//            canvas.drawCircle(scorePoints.get(i).x, scorePoints.get(i).y, dipToPx(1.5f), brokenPaint);
//            brokenPaint.setStyle(Paint.Style.STROKE);
//            brokenPaint.setColor(brokenLineColor);
//            canvas.drawCircle(scorePoints.get(i).x, scorePoints.get(i).y, dipToPx(2.5f), brokenPaint);
        }
    }


    //绘制折线
    private void drawBrokenLine(Canvas canvas) {
        brokenPath.reset();
        brokenPaint.setColor(mContext.getResources().getColor(R.color.app_color));
        brokenPaint.setStyle(Paint.Style.STROKE);
        if (score.length == 0) {
            return;
        }
        Log.v("ScoreTrend", "drawBrokenLine: " + scorePoints.get(0));
        brokenPath.moveTo(scorePoints.get(0).x, scorePoints.get(0).y);
        for (int i = 0; i < scorePoints.size(); i++) {
            brokenPath.lineTo(scorePoints.get(i).x, scorePoints.get(i).y);
            Log.i("scorePoint", scorePoints.get(i).x + "," + scorePoints.get(i).y);
        }
        canvas.drawPath(brokenPath, brokenPaint);

    }

    //绘制显示浮动文字的背景
    private void drawFloatTextBackground(Canvas canvas, int x, int y, int i) {
        brokenPath.reset();
        brokenPaint.setColor(mContext.getResources().getColor(R.color.app_color));
        brokenPaint.setStyle(Paint.Style.FILL);
        //P1
        Point point = new Point(x, y);
        brokenPath.moveTo(point.x, point.y);

        //P2
        point.x = point.x + dipToPx(5);
        point.y = point.y - dipToPx(5);
        brokenPath.lineTo(point.x, point.y);

        //P3
        point.x = point.x + dipToPx(20);
        brokenPath.lineTo(point.x, point.y);

        //P4
        point.y = point.y - dipToPx(25);
        brokenPath.lineTo(point.x, point.y);

        //P5
        point.x = point.x - dipToPx(50);
        brokenPath.lineTo(point.x, point.y);

        //P6
        point.y = point.y + dipToPx(25);
        brokenPath.lineTo(point.x, point.y);

        //P7
        point.x = point.x + dipToPx(20);
        brokenPath.lineTo(point.x, point.y);

        //最后一个点连接到第一个点
        brokenPath.lineTo(x, y);

        canvas.drawPath(brokenPath, brokenPaint);
    }


    public int[] getScore() {
        return score;
    }

    public void setScore(int[] score) {
        this.score = score;
        initData();
    }

    public void setRealScore(int[] score) {
        this.mRealscore = score;
        initData();
    }

    public void setYScore(List<String> yList) {
        this.mYTextList = yList;
        initData();
    }

    public void setXScore(List<String> xList) {
        this.mXTextList = xList;
        initData();
    }

    public void setXWeekScore(List<String> xWeekList) {
        this.mXWeekTextList = xWeekList;
        initData();
    }


    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public void setMinScore(int minScore) {
        this.minScore = minScore;
    }

    /**
     * dip 转换成px
     *
     * @param dip
     * @return
     */
    private int dipToPx(float dip) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (dip * density + 0.5f * (dip >= 0 ? 1 : -1));
    }
}
