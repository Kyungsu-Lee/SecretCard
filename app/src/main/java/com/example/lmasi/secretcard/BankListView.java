package com.example.lmasi.secretcard;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by lmasi on 2017. 2. 24..
 */

public class BankListView extends RelativeLayout {

    private RelativeLayout mainLayout;
    private SecretParameter mainParam;
    private ImageView list_btn;
    private ImageView bankName;

    public BankListView(Context context)
    {
        super(context);

        mainLayout = new RelativeLayout(context);

        mainParam = new SecretParameter(565 * ScreenParameter.getScreenparam_x(), 87 * ScreenParameter.getScreenparam_y());
        mainLayout.setLayoutParams(mainParam);
        mainLayout.setBackground(getResources().getDrawable(R.drawable.listbox));

        list_btn = new ImageView(context);
        list_btn.setLayoutParams(
                new SecretParameter(44 * ScreenParameter.getScreenparam_x(), 43 * ScreenParameter.getScreenparam_y())
                    .addRules(RelativeLayout.CENTER_VERTICAL)
                    .setMargin(490 * ScreenParameter.getScreenparam_x(), 0, 0, 0));
        list_btn.setBackground(getResources().getDrawable(R.drawable.btn_list));
        list_btn.setRotation(180);
        mainLayout.addView(list_btn);
        list_btn.setOnTouchListener(new OnTouchListener() {

            boolean up = true;

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                {
                    if(up)
                        list_btn.setRotation(0);
                    else
                        list_btn.setRotation(180);

                    up = !up;
                }

                return true;
            }
        });

        bankName = new ImageView(getContext());
        bankName.setLayoutParams(
                new SecretParameter(249 * ScreenParameter.getScreenparam_x(), 61 * ScreenParameter.getScreenparam_y())
                .addRules(RelativeLayout.CENTER_IN_PARENT)
        );
        updateBankName();
        mainLayout.addView(bankName);


        this.addView(mainLayout);
    }

    private void updateBankName()
    {
        String name = DbResource.getPrimaryBankName();
        Drawable img = null;

        if(name.equals("신한"))
            img = getResources().getDrawable(R.drawable.bank_shin);
        else if(name.equals("기업"))
            img = getResources().getDrawable(R.drawable.bank_gi);


        bankName.setBackground(img);
    }


}
