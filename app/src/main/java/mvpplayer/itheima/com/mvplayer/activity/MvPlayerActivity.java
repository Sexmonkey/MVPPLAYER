package mvpplayer.itheima.com.mvplayer.activity;

import android.content.Intent;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.BindView;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import mvpplayer.itheima.com.mvplayer.R;
import mvpplayer.itheima.com.mvplayer.base.BaseActivity;
import mvpplayer.itheima.com.mvplayer.fragment.CommentFragment;
import mvpplayer.itheima.com.mvplayer.fragment.DescFragment;
import mvpplayer.itheima.com.mvplayer.fragment.RelativeFragment;

/**
 * Created by rebort on 2017/1/18.
 */
public class MvPlayerActivity extends BaseActivity {
    private static final String TAG = "MvPlayerActivity";
    @BindView(R.id.videoplayer)
    JCVideoPlayerStandard mVideoplayer;
    @BindView(R.id.mv_description)
    RadioButton           mMvDescription;
    @BindView(R.id.mv_comment)
    RadioButton           mMvComment;
    @BindView(R.id.mv_relative)
    RadioButton           mMvRelative;
    @BindView(R.id.radio_group)
    RadioGroup            mRadioGroup;
    @BindView(R.id.view_pager)
    ViewPager             mViewPager;

    @Override
    public int setLayoutInflater() {
        return R.layout.activity_mv_player;
    }

    @Override
    public void init() {
        Intent intent = getIntent();
        String shdUrl = intent.getStringExtra("shdUrl");
        String description = intent.getStringExtra("description");
        mRadioGroup.check(R.id.mv_description);
        mVideoplayer.setUp(shdUrl, JCVideoPlayerStandard.SCREEN_LAYOUT_LIST, description);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.mv_description:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.mv_comment:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.mv_relative:
                        mViewPager.setCurrentItem(2);
                        break;
                }
            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mRadioGroup.check(R.id.mv_description);
                        break;
                    case 1:
                        mRadioGroup.check(R.id.mv_comment);
                        break;
                    case 2:
                        mRadioGroup.check(R.id.mv_relative);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        mViewPager.setAdapter(mFragmentPagerAdapter);
    }
    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
    private FragmentPagerAdapter mFragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
        @Override
        public int getCount() {
            return 3;
        }
        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new DescFragment();
                case 1:
                    return new CommentFragment();
                case 2:
                    return new RelativeFragment();
            }
            return null;
        }
    };
}
