package com.res.reglogin;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LinearLayout Submit;
    EditText etUsername;
    EditText etPassword;
    String Username;
    String Password;
    Intent ToLogin;

    public void CheckValidity(){
        AlertDialog.Builder builder;
        if(Username.isEmpty() || Password.isEmpty()){
            builder=new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Register");
            builder.setMessage("One or More fields are left blank?");
            builder.setNegativeButton("Go Back", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            AlertDialog dialog=builder.create();
            dialog.show();
        }
        else{
            ProceedFurther();
        }
    }
    public void ProceedFurther(){
            AlertDialog.Builder builder;
            builder=new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Register");
            builder.setMessage("Your Username is "+Username+"\n Are you sure you want to proceed further?");
            builder.setPositiveButton("Register", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ToLogin=new Intent(MainActivity.this, LoginActivity.class);
                    ToLogin.putExtra("Incomingusername",Username);
                    ToLogin.putExtra("Incomingpassword",Password);
                    startActivity(ToLogin);
                }
            });
            AlertDialog dialog=builder.create();
            dialog.show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Submit=findViewById(R.id.Submit);
        etUsername=findViewById(R.id.etUsername);
        etPassword=findViewById(R.id.etPassword);
        Submit.setOnClickListener(v->{
            Username = etUsername.getText().toString().replaceAll("\\s"," ").trim();
            Password = etPassword.getText().toString();
            CheckValidity();
        });

    }
}