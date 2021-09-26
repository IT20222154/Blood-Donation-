package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class HospitalDetails extends AppCompatActivity {

    RecyclerView recyclerView;
    HosDetailsAdapter hosDetailsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_details);

        recyclerView = (RecyclerView)findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<ModelHosDetails> options=
                new FirebaseRecyclerOptions.Builder<ModelHosDetails>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Hospitals"),ModelHosDetails.class)
                .build();

        hosDetailsAdapter = new HosDetailsAdapter(options);
        recyclerView.setAdapter(hosDetailsAdapter);

    }


    @Override
    protected void onStart() {
        super.onStart();
        hosDetailsAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        hosDetailsAdapter.startListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.search,menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                txtSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                txtSearch(query);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void txtSearch(String str){

        FirebaseRecyclerOptions<ModelHosDetails> options=
                new FirebaseRecyclerOptions.Builder<ModelHosDetails>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Hospitals")
                                .orderByChild("hosId").startAt(str).endAt(str+"~"),ModelHosDetails.class)
                        .build();

        hosDetailsAdapter = new HosDetailsAdapter(options);
        hosDetailsAdapter.startListening();
        recyclerView.setAdapter(hosDetailsAdapter);
    }
}