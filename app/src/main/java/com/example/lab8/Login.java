package com.example.lab8;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.util.GAuthToken;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {

    private FirebaseAuth auth;
    private Login context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        context = this;
        auth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_sign_in);

        TextView txtRegister = (TextView) findViewById(R.id.txt_register) ;
        EditText edtEmail = (EditText)findViewById(R.id.edt_Email);
        EditText edtPass = (EditText) findViewById(R.id.edt_password);
        Button btnLogin = (Button) findViewById(R.id.btn_sign_in2);

        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegister();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void openRegister(){
        Intent intent = new Intent(context, Register.class);
        startActivity(intent);
    }

    private void openLogin(){
        Intent intent = new Intent(this, SignedIn.class);
        startActivity(intent);
    }
    private void login(String email, String password){
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    FirebaseUser user = auth.getCurrentUser();
                    Log.d("MSG", "onComplete: " + user.getDisplayName());
                    openLogin();
                }else{
                    Log.d("MSG", "onComplete : Faile" );
                }
            }
        });
    }




}
