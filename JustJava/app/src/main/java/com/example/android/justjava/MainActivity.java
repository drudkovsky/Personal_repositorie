package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String PersoneName = "Ублюдок";
        int price = calculatePrice();
        /*String PriceMessage = "Total: " + price + " РУБ";
        PriceMessage = PriceMessage + "\n You, dirty MotherFucker!";*/
        String orderSum = createOrderSummury(price, PersoneName);
        displayOrderSummury(orderSum);
    }

    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);

    }

    public void discrement(View view) {
        quantity = quantity - 1;
        display(quantity);

    }

    public void Reload(View view){
        quantity = 0;
        display(quantity);
        String PriceMessage = "name : " +"" +
        "\nQuantity : " + quantity +
                "\nTotal : " + "Free" +
                "\nЯ тебя сам трахну!";
        displayOrderSummury(PriceMessage);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */

    private void displayOrderSummury(String orderSum) {
        TextView priceTextView = (TextView) findViewById(R.id.Order_summary_text_view);
        priceTextView.setText(orderSum);
    }

    private int calculatePrice(){
        int price = (quantity * 150);
        return price;

    }
    public String createOrderSummury(int price,String PersoNename){
        String orderSum = "name : " + PersoNename +
                "\nQuantity : " + quantity +
                "\nTotal : " + price +
                "\nТы, ублюдок мать твою!";
        return orderSum;

    }
}
