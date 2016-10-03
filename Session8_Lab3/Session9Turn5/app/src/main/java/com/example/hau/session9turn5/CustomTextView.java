package com.example.hau.session9turn5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

import butterknife.BindColor;
import butterknife.ButterKnife;

/**
 * Created by Hau on 03/10/2016.
 */
public class CustomTextView extends TextView {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    @BindColor(R.color.colorAccent)
    int accent;
    @BindColor(R.color.colorPrimary)
    int primary;
    public CustomTextView(Context context) {
        super(context);
        ButterKnife.bind(this, this);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        ButterKnife.bind(this, this);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ButterKnife.bind(this, this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(accent);
        canvas.drawCircle(250, 200, 100, paint);
        paint.setColor(primary);
        canvas.drawCircle(350, 200, 100, paint);
    }
}
