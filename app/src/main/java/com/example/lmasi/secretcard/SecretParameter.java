package com.example.lmasi.secretcard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by lmasi on 2016-11-07.
 */
public class SecretParameter extends RelativeLayout.LayoutParams {


    public SecretParameter(Context c, AttributeSet attrs) {
        super(c, attrs);
    }

    public SecretParameter(ViewGroup.LayoutParams source) {
        super(source);
    }

    public SecretParameter(RelativeLayout.LayoutParams source) {
        super(source);
    }

    public SecretParameter(ViewGroup.MarginLayoutParams source) {
        super(source);
    }

    public SecretParameter(int w, int h) {
        super(w, h);
    }

    public SecretParameter(double w, double h)
    {
        super((int)w, (int)h);
    }

    public SecretParameter setMargin(double left, double top, double right, double bottom)
    {
        super.setMargins((int)left, (int)top, (int)right, (int)bottom);
        return this;
    }


    public SecretParameter addRules(int verb) {
        super.addRule(verb);

        return this;
    }


    public SecretParameter addRules(int verb, int subject) {
        super.addRule(verb, subject);

        return this;
    }
}
