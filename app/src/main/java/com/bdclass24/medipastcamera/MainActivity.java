package com.bdclass24.medipastcamera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView pImageIV;
    private Button takePhotoBtn;
    private Bitmap bitmap;
    private int flag=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pImageIV= (ImageView) findViewById(R.id.prescriptionImage);
        takePhotoBtn= (Button) findViewById(R.id.takePhoto);
    }

    public void takePhoto(View view) {
        if (flag==0){
            Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,5);
        }
        else if (flag==1){

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==5 && resultCode==RESULT_OK && data!=null){
            bitmap= (Bitmap) data.getExtras().get("data");
            pImageIV.setImageBitmap(bitmap);

            flag=1;
            takePhotoBtn.setText("Save Photo");
        }


    }

    private savePhoto
}
