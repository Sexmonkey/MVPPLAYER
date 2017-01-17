package mvpplayer.itheima.com.mvplayer.factory;


import android.support.v4.app.Fragment;
import mvpplayer.itheima.com.mvplayer.R;
import mvpplayer.itheima.com.mvplayer.fragment.HomeFragment;
import mvpplayer.itheima.com.mvplayer.fragment.MvFragment;
import mvpplayer.itheima.com.mvplayer.fragment.VbangFragment;
import mvpplayer.itheima.com.mvplayer.fragment.YuedanFragment;

/**
 * Created by rebort on 2017/1/15.
 */

public class FragmentFactory {
   private         Fragment        mHomeFragment;
   private         Fragment        mMvFragment;
   private         Fragment        mVbangFragment;
   private         Fragment        mYuedanFragment;
    private static FragmentFactory mFragmentFactory;
    private FragmentFactory() {}
    public static FragmentFactory getInstance() {
        if (mFragmentFactory == null) {
            synchronized (FragmentFactory.class) {
                if (mFragmentFactory == null) {
                    mFragmentFactory = new FragmentFactory();
                }
            }
        }
        return mFragmentFactory;
    }

    public Fragment getFragment(int tabId) {
        switch (tabId) {
            case R.id.tab_home:
                return getHomeFragment();
            case R.id.tab_mv:
                return getMvFragment();
            case R.id.tab_Vbang:
                return getVbangFragment();
            case R.id.tab_yuedan:
               return getYuedanFranment();
        }
        return null;
    }
    private  Fragment getHomeFragment() {
        if(mHomeFragment==null){
            mHomeFragment=new HomeFragment();
        }
        return mHomeFragment;
    }
    private Fragment getMvFragment() {
        if (mMvFragment == null) {
            mMvFragment = new MvFragment();
        }
        return mMvFragment;
    }

    private Fragment getVbangFragment() {
        if (mVbangFragment == null) {
            mVbangFragment = new VbangFragment();
        }
        return mVbangFragment;
    }
    private  Fragment getYuedanFranment() {
        if (mYuedanFragment == null) {
            mYuedanFragment = new YuedanFragment();
        }
        return mYuedanFragment;
    }
}
