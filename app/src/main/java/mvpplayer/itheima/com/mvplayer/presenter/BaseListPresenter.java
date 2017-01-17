package mvpplayer.itheima.com.mvplayer.presenter;

import java.util.List;

/**
 * Created by rebort on 2017/1/17.
 */

public interface BaseListPresenter<T> {
    void initData();
    void refresh();
    void loadMore();
    List<T> getDataList();
}
