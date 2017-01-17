package mvpplayer.itheima.com.mvplayer.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rebort on 2017/1/17.
 */
public class MVDataBean {
    public String name;
    public String code;
    public static List<MVDataBean> data(String str) {
        Type listType = new TypeToken<ArrayList<MVDataBean>>() {
        }.getType();
        return new Gson().fromJson(str, listType);
    }
}
