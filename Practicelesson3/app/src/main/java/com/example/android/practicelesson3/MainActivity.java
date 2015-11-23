package com.example.android.practicelesson3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        TextView textView = new TextView(this);
        textView.setText("Ублюдок, мать твою!");
        textView.setTextSize(55);
        textView.setTextColor(Color.BLACK);;
        setContentView(textView);
    }

}
