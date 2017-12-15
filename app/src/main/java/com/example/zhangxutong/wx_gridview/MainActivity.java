package com.example.zhangxutong.wx_gridview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_UP;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final FrameLayout frameLayout = new FrameLayout(MainActivity.this);
        frameLayout.setBackgroundColor(Color.BLUE);
        final ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        findViewById(R.id.button).setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                ViewGroup dectorView = null;
                Context context = v.getContext();
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;

                    dectorView = ((ViewGroup) activity.getWindow().getDecorView());
                }


                switch (event.getAction()) {
                    case ACTION_DOWN:

                        dectorView.addView(frameLayout, lp);
                        break;
                    case ACTION_UP:
                        dectorView.removeView(frameLayout);
                        break;
                }

                return false;
            }
        });

    }
}
