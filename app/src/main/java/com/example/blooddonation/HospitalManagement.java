package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HospitalManagement extends AppCompatActivity {
    private Button button1;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_management);

        button1 = (Button) findViewById(R.id.hospital_btn1);
        button2 = (Button) findViewById(R.id.hospital_btn2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegistration();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHospitalDetails();
            }
        });
    }

    public void openRegistration(){
        Intent intent =  new Intent(this,HospitalRegistration.class);
        startActivity(intent);
    }

    public void openHospitalDetails(){
        Intent intent =  new Intent(this,HospitalDetails.class);
        startActivity(intent);
    }
}