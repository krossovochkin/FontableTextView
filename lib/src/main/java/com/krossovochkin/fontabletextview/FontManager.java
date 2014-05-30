package com.krossovochkin.fontabletextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.SparseArray;
import android.util.TypedValue;

/**
 * Created by v.drobushkov on 5/28/14.
 */
public class FontManager {

    private static final SparseArray<Typeface> sFonts = new SparseArray<Typeface>();

    private static boolean sIsInited = false;

    public static void init(Context context) throws IllegalStateException, IllegalArgumentException {
        if (context.getTheme() != null) {
            TypedArray typefaces = context.getResources().obtainTypedArray(R.attr.typeface);
            String[] fontPaths = context.getResources().getStringArray(R.array.fontPaths);

            if (typefaces != null && fontPaths != null) {

                if (typefaces.length() != fontPaths.length + 1) {
                    throw new IllegalArgumentException("illegal sizes of typefaces and fontPathes arrays");
                }

                for (int i = 1; i < typefaces.length(); i++) {
                    TypedValue value = new TypedValue();
                    typefaces.getValue(i, value);

                    int id = value.data;
                    if (id < 0 || id >= fontPaths.length) {
                        throw new IllegalArgumentException("illegal id: " + id);
                    }

                    Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/" + fontPaths[id] + ".ttf");
                    sFonts.put(id, typeface);
                }

                typefaces.recycle();
            } else {
                throw new IllegalArgumentException("typefaces and/or fontPaths don't exist");
            }

            sIsInited = true;
        } else {
            throw new IllegalStateException("There should be defined theme for the context");
        }
    }

    public static void addTypeface(int id, Typeface typeface) throws IllegalStateException {
        if (!sIsInited) {
            throw new IllegalStateException("FontManager is not inited");
        }
        sFonts.put(id, typeface);
    }

    public static Typeface getTypeface(int id) throws IllegalArgumentException, IllegalStateException {
        if (!sIsInited) {
            throw new IllegalStateException("FontManager is not inited");
        }

        Typeface typeface = sFonts.get(id);

        if (typeface == null) {
            throw new IllegalArgumentException("there is no typeface for id: " + id);
        }
        return typeface;
    }
}