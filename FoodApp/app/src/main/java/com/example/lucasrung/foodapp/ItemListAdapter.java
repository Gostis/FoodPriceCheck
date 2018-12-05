package com.example.lucasrung.foodapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ItemListAdapter extends ArrayAdapter<Item> {


    private Context mContext;
    int mResource;
    public ItemListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Item> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //get the item information
        String name = getItem(position).getName();
        String brand = getItem(position).getBrand();
        int id = getItem(position).getId();
        String img = getItem(position).getImg();


        //all info
        Item item = new Item(name,id,brand,img);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource,parent,false);

        TextView tVName = (TextView) convertView.findViewById(R.id.textView2);
        ImageView imgV = (ImageView) convertView.findViewById(R.id.imageView);
        TextView tVId = (TextView) convertView.findViewById(R.id.textView3);

        tVName.setText(name);
        Picasso.with(mContext).load(img).into(imgV);       // tVBrand.setText(brand);
        //tVId.setText(id);


        return convertView;

    }
}
