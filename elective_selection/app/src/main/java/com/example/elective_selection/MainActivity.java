package com.example.elective_selection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText name,roll;
    TextView res;
    Spinner dept,disc;
    Button submit,reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.nameBox);
        roll=findViewById(R.id.rollBox);
        dept=findViewById(R.id.deptSpinner);
        disc=findViewById(R.id.discSpinner);
        submit=findViewById(R.id.submitBtn);
        reset=findViewById(R.id.resetBtn);
        res=findViewById(R.id.result);

        ArrayAdapter deptAdap =ArrayAdapter.createFromResource(this,R.array.dept_options, android.R.layout.simple_spinner_item);
        deptAdap.setDropDownViewResource(android.R.layout.select_dialog_item);
        dept.setAdapter(deptAdap);

        ArrayAdapter discAdap =ArrayAdapter.createFromResource(this,R.array.disc_options, android.R.layout.simple_spinner_item);
        discAdap.setDropDownViewResource(android.R.layout.select_dialog_item);
        disc.setAdapter(discAdap);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = name.getText().toString();
                String r = roll.getText().toString();
                String de = dept.getSelectedItem().toString();
                String di = disc.getSelectedItem().toString();

                res.setText("Name : "+n+"\nRoll no : "+r+"\nDepartment : "+de+"\nDiscipline : "+di);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               name.getText().clear();
               roll.getText().clear();
               dept.setSelection(0);
               disc.setSelection(0);
               res.setText("");
            }
        });
    }
}