package com.example.lucasrung.foodapp;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ListItem extends AppCompatActivity {
    ArrayList<Item> shoppingList;
    ItemListAdapter adapter;
    Price priceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);

        priceList = new Price();
        shoppingList = ItemListHolder.getInstance().getList();
        UpdateList(shoppingList);
        LoadItems();
    }





    public void UpdateList(ArrayList<Item> list){

        ListView shoppingListN = (ListView) findViewById(R.id.shoppingList);
        adapter = new ItemListAdapter(this,R.layout.adapter_view_layout,list);
        shoppingListN.setAdapter(adapter);
    }

    public void LoadItems(){

        Resources res = getResources();

        InputStream is = res.openRawResource(R.raw.matpriser);

        Scanner scanner = new Scanner(is);

        StringBuilder builder = new StringBuilder();
        while (scanner.hasNextLine()){

            builder.append(scanner.nextLine());

        }

        parseJson(builder.toString());

    }

    private void parseJson(String s) {


        // TextView txtDisplay = (TextView) findViewById(R.id.text_display);

        StringBuilder builder = new StringBuilder();

        try {
            JSONObject root = new JSONObject(s);


            JSONObject products = root.getJSONObject("foodPrice");
            //builder.append("Name: ").append(products.getString("name")).append("\n");

            JSONArray items = products.getJSONArray("products");
            for (Item i:shoppingList){


                for (int c = 0; c < items.length(); c++) {


                    JSONObject js = items.getJSONObject(c);

                    if(js.getInt("ID") == i.getId()){
                        priceList.addPriceOne(js.getInt("ica"));
                        priceList.addPriceTwo(js.getInt("willys"));
                        priceList.addPriceThree(js.getInt("hemköp"));


                    }


                }

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ShowPrice();
        //  txtDisplay.setText(builder.toString());
    }

    private void ShowPrice() {



        TextView viewStoreOne = (TextView) findViewById(R.id.storeOne);
        TextView viewStoreTwo = (TextView) findViewById(R.id.storeTwo);
        TextView viewStoreThree = (TextView) findViewById(R.id.storeThree);

        viewStoreOne.setText("priset hos " + priceList.getStoreOne() + " är " + Integer.toString(priceList.getPriceOne()));
        viewStoreTwo.setText("priset hos " + priceList.getStoreOne() + " är " + Integer.toString(priceList.getPriceTwo()));
        viewStoreThree.setText("priset hos " + priceList.getStoreOne() + " är " + Integer.toString(priceList.getPriceThree()));



    }


}
