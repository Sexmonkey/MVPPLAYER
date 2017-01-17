package mvpplayer.itheima.com.mvplayer.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import mvpplayer.itheima.com.mvplayer.bean.MVDataBean;
import mvpplayer.itheima.com.mvplayer.fragment.MvPagerFragment;

/**
 * Created by rebort on 2017/1/17.
 */
//FragmentPagerAdapter继承自PagerAdapter ViewPager里每一个页面都是fragment
public class MvPagerAdapter extends FragmentPagerAdapter {
    private List<MVDataBean> mDataList;

    public MvPagerAdapter(FragmentManager childFragmentManager, List<MVDataBean> dataList) {
        this(childFragmentManager);
        mDataList = dataList;
    }

    public MvPagerAdapter(FragmentManager childFragmentManager) {
        super(childFragmentManager);
    }

    @Override
    public int getCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    @Override
    public Fragment getItem(int position) {
        return new MvPagerFragment();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mDataList.get(position).name;
    }
}
