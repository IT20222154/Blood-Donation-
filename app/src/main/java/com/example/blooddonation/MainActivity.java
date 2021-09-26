package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.home_btn1);
        button2 = (Button) findViewById(R.id.home_btn2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEventManagement();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHospitalManagement();
            }
        });
    }

    public void openEventManagement(){
        Intent intent =  new Intent(this,EventManagement.class);
        startActivity(intent);
    }

    public void openHospitalManagement(){
        Intent intent =  new Intent(this,HospitalManagement.class);
        startActivity(intent);
    }
}