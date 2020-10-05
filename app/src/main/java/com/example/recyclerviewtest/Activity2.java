package com.example.recyclerviewtest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView textView, textView2;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        ActionBar actionBar = getSupportActionBar();

        textView = findViewById(R.id.titleVw);
        textView2 = findViewById(R.id.descw);
        imageView = findViewById(R.id.imageVw);

        Intent intent = getIntent();
        String mJudul = intent.getStringExtra("iJudul");
        String mDesc = intent.getStringExtra("iDesc");
        byte[] mByte = getIntent().getByteArrayExtra("iImg");

        Bitmap bitmap = BitmapFactory.decodeByteArray(mByte, 0, mByte.length);
        actionBar.setTitle(mJudul);

        textView.setText(mJudul);
        textView2.setText(mDesc);
        imageView.setImageBitmap(bitmap);
    }
}
