package mvpplayer.itheima.com.mvplayer.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(setLayoutInflater(), null);
        init();
        return  rootView;
    }
    public abstract int setLayoutInflater();
    public void init(){

    }
}
