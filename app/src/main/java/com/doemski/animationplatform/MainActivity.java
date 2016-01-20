package com.doemski.animationplatform;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.doemski.animationplatform.swipe.SwipeDetector;
import com.doemski.animationplatform.swipe.SwipeEvent;
import com.doemski.animationplatform.swipe.TouchPoint;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  View.OnTouchListener {

    ImageView imageView;
    private ViewGroup mRrootLayout;
    private boolean animationRunning=false;
    GestureAnimation sendAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageView = (ImageView) findViewById(R.id.imageview);
        mRrootLayout = (ViewGroup) getWindow().getDecorView().getRootView();
        imageView.setOnTouchListener(this);

        sendAnimation = new PostCardFlipAnimation(this, imageView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        TouchPoint touchPoint = new TouchPoint(event);
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:

                sendAnimation.onSwipeStart(touchPoint);

                break;
            case MotionEvent.ACTION_UP:

                sendAnimation.onSwipeEnd(touchPoint);

                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                break;
            case MotionEvent.ACTION_POINTER_UP:
                break;
            case MotionEvent.ACTION_MOVE:

                sendAnimation.onSwiping(touchPoint);

                break;
        }
        mRrootLayout.invalidate();
        return true;
    }
}
