package com.edgarcode.qytoolbox;

import android.text.TextUtils;

public class ChannelId {
    public static final int CHANNEL_ID_FILM = 1;// 电影
    public static final int CHANNEL_ID_EPISODE = 2;// 电视剧
    public static final int CHANNEL_ID_DOCUMENTARY = 3;// 纪录片
    public static final int CHANNEL_ID_CARTOON = 4;// 动漫
    public static final int CHANNEL_ID_MUSIC = 5;// 音乐
    public static final int CHANNEL_ID_VARIETY = 6;// 综艺
    public static final int CHANNEL_ID_ENTERTAINMENT = 7;// 娱乐
    public static final int CHANNEL_ID_TRAVEL = 9;// 旅游
    public static final int CHANNEL_ID_NG = 10;// 片花
    public static final int CHANNEL_ID_EDUCATION = 12;// 教育
    public static final int CHANNEL_ID_FASHIONVARIETY = 13;// 时尚
    public static final int CHANNEL_ID_KIDS = 15; // 少儿
    public static final int CHANNEL_ID_SPORTS = 17;// 体育
    public static final int CHANNEL_ID_LIFE = 21;// 生活
    public static final int CHANNEL_ID_FUNNY = 22;// 搞笑
    public static final int CHANNEL_ID_FINANCE = 24;// 财经  
    public static final int CHANNEL_ID_INFO = 25; // 咨讯
    public static final int CHANNEL_ID_CAR = 26; // 汽车
    public static final int CHANNEL_ID_WAR = 28; // 军事
    public static final int CHANNEL_ID_CINEMA = 33; // 院线大片    
    public static final int CHANNEL_ID_INFANT = 29; //母婴
    
    public static final int CHANNEL_ID_3D = 100005;
    public static final int CHANNEL_ID_1080P = 10004;
    public static final int CHANNEL_ID_4K = 10002;
    public static final int CHANNEL_ID_DOLBY = 10003;
    public static final int CHANNEL_ID_H265 = 100001;
    public static final int CHANNEL_ID_NEWEST = 100004;
    public static final int CHANNEL_ID_MEMBER = 10006;
    public static final int CHANNEL_ID_QIYI_MUSIC = 100002;
    public static final int CHANNEL_ID_MV = 10005;
    public static final int CHANNEL_ID_WEEKENDS = 100003;
    public static final int CHANNEL_ID_DAILYINFO = 10007;
    
    public static String getChannelName(String chnId) {
        int channelId = Integer.parseInt(chnId);
        if(channelId == CHANNEL_ID_FILM) 
            return "电影";
        else if(channelId == CHANNEL_ID_EPISODE) 
            return "电视剧";
        else if(channelId == CHANNEL_ID_DOCUMENTARY) 
            return "纪录片";
        else if(channelId == CHANNEL_ID_CARTOON) 
            return "动漫";
        else if(channelId == CHANNEL_ID_MUSIC) 
            return "音乐";
        else if(channelId == CHANNEL_ID_VARIETY) 
            return "综艺";
        else if(channelId == CHANNEL_ID_ENTERTAINMENT) 
            return "娱乐";
        else if(channelId == CHANNEL_ID_TRAVEL) 
            return "旅游";
        else if(channelId == CHANNEL_ID_NG) 
            return "片花";
        else if(channelId == CHANNEL_ID_EDUCATION) 
            return "教育";
        else if(channelId == CHANNEL_ID_FASHIONVARIETY) 
            return "时尚";
        else if(channelId == CHANNEL_ID_KIDS) 
            return "少儿";
        else if(channelId == CHANNEL_ID_SPORTS) 
            return "体育";
        else if(channelId == CHANNEL_ID_LIFE) 
            return "生活";
        else if(channelId == CHANNEL_ID_FINANCE) 
            return "财经";
        else if(channelId == CHANNEL_ID_INFO) 
            return "咨询";
        else if(channelId == CHANNEL_ID_CAR) 
            return "汽车";
        else if(channelId == CHANNEL_ID_WAR) 
            return "军事";
        else if(channelId == CHANNEL_ID_CINEMA) 
            return "院线大片";
        else if(channelId == CHANNEL_ID_INFANT) 
            return "母婴";
        else if(channelId == CHANNEL_ID_3D) 
            return "3D专区";
        else if(channelId == CHANNEL_ID_1080P) 
            return "1080专区";
        else if(channelId == CHANNEL_ID_4K) 
            return "4K专区";
        else if(channelId == CHANNEL_ID_DOLBY) 
            return "杜比专区";
        else if(channelId == CHANNEL_ID_H265) 
            return "H.265";
        else 
            return "";
        
    }
}
