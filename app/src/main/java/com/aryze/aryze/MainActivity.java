package com.aryze.aryze;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLogIn;
    TextView tvForUser, tvForPass, tvSignUp;
    EditText etUser, etPass;
    ImageView showPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUser = findViewById(R.id.etUserName);
        etPass = findViewById(R.id.etPass);


        btnLogIn = findViewById(R.id.btnLogIn);
        btnLogIn.setOnClickListener(this);
        tvForPass = findViewById(R.id.tvForgotPass);
        tvForPass.setOnClickListener(this);
        tvForUser = findViewById(R.id.tvForgotUser);
        tvForUser.setOnClickListener(this);
        tvSignUp = findViewById(R.id.tvSignUp);
        tvSignUp.setOnClickListener(this);

        showPass = findViewById(R.id.iv_Show_Pass);
        showPass.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvForgotPass:
                Toast.makeText(MainActivity.this, "Forgot Password Event", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tvForgotUser:
                Toast.makeText(MainActivity.this, "Forgot User Name Event", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tvSignUp:
                Intent i = new Intent(getApplicationContext(),SignUp.class);
                startActivity(i);
                break;
            case R.id.btnLogIn:
                String user = etUser.getText().toString();
                String pass = etPass.getText().toString();

                if(ValidateCredentials(user, pass)){
                    Toast.makeText(MainActivity.this, "Credentials Validated", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "USERNAME = " + user + " PASSWORD = " + pass, Toast.LENGTH_LONG).show();
                    etUser.setText("");
                    etPass.setText("");

                    Intent intent = new Intent(MainActivity.this, AryzeHome.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, "Invalid Credentials, Try again", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.iv_Show_Pass:
                etPass.setTransformationMethod(null);
                break;

            default:
                break;
        }
    }


    private boolean ValidateCredentials(String user, String pass) {

        boolean validated = false;
        String[] userNames = {"eLale111", "fLale222"};
        String[] passwords = {"FastEddie", "SlowFletcher"};

        for (int i = 0; i < userNames.length; i++){
            if(userNames[i].equals(user)){
                if(passwords[i].equals(pass))
                    validated = true;
            }
        }

        return validated;
    }



}