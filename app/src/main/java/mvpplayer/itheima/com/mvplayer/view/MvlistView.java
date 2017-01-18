package mvpplayer.itheima.com.mvplayer.view;

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
import mvpplayer.itheima.com.mvplayer.bean.MvBean;

/**
 * Created by rebort on 2017/1/18.
 */

public class MvlistView extends RelativeLayout {
    @BindView(R.id.mv_image)
    ImageView mMvImage;
    @BindView(R.id.title)
    TextView  mTitle;
    @BindView(R.id.author)
    TextView  mAuthor;

    public MvlistView(Context context) {
        this(context, null);
    }

    public MvlistView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(getContext()).inflate(R.layout.item_mv, this);
        ButterKnife.bind(this, this);
    }
    public void bindView(MvBean.VideosBean videosBean) {
        mAuthor.setText(videosBean.artistName);
        mTitle.setText(videosBean.title);
        Picasso.with(getContext()).load(videosBean.albumImg).into(mMvImage);
    }
}
