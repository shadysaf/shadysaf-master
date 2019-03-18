package com.example.user.shadysaf;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CalendarActivity extends AppCompatActivity implements View.OnClickListener,DialogInterface.OnClickListener {
    ArrayList<Item2> items1;
    CustomAdapter2 arrayAdapter;
    ListView GamesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        GamesList = findViewById(R.id.GamesList);
        items1 = new ArrayList<>();
        items1.add(new Item2("6 Tue-Nov","Milan","1-1","Barcelona"));
        items1.add(new Item2("11 Sun-Nov","Barcelona","3-4","Betis"));
        items1.add(new Item2("24 Sat-Nov","Atletico","21:45","Barcelona"));
        items1.add(new Item2("28 Wed-Nov","PSV","10:00","Barcelona"));
        items1.add(new Item2("2 Sun-Dec","Barcelona","19:30","Villarreal"));
        items1.add(new Item2("5 wed-Dec","Barcelona","22:30","Leonesa"));
        items1.add(new Item2("8 Sat-Dec","Espanyol","21:45","Barcelona"));
        items1.add(new Item2("11 Tue-Dec","Barcelona","22:00","Tottenham"));
        items1.add(new Item2("16 Sun-Dec","Levante","21:00","Barcelona"));
        items1.add(new Item2("22 Sat-Dec","Barcelona","21:00","Celta Vigo"));
        items1.add(new Item2("6 Sat-Dec","Getafe","21:00","Barcelona"));
        items1.add(new Item2("13 Sun-Lan","Barcelona","21:00","Eibar"));



        arrayAdapter = new CustomAdapter2(this, R.layout.custom_row2, items1);
        GamesList.setAdapter(arrayAdapter);

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
