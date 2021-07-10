package com.cdl.supermarket.checkout.data;

import java.util.Objects;

/**
 * Class to store information about items
 */
public class Item {

    private char SKU;

    private String name;

    private int unitPrice;

    public Item(){

    }

    public Item(char SKU, int unitPrice) {
        this.SKU = SKU;
        this.unitPrice = unitPrice;
    }


    public char getSKU() {
        return SKU;
    }

    public void setSKU(char SKU) {
        this.SKU = SKU;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return SKU == item.SKU;
    }
}