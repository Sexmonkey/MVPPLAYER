package mvpplayer.itheima.com.mvplayer.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import mvpplayer.itheima.com.mvplayer.R;
import mvpplayer.itheima.com.mvplayer.adapter.MvPagerAdapter;
import mvpplayer.itheima.com.mvplayer.base.BaseFragment;
import mvpplayer.itheima.com.mvplayer.bean.MVDataBean;
import mvpplayer.itheima.com.mvplayer.utils.URLProviderUtil;
import okhttp3.Call;

/**
 * Created by rebort on 2017/1/15.
 */
public class MvFragment extends BaseFragment {
    @BindView(R.id.tab_mv)
    TabLayout mTabMv;
    @BindView(R.id.viewpager_mv)
    ViewPager mViewpager;
    private List<MVDataBean> dataList= new ArrayList<MVDataBean>();
    private MvPagerAdapter   mMvPagerAdapter;
    private static final String TAG = "MvFragment";
    private MVDataBean mMvBean;

    @Override
    public int setLayoutInflater() {
        return R.layout.fragment_mv;
    }
    @Override
    public void init() {
        mMvBean = new MVDataBean();
        initView();
        String url = URLProviderUtil.getMVareaUrl();
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {
                Toast.makeText(getContext(), "加载失败", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onResponse(Call call, String s) {
                Toast.makeText(getContext(), "加载成功", Toast.LENGTH_SHORT).show();
                dispose(s);
            }
        });
    }
    private void dispose(String s) {
        List<MVDataBean> dataBean = mMvBean.data(s);
        dataList.addAll(dataBean);
        mMvPagerAdapter.notifyDataSetChanged();
    }
    private void initView() {
        //MV自身是一个Fragment ViewPager内部每一个页面都是一个fragment
        // 传入getChildFragmentManager()管理fragment里面的fragment
        mMvPagerAdapter = new MvPagerAdapter(getChildFragmentManager(), dataList);
        mViewpager.setAdapter(mMvPagerAdapter);
        mTabMv.setupWithViewPager(mViewpager);
    }
}
