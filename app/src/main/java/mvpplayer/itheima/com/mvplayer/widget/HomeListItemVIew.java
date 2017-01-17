package mvpplayer.itheima.com.mvplayer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import mvpplayer.itheima.com.mvplayer.R;
import mvpplayer.itheima.com.mvplayer.bean.HomeListItemBean;

/**
 * Created by rebort on 2017/1/15.
 */

public class HomeListItemVIew extends RelativeLayout {

    @BindView(R.id.mv_image)
    ImageView mMvImage;
    @BindView(R.id.item_title)
    TextView  mItemTitle;
    @BindView(R.id.item_desc)
    TextView  mItemDesc;
    private static final String TAG = "HomeListItemVIew";

    public HomeListItemVIew(Context context) {
        this(context, null);
    }

    public HomeListItemVIew(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {

        LayoutInflater.from(getContext()).inflate(R.layout.view_home_list_item, this);
        ButterKnife.bind(this, this);
    }

    public void bindView(HomeListItemBean homeListItemBean) {
        mItemTitle.setText(homeListItemBean.title);
        mItemDesc.setText(homeListItemBean.description);
        Picasso.with(getContext()).load(homeListItemBean.posterPic).into(mMvImage);
    }
}
