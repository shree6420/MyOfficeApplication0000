package com.example.myofficeapplication2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myofficeapplication2.ModelResponse.LoginResponse;
import com.example.myofficeapplication2.activity.DashboardActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity  {
    EditText Username, Password;
    Button Login;
    TextView registerlink;
    private Context context;

    private EditText editTextUsername;
    private EditText editTextPassword;

    private TextView textViewRegister;

    private Button buttonLogin;
    private TextView txtForgetpass;
    private String username ,password;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        }

        private void init(){
            context = this;
            editTextUsername = findViewById(R.id.editTextUsername);
            editTextPassword = findViewById(R.id.editTextPassword);
            buttonLogin = findViewById(R.id.buttonLogin);
            textViewRegister= findViewById(R.id.textViewRegister);
            txtForgetpass = findViewById(R.id.txtForgotPassword);



            setOnClick();
        }

    private void setOnClick() {

        username = editTextUsername.getText().toString().trim();
        password = editTextPassword.getText().toString().trim();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValid()){
                    //loginuser();
                    startActivity(new Intent(context, DashboardActivity.class));
                }

            }
        });

        textViewRegister.setOnClickListener(v ->{
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);

        });

        txtForgetpass.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
            startActivity(intent);
        });

    }


    public void loginuser(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername(editTextUsername.getText().toString());
        loginRequest.setPassword(editTextPassword.getText().toString());
        loginuser(loginRequest);

        Call<LoginResponse> loginResponseCall = ApiClient.getUserService().userLogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if(response.isSuccessful()){
                    Toast.makeText(LoginActivity.this,"Login Successful", Toast.LENGTH_LONG).show();
                    LoginResponse loginResponse = response.body();
                    if (loginResponse != null){
                        startActivity(new Intent(LoginActivity.this, HomeActivity.class).putExtra("data",loginResponse.getusername()));
                    }

                }else{
                    Toast.makeText(LoginActivity.this,"Login Failed", Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"Throwable "+t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

            }
        });


    }
    private void loginuser(LoginRequest loginRequest){}

    private boolean isValid(){
        if (editTextUsername.getText().toString().trim().isEmpty()){
            Toast.makeText(context, "Please enter your username", Toast.LENGTH_SHORT).show();
            return false;
        }else if (editTextPassword.getText().toString().trim().isEmpty()){
            Toast.makeText(context, "Please enter your password", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


}

