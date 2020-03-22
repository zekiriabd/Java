package com.example.floatingactionmenu;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txPhone;
    EditText txSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txPhone = findViewById(R.id.txPhone);
        txSms   = findViewById(R.id.txSms);

    }

    public void callPhone(View v){
        Intent Phone_intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + txPhone.getText()));
        startActivity(Phone_intent);
    }

    public void sendSms(View v){
        Intent sms_intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+ txPhone.getText()));
        sms_intent.putExtra("sms_body", txSms.getText().toString() );
        startActivity(sms_intent);
    }


}
