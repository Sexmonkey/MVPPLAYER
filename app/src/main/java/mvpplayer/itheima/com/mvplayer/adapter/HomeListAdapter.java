package mvpplayer.itheima.com.mvplayer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mvpplayer.itheima.com.mvplayer.bean.HomeListItemBean;
import mvpplayer.itheima.com.mvplayer.widget.HomeListItemVIew;

/**
 * Created by rebort on 2017/1/15.
 */

public class HomeListAdapter extends RecyclerView.Adapter {
    private Context                mContext;
    private List<HomeListItemBean> mHomeList;
    private HomeListItemBean mHomeListItemBean;

    public HomeListAdapter(Context context, List<HomeListItemBean> mHomeList) {
        mContext = context;
        this.mHomeList = mHomeList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(new HomeListItemVIew(mContext));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((HomeListItemVIew) (holder.itemView)).bindView(mHomeList.get(position));
    }

    @Override
    public int getItemCount() {
        return mHomeList == null ? 0 : mHomeList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
