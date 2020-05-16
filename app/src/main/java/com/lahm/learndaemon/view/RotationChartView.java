package com.lahm.learndaemon.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;


public class RotationChartView extends ViewGroup {

    private static final String TAG = RotationChartView.class.getSimpleName();
    int currentIndex;
    private GestureDetector gestureDetector;
    private MyScroller scoller;
    //    private Scroller scoller;
    private int startX = 0;
    private int endX = 0;
    private int downX = 0;
    private int upX = 0;
    private VelocityTracker mVelocityTracker;
    private int mMinimumFlingVelocity;
    private int mMaximumFlingVelocity;

    private int interceptStartX;
    private int interceptStartY;

    private int interceptEndX;
    private int interceptEndY;
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            if (msg.what == 100) {
                if (scoller.computeScrollOffset()) {
                    int currX = scoller.getCurrX();

                    scrollTo(currX, 0);
                    handler.sendEmptyMessage(100);
                }
            }
        }
    };

    public RotationChartView(Context context) {
        super(context);
        init();
    }

    private void init() {
        // 在初始化时 分别获取当前手机能够感应到的最大和最小手速
        final ViewConfiguration configuration = ViewConfiguration
                .get(getContext());
        // 最大和最小手速 分别是50~8000 只有在这个范围内的速率是我们可以感应到的
        mMinimumFlingVelocity = configuration.getScaledMinimumFlingVelocity();
        mMaximumFlingVelocity = configuration.getScaledMaximumFlingVelocity();
        scoller = new MyScroller(getContext());
        gestureDetector = new GestureDetector(new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                Log.i(TAG, "distanceX:" + distanceX);
//                scrollBy((int)distanceX,0);
                if (distanceX > 0) {
                    if (currentIndex < getChildCount() - 1) {
                        Log.i(TAG, "currentindex:" + currentIndex);
                        Log.i(TAG, "getChildCount():" + getChildCount());
                        currentIndex++;
                    }
                } else {
                    if (currentIndex > 0)
                        currentIndex--;
                }
                scrollTo(currentIndex * getWidth(), 0);
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                return false;
            }
        });
    }

    public RotationChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
     //解决添加布局展示不出来的问题
    // 系统的LinerLayout 他给孩子们排布位置时 参照孩子们计算出的Mesure宽高来决定给他们分配多少控件
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // TODO Auto-generated method stub
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);

        System.out.println("specMode:" + specMode);
        System.out.println("specSize:" + specSize);

        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            view.measure(widthMeasureSpec, heightMeasureSpec);
        }

        // View view1 = null;
        // view1.getMeasuredWidth(); // 获取的是测量的宽高
        //
        // view1.getWidth(); // 获取的是控件的宽度
        // // 如果view的父布局是一个系统控件 比如线性布局或者相对布局

    }
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //遍历得到子view，并给他们指定位置
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            childAt.layout(i * getWidth(), 0, (i + 1) * getWidth(), getHeight());
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        gestureDetector.onTouchEvent(event);
        // 将事件源源不断的交给手势识别器去识别
        // gd.onTouchEvent(event);
        // 获取速率解析器 如果缓冲区中有直接获取
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = (int) event.getX();
                downX = (int) event.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                endX = (int) event.getX();
                int distanceX = startX - endX;
                scrollBy(distanceX, 0);
                startX = endX;
                break;
            case MotionEvent.ACTION_UP:
                Log.i(TAG, "distanceX:" + (event.getX() - downX));
                Log.i(TAG, "getWidth()/2:" + getWidth() / 2);
                // A fling must travel the minimum tap distance
                final VelocityTracker velocityTracker = mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, mMaximumFlingVelocity);
                final float velocityY = velocityTracker.getYVelocity();
                final float velocityX = velocityTracker.getXVelocity();
                System.out.println("手速：" + velocityX);
                if ((Math.abs(velocityX) > 100)) {
                    // 相当于我们解析到了飞划事件
                    // 直接切换下一页
                    System.out.println("手速：" + velocityX);
                    // 手指向右滑动 速率是正值 上一页
                    if (velocityX >0) {
                        if (currentIndex > 0) {
                            currentIndex--;
                        }
                    } else {
                        // 手指向左滑动 速率是负值 下一页
                        if (currentIndex < getChildCount() - 1) {
                            currentIndex++;
                        }
                    }
                } else {
                    // 普通滑动 感应距离的 大于1/2才认为切换下一页
                    upX = (int) event.getX();
                    if (upX - downX > getWidth() / 2) {
                        //手指向右滑动，upx大于downX
                        // 上一页
                        if (currentIndex > 0) {
                            currentIndex--;
                        }
                    } else if (downX - upX > getWidth() / 2) {
                        //手指向左滑动，downX小于upX
                        //下一页
                        if (currentIndex < getChildCount() - 1) {
                            currentIndex++;
                        }
                    }
                }
                if(null!=checkListener){
                    checkListener.getPositon(currentIndex);
                }
                moveToIndex(currentIndex);
                break;
        }
        return true;
    }

    // 拦截事件
    // 我们在
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        boolean flag = false;

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                interceptStartX = (int) ev.getX();
                interceptStartY = (int) ev.getY();

                // 我们在第一次点击时 这个 事件直接传递给ScroolView了 我们并没有收到down事件
                startX = (int) ev.getX();
                downX = (int) ev.getX();
//                tempIndex = currentIndex;
                break;

            case MotionEvent.ACTION_MOVE:

                interceptEndX = (int) ev.getX();
                interceptEndY = (int) ev.getY();

                int distanceX = interceptEndX - interceptStartX;

                int distanceY = interceptEndY - interceptStartY;

                int distacne = (int) Math.sqrt(distanceX * distanceX + distanceY
                        * distanceY);

                if (Math.abs(distanceX) < Math.abs(distanceY) || distacne < 15) {
                    // 竖直距离多一些 优先处理ScrollVew 点击事件
                    flag = false;
                } else {
                    // 水平滑动 优先处理ViewPager
                    flag = true;
                }

                break;

            case MotionEvent.ACTION_UP:

                break;

            default:
                break;
        }

        return flag;
    }

    public void moveToIndex(int index) {
        currentIndex = index;
        // scrollTo(index * getWidth(), 0);
        // 从一个点 移动到另一个点 起始位置 - 目标位置

        // ValueAnimator va = ObjectAnimator.ofInt(getScrollX(), index*
        // getWidth());
        // va.setDuration(500);
        // va.setInterpolator(new DecelerateInterpolator());
        // va.addUpdateListener(new AnimatorUpdateListener() {
        //
        // @Override
        // public void onAnimationUpdate(ValueAnimator animation) {
        // // 获取到每次属性动画改变的值
        // int currentX = (Integer) animation.getAnimatedValue();
        // System.out.println(currentX);
        // scrollTo(currentX, 0);
        // }
        // });
        // va.start();
        scoller.startScroll(getScrollX(), 0, index * getWidth() - getScrollX(),
                0);
        handler.sendEmptyMessage(100);

    }
    public CheckListener checkListener;
    public interface  CheckListener{
        void getPositon(int position);
    }

    public void setCheckListener(CheckListener checkListener){
        this.checkListener=checkListener;
    }
}
