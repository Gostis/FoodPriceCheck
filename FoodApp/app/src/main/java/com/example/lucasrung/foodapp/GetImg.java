package com.example.lucasrung.foodapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class GetImg extends AsyncTask<String,Void, Bitmap>{

    public static void downloadfile(String fileurl, ImageView img) {
        Bitmap bmImg = null;
        URL myfileurl = null;
        try {
            myfileurl = new URL(fileurl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            HttpURLConnection conn = (HttpURLConnection) myfileurl.openConnection();
            conn.setDoInput(true);
            conn.connect();
            int length = conn.getContentLength();
            if (length > 0) {
                int[] bitmapData = new int[length];
                byte[] bitmapData2 = new byte[length];
                InputStream is = conn.getInputStream();
                bmImg = BitmapFactory.decodeStream(is);
                img.setImageBitmap(bmImg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

