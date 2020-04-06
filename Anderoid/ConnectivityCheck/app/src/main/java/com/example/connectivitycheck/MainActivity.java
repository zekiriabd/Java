package com.example.connectivitycheck;

import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.treebo.internetavailabilitychecker.InternetAvailabilityChecker;
import com.treebo.internetavailabilitychecker.InternetConnectivityListener;

public class MainActivity extends AppCompatActivity implements InternetConnectivityListener{

    InternetAvailabilityChecker networkInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InternetAvailabilityChecker.init(this);
        networkInfo = InternetAvailabilityChecker.getInstance();
        networkInfo.addInternetConnectivityListener(this);
    }

    @Override
    public void onInternetConnectivityChanged(boolean isConnected) {
        if (networkInfo.getCurrentInternetAvailabilityStatus()){
            Toast.makeText(this, "- is internet connected", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "- is not internet connection", Toast.LENGTH_SHORT).show();
        }
    }





    /*public void ConnectivityCheck(View view){
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null) {
            Toast.makeText(this, "is internet connected", Toast.LENGTH_SHORT).show();
            switch (networkInfo.getType()) {
                case ConnectivityManager.TYPE_WIFI:
                    Toast.makeText(this, "is connected with WIFI", Toast.LENGTH_SHORT).show();
                    break;
                case ConnectivityManager.TYPE_MOBILE:
                    Toast.makeText(this, "is connected with MOBILE", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
        else{
            Toast.makeText(this, "is not internet connection", Toast.LENGTH_SHORT).show();
        }
    }*/

}
