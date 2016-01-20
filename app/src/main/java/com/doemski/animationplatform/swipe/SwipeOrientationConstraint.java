package com.doemski.animationplatform.swipe;

public class SwipeOrientationConstraint implements SwipeConstraint {

    private final SwipeEvent.Orientation mOrientation;

    public SwipeOrientationConstraint(SwipeEvent.Orientation orientation) {
        mOrientation = orientation;
    }

    @Override
    public boolean isValid(SwipeEvent event) {
        return mOrientation.equals(event.getOrientation());
    }
}
