package com.example.pawsome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private ImageView imageView2;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    List<data> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        getSupportActionBar().hide();


            imageView2 = findViewById(R.id.imageView2);
            textView2 = findViewById(R.id.textView2);
            textView3 = findViewById(R.id.textView3);
            textView4 = findViewById(R.id.textView4);
            textView5 = findViewById(R.id.textView5);
            textView6 = findViewById(R.id.textView6);
            textView7 = findViewById(R.id.textView7);
            textView2.setText(intent.getStringExtra("name"));
            Picasso.get().load(intent.getStringExtra("url")).into(imageView2);
            textView3.setText("Imperial Weight : " + intent.getStringExtra("weighti") + "\nMetric Weight : " + intent.getStringExtra("weightm"));
            textView4.setText("Imperial Height: " + intent.getStringExtra("heighti") + "\nMetric Height : " + intent.getStringExtra("heightm"));
            textView5.setText("Bred for : "+intent.getStringExtra("bred"));

            textView6.setText("Lifespan : "+intent.getStringExtra("life"));
            textView7.setText("Temperament : "+intent.getStringExtra("temper"));

    }
}