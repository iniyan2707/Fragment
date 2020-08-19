package com.example.fragment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class FragmentB extends Fragment {
    private FragmentBListener listener;
    private Path drawPath=new Path();
    private Paint drawPaint=new Paint();
    private Canvas drawCanvas=new Canvas();

    public interface FragmentBListener
    {
        void inputBSent(Path path,Paint paint,Canvas canvas);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        drawPaint.setColor(Color.BLACK);
        View v = inflater.inflate(R.layout.fragment_b, container, false);
        v.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                float touchX = event.getX();
                float touchY = event.getY();


                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        drawPath.moveTo(touchX, touchY);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        drawPath.lineTo(touchX, touchY);
                        drawCanvas.drawPath(drawPath, drawPaint);
                        break;
                    case MotionEvent.ACTION_UP:
                        listener.inputBSent(drawPath,drawPaint,drawCanvas);

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
        if(context instanceof FragmentBListener){
            listener=(FragmentBListener) context;
        }
        else
        {
            throw new RuntimeException(context.toString()+"must implement FragmentBListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }
}
