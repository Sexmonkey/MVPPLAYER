package mvpplayer.itheima.com.mvplayer.adapter;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import mvpplayer.itheima.com.mvplayer.view.HomeListItemVIew;

/**
 * Created by rebort on 2017/1/15.
 */

public class HomeListAdapter extends RecyclerView.Adapter{
    private Context mContext;

    public HomeListAdapter(Context context) {
        mContext = context;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(new HomeListItemVIew(mContext));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 30;
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
