package mvpplayer.itheima.com.mvplayer.fragment;

import android.support.v7.widget.RecyclerView;

import mvpplayer.itheima.com.mvplayer.adapter.HomeListAdapter;
import mvpplayer.itheima.com.mvplayer.base.BaseListFragment;
import mvpplayer.itheima.com.mvplayer.presenter.BaseListPresenter;
import mvpplayer.itheima.com.mvplayer.presenter.impl.HomePresenterImpl;
import mvpplayer.itheima.com.mvplayer.view.BaseListView;

/**
 * Created by rebort on 2017/1/15.
 */
public class HomeFragment extends BaseListFragment{
    private BaseListPresenter mHomePresenter;
    private static final String TAG = "HomeFragment";
    @Override
    public BaseListPresenter getPresenter(BaseListView baseListView) {
         mHomePresenter = new HomePresenterImpl(baseListView);
        return mHomePresenter;
    }
    @Override
    public RecyclerView.Adapter getAdapter() {
        return new HomeListAdapter(getContext(),mHomePresenter.getDataList());
    }
}