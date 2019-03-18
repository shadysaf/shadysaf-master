package com.example.user.shadysaf;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements DialogInterface.OnClickListener,View.OnClickListener {
    TextView textView3,textView5,topscorers,textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView3=(TextView) findViewById(R.id.textView3);
        textView3.setOnClickListener(this);
        textView4=(TextView) findViewById(R.id.textView4);
        textView4.setOnClickListener(this);
        textView5=(TextView) findViewById(R.id.textView5);
        textView5.setOnClickListener(this);
        topscorers=(TextView) findViewById(R.id.topscorers);
        topscorers.setOnClickListener(this);

    }


    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == dialog.BUTTON_POSITIVE)
        {
            Intent intent= new Intent(getApplication(),MainActivity.class);
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
        if(v==textView3){
            Intent intent1 = new Intent(getApplication(),ListActivity.class);
            startActivity(intent1);
        }
        if(v== textView5){
            Intent intent5 = new Intent(getApplication(),PLAYERLISTActivity.class);
            startActivity(intent5);
        }
        if(v== topscorers){
            Intent intent6 = new Intent(getApplication(),TopScorers.class);
            startActivity(intent6);
        }
        if(v==textView4){
            Intent intent1 = new Intent(getApplication(),CalendarActivity.class);
            startActivity(intent1);
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu2, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Camera:
                Intent i = new Intent(this,CameraGalleryActivity.class);
                startActivity(i);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    
}
