package com.cdl.supermarket.checkout.data;

/**
 * Class to store information about items
 */
public class Item implements IItem {

    private char SKU;

    private int unitPrice;

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
