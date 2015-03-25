package com.edgarcode.qytoolbox.receiver;

import com.edgarcode.qytoolbox.ChannelId;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

public class QReceiver extends BroadcastReceiver {
    private static final String TAG = "QReceiver";
    private static final int TYPE_PLAY = 1;
    private static final int TYPE_ALBUMDETAIL = 2;
    private static final int TYPE_ALBUMLIST = 3;
    
    private static final String jsonKey_AlbumDetail = "{version:\"1.0\",vrsAlbumId:%s,vrsTvId:%s,history:\"0\",customer:\"iqiyi\",device:\"\",vrsChnId:%s,albumId:%s}";
    private static final String jsonKey_AlbumList = "{version:\"1.0\",chnId:%s,chnName:%s,customer:\"iqiyi\",device:\"\",tagId:%s,tagName:%s,listType:%s}";
    private static final String jsonKey_Play = "{version:\"1.0\",vrsAlbumId:%s,vrsTvId:%s,history:\"0\",customer:\"iqiyi\",device:\"\"}";
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = (intent != null ? intent.getAction() : "");
        Log.d(TAG, "onReceive action : " + action);
        int type = intent.getIntExtra("type", TYPE_PLAY);
        String vrsAlbumId = intent.getStringExtra("vrsAlbumId");
        String vrsTvId = intent.getStringExtra("vrsTvId");
        String vrsChnId = null; 
        String albumId = null;
        String key = "playInfo";
        String jsonKey = null;
        String broadcastAction = "com.qiyi.video.action.ACTION_PLAYVIDEO";
        String appPackage = intent.getStringExtra("package");
        if(TextUtils.isEmpty(appPackage)) {
            appPackage = "com.qiyi.video";
        }
        if(type == TYPE_ALBUMDETAIL) {
            broadcastAction = appPackage + ".action.ACTION_PLAYVIDEO";
            vrsChnId = intent.getStringExtra("vrsChnId");
            albumId = intent.getStringExtra("albumId");
            jsonKey = String.format(jsonKey_AlbumDetail, vrsAlbumId, vrsTvId, vrsChnId, albumId);
        } else if(type == TYPE_ALBUMLIST) {
            broadcastAction = appPackage + ".action.ACTION_ALBUMLIST";
            String listType = intent.getStringExtra("listType");
            Log.i("QReceiver", "listType = " + listType);
            String chnId =  null;
            String chnName = null;
            if(TextUtils.isEmpty(listType)) {
                chnId = intent.getStringExtra("chnId");
                Log.i("QReceiver", "chnId = " + chnId);
                chnName = ChannelId.getChannelName(chnId);
                Log.i("QReceiver", "chnName = " + chnName);
            }
            jsonKey = String.format(jsonKey_AlbumList, chnId, chnName, null, null, listType);
            
        } else {
            broadcastAction = appPackage + ".action.ACTION_PLAYVIDEO";
            jsonKey = String.format(jsonKey_Play, vrsAlbumId, vrsTvId);
        }
        Intent i = new Intent(broadcastAction);
        i.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        Bundle data = new Bundle();
        data.putString(key,jsonKey);
        i.putExtras(data);
        context.sendBroadcast(i);
    }
}
