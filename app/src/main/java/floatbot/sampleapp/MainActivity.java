package floatbot.sampleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import io.floatbot.FloatBot;

public class MainActivity extends AppCompatActivity {
    public static String BOT_ID = "your-bot-id";
    public static String API_TOKEN = "your-api-token";

    private boolean checkPlayServices() {
        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        int resultCode = apiAvailability.isGooglePlayServicesAvailable(this);
        return resultCode == ConnectionResult.SUCCESS;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Call this Method to set mobile number
        //FloatBot.setMobileNumber("918866098040");

        //Call this anywhere to clear chat data in floatbot
        //Note call this method Before calling startChat
        /* FloatBot.clearChatData(this); */

        //Call this anywhere to reset floatbot cred
        //Note call this method Before calling startChat
        /* FloatBot.clearData(this); */

        //Call this anywhere to set your token in floatbot Dashboard for broadcast
        //Note call this method Before calling startChat()
        /* FloatBot.setPushToken("your-gcm-token"); */

        //Call this method to update your push token in Floatbot Dashboard
        //Note call this after calling startchat(), Atleast once you need to initialize startchat before calling setPushToken
        /* FloatBot.updatePushToken(this,"new-gcm_toekn"); */



        FloatBot.startChat(MainActivity.this,BOT_ID,API_TOKEN,"My Bot");
        if (checkPlayServices()) {
            // Start IntentService to register this application with GCM.
            Intent intent = new Intent(this, RegistrationIntentService.class);
            startService(intent);
        }
    }
}
