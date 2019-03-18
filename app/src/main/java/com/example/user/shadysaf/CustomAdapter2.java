package com.example.user.shadysaf;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter2 extends ArrayAdapter<Item2>{
    private int resourcelLayout;
    private Context mContext;

    public CustomAdapter2(@NonNull Context context, int resource, ArrayList<Item2> objects) {
        super(context, resource,objects);
        this.resourcelLayout = resource;
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null)
            v = LayoutInflater.from(mContext).inflate(resourcelLayout, parent, false);

        Item2 p = getItem(position);
        if (p != null) {
            TextView textView9 = (TextView) v.findViewById(R.id.textView9);
            textView9.setText(p.getTextView1());
            TextView textView10 = (TextView) v.findViewById(R.id.textView10);
            textView10.setText(p.getTextView2());
            TextView textView11 = (TextView) v.findViewById(R.id.textView11);
            textView11.setText(p.getTextView3());
            TextView textView12 = (TextView) v.findViewById(R.id.textView12);
            textView12.setText(p.getTextView4());

        }
        return v;

    }
}
