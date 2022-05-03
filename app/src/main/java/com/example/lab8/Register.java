package com.example.lab8;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.core.Tag;

public class Register extends AppCompatActivity {

    private FirebaseAuth auth;
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        context = this;
        auth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_register);

        Button btnRegister = (Button) findViewById(R.id.btn_registerIn);
        EditText txtName = (EditText) findViewById(R.id.edt_yourName);
        EditText txtEmail =(EditText) findViewById(R.id.edt_Email);
        EditText txtPassword = (EditText) findViewById(R.id.edt_password);
        EditText txtConfirmPass =(EditText) findViewById(R.id.edt_confirmPass);
        TextView txtSignIn = (TextView) findViewById(R.id.txtSignin);



        txtSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("msg", "onClick: " + txtEmail.getText().toString() + txtPassword.getText().toString());
                register(txtEmail.getText().toString(), txtPassword.getText().toString(), txtName.getText().toString());
            }

        });
    }

    private void openLogin(){
        Intent intent = new Intent(context, Login.class);
        startActivity(intent);
    }

    private void register(String email, String password, String name){
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.d("Register", "createUserWithEmail:success");
                    FirebaseUser user = auth.getCurrentUser();
                    UserProfileChangeRequest request = new UserProfileChangeRequest.Builder().setDisplayName(name).build();
                    user.updateProfile(request).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(user.getUid() != null){
                                openLogin();
                                Log.d("msg","onComplete: "+user.getDisplayName());
                            }
                        }
                    });
                }else{
                    Log.w("Register", "createUserWithEmail:failure", task.getException());
                }
            }
        });
    }


}
