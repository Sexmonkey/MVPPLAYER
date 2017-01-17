package mvpplayer.itheima.com.mvplayer.activity;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;
import mvpplayer.itheima.com.mvplayer.R;
import mvpplayer.itheima.com.mvplayer.base.BaseActivity;
import mvpplayer.itheima.com.mvplayer.factory.FragmentFactory;

public class MainActivity extends BaseActivity {
    @BindView(R.id.contentContainer)
    FrameLayout mContentContainer;
    @BindView(R.id.bottomBar)
    BottomBar   mBottomBar;

    @Override
    public int setLayoutInflater() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        mBottomBar.setOnTabSelectListener(selectListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //加载菜单布局
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //设置菜单布局view的点击事件
        switch (item.getItemId()) {
            case R.id.settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private OnTabSelectListener selectListener = new OnTabSelectListener() {
        @Override
        public void onTabSelected(@IdRes int tabId) {
            //通过工厂模式 不同的id得到不同fragment
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.contentContainer, FragmentFactory.getInstance().getFragment(tabId));
            fragmentTransaction.commit();
        }
    };
}
