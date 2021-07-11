package com.cdl.supermarket.checkout.data;

/**
 * Class to store information about transactions.
 */
public class Transaction implements ITransaction {



    private IBasket basket;

    private CurrentOffers currentOffers;

    private int runningTotal;

    private int finalTotal;

    public Transaction() {
        basket = new Basket();
        currentOffers = new CurrentOffers();
        runningTotal = 0;
        finalTotal = 0;
    }

    /**
     * Method called to update transaction with new item
     * @param item item to add to basket
     * @return Updated basket object
     */
    public IBasket addItem(IItem item){
        basket.addToBasket(item);
        runningTotal = runningTotal + item.getUnitPrice();
        runningTotal = runningTotal + currentOffers.calculateOfferDiscount(item,basket);
        return basket;
    }

    /**
     * Calculates the final total amount
     * @return int final total
     */
    public int calculateFinalTotal(){
        for(IItem item: basket.getItemsInBasket()){
            finalTotal = finalTotal + item.getUnitPrice() * basket.getAmountOfItemInBasket(item);
            finalTotal = finalTotal + currentOffers.calculateFinalOfferDiscount(item,basket);
        }
        return finalTotal;
    }


    public CurrentOffers getCurrentOffers() {
        return currentOffers;
    }

    public void setCurrentOffers(CurrentOffers currentOffers) {
        this.currentOffers = currentOffers;
    }

    public int getRunningTotal() {
        return runningTotal;
    }

    public void setRunningTotal(int runningTotal) {
        this.runningTotal = runningTotal;
    }

    public int getFinalTotal() {
        return finalTotal;
    }

    public void setFinalTotal(int finalTotal) {
        this.finalTotal = finalTotal;
    }

    public IBasket getBasket() {
        return basket;
    }

    public void setBasket(IBasket basket) {
        this.basket = basket;
    }
}
