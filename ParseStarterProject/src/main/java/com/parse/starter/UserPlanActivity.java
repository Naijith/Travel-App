package com.parse.starter;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.Toast;

public class UserPlanActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.photos:
                    Intent intent = new Intent(getApplicationContext(), UserFeedActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.plan:
                    return true;
                case R.id.location:
                    Intent intent2 = new Intent(getApplicationContext(), UserLocationActivity.class);
                    startActivity(intent2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_plan);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.getMenu().getItem(0).setChecked(false);
        navigation.getMenu().getItem(1).setChecked(true);
        navigation.getMenu().getItem(2).setChecked(false);

        BottomNavigationMenuView menuView = (BottomNavigationMenuView) navigation.getChildAt(0);
        for (int i = 0; i < menuView.getChildCount(); i++) {
            final View iconView = menuView.getChildAt(i).findViewById(android.support.design.R.id.icon);
            final ViewGroup.LayoutParams layoutParams = iconView.getLayoutParams();
            final DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            // set your height here
            layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32, displayMetrics);
            // set your width here
            layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 32, displayMetrics);
            iconView.setLayoutParams(layoutParams);
            iconView.setPadding(0,5,0,0);
        }

        setTitle("Plan");

        int day=3;

        if(day >=1){
            if(day >= 2){
                final SeekBar seekBar1 = (SeekBar) findViewById(R.id.day1);
                ValueAnimator anim1 = ValueAnimator.ofInt(0, seekBar1.getMax());
                anim1.setDuration(1000);
                anim1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int animProgress = (Integer) animation.getAnimatedValue();
                        seekBar1.setProgress(animProgress);
                    }
                });
                anim1.start();
                if(day >= 3){
                    final SeekBar seekBar2 = (SeekBar) findViewById(R.id.day2);
                    ValueAnimator anim2 = ValueAnimator.ofInt(0, seekBar2.getMax());
                    anim2.setStartDelay(1000);
                    anim2.setDuration(1000);
                    anim2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            int animProgress = (Integer) animation.getAnimatedValue();
                            seekBar2.setProgress(animProgress);
                        }
                    });
                    anim2.start();
                }
                if(day >= 4){
                    final SeekBar seekBar2 = (SeekBar) findViewById(R.id.day3);
                    ValueAnimator anim3 = ValueAnimator.ofInt(0, seekBar2.getMax());
                    anim3.setDuration(1000);
                    anim3.setStartDelay(2000);
                    anim3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            int animProgress = (Integer) animation.getAnimatedValue();
                            seekBar2.setProgress(animProgress);
                        }
                    });
                    anim3.start();
                }
            }
        }

    }
}
