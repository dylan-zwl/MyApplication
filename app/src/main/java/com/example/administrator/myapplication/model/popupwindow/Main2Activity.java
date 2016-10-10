package com.example.administrator.myapplication.model.popupwindow;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.PopupWindow;

import com.example.administrator.myapplication.R;
import com.google.gson.Gson;


public class Main2Activity extends Activity {
    private PopupWindow mPopupWindow;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mButton = (Button) findViewById(R.id.button2);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initPopupWindow();
            }
        });
        Button button1 = (Button) findViewById(R.id.button3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();
            }
        });
    }

    private void initPopupWindow() {
        View poppupWindowView = getLayoutInflater().inflate(R.layout.activity_main2, null);
        mPopupWindow = new PopupWindow(poppupWindowView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        mPopupWindow.setAnimationStyle(R.style.AnimationLeftFade);
        ColorDrawable colorDrawable = new ColorDrawable(0xff000000);
        mPopupWindow.setBackgroundDrawable(colorDrawable);
        mPopupWindow.showAtLocation(getLayoutInflater().inflate(R.layout.activity_main2, null), Gravity.BOTTOM, 0, 0);
//        mPopupWindow.showAsDropDown(mButton);
    }
}
