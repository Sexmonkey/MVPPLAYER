package mvpplayer.itheima.com.mvplayer.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import butterknife.BindView;
import mvpplayer.itheima.com.mvplayer.R;
import mvpplayer.itheima.com.mvplayer.adapter.HomeListAdapter;
import mvpplayer.itheima.com.mvplayer.base.BaseFragment;
import mvpplayer.itheima.com.mvplayer.utils.URLProviderUtil;
import okhttp3.Call;

/**
 * Created by rebort on 2017/1/15.
 */
public class HomeFragment extends BaseFragment {
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerview;

    @Override
    public int setLayoutInflater() {
        return R.layout.fragment_home;
    }

    @Override
    public void init() {
        initRecycleView();
        initData();
    }

    private void initData() {
        String url= URLProviderUtil.getHomeUrl(0, 10);
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {
                    Toast.makeText( getContext(),"数据加载失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, String s) {
                Toast.makeText(getContext(), "加载成功", Toast.LENGTH_SHORT).show();
                dispose(s);
            }
        });
    }

    private void dispose(String s) {

    }

    private void initRecycleView() {
        mRecyclerview.setHasFixedSize(true);//RecyclerView的大小如果是固定的，则需设置，内部会做相应的优化
        mRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));//设置布局管理器
        HomeListAdapter adapter=new HomeListAdapter(getContext());
        mRecyclerview.setAdapter(adapter);
    }
}
