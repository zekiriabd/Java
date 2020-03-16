package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.myapplication.model.Baby;
import com.example.myapplication.view_model.BabyListVM;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ListView babyListV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Baby> babies = new ArrayList<>();
        babies.add(new Baby(1, "Zekiri", "Abdelali"));
        babies.add(new Baby(2, "Aloui", "Ali"));
        babies.add(new Baby(3, "Rahich", "Rouf"));
        babies.add(new Baby(4, "44444444", "44444444444"));

        BabyListVM adapter = BabyListVM.builder()
                .context(this)
                .babyList(babies)
                .xmlBabyRow((LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .build();

        babyListV = findViewById(R.id.babyListV);
        babyListV.setAdapter(adapter);
    }


   // Main Menu ----------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String msg = "";
        switch (item.getItemId()) {
            case R.id.menu_add:
                msg = "Menu Add is ok";
                break;
            case R.id.menu_msg:
                msg = "Menu Msg is ok";
                break;
            case R.id.menu_edit:
                msg = "Menu Edit is ok";
                break;
            case R.id.menu_exit:
                msg = "Menu Exit is ok";
                break;
        }
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
