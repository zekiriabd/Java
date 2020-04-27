package com.example.recyclerview.view_model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recyclerview.R;
import com.example.recyclerview.model.Baby;
import lombok.Builder;
import java.util.List;

@Builder
public class BabyListVM extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Baby> babyList;
    private LayoutInflater xmlBabyRow;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*View view = (convertView == null) ?
                xmlBabyRow.inflate(R.layout.baby_view,null) : convertView;
        Baby baby = this.babyList.get(position);
        ((TextView) view.findViewById(R.id.baby_firstname)).setText(baby.getFirstName());
        ((TextView) view.findViewById(R.id.baby_lastname)).setText(baby.getLastName());
        int imageResource = context.getResources().getIdentifier(
                "bebe" + baby.getId(),
                "drawable",
                context.getPackageName());
        ((ImageView) view.findViewById(R.id.baby_image)).setImageResource(imageResource);
        return view;
        */
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
