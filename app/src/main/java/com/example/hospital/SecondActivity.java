package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    private Button but1;
    private Button but2;
    private Button but3;

//Home page
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button but1=(Button)findViewById(R.id.button4);
        Button but2=(Button)findViewById(R.id.button5);
        Button but3=(Button)findViewById(R.id.button3);
        but1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent int1=new Intent(SecondActivity.this,FourthActivity.class);
                startActivity(int1);
            }
        });
        but2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent int2=new Intent(SecondActivity.this,DeleteActivity.class);
                startActivity(int2);
            }
        });
        but3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent int3=new Intent(SecondActivity.this,ViewActivity.class);
                startActivity(int3);
            }
        });
    }


}
