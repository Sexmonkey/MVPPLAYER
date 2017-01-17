package mvpplayer.itheima.com.mvplayer.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(setLayoutInflater(), null);
        ButterKnife.bind(this,rootView);
        init();
        return  rootView;
    }
    public abstract int setLayoutInflater();
    public void init(){

    }
}
