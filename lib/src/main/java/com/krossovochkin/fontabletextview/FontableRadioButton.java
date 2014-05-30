package com.krossovochkin.fontabletextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RadioButton;

/**
 * Created by v.drobushkov on 5/30/14.
 */
public class FontableRadioButton extends RadioButton {

    public FontableRadioButton(Context context) {
        super(context);
    }

    public FontableRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs);

    }

    public FontableRadioButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FontableRadioButton);

        if(a != null) {
            int typefaceId = a.getInt(R.styleable.FontableRadioButton_typeface, 0);
            this.setTypeface(FontManager.getTypeface(typefaceId));
            a.recycle();
        } else {
            Log.d(FontableTextView.class.getSimpleName(), "no typeface defined");
        }
    }

}
