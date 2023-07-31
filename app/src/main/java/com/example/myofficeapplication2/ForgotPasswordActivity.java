package com.example.myofficeapplication2;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ForgotPasswordActivity extends AppCompatActivity {


    private Button buttonPwdReset;
    private EditText editTextPwdResetEmail;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        editTextPwdResetEmail = findViewById(R.id.editText_password_reset_email);
        buttonPwdReset = findViewById(R.id.button_password_reset);

        buttonPwdReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextPwdResetEmail.getText().toString().trim();

                if (!email.isEmpty()) {
                    resetPassword(email);
                } else {
                    Toast.makeText(ForgotPasswordActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void resetPassword(String email) {
        new ResetPasswordTask().execute(email);
    }

    private class ResetPasswordTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            String email = params[0];
            String response = "";

            try {
                URL url = new URL("localhost/userapi/forgotpassword.php.txt");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
                conn.setDoInput(true);

                JSONObject jsonParam = new JSONObject();
                jsonParam.put("email", email);

                OutputStream os = conn.getOutputStream();
                os.write(jsonParam.toString().getBytes("UTF-8"));
                os.close();

                int responseCode = conn.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    String line;
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    while ((line = br.readLine()) != null) {
                        response += line;
                    }
                } else {
                    response = "";
                }

                conn.disconnect();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }

            return response;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            Log.d(TAG, "Response: " + result);

            if (result.equals("success")) {
                Toast.makeText(ForgotPasswordActivity.this, "Password reset successful. Check your email.", Toast.LENGTH_SHORT).show();
            } else if (result.equals("error")) {
                Toast.makeText(ForgotPasswordActivity.this, "Email not found. Please try again.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(ForgotPasswordActivity.this, "An error occurred. Please try again.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}





