package com.example.hospital;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import static com.example.hospital.FirebaseDatabase.getInstance;

public class DeleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
    }
    holder.buttondel.setOnClickListener(new View.OnClickListener() {
        @Override
                public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(holder.apoID.getContext());
            builder.setNeutralButton("Delete", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    getInstance().getReference().child("Appointment")
                            .child(getRef(position),
                                    getKey()).removeValue();
                }
            })
        }
    }
}