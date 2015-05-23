package com.embassat.view

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.TextView

/**
 * Created by Quique on 23/5/15.
 */

public class ApercuTextView : TextView {

    public constructor(context: Context) : super(context) {
        init()
    }

    public constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    public constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    fun init() {
        setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/apercu-medium.otf"))
    }
}