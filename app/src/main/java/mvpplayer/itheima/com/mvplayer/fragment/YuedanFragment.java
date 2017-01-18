package mvpplayer.itheima.com.mvplayer.fragment;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

import mvpplayer.itheima.com.mvplayer.adapter.YueDanListAdapter;
import mvpplayer.itheima.com.mvplayer.base.BaseListFragment;
import mvpplayer.itheima.com.mvplayer.presenter.BaseListPresenter;
import mvpplayer.itheima.com.mvplayer.presenter.impl.YueDanPresenterImpl;
import mvpplayer.itheima.com.mvplayer.view.BaseListView;

/**
 * Created by rebort on 2017/1/15.
 */
public class YuedanFragment extends BaseListFragment  {
private BaseListPresenter baseListPresenter;
    @Override
    public BaseListPresenter getPresenter(BaseListView baseListView) {
        baseListPresenter=new YueDanPresenterImpl(baseListView);
        return baseListPresenter;
    }
    @Override
    public RecyclerView.Adapter getAdapter() {
        return new YueDanListAdapter(getContext(),baseListPresenter.getDataList());
    }
}