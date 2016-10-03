package com.example.hau.session9viewcompoundturn1;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hau on 02/10/2016.
 */
public class ViewCompound extends RelativeLayout {
    @BindView(R.id.tv_progess)
    TextView tvProgess;
    @BindView(R.id.tv_value)
    TextView tvLabel;
    @BindView(R.id.iv_plus)
    ImageView ivPlus;
    @BindView(R.id.iv_subtraction)
    ImageView ivSubtraction;
    private int progess;
    private String label;

    public ViewCompound(Context context) {
        super(context);
        initFromContext(context, null);
    }


    public ViewCompound(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFromContext(context, attrs);
    }

    public ViewCompound(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFromContext(context, attrs);
    }

    private void initFromContext(Context context, AttributeSet attrs) {
        if (attrs != null) {
            View view = inflate(context, R.layout.view_compound, this);
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ViewCompound);
            this.progess = typedArray.getInt(R.styleable.ViewCompound_value, -1);
            this.label = typedArray.getString(R.styleable.ViewCompound_label);

            typedArray.recycle();
            ButterKnife.bind(this, view);
            if (progess != -1) {
                updateUI();
            }
            addListeners();
        }
    }

    private void addListeners() {
        ivPlus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                progess++;
                updateUI();
            }
        });
        ivSubtraction.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                progess--;
                updateUI();
            }
        });
    }


    private void updateUI() {
        tvProgess.setText(String.format("%s", this.progess));
        tvLabel.setText(String.format("%s", this.label));
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
        updateUI();
    }

    public int getProgess() {
        return progess;
    }

    public void setProgess(int progess) {
        this.progess = progess;
        updateUI();
    }
}
