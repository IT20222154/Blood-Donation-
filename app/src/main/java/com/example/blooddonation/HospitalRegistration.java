package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class HospitalRegistration extends AppCompatActivity {

    EditText hName,hLocation,hemail,hcontactNo,hId;
    Button button;
    DatabaseReference dbRef;
    Hospital hos;

    private void clearControls(){
        hId.setText("");
        hName.setText("");
        hLocation.setText("");
        hemail.setText("");

        hcontactNo.setText("");
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_registration);

        hId = findViewById(R.id.et_hosreg_id);
        hName = findViewById(R.id.et_hosreg_name);
        hLocation = findViewById(R.id.et_hosreg_location);
        hemail = findViewById(R.id.et_hosreg_email);
        hcontactNo = findViewById(R.id.et_hosreg_contact);
        button = findViewById(R.id.button);

        hos = new Hospital();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               dbRef = FirebaseDatabase.getInstance().getReference().child("Hospitals");
               try{
                   if(TextUtils.isEmpty(hName.getText().toString()))
                       Toast.makeText(getApplicationContext(),"Please enter a name",Toast.LENGTH_SHORT).show();
                   else if(TextUtils.isEmpty(hLocation.getText().toString()))
                       Toast.makeText(getApplicationContext(),"Please enter location",Toast.LENGTH_SHORT).show();
                   else if(TextUtils.isEmpty(hemail.getText().toString()))
                       Toast.makeText(getApplicationContext(),"Please enter email",Toast.LENGTH_SHORT).show();
                   else if(TextUtils.isEmpty(hcontactNo.getText().toString()))
                       Toast.makeText(getApplicationContext(),"Please enter a contact number",Toast.LENGTH_SHORT).show();
                   else if(TextUtils.isEmpty(hId.getText().toString()))
                       Toast.makeText(getApplicationContext(),"Please enter a id",Toast.LENGTH_SHORT).show();
                   else{
                       hos.setHosId(hId.getText().toString().trim());
                       hos.setHosName(hName.getText().toString().trim());
                       hos.setHosLocation(hLocation.getText().toString().trim());
                       hos.setHosemail(hemail.getText().toString().trim());
                       hos.setHosContactNo(hcontactNo.getText().toString().trim());

                       dbRef.push().setValue(hos);
                       Toast.makeText(getApplicationContext(),"Data saved Successfull",Toast.LENGTH_SHORT).show();
                       clearControls();
                   }
               } catch (NumberFormatException e){
                      Toast.makeText(getApplicationContext(),"Inavlid Contact Number",Toast.LENGTH_SHORT).show();
               }
            }
        });

    }
}