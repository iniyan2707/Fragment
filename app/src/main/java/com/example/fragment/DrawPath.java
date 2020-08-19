package com.example.fragment;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class DrawPath extends androidx.appcompat.widget.AppCompatImageView{
    private Path drawPath;

    private Paint drawPaint;
    private int paintColor = 0x00660000;


    public DrawPath(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        drawPath = new Path();
        drawPaint = new Paint();

        drawPaint.setColor(paintColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}


