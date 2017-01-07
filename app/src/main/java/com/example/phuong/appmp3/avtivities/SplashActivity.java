package com.example.phuong.appmp3.avtivities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.phuong.appmp3.R;
import com.example.phuong.appmp3.common.Constant;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by phuong on 07/01/2017.
 */
@EActivity(R.layout.activity_splash)
public class SplashActivity extends BaseActivity {
    @ViewById(R.id.tvTitle)
    TextView mTvTitle;

    @Override
    void inits() {
        Typeface tpTitle = Typeface.createFromAsset(getAssets(), Constant.TITLE_FONT);
        mTvTitle.setTypeface(tpTitle);
        startWithAnimation();
    }

    private void startWithAnimation() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.anim_splash);
        anim.reset();
        mTvTitle.startAnimation(anim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity_.class);
                startActivity(intent);
            }
        }, 2000);

    }
}
