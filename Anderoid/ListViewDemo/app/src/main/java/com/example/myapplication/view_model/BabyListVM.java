package com.example.myapplication.view_model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.myapplication.R;
import com.example.myapplication.model.Baby;
import lombok.Builder;
import java.util.List;

@Builder
public class BabyListVM extends BaseAdapter {
    private Context context;
    private List<Baby> babyList;
    private LayoutInflater xmlBabyRow;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = (convertView == null) ?
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
    }

    @Override public int getCount() { return this.babyList.size(); }
    @Override public Object getItem(int position) { return null; }
    @Override public long getItemId(int i) { return i; }
}
