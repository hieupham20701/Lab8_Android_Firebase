package com.example.lab8;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignedIn extends AppCompatActivity {
    private FirebaseAuth auth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_signed_in);
        FirebaseUser user = auth.getCurrentUser();
        Log.d("MSG", "onCreate: " + user.getDisplayName());

        Button btnLogout = (Button) findViewById(R.id.btnLogOut);
        TextView txtName = (TextView) findViewById(R.id.txtDisplayName);
        if(user.getDisplayName() != null) {
            txtName.setText(user.getDisplayName());
        }

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                openWelcome();
            }
        });
    }
    public void openWelcome(){
        Intent intent =new Intent(this, Welcome.class);
        startActivity(intent);
    }

}
