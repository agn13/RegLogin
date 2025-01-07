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

public class MainActivity extends AppCompatActivity {
    LinearLayout Submit;
    EditText etEmail;
    EditText etPassword;
    String email;
    String password;
    Intent ToLogin;

    public void CheckValidity(){
        AlertDialog.Builder builder;
        if(email.isEmpty() || password.isEmpty()){
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
            builder.setMessage("Your email is "+email+"\n Are you sure you want to proceed further?");
            builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
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
        etEmail=findViewById(R.id.etEmail);
        etPassword=findViewById(R.id.etPassword);
        Submit.setOnClickListener(v->{
            email = etEmail.getText().toString().trim();
            password = etPassword.getText().toString().trim();
            CheckValidity();
        });

    }
}