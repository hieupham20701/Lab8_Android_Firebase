package com.example.lab8;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Welcome extends AppCompatActivity {
    Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.screen_01);

        Button btnRegister = (Button) findViewById(R.id.btn_register);
        Button btnSignIn = (Button) findViewById(R.id.btn_signin);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegister();
            }
        });
     }
    public void openLogin(){
        Intent intent = new Intent(this.context, Login.class);
        startActivity(intent);
    }

    public void openRegister(){
        Intent intent = new Intent(this.context, Register.class);
        startActivity(intent);
    }
}
