package mvpplayer.itheima.com.mvplayer.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import mvpplayer.itheima.com.mvplayer.activity.MvPlayerActivity;
import mvpplayer.itheima.com.mvplayer.bean.MvBean;
import mvpplayer.itheima.com.mvplayer.view.MvlistView;

/**
 * Created by rebort on 2017/1/18.
 */

public class MvAdapter extends RecyclerView.Adapter{

    private Context mContext;
    private List<MvBean.VideosBean> mDataList;

    public MvAdapter(Context context, List<MvBean.VideosBean> dataList){
        mContext = context;
        mDataList = dataList;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(new MvlistView(mContext));
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ((MvlistView)holder.itemView).bindView(mDataList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,MvPlayerActivity.class);
                MvBean.VideosBean videosBean = mDataList.get(position);
                intent.putExtra("shdUrl",videosBean.shdUrl);
                intent.putExtra("description",videosBean.description);
                mContext.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return  mDataList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
