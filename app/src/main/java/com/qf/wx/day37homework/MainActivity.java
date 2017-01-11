package com.qf.wx.day37homework;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.xutils.view.annotation.Event;
import org.xutils.x;

import java.io.File;

public class MainActivity extends AppCompatActivity {


    private String imagePath;
    private static final int IMAGE_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.Ext.init(getApplication());
        x.Ext.setDebug(true);
        setContentView(R.layout.activity_main);

        x.view().inject(this);
    }
//kkkkkkkkkkkkkkkkkkkkkkkkk

    @Event(R.id.btn)
    private void btnPic(View view){
        imagePath = Environment.getExternalStorageDirectory()+"/aa.jpg";
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(imagePath)));
        startActivityForResult(intent,IMAGE_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == IMAGE_CODE && resultCode == RESULT_OK){
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(imagePath,options);
            options.inJustDecodeBounds=false;
            options.inSampleSize=5;
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath, options);
            if(bitmap != null){


            }
        }
    }
}
