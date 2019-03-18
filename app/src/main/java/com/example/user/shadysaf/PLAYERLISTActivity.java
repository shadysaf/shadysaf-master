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

public class PLAYERLISTActivity extends AppCompatActivity implements  DialogInterface.OnClickListener ,AdapterView.OnClickListener{
    ArrayList<Item> items;
    CustomAdapter arrayAdapter;
    ListView playersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playerlist);

        playersList = findViewById(R.id.playersList);
        items = new ArrayList<>();
        items.add(new Item(R.drawable.stegen,"1.STEGEN"));
        items.add(new Item(R.drawable.semedo,"2.SEMEDO"));
        items.add(new Item(R.drawable.pique,"3.PIQUE"));
        items.add(new Item(R.drawable.rakititc,"4.RAKITITC"));
        items.add(new Item(R.drawable.posquets,"5.BOSQUETS"));
        items.add(new Item(R.drawable.denis,"6.DENIS"));
        items.add(new Item(R.drawable.coutinho,"7.COUTINHO"));
        items.add(new Item(R.drawable.arthur,"8.ARTHUR"));
        items.add(new Item(R.drawable.suarez,"9.SUAREZ"));
        items.add(new Item(R.drawable.messi,"10.MESSI"));
        items.add(new Item(R.drawable.dembele,"11.DEMBELE"));
        items.add(new Item(R.drawable.rafinha,"12.RAFINHA"));
        items.add(new Item(R.drawable.cillessen,"13.CILLESSEN"));
        items.add(new Item(R.drawable.malcom,"14.MALCOM"));
        items.add(new Item(R.drawable.lenglet,"15.LENGLET"));
        items.add(new Item(R.drawable.samper,"16.SAMPER"));
        items.add(new Item(R.drawable.alba,"18.ALBA"));
        items.add(new Item(R.drawable.munir,"19.MUNIR"));
        items.add(new Item(R.drawable.roberto,"20.ROBERTO"));
        items.add(new Item(R.drawable.vidal,"22.VIDAL"));
        items.add(new Item(R.drawable.umtiti,"23.UMTITI"));
        items.add(new Item(R.drawable.vermalen,"24.VERMALEN"));
        items.add(new Item(R.drawable.valverde,"VALVERDE"));

        arrayAdapter = new CustomAdapter(this,R.layout.custom_row,items);
        playersList.setAdapter(arrayAdapter);

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
