package com.example.cw8;

import java.io.Serializable;

public class Items implements Serializable {

    private String ItemName;
    private double ItemPrice;
    private int ItemImg;

    public Items(String itemName, double itemPrice, int itemImg) {
        ItemName = itemName;
        ItemPrice = itemPrice;
        ItemImg = itemImg;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public double getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(double itemPrice) {
        ItemPrice = itemPrice;
    }

    public int getItemImg() {
        return ItemImg;
    }

    public void setItemImg(int itemImg) {
        ItemImg = itemImg;
    }
}
