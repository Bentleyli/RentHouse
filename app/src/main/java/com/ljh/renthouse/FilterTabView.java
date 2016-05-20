package com.ljh.renthouse;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by my on 2016/5/20.
 */
public class FilterTabView extends LinearLayout implements View.OnClickListener {

    private View view;
    private TextView text;
    private boolean isChecked;

    public FilterTabView(Context context) {
        super(context);
    }

    public FilterTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onClick(View v) {

    }
}
