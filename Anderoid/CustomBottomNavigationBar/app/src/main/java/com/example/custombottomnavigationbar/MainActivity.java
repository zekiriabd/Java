package com.example.custombottomnavigationbar;

import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView nav_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nav_view = findViewById(R.id.nav_view);
        nav_view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.nav_home   : nav_view.setItemBackgroundResource(R.color.colorhome);break;
                    case R.id.nav_add    : nav_view.setItemBackgroundResource(R.color.coloradd);break;
                    case R.id.nav_report : nav_view.setItemBackgroundResource(R.color.colorreport);break;
                    case R.id.nav_search : nav_view.setItemBackgroundResource(R.color.colorsearch);break;
                }
                return true;
            }
        });
    }
}
