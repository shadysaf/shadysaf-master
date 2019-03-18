package com.example.user.shadysaf;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class TopScorers extends AppCompatActivity implements DialogInterface.OnClickListener ,AdapterView.OnClickListener {
    ArrayList<Item> items;
    CustomAdapter arrayAdapter;
    ListView TopScorers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_scorers);

        TopScorers = findViewById(R.id.TopScorers);
        items = new ArrayList<>();
        items.add(new Item(R.drawable.messi3,"LEO MESSI        649 games       564 goals"));
        items.add(new Item(R.drawable.suarez4,"LUIS SUAREZ      211 games       156 goals"));
        items.add(new Item(R.drawable.rivaldo3,"RIVALDO             236 games       133 goals"));
        items.add(new Item(R.drawable.etoo3,"ETO'O                  199 games       130 goals"));
        items.add(new Item(R.drawable.kluivert2,"KLUIVERT             259 games       123 goals"));
        items.add(new Item(R.drawable.stoichkov2,"STOICHKOV              247 games       114 goals"));
        items.add(new Item(R.drawable.enrique2,"LUIS ENRIQUE            301 games       110 goals"));
        items.add(new Item(R.drawable.neymar2,"NEYMAR JR             186 games       105 goals"));
        items.add(new Item(R.drawable.pedro2,"PEDRO                321 games         99 goals"));
        items.add(new Item(R.drawable.ronaldinho2,"RONALDINHO                 207 games         94 goals"));

        arrayAdapter = new CustomAdapter(this,R.layout.custom_row,items);
        TopScorers.setAdapter(arrayAdapter);


    }
    public void onClick(DialogInterface dialog, int which) {
        if (which == dialog.BUTTON_POSITIVE)
        {
            Intent intent= new Intent(getApplication(),Main2Activity.class);
            startActivity(intent);

        }

    }

    @Override
    public void onBackPressed() {
        //
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        //
        builder.setMessage("are you sure");
        //
        builder.setCancelable(false);
        //
        builder.setPositiveButton("yes",this);
        //
        builder.setNegativeButton("no",this);
        //
        AlertDialog dialog = builder.create();
        //
        dialog.show();
    }


    @Override
    public void onClick(View v) {

    }
}
