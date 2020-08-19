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
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class FragmentA extends Fragment {

   private FragmentAListener listener;
    private DrawPath drawPath;
    private Canvas drawCanvas=new Canvas();

    private Paint drawPaint=new Paint();
    private Path path=new Path();



    public interface FragmentAListener
    {
        void inputASent(Path path,Paint paint,Canvas canvas);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_a, container, false);
        v.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                float touchX = event.getX();
                float touchY = event.getY();


                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        path.moveTo(touchX, touchY);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        path.lineTo(touchX, touchY);
                        drawCanvas.drawPath(path, drawPaint);
                        break;
                    case MotionEvent.ACTION_UP:

                        listener.inputASent(path,drawPaint,drawCanvas);

                        break;
                    default:
                        return false;
                }

                return true;
            }
        });




         return v;

    }
    public void draw(Path path,Canvas canvas,Paint paint)
    {
        canvas.drawPath(path,paint);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentAListener){
            listener=(FragmentAListener) context;
        }
        else
        {
            throw new RuntimeException(context.toString()+"must implement FragmentAListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }





}










