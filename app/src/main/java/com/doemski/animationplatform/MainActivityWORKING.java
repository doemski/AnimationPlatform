package com.doemski.animationplatform;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivityWORKING extends AppCompatActivity implements  View.OnTouchListener, Animator.AnimatorListener {

    ImageView imageView;
    private ViewGroup mRrootLayout;
    private boolean animationRunning=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageView = (ImageView) findViewById(R.id.imageview);
        mRrootLayout = (ViewGroup) getWindow().getDecorView().getRootView();
        imageView.setOnTouchListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animator animator = AnimatorInflater.loadAnimator(MainActivityWORKING.this.getApplicationContext(),R.animator.elevate_leave);
                animator.setTarget(imageView);
                animator.start();
            }
        });
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

    private int _yDelta;
    private ArrayList<Animator> animatorQueue = new ArrayList<>();

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        final int Y = (int) event.getRawY();
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:

                Animator animator = AnimatorInflater.loadAnimator(MainActivityWORKING.this.getApplicationContext(),R.animator.elevate);
                animator.addListener(this);
                animator.setTarget(imageView);
                if(!animationRunning){
                    animator.start();
                }

                RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                 _yDelta = Y - lParams.topMargin;
                break;
            case MotionEvent.ACTION_UP:
                Animator animator2 = AnimatorInflater.loadAnimator(MainActivityWORKING.this.getApplicationContext(),R.animator.lower);
                animator2.setTarget(imageView);
                if(!animationRunning){
                    animator2.start();
                } else {
                    animatorQueue.add(animator2);
                }

                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                break;
            case MotionEvent.ACTION_POINTER_UP:
                break;
            case MotionEvent.ACTION_MOVE:
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view
                        .getLayoutParams();
                layoutParams.topMargin = Y - _yDelta;
                view.setLayoutParams(layoutParams);
                break;
        }
        mRrootLayout.invalidate();
        return true;
    }

    @Override
    public void onAnimationStart(Animator animation) {
        animationRunning = true;
    }

    @Override
    public void onAnimationEnd(Animator animation) {
        animationRunning = false;
        if(!animatorQueue.isEmpty()) {
            animatorQueue.get(0).start();
            animatorQueue.remove(animatorQueue.get(0));
        }
    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }
}
