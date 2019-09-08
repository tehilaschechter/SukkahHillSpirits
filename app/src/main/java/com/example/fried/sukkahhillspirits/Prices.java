package com.example.fried.sukkahhillspirits;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Prices extends AppCompatActivity {
    double etrogPrice = 21.99;
    double besamimPrice = 23.99;
    double caliPrice = 24.99;
    double bulkDiscount1 = .9;
    double bulkDiscount2 = .85;
    double bulkDiscount3 = .8;
    double cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prices);

        final RadioButton etrog = (RadioButton)findViewById(R.id.radEtrog);
        final RadioButton besamim = (RadioButton)findViewById(R.id.radBesamim);
        final RadioButton cali = (RadioButton)findViewById(R.id.radCali);
        final Spinner amount = (Spinner)findViewById(R.id.txtAmount);
        Button calculate = (Button)findViewById(R.id.btnCalc);
        calculate.setOnClickListener(new View.OnClickListener() {
            final TextView result = (TextView)findViewById(R.id.txtPrice);
            @Override
            public void onClick(View view) {

                DecimalFormat currency = new DecimalFormat("$###,###.##");

                if(etrog.isChecked()){
                    if(amount.getSelectedItem().toString().equals("0-10")){
                        cost = etrogPrice;
                    }
                    else if(amount.getSelectedItem().toString().equals("10-50")){
                        cost = etrogPrice * bulkDiscount1;
                    }
                    else if(amount.getSelectedItem().toString().equals("50-100")){
                        cost = etrogPrice * bulkDiscount2;
                    }
                    else if(amount.getSelectedItem().toString().equals("100+")){
                        cost = etrogPrice * bulkDiscount3;
                    }
                }
                else if(besamim.isChecked()){
                    if(amount.getSelectedItem().toString().equals("0-12")){
                        cost = besamimPrice;
                    }
                    else if(amount.getSelectedItem().toString().equals("10-50")){
                        cost = besamimPrice * bulkDiscount1;
                    }
                    else if(amount.getSelectedItem().toString().equals("50-100")){
                        cost = besamimPrice * bulkDiscount2;
                    }
                    else if(amount.getSelectedItem().toString().equals("100+")){
                        cost = besamimPrice * bulkDiscount3;
                    }
                }
                else{
                    if(amount.getSelectedItem().toString().equals("0-10")){
                        cost = caliPrice;
                    }
                    else if(amount.getSelectedItem().toString().equals("10-50")){
                        cost = caliPrice * bulkDiscount1;
                    }
                    else if(amount.getSelectedItem().toString().equals("50-100")){
                        cost = caliPrice * bulkDiscount2;
                    }
                    else if(amount.getSelectedItem().toString().equals("100+")){
                        cost = caliPrice * bulkDiscount3;
                    }
                }

                result.setText("Price: " + currency.format(cost) + " each");
            }
        });
    }
}
