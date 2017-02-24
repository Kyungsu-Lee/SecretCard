package com.example.lmasi.secretcard;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by lmasi on 2017. 2. 22..
 */

public class Settings extends Activity {

    RelativeLayout main;

    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        main = (RelativeLayout)findViewById(R.id.main);
        main.setBackgroundColor(Color.WHITE);
        main.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if(motionEvent.getAction() == MotionEvent.ACTION_UP)
                    finish();

                return true;
            }
        });

        textView = new TextView(getApplicationContext());
        textView.setLayoutParams(new SecretParameter(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        setString(textView);
        main.addView(textView);
        textView.setTextColor(Color.BLACK);
    }

    private void setString(TextView textView)
    {
        String str = "";

        for(int i=1; i<=30; i++)
        {
            str += i + " : " + Integer.toString(DbResource.get(i, "신한")) + "\n";
        }

        textView.setText(str);
    }
}
