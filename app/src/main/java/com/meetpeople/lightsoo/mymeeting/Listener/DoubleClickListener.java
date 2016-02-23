package com.meetpeople.lightsoo.mymeeting.Listener;

import android.os.SystemClock;
import android.view.View;

/**
 * Created by LG on 2016-02-19.
 */
public abstract class DoubleClickListener implements View.OnClickListener {
    // The time in which the second tap should be done in order to qualify as
    // a double click
    //더블클릭 시간 0.2
    private static final long DEFAULT_QUALIFICATION_SPAN = 200;
    //새로 설정된시간
    private long doubleClickQualificationSpanInMillis;
    private long timestampLastClick;

    public DoubleClickListener() {
        doubleClickQualificationSpanInMillis = DEFAULT_QUALIFICATION_SPAN;
        timestampLastClick = 0;
    }
    //더블클릭 시간설정
    public DoubleClickListener(long doubleClickQualificationSpanInMillis) {
        this.doubleClickQualificationSpanInMillis = doubleClickQualificationSpanInMillis;
        timestampLastClick = 0;
    }
    @Override
    public void onClick(View v) {
        if((SystemClock.elapsedRealtime() - timestampLastClick) < doubleClickQualificationSpanInMillis) {
            onDoubleClick();
        }
        timestampLastClick = SystemClock.elapsedRealtime();
    }

    public abstract void onDoubleClick();
}
