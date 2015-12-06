package com.example.android.budget;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    int summValue;
    int interedNumber;
    String picName;
    String fontVar;
    private SharedPreferences Budget;
    private SharedPreferences Picture;
    private SharedPreferences Font;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Budget = getSharedPreferences("MyData", 0);
        Picture = getSharedPreferences("picName", 0);
        Font = getSharedPreferences("font", 0);

    }

    @Override
    protected void onPause() {
        super.onPause();
        // Запоминаем данные
        SharedPreferences.Editor editor = Budget.edit();
        editor.putInt("MyData", summValue);
        editor.apply();
        SharedPreferences.Editor editor2 = Picture.edit();
        editor2.putString("picName", picName);
        editor2.apply();
        SharedPreferences.Editor editor3 = Font.edit();
        editor3.putString("font", fontVar);
        editor3.apply();

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (Budget.contains("MyData")) {
            // Получаем число из настроек
            summValue = Budget.getInt("summValue", summValue);
            // Надо вывести на экран
            TextView summaryId = (TextView) findViewById(R.id.Sunnury_id);
            summaryId.setText(summValue + "РУБ");
        }
        if (Picture.contains("picName")) {
            // Получаем число из настроек
            picName = Picture.getString("picName", picName);
            // Надо вывести на экран
            ImageView pic = (ImageView) findViewById(R.id.Pic_id);
            pic.setImageResource(getResources().getIdentifier(picName, "drawable", getPackageName()));
        }
        if (Font.contains("font")) {
            // Получаем число из настроек
            fontVar = Font.getString("font", fontVar);
            // Надо вывести на экран
            TextView dept = (TextView) findViewById(R.id.Sunnury_id);
            dept.setTextColor(Color.parseColor(fontVar));

        }
    }

    // Method for displaying the number
    private void display(int number) {

        TextView summaryId = (TextView) findViewById(R.id.Sunnury_id);
        summaryId.setText(number + "РУБ");
        ImageView pic = (ImageView) findViewById(R.id.Pic_id);
        if (summValue >= 20000) {
            pic.setImageResource(R.drawable.alotmoney);
            picName = "alotmoney";
            SharedPreferences.Editor editor = Picture.edit();
            editor.putString("picName",picName);
            editor.apply();
        }
        if ((summValue >= 10000) & (summValue < 20000)) {
            pic.setImageResource(R.drawable.money);
            picName = "money";
            SharedPreferences.Editor editor = Picture.edit();
            editor.putString("picName", "picName");
            editor.apply();
        }
        if (summValue >= 5000 & summValue < 10000) {
            pic.setImageResource(R.drawable.somemoney);
            picName = "somemoney";
            SharedPreferences.Editor editor = Picture.edit();
            editor.putString("picName", picName);
            editor.apply();
        }
        if (summValue >= 3000 & summValue < 5000) {
            pic.setImageResource(R.drawable.littlemoney);
            picName = "littlemoney";
            SharedPreferences.Editor editor = Picture.edit();
            editor.putString("picName", picName);
            editor.apply();

        }
        if (summValue < 3000) {
            pic.setImageResource(R.drawable.nomoney);
            picName = "nomoney";
            SharedPreferences.Editor editor = Picture.edit();
            editor.putString("picName", picName);
            editor.apply();
        }
        if (summValue < 0){
            TextView dept = (TextView) findViewById(R.id.Sunnury_id);
            dept.setTextColor(Color.parseColor("#F44336"));
            pic.setImageResource(R.drawable.overbudget);
            picName = "overbudget";
            fontVar = "#F44336";
            SharedPreferences.Editor editor = Picture.edit();
            editor.putString("picName", picName);
            editor.apply();
            fontVar = "#F44336";
            SharedPreferences.Editor font = Font.edit();
            font.putString("font", fontVar);
            font.apply();
        }
        if (summValue >= 0){
            TextView dept = (TextView) findViewById(R.id.Sunnury_id);
            dept.setTextColor(Color.parseColor("#000000"));
            fontVar = "#000000";
            SharedPreferences.Editor font = Font.edit();
            font.putString("font", fontVar);
            font.apply();



        }
    }

    //Method for grabbing the intered number from edittext to the variable
    private int GrabbingNumber() {
        TextView UserNumber = (TextView) findViewById(R.id.Entered_number_id);
        String CheckInteredNumber = UserNumber.getText().toString();
        if (UserNumber.getText().toString().equals("")) {
            interedNumber = 0;
            Toast.makeText(getApplicationContext(), "Введите сумму!",
                    Toast.LENGTH_LONG).show();
            return interedNumber;
        } else {
            interedNumber = Integer.parseInt(UserNumber.getText().toString());
            return interedNumber;
        }
    }

    ;

    // Method for adding intered number to SummValue and displaying the number
    public void Adding(View view) {

        GrabbingNumber();
        summValue = summValue + interedNumber;
        SharedPreferences.Editor editor = Budget.edit();
        editor.putInt("summValue", summValue);
        editor.commit();
        display(summValue);


    }

    // Method for substruction intered number to SummValue and displaying the number
    public void Substraction(View view) {
        GrabbingNumber();
        summValue = summValue - interedNumber;
        SharedPreferences.Editor editor = Budget.edit();
        editor.putInt("summValue", summValue);
        editor.commit();
        display(summValue);
    }
}

