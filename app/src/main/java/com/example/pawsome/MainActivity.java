package com.example.pawsome;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pawsome.adapter.RecyclerViewAdapter;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements RecyclerViewClickInterface {
private RecyclerView recyclerView;
List<data> data2,data3,data4;
private RecyclerViewAdapter recyclerViewAdapter;
private ImageView imageView;
private TextView textView;
SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        data2=new ArrayList<>();
        data3=new ArrayList<>();

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        imageView=findViewById(R.id.imageView);
        textView=findViewById(R.id.textView);


        searchView=findViewById(R.id.action_search);



        Call<List<data>> call= Apiclient.getapi1().getData();
        call.enqueue(new Callback<List<data>>() {
            @Override
            public void onResponse(Call<List<data>> call, Response<List<data>> response) {
                List<data>data1 = response.body();
                for (data d:data1) {
                    data2.add(d);
                    data3.add(d);
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerViewAdapter=new RecyclerViewAdapter(MainActivity.this,data2,MainActivity.this::onItemClick);
                recyclerView.setAdapter(recyclerViewAdapter);
            }

            @Override
            public void onFailure(Call<List<data>> call, Throwable t) {
                Log.d("myapp","Something went wrong!"+t.getLocalizedMessage());
            }
        });

        searchView.setOnQueryTextListener(new android.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                recyclerViewAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        searchView.setOnCloseListener(new android.widget.SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                data4=new ArrayList<>();
                data4.addAll(data3);
                Log.d("shivam","clicked");
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerViewAdapter =new RecyclerViewAdapter(getApplicationContext(),data4, MainActivity.this::onItemClick);
                recyclerView.setAdapter(recyclerViewAdapter);
                return false;

            }
        });




    }

    @Override
    public void onItemClick(int position,ImageView imageView) {
        Intent intent =new Intent(this, MainActivity2.class);


        intent.putExtra("name",recyclerViewAdapter.dataList.get(position).getName());
        intent.putExtra("url",recyclerViewAdapter.dataList.get(position).getUrl());
        intent.putExtra("weighti",recyclerViewAdapter.dataList.get(position).getWeight().getImperial());
        intent.putExtra("weightm",recyclerViewAdapter.dataList.get(position).getWeight().getMetric());
        intent.putExtra("heighti",recyclerViewAdapter.dataList.get(position).getHeight().getImperial());
        intent.putExtra("heightm",recyclerViewAdapter.dataList.get(position).getHeight().getMetric());
        intent.putExtra("bred",recyclerViewAdapter.dataList.get(position).getBred_for());
        intent.putExtra("life",recyclerViewAdapter.dataList.get(position).getLife_span());
        intent.putExtra("temper",recyclerViewAdapter.dataList.get(position).getTemperament());
        ActivityOptionsCompat options=ActivityOptionsCompat.makeSceneTransitionAnimation(this,imageView, ViewCompat.getTransitionName(imageView));
        startActivity(intent,options.toBundle());
    }
}