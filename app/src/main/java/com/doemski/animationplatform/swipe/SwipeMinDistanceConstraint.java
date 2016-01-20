package com.doemski.animationplatform.swipe;

public class SwipeMinDistanceConstraint implements SwipeConstraint {

    private float mMinDistance;

    public SwipeMinDistanceConstraint(float minDistance) {
        mMinDistance = minDistance;
    }

    @Override
    public boolean isValid(SwipeEvent event) {
        return event.getDistance() >= mMinDistance;
    }
}