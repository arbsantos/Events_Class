package pt.cm.paintapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

//TODO
// Detect a double tap
// Detect a long press
//TODO
// when double tap is detected the app should enter in "erase mode"
// this mode changes the color of the paint to color of the background
//TODO
// when a long press is detect change the background color with a random one

public class MainActivity extends AppCompatActivity {

    private static final String DEBUG_TAG = "Gestures";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SingleTouchEventView paintCanvas = new SingleTouchEventView(getApplicationContext(), null);
        setContentView(paintCanvas);// adds the created view to the screen
    }

    class SingleTouchEventView extends View {
        private Paint paint = new Paint();
        private Path path = new Path();

        public SingleTouchEventView(Context context, AttributeSet attrs) {
            super(context, attrs);

            paint.setAntiAlias(true);
            paint.setStrokeWidth(20f);
            paint.setColor(Color.BLACK);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeJoin(Paint.Join.ROUND);
        }


        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawPath(path, paint);// draws the path with the paint
        }

        @Override
        public boolean performClick(){
            return super.performClick();
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            float eventX = event.getX();
            float eventY = event.getY();
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    path.moveTo(eventX, eventY);// updates the path initial point
                    return true;
                case MotionEvent.ACTION_MOVE:
                    path.lineTo(eventX, eventY);// makes a line to the point each time this event is fired
                    break;
                case MotionEvent.ACTION_UP:// when you lift your finger

                    performClick();
                    break;
                default:
                    return false;
            }

            // Schedules a repaint.
            invalidate();
            return true;
        }
    }
}
