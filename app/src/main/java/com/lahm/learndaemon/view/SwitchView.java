package com.lahm.learndaemon.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.lahm.learndaemon.R;

import static android.content.ContentValues.TAG;

public class SwitchView extends View {

    private Bitmap slideButton;//开关上层图片
    private Bitmap switchBackground;//开关下层背景
    private Paint paint;
    float marginLeft = 0;
    private float startX;
    private float endX;
    private float maxLeftMargin;
    boolean isOpen;//是否开启
    private boolean flag;//标记是否改变
    private float downX;

    public SwitchView(Context context) {
        super(context);
        init();
    }

    private void init() {
//        //获取图片bitmap
//        slideButton = BitmapFactory.decodeResource(getResources(), R.mipmap.slide_button);
//        switchBackground = BitmapFactory.decodeResource(getResources(), R.mipmap.switch_background);
//        maxLeftMargin = switchBackground.getWidth() - slideButton.getWidth();
        //初始化画笔
        paint = new Paint();
        //处理点击事件,ontouchEvent返回为true时无效
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                upDateState();
            }
        });
    }

    private void upDateState() {
        isOpen = !isOpen;
        if (isOpen) {
            marginLeft = maxLeftMargin;
        } else {
            marginLeft = 0;
        }
        invalidate();
    }

    public SwitchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initParams(attrs);
    }

    private void initParams(AttributeSet attrs) {
        //动态自定义属性
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.SwitchView);
        if (typedArray != null) {
            Drawable switchView_slideButton = typedArray.getDrawable(R.styleable.SwitchView_slideButton);
            slideButton = drawableToBitamp(switchView_slideButton);
            Drawable switchView_switchBackground = typedArray.getDrawable(R.styleable.SwitchView_switchBackground);
            switchBackground = drawableToBitamp(switchView_switchBackground);
            maxLeftMargin = switchBackground.getWidth() - slideButton.getWidth();
        }
    }

    private Bitmap drawableToBitamp(Drawable drawable) {
        BitmapDrawable bd = (BitmapDrawable) drawable;
        Bitmap bitmap = bd.getBitmap();
        return bitmap;
    }

    //设置图片宽高，根据最大图片来设置
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(switchBackground.getWidth(), switchBackground.getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画最下面的展示在最上层
        canvas.drawBitmap(switchBackground, 0, 0, paint);
        canvas.drawBitmap(slideButton, marginLeft, 0, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                downX = event.getX();
                flag = isOpen;
                break;
            case MotionEvent.ACTION_MOVE:
                endX = event.getX();
                float moveX = endX - startX;
                Log.i(TAG, "ACTION_MOVE");
                //重新测量上层开关距离左边的距离
                marginLeft += moveX;
                if (marginLeft >= 0 && marginLeft <= maxLeftMargin) {
                    //只有满足距离左边的距离大于0而且小于最大距离才能重新绘制
                    invalidate();
                }
                //移动到哪里哪里就做起始距离
                startX = endX;
                break;
            case MotionEvent.ACTION_UP:
                if (Math.abs(event.getX() - downX) < 10) {
                    //认为是点击事件
                    upDateState();
                } else {
                    //触摸处理
                    touch();
                }
                if (null != switchListener) {
                    //判断是否等于，如果等于，没有改变，不等于，说明改变了，需要通知外部
                    if (flag != isOpen)
                        switchListener.isOpen(isOpen);
                }
                break;
        }
        //必须处理事件，继承无效
        return true;
//       return super.onTouchEvent(event);
    }

    private void touch() {
        if (marginLeft > maxLeftMargin / 2) {
            marginLeft = maxLeftMargin;
            isOpen = true;
        } else {
            marginLeft = 0;
            isOpen = false;
        }
        invalidate();
    }

    private SwitchListener switchListener;

    public interface SwitchListener {
        void isOpen(boolean isOpen);
    }

    public void setSwitchListener(SwitchListener switchListener) {
        this.switchListener = switchListener;
    }
}
