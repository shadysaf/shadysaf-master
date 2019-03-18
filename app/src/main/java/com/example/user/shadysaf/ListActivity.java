package com.example.user.shadysaf;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, DialogInterface.OnClickListener {
    ListView standings;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        standings = (ListView) findViewById(R.id.standings);
        arrayList.add("      TEAM                                       Pl      W     D     L      Pts");
        arrayList.add("1  SEVILLA                                     8       5     1     2       16");
        arrayList.add("2  FC BARCELONA                       8       4     3     1       15");
        arrayList.add("3  ATLETICO MADRID                 8       4     3     1       15");
        arrayList.add("4  REAL MADRID                          8       4     2     2       14");
        arrayList.add("5  ESPANYOL                                8       4     2     2       14");
        arrayList.add("6  ALAVES                                      8       4     2     2       14");
        arrayList.add("7  VALLADOLID                             8       3     3     2       12");
        arrayList.add("8  REAL BETIS                               8       3     3     2       12");
        arrayList.add("9  REAL SOCIEDAD                       8       3     2     3       11");
        arrayList.add("10 CELTA VIGO                              8       2     4     2       10");
        arrayList.add("11 LEVANTE                                   8       3     1     4       10");
        arrayList.add("12 EIBAR                                         8       3     1     4       10");
        arrayList.add("13 GETAFE                                     8       2     3     3       9");
        arrayList.add("14 VALENCIA                                 8       1     6     1       9");
        arrayList.add("15 GIRONA                                     8       2     3     3       9");
        arrayList.add("16 VILLARREAL                             8       2     2     4       8");
        arrayList.add("17 ATHLETIC CLUB                      7       1     4     2       7");
        arrayList.add("18 CD LEGANES                           8       2     1     5       7");
        arrayList.add("19 RAYO VALLECANO                 7       1     2     4       5");
        arrayList.add("20 SD HUESCA                              8       1     2     5       5");



        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        standings.setAdapter(arrayAdapter);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String selectedItem = arrayList.get(position);
        if(position == 0){

        }
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

}
