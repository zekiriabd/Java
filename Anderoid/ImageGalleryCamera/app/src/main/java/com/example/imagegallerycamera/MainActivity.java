package com.example.imagegallerycamera;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;




public class MainActivity extends AppCompatActivity {

    final int GALLERY_REQUEST_CODE = 150;
    final int CAMERA_REQUEST_CODE  = 100;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
    }


    public void openGallery(View view){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(intent, GALLERY_REQUEST_CODE);
    }

    public void openCamera(View view){
        String[] perms = {Manifest.permission.CAMERA};
        if (EasyPermissions.hasPermissions(this, perms)) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, CAMERA_REQUEST_CODE);
        }
        else {
            EasyPermissions.requestPermissions
                    (this, "فتح الكميرة ضروري",
                            CAMERA_REQUEST_CODE, perms);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case GALLERY_REQUEST_CODE:
                Uri uri = data.getData();
                imageView.setImageURI(uri);
                break;

            case CAMERA_REQUEST_CODE:
                Bitmap myimage = (Bitmap)data.getExtras().get("data");
                imageView.setImageBitmap(myimage);
                break;
        }
    }



}

