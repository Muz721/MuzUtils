package com.muz.muzutils.utils;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.util.Log;
import android.view.View;

/**
 * @description  AnimationUtils
 * @author  Muz
 * @date  2018/2/8 11:04
 */

public class MuzAnimationUtils {
    /**
     * RotateAnimation
     * @param view     view
     * @param start    start position
     * @param end      end position
     */
    public static void rotateAnimation(View view,float start,float end){
        rotateAnimation( view, start, end, 300);
    }
    /**
     * RotateAnimation
     * Set the time you need for your animation to rotation.
     * @param view     view
     * @param start    start position
     * @param end      end position
     * @param time     rotation time
     */
    public static void rotateAnimation(View view,float start,float end,int time){
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotation", start, end);
        animator.setDuration(time);
        // The callback listener
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (Float) animation.getAnimatedValue();
                //remain to be improved
            }
        });
        // Start the execution animation officially.
        animator.start();
    }
}
