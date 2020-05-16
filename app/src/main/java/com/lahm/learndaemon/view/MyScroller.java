package com.lahm.learndaemon.view;

import android.content.Context;

public class MyScroller {

	private Context context;
	private int startX;
	private int startY;
	private int distanceX;
	private int distanceY;
	private int currentX;
	private long duration = 250;

	private boolean isFinish;
	private long startTime;

	public MyScroller(Context context) {
		this.context = context;
	}

	public void startScroll(int startX, int startY, int distanceX, int distanceY) {
		this.startX = startX;
		this.startY = startY;
		this.distanceX = distanceX;
		this.distanceY = distanceY;
		isFinish = false;
		startTime = System.currentTimeMillis();
	}

	// ���ص�ǰ�Ƿ����˶�
	public boolean computeScrollOffset() {
		if (isFinish) {
			return false;
		}

		long passTime = System.currentTimeMillis() - startTime;

		if (passTime < duration) {
			// ˵�������˶� �����˶� ��ǰλ��= ��ʼλ��+�ƶ����루�ٶ�*��ǰ������ʱ�䣩
			// ����Ǽ����أ� vt+1/2*at

			currentX = (int) (startX + passTime * distanceX / duration);
//			currentX = (int) (startX + (passTime * passTime) * distanceX
//					/ (duration * duration));
		} else {
			// �˶�����
			currentX = startX + distanceX;

			isFinish = true;
		}

		return true;
	}

	public int getCurrX() {
		return currentX;
	}

}
