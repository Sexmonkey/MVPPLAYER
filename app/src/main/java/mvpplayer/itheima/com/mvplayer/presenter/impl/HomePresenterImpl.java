package mvpplayer.itheima.com.mvplayer.presenter.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import mvpplayer.itheima.com.mvplayer.bean.HomeListItemBean;
import mvpplayer.itheima.com.mvplayer.presenter.BaseListPresenter;
import mvpplayer.itheima.com.mvplayer.utils.URLProviderUtil;
import mvpplayer.itheima.com.mvplayer.view.BaseListView;
import okhttp3.Call;

/**
 * Created by rebort on 2017/1/16.
 */

public class HomePresenterImpl implements BaseListPresenter<HomeListItemBean>{

    private List<HomeListItemBean> mHomeList;
    private Gson                   mGson;
    private BaseListView       mHomeView;
    private static final String TAG = "HomePresenterImpl";

    public HomePresenterImpl(BaseListView homeView) {
        mHomeView = homeView;
        mHomeList = new ArrayList<HomeListItemBean>();
        mGson = new Gson();
    }

    @Override
    public void initData() {
        initData(0);
    }

    @Override
    public void refresh() {
        mHomeList.clear();
        initData(0);
    }

    @Override
    public void loadMore() {
        initData(mHomeList.size());
    }

    @Override
    public List<HomeListItemBean> getDataList() {
        return mHomeList;
    }

    private void initData(int offset) {
        String url = URLProviderUtil.getHomeUrl(offset, 10);
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {
                mHomeView.loadDataFail();
            }

            @Override
            public void onResponse(Call call, String s) {
                List<HomeListItemBean> mHomeListItemList = mGson.fromJson(s, new TypeToken<List<HomeListItemBean>>() {
                }.getType());
                mHomeList.addAll(mHomeListItemList);
                mHomeView.loadDataSuccessed();
            }
        });
    }
}
