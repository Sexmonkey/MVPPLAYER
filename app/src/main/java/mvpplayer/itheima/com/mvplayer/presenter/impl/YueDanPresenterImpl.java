package mvpplayer.itheima.com.mvplayer.presenter.impl;

import android.util.Log;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import mvpplayer.itheima.com.mvplayer.bean.YueDanListItemBean;
import mvpplayer.itheima.com.mvplayer.presenter.BaseListPresenter;
import mvpplayer.itheima.com.mvplayer.utils.URLProviderUtil;
import mvpplayer.itheima.com.mvplayer.view.BaseListView;
import okhttp3.Call;

/**
 * Created by rebort on 2017/1/16.
 */

public class YueDanPresenterImpl implements BaseListPresenter<YueDanListItemBean.PlayListsBean> {
    private Gson mGson;
    private List<YueDanListItemBean.PlayListsBean> mYueDanlist;
    private BaseListView mYueDanView;
    private static final String TAG = "YueDanPresenterImpl";

    public YueDanPresenterImpl(BaseListView yueDanView) {
        mYueDanView = yueDanView;
        mYueDanlist=new ArrayList<>();
        mGson = new Gson();
        Log.d(TAG,"YueDanPresenterImpl");
    }
    @Override
    public void initData() {
        initData(0);
    }

    @Override
    public void refresh() {
        mYueDanlist.clear();
        initData(0);
    }

    @Override
    public void loadMore() {
        initData(mYueDanlist.size());
    }

    @Override
    public List<YueDanListItemBean.PlayListsBean> getDataList()
    {
        return mYueDanlist;
    }
    private void initData(int offset) {
        String url = URLProviderUtil.getYueDanUrl(offset, 20);
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {
                mYueDanView.loadDataFail();
            }
            @Override
            public void onResponse(Call call, String s) {
                YueDanListItemBean yueDanListItemBean = mGson.fromJson(s, YueDanListItemBean.class);
                List<YueDanListItemBean.PlayListsBean> yueDanPlayList = yueDanListItemBean.playLists;
                mYueDanlist.addAll(yueDanPlayList);
                mYueDanView.loadDataSuccessed();
            }
        });
    }
}
