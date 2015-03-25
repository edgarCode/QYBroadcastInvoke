package com.edgarcode.qytoolbox.net;
import com.squareup.okhttp.OkHttpClient;


public class QHttpClient {
    private static OkHttpClient sClient = new OkHttpClient();

    private QHttpClient() {
    }

    public static OkHttpClient getClient() {
        sClient.setFollowRedirects(false);
        return sClient;
    }
    
}
