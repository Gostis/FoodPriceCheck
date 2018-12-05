package com.example.lucasrung.foodapp;

import java.util.ArrayList;

public class ItemListHolder {


        private static ItemListHolder mInstance;
        private ArrayList<Item> list = null;

        public static ItemListHolder getInstance() {
            if(mInstance == null)
                mInstance = new ItemListHolder();

            return mInstance;
        }

        private ItemListHolder() {
            list = new ArrayList<Item>();
        }
        // retrieve array from anywhere
        public ArrayList<Item> getList() {
            return this.list;
        }
        //Add element to array
        public void addItem(Item value) {
            list.add(value);
        }



}
