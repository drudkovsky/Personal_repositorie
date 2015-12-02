package com.example.android.budget;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int summValue;
    int interedNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Method for displaying the number
    private void display(int number) {
        TextView summaryId = (TextView) findViewById(R.id.Sunnury_id);
        summaryId.setText(number + "РУБ");
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
        display(summValue);
        ImageView pic = (ImageView) findViewById(R.id.Pic_id);
        if (summValue >= 20000) {
            pic.setImageResource(R.drawable.alotmoney);
        }
        if ((summValue >= 10000) & (summValue < 20000)) {
            pic.setImageResource(R.drawable.money);
        }
        if (summValue >= 5000 & summValue < 10000) {
            pic.setImageResource(R.drawable.somemoney);
        }
        if (summValue >= 3000 & summValue < 5000) {
            pic.setImageResource(R.drawable.littlemoney);

        }
        if (summValue < 3000) {
            pic.setImageResource(R.drawable.nomoney);
        }
    }

    // Method for substruction intered number to SummValue and displaying the number
    public void Substraction(View view) {
        GrabbingNumber();
        summValue = summValue - interedNumber;
        display(summValue);
        ImageView pic = (ImageView) findViewById(R.id.Pic_id);
        if (summValue >= 20000) {
            pic.setImageResource(R.drawable.alotmoney);
        }
        if ((summValue >= 10000) & (summValue < 20000)) {
            pic.setImageResource(R.drawable.money);
        }
        if (summValue >= 5000 & summValue < 10000) {
            pic.setImageResource(R.drawable.somemoney);
        }
        if (summValue >= 3000 & summValue < 5000) {
            pic.setImageResource(R.drawable.littlemoney);

        }
        if (summValue < 3000) {
            pic.setImageResource(R.drawable.nomoney);
        }
    }
}

