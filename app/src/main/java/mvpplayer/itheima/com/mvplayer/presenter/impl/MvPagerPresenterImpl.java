package mvpplayer.itheima.com.mvplayer.presenter.impl;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import mvpplayer.itheima.com.mvplayer.bean.MvBean;
import mvpplayer.itheima.com.mvplayer.presenter.BaseListPresenter;
import mvpplayer.itheima.com.mvplayer.utils.URLProviderUtil;
import mvpplayer.itheima.com.mvplayer.view.BaseListView;
import okhttp3.Call;

/**
 * Created by rebort on 2017/1/18.
 */
public class MvPagerPresenterImpl implements BaseListPresenter<MvBean.VideosBean> {
    private String       mArea;
    private BaseListView mBaseListView;
    private static final String TAG = "MvPagerPresenterImpl";
    private Gson                    mGson;
    private List<MvBean.VideosBean> mMvBeanList;

    public MvPagerPresenterImpl(String mArea, BaseListView baseListView) {
        this.mArea = mArea;
        mBaseListView = baseListView;
        mGson = new Gson();
        mMvBeanList = new ArrayList<>();
    }

    @Override
    public void initData() {
        initData(0);
    }

    private void initData(int offset) {
        String url = URLProviderUtil.getMVListUrl(mArea, offset, 10);
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {
                mBaseListView.loadDataFail();
            }
            @Override
            public void onResponse(Call call, String s) {
                mBaseListView.loadDataSuccessed();
                MvBean mvBean = mGson.fromJson(s, MvBean.class);
                List<MvBean.VideosBean> videos = mvBean.videos;
                mMvBeanList.addAll(videos);
            }
        });
    }
    @Override
    public void refresh() {
        mMvBeanList.clear();
        initData(0);
    }

    @Override
    public void loadMore() {
        initData(mMvBeanList.size());
    }

    @Override
    public List getDataList() {
        return mMvBeanList;
    }
}
