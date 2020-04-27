package com.example.recyclerview;

import android.view.LayoutInflater;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.recyclerview.model.Baby;
import com.example.recyclerview.view_model.BabyListVM;

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
                .xmlBabyRow((LayoutInflater) this.getSystemService(this.LAYOUT_INFLATER_SERVICE))
                .build();

        babyListV = findViewById(R.id.babyListV);
        babyListV.setAdapter(adapter);
    }
}
