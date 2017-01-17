package mvpplayer.itheima.com.mvplayer.base;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import butterknife.BindView;
import mvpplayer.itheima.com.mvplayer.R;
import mvpplayer.itheima.com.mvplayer.presenter.BaseListPresenter;
import mvpplayer.itheima.com.mvplayer.view.BaseListView;

/**
 * Created by rebort on 2017/1/17.
 */

public abstract class BaseListFragment extends BaseFragment implements BaseListView {
    private static final String TAG = "BaseListFragment";
    @BindView(R.id.base_recyclerview)
    RecyclerView       mBaseRecyclerview;
    @BindView(R.id.base_refresh)
    SwipeRefreshLayout mBaseRefresh;
    private BaseListPresenter mBaseListPresenter;
    @Override
    public int setLayoutInflater() {
        return R.layout.fragment_base_list;
    }
    @Override
    public void init() {
        mBaseListPresenter = getPresenter(this);
        mBaseRefresh.setOnRefreshListener(onRefreshListener);
        mBaseRefresh.setColorSchemeResources(R.color.green, R.color.colorAccent, R.color.colorMusicProgress);
        initRecyclerView();
        mBaseListPresenter.initData();
    }

    public abstract BaseListPresenter getPresenter(BaseListView baseListView);
    public abstract RecyclerView.Adapter getAdapter();

    private void initRecyclerView(){
        mBaseRecyclerview.setHasFixedSize(true);//RecyclerView的大小如果是固定的，则需设置，内部会做相应的优化
        mBaseRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));//设置布局管理器
        //给Adapter传入数据集合,初始化集合大小为0
        mBaseRecyclerview.setAdapter(getAdapter());//设置Adapter
        mBaseRecyclerview.addOnScrollListener(mOnScrollListener);
    }


    private SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            mBaseListPresenter.refresh();
        }
    };
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                if (layoutManager.findLastVisibleItemPosition() == mBaseListPresenter.getDataList().size() - 1) {
                    Toast.makeText(getContext(), "加载更多成功", Toast.LENGTH_SHORT).show();
                    mBaseListPresenter.loadMore();
                }
            }
            super.onScrollStateChanged(recyclerView, newState);
        }
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
        }
    };
    @Override
    public void loadDataSuccessed() {
        Toast.makeText(getContext(), "加载成功", Toast.LENGTH_SHORT).show();
        mBaseRecyclerview.getAdapter().notifyDataSetChanged();
        mBaseRefresh.setRefreshing(false);
    }
    @Override
    public void loadDataFail() {
        Toast.makeText(getContext(), "加载失败", Toast.LENGTH_SHORT).show();
    }
}
