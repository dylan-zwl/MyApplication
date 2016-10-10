package com.example.administrator.myapplication.model.crop;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;

import com.example.administrator.myapplication.R;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Main3Activity extends Activity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Button button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
//                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
//                intent.putExtra(MediaStore.EXTRA_OUTPUT,
//                        Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "sss")));

                startActivityForResult(intent, 1);
            }
        });
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                setImageToView(data);
                break;
            default:
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * 保存裁剪之后的图片数据
     *
     * @param
     */
    private void setImageToView(Intent data) {
        ContentResolver resolver = getContentResolver();
        Uri originalUri = data.getData();
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(resolver, originalUri);
            Drawable drawable = new BitmapDrawable(bitmap);
            imageView.setBackgroundDrawable(drawable);
        } catch (IOException e){
        }
    }
}
