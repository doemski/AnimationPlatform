package com.doemski.animationplatform;

import android.animation.Animator;
import android.view.View;
import android.widget.ImageView;

import com.doemski.animationplatform.swipe.*;

import java.util.ArrayList;


public abstract class GestureAnimation implements Animator.AnimatorListener{
    protected ImageView view;
    protected AnimationType type;
    protected TouchPoint startPoint, currentPoint;
    protected boolean animationRunning;
    protected Animator playAnimator;
    protected ArrayList<Animator> animatorQueue = new ArrayList<>();

    public abstract void play();

    public void onSwiping(TouchPoint touchPoint){
        if(this.type.equals(AnimationType.SEND)){
            handleSwiping(touchPoint);
        }
    }

    public View getView(){
        return view;
    }

    public AnimationType getType(){
        return type;
    }

    public void onSwipeStart(TouchPoint touchPoint) {
        handleSwipeStart(touchPoint);
    }

    public void onSwipeEnd(TouchPoint touchPoint) {
        handleSwipeEnd(touchPoint);
    }

    protected abstract void handleSwipeStart(TouchPoint touchPoint);

    protected abstract void handleSwipeEnd(TouchPoint touchPoint);

    protected abstract void handleSwiping(TouchPoint touchPoint);

    protected abstract void registerAnimators();
}
