package com.example.hospital;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.text.TextUtils;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class FourthActivity extends AppCompatActivity {

    EditText donorsId,donorsName,PatientId,PatientName,Hospital,Bloodtype,date;
    Button button;
    ManageAppointment ma;


    private void clearControls(){
        donorsId.setText("");
        donorsName.setText("");
        PatientId.setText("");
        PatientName.setText("");
        Hospital.setText("");
        Bloodtype.setText("");
    }
//appointment confirmation
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        donorsId = findViewById(R.id.et_am_donorsId);
        donorsName = findViewById(R.id.et_am_donorsName);
        PatientId = findViewById(R.id.et_am_donorsId);
        PatientName = findViewById(R.id.et_am_patientName);
        Hospital = findViewById(R.id.et_am_hospital);
        Bloodtype = findViewById(R.id.et_am_btype);


        ma = new ManageAppointment();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try{
                    if(TextUtils.isEmpty(donorsId.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter an Donor's ID",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(donorsName.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter a Donor's Name",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(PatientId.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter Patient ID",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(PatientName.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter Patient Name",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(Hospital.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter Hospital",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(Bloodtype.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please enter email",Toast.LENGTH_SHORT).show();
                    else{
                        ma.setDonorsId(donorsId.getText().toString().trim());
                        ma.setDonorsName(donorsName.getText().toString().trim());
                        ma.setPatientId(PatientId.getText().toString().trim());
                        ma.setPatientName(PatientName.getText().toString().trim());
                        ma.setBloodType(Bloodtype.getText().toString().trim());
                        ma.setHospital(Hospital.getText().toString().trim());


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