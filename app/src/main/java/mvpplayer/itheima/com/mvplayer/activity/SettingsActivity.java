package mvpplayer.itheima.com.mvplayer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import mvpplayer.itheima.com.mvplayer.R;
import mvpplayer.itheima.com.mvplayer.base.BaseActivity;

/**
 * Created by rebort on 2017/1/15.
 */
public class SettingsActivity extends BaseActivity {
    @Override
    public int setLayoutInflater() {
        return R.layout.activity_settings;
    }

    @Override
    public void init() {
        //设置菜单栏的view
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setTitle("设置");
    }

    //设置点击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //加载首选项布局即设置布局 perferenceActivity/perferenceFragment
    public static class SettingsFragment extends PreferenceFragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            addPreferencesFromResource(R.xml.settings);
            return super.onCreateView(inflater, container, savedInstanceState);
        }

        //about的点击事件
        @Override
        public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
            if (preference.getKey().equals("about")) {
                Intent intent = new Intent(getActivity(), AboutActivity.class);
                startActivity(intent);
            }
            return super.onPreferenceTreeClick(preferenceScreen, preference);
        }
    }
}
