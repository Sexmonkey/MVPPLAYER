package mvpplayer.itheima.com.mvplayer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import mvpplayer.itheima.com.mvplayer.bean.YueDanListItemBean;
import mvpplayer.itheima.com.mvplayer.widget.YueDanListItemVIew;

/**
 * Created by rebort on 2017/1/16.
 */

public class YueDanListAdapter extends RecyclerView.Adapter{
    private Context                                mContext;
    private List<YueDanListItemBean.PlayListsBean> mYueDanList;
    public YueDanListAdapter(Context context, List<YueDanListItemBean.PlayListsBean> yueDanlist) {
        mContext = context;
        mYueDanList = yueDanlist;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new YueDanViewHolder(new YueDanListItemVIew(mContext));
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        YueDanListItemBean.PlayListsBean playListsBean = mYueDanList.get(position);
        ((YueDanListItemVIew)(holder.itemView)).bindView(playListsBean);
    }

    @Override
    public int getItemCount() {
        return mYueDanList.size();
    }
    class YueDanViewHolder extends   RecyclerView.ViewHolder{
        public YueDanViewHolder(View itemView) {
            super(itemView);
        }
    }
}
