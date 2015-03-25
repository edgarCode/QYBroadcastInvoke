package com.edgarcode.qytoolbox;

import java.io.IOException;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

import com.edgarcode.qytoolbox.net.QHttpClient;
import com.edgarcode.qytoolbox.receiver.QReceiver;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class MainActivity extends Activity {
    private QReceiver mReceiver;
    private static final String TAG = "MainActivity";
//    private String mUrl = "http://data.video.iqiyi.com/videos/v0/20150127/20/02/2b2dc765d80948f3fe9b7f94d3904368.ts?mts=a1046499x3fa377c8&start=28270302&end=30408508&hsize=4149&tag=1&v=&contentlength=886420#";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        IntentFilter filter = new IntentFilter(); 
        filter.addAction("com.qiyi.video.myreiver"); 
        mReceiver  = new QReceiver();
        registerReceiver(mReceiver, filter);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
    }
    
    @Override
    protected void onResume() {
        super.onResume();
//        request(mUrl);
    }
    
    private void request(String url) {
        Log.i(TAG, "request url = " + url);
        Request request = new Request.Builder().url(url).build();
        QHttpClient.getClient().newCall(request).enqueue(new Callback() {

            @Override
            public void onResponse(Response response) throws IOException {
                Log.i(TAG, "response " + response.code());
                if(response.isRedirect()) {
                    String redirectUrl = response.header("location");
                    Log.i(TAG, "response header location = "+redirectUrl);
                    request(redirectUrl);
                }
            }

            @Override
            public void onFailure(Request response, IOException arg1) {
                Log.i(TAG, "onFailure");

            }
        });
    }
}
