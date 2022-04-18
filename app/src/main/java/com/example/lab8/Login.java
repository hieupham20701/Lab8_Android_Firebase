package com.example.lab8;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        TextView txtRegister = (TextView) findViewById(R.id.txt_register);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_sign_in);
    }

    private void openRegister(){

    }




}
