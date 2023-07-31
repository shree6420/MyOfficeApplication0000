package com.example.myofficeapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myofficeapplication2.ModelResponse.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity  {




    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPassword;

    private Button buttonRegister;
    private TextView loginlink;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonRegister = (Button) findViewById(R.id. buttonRegister);
        loginlink = (TextView) findViewById(R.id.loginlink);







        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(editTextEmail.getText().toString()) || TextUtils.isEmpty(editTextName.getText().toString()) || TextUtils.isEmpty(editTextPassword.getText().toString())) {

                    String message = "All Input Required...";
                    Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
                } else {
                    RegisterRequest registerRequest = new RegisterRequest();
                    registerRequest.setUsername(editTextName.getText().toString());
                    registerRequest.setEmail(editTextEmail.getText().toString());
                    registerRequest.setPassword(editTextPassword.getText().toString());
                    registerUser(registerRequest);


                    Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
                    intent.putExtra(" editTextName", (CharSequence) editTextName);
                    intent.putExtra("editTextEmail", (CharSequence) editTextEmail);
                    intent.putExtra(" editTextPassword", (CharSequence) editTextPassword);


                    startActivity(intent);

                }
            }


            private void registerUser(RegisterRequest registerRequest) {
                Call<RegisterResponse> registerResponseCall = ApiClient.getUserService().registerusers(registerRequest);
                registerResponseCall.enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                        if (response.isSuccessful()) {

                            String message = "Registration Successful...";
                            Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                            finish();
                        } else {
                            String message = "An error occurred please try again Later....";
                            Toast.makeText(RegisterActivity.this, message, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {

                    }
                });
            }
        });
    }
}
























