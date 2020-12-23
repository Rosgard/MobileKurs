package com.example.kurs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;

public class OrderForm extends AppCompatActivity {
private Button btnInf;
private Button buttonOrder;
private CheckBox chRmClean;
private CheckBox chGenRmClean;
private CheckBox chTrClean;
private CheckBox chFixClean;
private CheckBox chBrnClean;
private CheckBox chSpcClean;
private CheckBox chOtherKindClean;
private TextView tApxSum;
private EditText name;
private EditText address;
private EditText phnumber;
private EditText date;
private EditText number;
private final static String FILE_NAME = "order.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_form);
        ListInf();
    }

    public void ListInf()
    {
        btnInf = (Button)findViewById(R.id.buttonInf);
        btnInf.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(".InfBureau");
                startActivity(intent);
            }
        });
        buttonOrder = (Button)findViewById(R.id.btnOrder);
        buttonOrder.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(
                        OrderForm.this, /*login.getText()*/ "Заказ сохранён",
                        Toast.LENGTH_LONG
                ).show();
                tApxSum = (TextView) findViewById(R.id.ApxSum);
                number = (EditText)findViewById(R.id.editTextNumber);
                name = (EditText) findViewById(R.id.editTextTextPersonName);
                address = (EditText) findViewById(R.id.editTextTextPersonName5);
                phnumber = (EditText) findViewById(R.id.editTextPhone);
                date = (EditText) findViewById(R.id.editTextDate);
                int sum = Integer.parseInt(number.getText().toString());
                int summ = sum * 250;
                chRmClean = (CheckBox) findViewById(R.id.RmClean);
                chGenRmClean = (CheckBox) findViewById(R.id.GenRmClean);
                chTrClean = (CheckBox) findViewById(R.id.TrClean);
                chFixClean = (CheckBox) findViewById(R.id.FixClean);
                chBrnClean = (CheckBox) findViewById(R.id.BrnClean);
                chSpcClean = (CheckBox) findViewById(R.id.SpcClean);
                chOtherKindClean = (CheckBox) findViewById(R.id.OtherKindClean);

                if (chRmClean.isChecked()){
                    summ *= 1.2;

                }
                if (chGenRmClean.isChecked()){
                    summ *= 1.5;
                }
                if (chTrClean.isChecked()){
                    summ *= 1.6;
                }
                if (chFixClean.isChecked()){
                    summ *= 1.7;
                }
                if (chBrnClean.isChecked()){
                    summ *= 2;
                }
                if (chSpcClean.isChecked()){
                    summ *= 3;
                }
                if (chOtherKindClean.isChecked()){
                    summ *= 6;

                }

                tApxSum.setText(summ+"");
                FileOutputStream fos = null;
                try {

                     String a = name.getText().toString();
                     String b = address.getText().toString();
                     String c = phnumber.getText().toString();
                     String d = date.getText().toString();
                     String e = number.getText().toString();
                     String f = tApxSum.getText().toString();

                    fos = openFileOutput(FILE_NAME, MODE_APPEND);
                    fos.write(a.getBytes());
                    fos.write(b.getBytes());
                    fos.write(c.getBytes());
                    fos.write(d.getBytes());
                    fos.write(e.getBytes());
                    fos.write(f.getBytes());
                    Toast.makeText(OrderForm.this, "Файл сохранен", Toast.LENGTH_SHORT).show();
                }
                catch(IOException ex) {

                    Toast.makeText(OrderForm.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                }
                finally{
                    try{
                        if(fos!=null)
                            fos.close();
                    }
                    catch(IOException ex){

                        Toast.makeText(OrderForm.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}