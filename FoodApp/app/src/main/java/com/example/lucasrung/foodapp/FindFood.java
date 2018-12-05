package com.example.lucasrung.foodapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class FindFood extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    ListView  listView;
    public ArrayList<Item> itemList;
    ArrayList<Item> searchList;
    ItemListAdapter adapter;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findfood);
        LoadItems();
          listView = (ListView) findViewById(R.id.listView);

         intent = new Intent(FindFood.this, ListItem.class);

        //
        ItemClick();
        Button btn = (Button) findViewById(R.id.changeView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        searchList = new ArrayList<Item>();
        searchList.add(new Item("hej",2,"test","test"));
        //search

        final EditText editText = (EditText) findViewById(R.id.searchFilter);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int textlength = editText.getText().length();
             //clear list TODO
                searchList.clear();
                for (int i = 0; i < itemList.size(); i++) {


                    if (textlength <= itemList.get(i).getName().length()) {
                        if (itemList.get(i).getName().toLowerCase().trim().contains(
                                editText.getText().toString().toLowerCase().trim())) {

                            searchList.add(itemList.get(i));
                        }
                    }


                }
                /*adapter = new ItemListAdapter(FindFood.this,R.layout.adapter_view_layout,searchList);
                listView.setAdapter(adapter);*/
                UpdateList(searchList);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    public void ItemClick(){
        ListView listView1 = (ListView) findViewById(R.id.listView);

        adapter = new ItemListAdapter(this,R.layout.adapter_view_layout,itemList);
        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener( new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(FindFood.this, "Added " +  itemList.get( i ).name + " to shoppinglist ", Toast.LENGTH_SHORT).show();

                //FoodlistActivity newFood = new FoodlistActivity();
               ItemListHolder.getInstance().addItem(itemList.get( i ));

            }
        });
    }



    
public void LoadItems(){

    Resources res = getResources();

    InputStream is = res.openRawResource(R.raw.matvaror);

    Scanner scanner = new Scanner(is);

    StringBuilder builder = new StringBuilder();
    while (scanner.hasNextLine()){

        builder.append(scanner.nextLine());

    }

    parseJson(builder.toString());

}
public void UpdateList(ArrayList<Item> list){
    ListView listView = (ListView) findViewById(R.id.listView);

    adapter = new ItemListAdapter(this,R.layout.adapter_view_layout,list);
    listView.setAdapter(adapter);
}
private void parseJson(String s) {


   // TextView txtDisplay = (TextView) findViewById(R.id.text_display);

    ListView listView = (ListView) findViewById(R.id.listView);
    StringBuilder builder = new StringBuilder();
    itemList = new ArrayList<Item>();

    try {
        JSONObject root = new JSONObject(s);


        JSONObject products = root.getJSONObject("foodItems");
        //builder.append("Name: ").append(products.getString("name")).append("\n");

        JSONArray items = products.getJSONArray("products");
        for(int i = 0; i < items.length();i++){


            JSONObject itemC = items.getJSONObject(i);
            /*builder.append("Name:")
                    .append(itemC.getString("name"))
                    .append("\n");*/

            itemList.add(new Item(itemC.getString("name"), itemC.getInt("ID"),itemC.getString("brand"), itemC.getString("imgsrc")));

        }

        //adapter = new ItemListAdapter(this,R.layout.adapter_view_layout,itemList);
        //listView.setAdapter(adapter);
        UpdateList(itemList);

    } catch (JSONException e) {
        e.printStackTrace();
    }


  //  txtDisplay.setText(builder.toString());
}

}
