package com.example.kurs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfBureau extends AppCompatActivity {
private Button buttonback;
private Button btnInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inf_bureau);
        ListBack();
        Info();
    }
    public void ListBack()
    {
        buttonback = (Button)findViewById(R.id.buttonBack);
        buttonback.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
    }
    public void Info()
    {
     btnInfo =(Button) findViewById(R.id.buttonInfo);
     btnInfo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent browserIntent = new
                        Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ssa.ru/articles/entry/068187c7a"));
                startActivity(browserIntent);
            }
        });
    }
}