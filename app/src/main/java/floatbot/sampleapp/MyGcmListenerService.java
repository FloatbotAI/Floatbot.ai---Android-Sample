package floatbot.sampleapp;

import android.os.Bundle;

import com.google.android.gms.gcm.GcmListenerService;

import io.floatbot.FloatBot;

/**
 * Created by root on 23/11/17.
 */

public class MyGcmListenerService extends GcmListenerService {

    private static final String TAG = "MyGcmListenerService";

    @Override
    public void onMessageReceived(String s, Bundle bundle) {
        super.onMessageReceived(s, bundle);
        FloatBot.processmessage(this,bundle);
        //Log.e("message",bundle.getString("msg").toString());
    }
}