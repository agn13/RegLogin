package com.res.reglogin;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    ArrayList<String> dataUsername = new ArrayList<>();
    ArrayList<String> dataPassword = new ArrayList<>();
    String Incomingusername;
    String Incomingpassword;
    String Username;
    String Password;
    LinearLayout LoginSubmit;
    EditText etUsername;
    EditText etPassword;
    public void CheckValidity(){
        AlertDialog.Builder builder;
        if(Username.isEmpty() || Password.isEmpty()){
            builder=new AlertDialog.Builder(LoginActivity.this);
            builder.setTitle("Login");
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
    public int ProceedFurther(){
        for(int i=0;i<dataUsername.size();i++){
            if(Username.equals(dataUsername.get(i)) && Password.equals(dataPassword.get(i))){
                return 1;
            }
        }
        return -1;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginSubmit=findViewById(R.id.Loginsubmit);
        etUsername=findViewById(R.id.etUsername);
        etPassword=findViewById(R.id.etPassword);
        Intent getIntent=getIntent();
        Incomingusername=getIntent.getStringExtra("Incomingusername");
        Incomingpassword=getIntent.getStringExtra("Incomingpassword");
        dataUsername.add(Incomingusername);
        dataPassword.add(Incomingpassword);
        LoginSubmit.setOnClickListener(v->{
            Username = etUsername.getText().toString().replaceAll("\\s"," ").trim();
            Password = etPassword.getText().toString();
            CheckValidity();
            AlertDialog.Builder builder;
            builder=new AlertDialog.Builder(LoginActivity.this);
            builder.setTitle("Login");
            if(ProceedFurther()==1){
                builder.setMessage("Your credentials match.");
                builder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
            }
            else{
                builder.setMessage("Your credentials don't match.");
                builder.setPositiveButton("Go back to Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });
    }
}