package mvpplayer.itheima.com.mvplayer.presenter;

import java.util.List;

import mvpplayer.itheima.com.mvplayer.bean.HomeListItemBean;

/**
 * Created by rebort on 2017/1/16.
 */

public interface HomePresenter {
    void initData();
    void refresh();
    void loadMore();
    List<HomeListItemBean> getDataList();
}
