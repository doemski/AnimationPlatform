package com.doemski.animationplatform.swipe;

@SuppressWarnings("unused")
public class SwipeDistanceConstraint implements SwipeConstraint {

    private float mMaxDistance;

    public SwipeDistanceConstraint(float maxDistance) {
        mMaxDistance = maxDistance;
    }

    @Override
    public boolean isValid(SwipeEvent event) {
        return event.getDistance() < mMaxDistance;
    }
}