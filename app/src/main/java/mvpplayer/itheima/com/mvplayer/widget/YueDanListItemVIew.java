package mvpplayer.itheima.com.mvplayer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import mvpplayer.itheima.com.mvplayer.R;
import mvpplayer.itheima.com.mvplayer.bean.YueDanListItemBean;

/**
 * Created by rebort on 2017/1/15.
 */

public class YueDanListItemVIew extends RelativeLayout {

    @BindView(R.id.mv_image)
    ImageView mMvImage;
    @BindView(R.id.home_page_video_icon)
    ImageView mHomePageVideoIcon;
    @BindView(R.id.item_title)
    TextView  mItemTitle;
    @BindView(R.id.item_desc)
    TextView  mItemDesc;
    @BindView(R.id.view)
    View      mView;

    public YueDanListItemVIew(Context context) {
        this(context, null);
    }
    public YueDanListItemVIew(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init() {

        LayoutInflater.from(getContext()).inflate(R.layout.view_home_list_item, this);
        ButterKnife.bind(this, this);
    }

    public void bindView(YueDanListItemBean.PlayListsBean playListsBean) {
        mItemTitle.setText(playListsBean.title);
        mItemDesc.setText(playListsBean.description);
        Glide.with(getContext()).load(playListsBean.creator.smallAvatar).bitmapTransform(new CropCircleTransformation(getContext())).into(mHomePageVideoIcon);
        Glide.with(getContext()).load(playListsBean.playListBigPic).into(mMvImage);
    }
}
