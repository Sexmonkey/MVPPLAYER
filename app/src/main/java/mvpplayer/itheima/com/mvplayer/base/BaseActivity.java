package mvpplayer.itheima.com.mvplayer.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutInflater());
        ButterKnife.bind(this);
        init();
    }

    public void init() {
    }
    public abstract int setLayoutInflater() ;
}
