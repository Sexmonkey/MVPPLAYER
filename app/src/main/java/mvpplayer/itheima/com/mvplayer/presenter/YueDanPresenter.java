package mvpplayer.itheima.com.mvplayer.presenter;

import java.util.List;

import mvpplayer.itheima.com.mvplayer.bean.YueDanListItemBean;

/**
 * Created by rebort on 2017/1/16.
 */

public interface YueDanPresenter {
    void initData();
    void refresh();
    void loadMore();
    List<YueDanListItemBean.PlayListsBean> getDataList();
}
