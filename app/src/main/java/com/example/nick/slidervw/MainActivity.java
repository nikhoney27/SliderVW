package com.example.nick.slidervw;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private TextView txtDisplay;
    private Animation mSlideDown, mMove, mMoveButton;
    private Button mBtnGetstatred;
    private static final Integer[] IMAGES = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //initialising
        init();

        //applying animation to the TextView
        startAnimations();

        mBtnGetstatred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void startAnimations() {
        txtDisplay.startAnimation(mMove);
        mMove.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
//        mBtnGetstatred.startAnimation(mMoveButton);
//        mMoveButton.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });


    }


    private void init() {

        txtDisplay = (TextView) findViewById(R.id.txtDisplay);
        txtDisplay.setText(getString(R.string.Welcome_message));


        //Set Get started button
        mBtnGetstatred = (Button) findViewById(R.id.btnGetstarted);
        mBtnGetstatred.setVisibility(View.GONE);

//        mSlideDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
        mMove = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        mMoveButton = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_button);


        for (int i = 0; i < IMAGES.length; i++)
            ImagesArray.add(IMAGES[i]);

        mPager = (ViewPager) findViewById(R.id.pager);


        mPager.setAdapter(new SlidingImage_Adapter(MainActivity.this, ImagesArray));


        CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);

        indicator.setViewPager(mPager);
        final float density = getResources().getDisplayMetrics().density;
        indicator.setRadius(5 * density);
        NUM_PAGES = IMAGES.length;

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

                switch (currentPage) {
                    case 0:
                        txtDisplay.setText(getString(R.string.Welcome_message));
                        mBtnGetstatred.setVisibility(View.GONE);
                        startAnimations();
                        break;

                    case 1:
                        txtDisplay.setText("View races and get passed on your mobile app");
                        mBtnGetstatred.setVisibility(View.GONE);
                        startAnimations();
                        break;

                    case 2:
                        txtDisplay.setText("Click and share photo on Facebook and Twitter");
                        mBtnGetstatred.setVisibility(View.GONE);
                        startAnimations();
                        break;

                    case 3:
                        txtDisplay.setText("Now get started to explore more about App");
                        mBtnGetstatred.setVisibility(View.VISIBLE);
                        startAnimations();
                        break;
                }


            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int pos) {
            }
        });

    }


}
