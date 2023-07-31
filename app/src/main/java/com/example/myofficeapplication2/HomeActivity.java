package com.example.myofficeapplication2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    private ApiServiceDS apiServiceDS;
    private Spinner spinnerStates;
    private Spinner spinnerDistricts;
    private List<String> stateList;
    private List<String> districtList;
    private TextView username_home;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        spinnerStates = findViewById(R.id.spinnerStates);
        spinnerDistricts = findViewById(R.id.spinnerDistricts);
        username_home = findViewById(R.id.username_home);

        String editTextUsername = getIntent().getStringExtra("username");
        Log.d("username", "username--" + editTextUsername);
        username_home.setText(editTextUsername);

        // Retrieve states using Retrofit API call
        retrieveStates();

        spinnerStates.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedState = parent.getItemAtPosition(position).toString();
                retrieveDistricts(selectedState);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
    }

    private void retrieveStates() {
        // Replace "YourApiService" with your actual Retrofit API service class
        ApiServiceDS apiServiceDS = RetrofitClientHome.getClient().create(ApiServiceDS.class);

        Call<List<String>> call = apiServiceDS.getStates();
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                if (response.isSuccessful()) {
                    stateList = response.body();

                    // Populate the states dropdown list
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(HomeActivity.this, android.R.layout.simple_spinner_item, stateList);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerStates.setAdapter(adapter);
                } else {
                    Toast.makeText(HomeActivity.this, "Failed to retrieve states", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Toast.makeText(HomeActivity.this, "Error retrieving states: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void retrieveDistricts(String selectedState) {
        // Replace "YourApiService" with your actual Retrofit API service class
        ApiServiceDS apiServiceDS = RetrofitClientHome.getClient().create(ApiServiceDS.class);

        Call<List<String>> call = apiServiceDS.getDistricts(selectedState);
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                if (response.isSuccessful()) {
                    districtList = response.body();

                    // Populate the districts dropdown list
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(HomeActivity.this, android.R.layout.simple_spinner_item, districtList);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerDistricts.setAdapter(adapter);
                } else {
                    Toast.makeText(HomeActivity.this, "Failed to retrieve districts", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Toast.makeText(HomeActivity.this, "Error retrieving districts: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

//    @Override
//    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//
//    }
//}
//
//








