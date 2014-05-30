package com.krossovochkin.fontabletextview;

/**
 * Created by v.drobushkov on 5/30/14.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by v.drobushkov on 5/28/14.
 */
public class FontableTextView extends TextView {

    public FontableTextView(Context context) {
        super(context);
    }

    public FontableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs);

    }

    public FontableTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FontableTextView);

        if(a != null) {
            int typefaceId = a.getInt(R.styleable.FontableTextView_typeface, 0);
            this.setTypeface(FontManager.getTypeface(typefaceId));
            a.recycle();
        } else {
            Log.d(FontableTextView.class.getSimpleName(), "no typeface defined");
        }
    }

}