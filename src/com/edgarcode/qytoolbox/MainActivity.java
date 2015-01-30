package com.edgarcode.qytoolbox;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    private MyReiver mReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IntentFilter filter = new IntentFilter(); 
        filter.addAction("com.qiyi.video.myreiver"); 
        mReceiver  = new MyReiver();
        registerReceiver(mReceiver, filter);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
    }
    class MyReiver extends BroadcastReceiver {
        private static final String TAG = "MyReiver";
        private static final int TYPE_PLAY = 1;
        private static final int TYPE_ALBUMDETAIL = 2;
        private static final String jsonKey_Album = "{version:\"1.0\",vrsAlbumId:%s,vrsTvId:%s,history:\"0\",customer:\"iqiyi\",device:\"\",vrsChnId:%s,albumId:%s}";
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
            Intent i = new Intent("com.qiyi.video.action.ACTION_PLAYVIDEO");
            i.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
            Bundle data = new Bundle();
            String jsonKey = null;
            if(type == TYPE_ALBUMDETAIL) {
                vrsChnId = intent.getStringExtra("vrsChnId");
                albumId = intent.getStringExtra("albumId");
                jsonKey = String.format(jsonKey_Album, vrsAlbumId, vrsTvId, vrsChnId, albumId);
            } else {
                jsonKey = String.format(jsonKey_Play, vrsAlbumId, vrsTvId);
            }
            data.putString(key,jsonKey);
            i.putExtras(data);
            sendBroadcast(i);
            finish();
        }
    }
}
