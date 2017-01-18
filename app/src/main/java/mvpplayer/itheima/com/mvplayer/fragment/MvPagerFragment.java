package mvpplayer.itheima.com.mvplayer.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import mvpplayer.itheima.com.mvplayer.adapter.MvAdapter;
import mvpplayer.itheima.com.mvplayer.base.BaseListFragment;
import mvpplayer.itheima.com.mvplayer.presenter.BaseListPresenter;
import mvpplayer.itheima.com.mvplayer.presenter.impl.MvPagerPresenterImpl;
import mvpplayer.itheima.com.mvplayer.view.BaseListView;
/**
 * Created by rebort on 2017/1/17.
 */
public class MvPagerFragment extends BaseListFragment {
    public  String               mCode;
    private MvPagerPresenterImpl mMvPagerPresenterImpl ;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        mCode = arguments.getString("code");
    }
    @Override
    public BaseListPresenter getPresenter(BaseListView baseListView) {
        mMvPagerPresenterImpl = new MvPagerPresenterImpl(mCode, baseListView);
        return mMvPagerPresenterImpl;
    }
    @Override
    public RecyclerView.Adapter getAdapter() {
        return new MvAdapter(getContext(),mMvPagerPresenterImpl.getDataList());
    }
    public static Fragment newInstance(String code) {
        MvPagerFragment mMvPagerFragment = new MvPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putString("code", code);
        mMvPagerFragment.setArguments(bundle);
        return mMvPagerFragment;
    }
}
