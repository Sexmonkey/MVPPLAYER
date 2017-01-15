package mvpplayer.itheima.com.mvplayer.activity;

import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import butterknife.BindView;
import mvpplayer.itheima.com.mvplayer.R;
import mvpplayer.itheima.com.mvplayer.base.BaseActivity;

public class SplashActivity extends BaseActivity {

    @BindView(R.id.activity_splash)
    RelativeLayout mActivitySplash;

    @Override
    public int setLayoutInflater() {
        return R.layout.activity_splash;
    }

    @Override
    public void init() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash_anim);
        animation.setDuration(1000);
        animation.setAnimationListener(animationListener);
        mActivitySplash.startAnimation(animation);

    }

    private Animation.AnimationListener animationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        @Override
        public void onAnimationRepeat(Animation animation) {
        }
    };
}
