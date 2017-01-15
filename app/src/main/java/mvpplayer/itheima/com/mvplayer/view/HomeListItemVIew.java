package mvpplayer.itheima.com.mvplayer.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import mvpplayer.itheima.com.mvplayer.R;

/**
 * Created by rebort on 2017/1/15.
 */

public class HomeListItemVIew extends RelativeLayout {

    private Context mContext;

    public HomeListItemVIew(Context context) {
        this(context,null);
        mContext = context;
    }
    public HomeListItemVIew(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init() {
        LayoutInflater.from(mContext).inflate(R.layout.view_home_list_item, this);
    }
}
