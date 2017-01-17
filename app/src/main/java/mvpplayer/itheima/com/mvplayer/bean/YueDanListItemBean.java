package mvpplayer.itheima.com.mvplayer.bean;

import java.util.List;

/**
 * Created by rebort on 2017/1/16.
 */

public class YueDanListItemBean {
    public int totalCount;
    public List<PlayListsBean> playLists;
    public static class PlayListsBean {
        public int id;
        public String      title;
        public String      thumbnailPic;
        public String      playListPic;
        public String      playListBigPic;
        public int         videoCount;
        public String      description;
        public String      category;
        public CreatorBean creator;
        public int         status;
        public int         totalViews;
        public int         totalFavorites;
        public String      updateTime;
        public String      createdTime;
        public int         integral;
        public int         weekIntegral;
        public int         totalUser;
        public int         rank;
        public static class CreatorBean {
            public int uid;
            public String nickName;
            public String smallAvatar;
            public String largeAvatar;
            public int    vipLevel;
            public String vipImg;
        }
    }
}
