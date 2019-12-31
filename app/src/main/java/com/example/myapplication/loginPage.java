package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class loginPage extends AppCompatActivity {
    private static final String TAG = "loginPage";
    private Button button;
    private TextView buttonReg;
    private TextView buttonRet;
    EditText txtEmail;
    EditText txtPwd;
    List<users> usersList;
    DatabaseReference dbr;
     String username;
     String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        button = (Button) findViewById(R.id.btnLogin);
        txtEmail = (EditText)findViewById(R.id.txtEmaill);
        txtPwd = (EditText) findViewById(R.id.txtPwdl);
        username = txtEmail.getText().toString().trim();
        password = txtPwd.getText().toString().trim();
        dbr = FirebaseDatabase.getInstance().getReference("users");
        button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            openMainPage();
        }
        });
        buttonReg = (TextView) findViewById(R.id.lnkRegister);
        buttonReg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openMainPageReg();
            }
        });
        buttonRet = (TextView) findViewById(R.id.lnkRetrieve);
        buttonRet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openMainPageRet();
            }
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        dbr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {

                for(DataSnapshot contactSnapshot: dataSnapshot.getChildren()) {
                    users user = contactSnapshot.getValue(users.class);
                    if(user.getUsersUn().equals(username) && user.getUsersPsw().equals(password)){
                        openMainPage();
                    }
                }

            }
            @Override
            public void onCancelled( DatabaseError databaseError) {

            }
        });
    }
    public void openMainPage(){
        Intent intent =  new Intent(this, lauch.class);
        startActivity(intent);
    }
    public void openMainPageReg(){
        Intent intent =  new Intent(this, signUpPage.class);
        startActivity(intent);
    }
    public void openMainPageRet(){
        Intent intent =  new Intent(this, retrievePage.class);
        startActivity(intent);
    }
}
