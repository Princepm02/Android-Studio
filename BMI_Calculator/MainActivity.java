package com.example.bmi_calulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button calculate;
    TextView result;
    EditText wtVal,htVal;
    Double wt,ht,bmi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculate=findViewById(R.id.cal);
        wtVal=findViewById(R.id.weightBox);
        htVal=findViewById(R.id.heightBox);
        result=findViewById(R.id.res);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wt=Double.parseDouble(wtVal.getText().toString());
                ht=Double.parseDouble(htVal.getText().toString());
                ht=ht/100;
                bmi=((wt)/(ht*ht));
                if (bmi<=18) {
                    result.setText("BMI : " + bmi + "\nUnderweight");
                }
                else if (bmi>18 && bmi<=25) {
                    result.setText("BMI : " + bmi + "\nHealthy");
                }
                else if (bmi>25) {
                    result.setText("BMI : " + bmi + "\nOverweight");
                }
            }
        });
    }
}
