package com.example.administrator.myapplication.model.progressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/8/29.
 */
public class MyProgressBar extends View {


    public MyProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        int strokeWidth = 20;
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        int radius = (width - strokeWidth) / 2;

        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(strokeWidth);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setAlpha(100);
//        canvas.drawArc(0 + strokeWidth / 2, 0 + strokeWidth / 2, width - strokeWidth / 2, height - strokeWidth / 2, -90, 360, false, paint);

        Paint progressPaint = new Paint();
        progressPaint.setColor(Color.GREEN);
        progressPaint.setStrokeWidth(strokeWidth);
        progressPaint.setStyle(Paint.Style.STROKE);
        progressPaint.setAntiAlias(true);
        progressPaint.setAlpha(100);

        LinearGradient linearGradient = new LinearGradient(0, 0, width, 0, Color.RED, Color.YELLOW, Shader.TileMode.CLAMP);
        progressPaint.setShader(linearGradient);
//        canvas.drawArc(0 + strokeWidth / 2, 0 + strokeWidth / 2, width - strokeWidth / 2, height - strokeWidth / 2, -90, 360, false, progressPaint);

        progressPaint.setStyle(Paint.Style.FILL);

        SweepGradient sweepGradient = new SweepGradient((width-strokeWidth)/2, (height-strokeWidth/2), new int[]{Color.RED, Color.YELLOW}, null);
        progressPaint.setShader(sweepGradient);

        canvas.drawArc(0 + strokeWidth / 2, 0 + strokeWidth / 2, width - strokeWidth / 2, height - strokeWidth / 2, -90, 360, false, progressPaint);

    }
}
