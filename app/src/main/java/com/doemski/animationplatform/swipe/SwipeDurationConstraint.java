package com.doemski.animationplatform.swipe;

public class SwipeDurationConstraint implements SwipeConstraint {
    private final long mMaxDuration;

    public SwipeDurationConstraint(long maxDuration) {
        this.mMaxDuration = maxDuration;
    }

    @Override
    public boolean isValid(SwipeEvent event) {
        return event.getDuration() < mMaxDuration;
    }
}
