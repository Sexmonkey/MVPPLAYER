package mvpplayer.itheima.com.mvplayer.bean;

import java.util.List;

/**
 * Created by rebort on 2017/1/18.
 */

public class MvBean {
    public int totalCount;
    public List<VideosBean> videos;
    public static class VideosBean {
        public int id;
        public String            title;
        public String            description;
        public String            artistName;
        public String            posterPic;
        public String            thumbnailPic;
        public String            albumImg;
        public String            regdate;
        public String            videoSourceTypeName;
        public int               totalViews;
        public int               totalPcViews;
        public int               totalMobileViews;
        public int               totalComments;
        public String            url;
        public String            hdUrl;
        public String            uhdUrl;
        public String            shdUrl;
        public int               videoSize;
        public int               hdVideoSize;
        public int               uhdVideoSize;
        public int               shdVideoSize;
        public int               duration;
        public int               status;
        public int               linkId;
        public String            playListPic;
        public List<ArtistsBean> artists;
        public static class ArtistsBean {
            public int artistId;
            public String artistName;
        }
    }
}
