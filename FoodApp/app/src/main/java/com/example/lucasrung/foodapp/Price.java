package com.example.lucasrung.foodapp;

public class Price {
    String storeOne;
    String storeTwo;
    String storeThree;
    int priceOne;
    int priceTwo;
    int priceThree;
    public Price(){
        this.storeOne = "Ica";
        this.storeTwo = "Willys";
        this.storeThree = "Hemköp";
        this.priceOne = 0;
        this.priceTwo = 0;
        this.priceThree = 0;

    }
    public Price(String storeOne, String storeTwo, String storeThree, int priceOne, int priceTwo, int priceThree) {
        this.storeOne = storeOne;
        this.storeTwo = storeTwo;
        this.storeThree = storeThree;
        this.priceOne = priceOne;
        this.priceTwo = priceTwo;
        this.priceThree = priceThree;
    }

    public String getStoreOne() {
        return storeOne;
    }

    public void setStoreOne(String storeOne) {
        this.storeOne = storeOne;
    }

    public String getStoreTwo() {
        return storeTwo;
    }

    public void setStoreTwo(String storeTwo) {
        this.storeTwo = storeTwo;
    }

    public String getStoreThree() {
        return storeThree;
    }

    public void setStoreThree(String storeThree) {
        this.storeThree = storeThree;
    }
    public void addPriceOne(int priceOne) {

        this.priceOne += priceOne;
    }
    public void addPriceTwo(int priceOne) {

        this.priceTwo += priceOne;
    }
    public void addPriceThree(int priceOne) {

        this.priceThree += priceOne;
    }
    public int getPriceOne() {
        return priceOne;
    }

    public void setPriceOne(int priceOne) {
        this.priceOne = priceOne;
    }

    public int getPriceTwo() {
        return priceTwo;
    }

    public void setPriceTwo(int priceTwo) {
        this.priceTwo = priceTwo;
    }

    public int getPriceThree() {
        return priceThree;
    }

    public void setPriceThree(int priceThree) {
        this.priceThree = priceThree;
    }


}
