package com.example.user.shadysaf;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CameraGalleryActivity extends AppCompatActivity implements  DialogInterface.OnClickListener, View.OnClickListener{

    private static final int CAMERA_REQUEST = 0;
    ImageView imageView2;
    Button btTakePhoto, btGallery;
    Bitmap bitmap;

    private static final int SELECT_IMAGE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_gallery);

        btGallery = findViewById(R.id.btGallery);
        btGallery.setOnClickListener(this);

        btTakePhoto = findViewById(R.id.btTakephoto);
        btTakePhoto.setOnClickListener(this);

        imageView2=findViewById(R.id.imageView2);
    }

    public void onClick(View view){
        if(view == btTakePhoto) {
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i,CAMERA_REQUEST);
        }else {
            Intent i = new
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i,SELECT_IMAGE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK){
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView2.setImageBitmap(photo);
            String imagepath = saveImage(bitmap);

            SharedPreferences pref = getSharedPreferences("mypref",MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("image",imagepath);
            editor.commit();


        }
        else if(requestCode == SELECT_IMAGE && requestCode == Activity.RESULT_OK){
            Uri targetUri = data.getData();
            try{
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                imageView2.setImageBitmap(bitmap);
            } catch (FileNotFoundException e){
                e.printStackTrace();
            }
        }

    }
    public String saveImage (Bitmap bitmap){
        File root = Environment.getExternalStorageDirectory();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = root.getAbsolutePath()+"/DCIM/Camera/IMG_"+timeStamp+".jpg";
        File file = new File(filePath);
        try
        {
            file.createNewFile();
            FileOutputStream ostream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100,ostream);
            ostream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(this,"Faild to save image",Toast.LENGTH_SHORT).show();
        }
        return filePath;
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
