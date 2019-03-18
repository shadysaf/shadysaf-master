package com.example.user.shadysaf;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Item> {
    private int resourcelLayout;
    private Context mContext;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Item> objects) {
        super(context, resource, objects);
        this.resourcelLayout = resource;
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null)
            v = LayoutInflater.from(mContext).inflate(resourcelLayout,parent, false);

        Item p = getItem(position);
        if (p != null){
            TextView tvName = (TextView) v.findViewById(R.id.tvItemList);
            tvName.setText(p.getName());

            ImageView imageView = (ImageView)v.findViewById(R.id.imageListItem);
            imageView.setImageResource(p.getImage());


        }
        return v;
    }
}
