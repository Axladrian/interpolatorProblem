package com.lotusss.interpolatorproblem;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Interpolator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ValueAnimator oneValueAnimator = ValueAnimator.ofInt(0,2000);
        oneValueAnimator.setDuration(500);
        oneValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.e("AnimatorValue ",animation.getAnimatedValue()+"");
            }
        });
        oneValueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                oneValueAnimator.setInterpolator(new ReverseInterpolator());
                oneValueAnimator.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        oneValueAnimator.start();
    }

    private class ReverseInterpolator implements Interpolator
    {
        @Override
        public float getInterpolation(float paramFloat) {
            return Math.abs(paramFloat -1f);
        }
    }
}
