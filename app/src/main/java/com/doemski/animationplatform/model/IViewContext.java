package com.doemski.animationplatform.model;

import android.graphics.Point;
import android.view.View;

public interface IViewContext {
    View getInteractionView();
    Point getDisplaySize();
}