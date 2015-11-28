package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
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
        CheckBox checkBoxState =(CheckBox) findViewById(R.id.checkBox_id);
        boolean ischeckBoxState1 = checkBoxState.isChecked();
        CheckBox checkBoxState2 =(CheckBox) findViewById(R.id.checkBox2_id);
        boolean ischeckBoxState2 = checkBoxState2.isChecked();
        EditText Name = (EditText) findViewById(R.id.edit_text_id);
        String PersoneName = Name.getText().toString();
        /*Log.v("MainActivity", "The name is :" + PersoneName );*/
        int price = calculatePrice( ischeckBoxState1, ischeckBoxState2);
        /*String PriceMessage = "Total: " + price + " РУБ";
        PriceMessage = PriceMessage + "\n You, dirty MotherFucker!";*/
        String orderSum = createOrderSummury(price, PersoneName,ischeckBoxState1,ischeckBoxState2  );
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

    private int calculatePrice(boolean ischeckBoxState2, boolean ischeckBoxState1){
        int govno = 0;
        int trah = 0;
        if(ischeckBoxState1)
        { govno = 50;}
        if(ischeckBoxState2)
        { trah = 70;}
        int adiing = trah + govno;
        int price = ((150 + adiing) * quantity);
        return price;

    }
    public String createOrderSummury(int price,String PersoneName, boolean ischeckBoxState1, boolean ischeckBoxState2){



        String orderSum = "Имя : " + PersoneName +
                "\nКоличество : " + quantity +
                "\nВсего : " + price +
                "\nТы, ублюдок мать твою!" +
                "\n Решил меня трахнуть? " + ischeckBoxState1 +
                "\n Говно собачье! " + ischeckBoxState2;
        return orderSum;

    }

    };


