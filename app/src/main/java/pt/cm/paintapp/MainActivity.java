package pt.cm.paintapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GestureListener mGestureListener = new GestureListener();
        GestureDetector mGestureDetector = new GestureDetector(getApplicationContext(), mGestureListener);
        mGestureDetector.setIsLongpressEnabled(true);
        mGestureDetector.setOnDoubleTapListener(mGestureListener);

        PaintCanvas paintCanvas = new PaintCanvas(getApplicationContext(), null, mGestureDetector);
        mGestureListener.setCanvas(paintCanvas);

        setContentView(paintCanvas);// adds the created view to the screen
    }

}
