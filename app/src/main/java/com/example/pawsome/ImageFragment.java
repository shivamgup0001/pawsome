package com.example.pawsome;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;


public class ImageFragment extends Fragment {

    private ImageView imageView2;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    List<data> dataList;

    public ImageFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_image, container, false);
        Bundle bundle = this.getArguments();
        String myValue = bundle.getString("message");

        Toast.makeText(getContext(), "Clicked", Toast.LENGTH_SHORT).show();
        if (myValue != null) {

            int value = Integer.parseInt(myValue);

            imageView2 = getView().findViewById(R.id.imageView2);
            textView2 = getView().findViewById(R.id.textView2);
            textView3 = getView().findViewById(R.id.textView3);
            textView4 = getView().findViewById(R.id.textView4);
            textView5 = getView().findViewById(R.id.textView5);
            textView6 = getView().findViewById(R.id.textView6);
            textView7 = getView().findViewById(R.id.textView7);
            textView2.setText(dataList.get(value).getName());
            Picasso.get().load(dataList.get(value).getUrl()).into(imageView2);
            textView3.setText("imperial:" + dataList.get(value).getWeight().imperial + " metric:" + dataList.get(value).getWeight().metric);
            textView3.setText("imperial:" + dataList.get(value).getHeight().imperial + " metric:" + dataList.get(value).getHeight().metric);
            textView5.setText(dataList.get(value).getBred_for());

            textView6.setText(dataList.get(value).getLife_span());
            textView7.setText(dataList.get(value).getTemperament());
        }
        return view;

    }
}