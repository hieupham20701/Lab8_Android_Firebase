package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnSignin =(Button) findViewById(R.id.btn_signin);
    Button btnRegister = (Button) findViewById(R.id.btn_register);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignin();
            }
        });
    }

    private void openSignin(){
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }
}