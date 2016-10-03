package com.example.hau.session9turn3a;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by Hau on 02/10/2016.
 */
public class SquareRelative extends RelativeLayout {
    public SquareRelative(Context context) {
        super(context);
    }

    public SquareRelative(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareRelative(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        widthSize = widthSize / 2;
        int widthMode = MeasureSpec.EXACTLY;
        int newWidth = MeasureSpec.makeMeasureSpec(widthSize, widthMode);
        super.onMeasure(newWidth, heightMeasureSpec);
    }
}
