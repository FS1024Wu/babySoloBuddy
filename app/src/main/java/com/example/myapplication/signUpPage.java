package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class signUpPage extends AppCompatActivity {
    private Button button;
    private TextView text;
    EditText un;
    EditText psw;
    EditText pswc;
    EditText pn;
    EditText eml;
    FirebaseDatabase  db;
    DatabaseReference dbr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_signup);
        db = FirebaseDatabase.getInstance();
        dbr = db.getReference("users");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("Hello, World!");

        un = (EditText) findViewById(R.id.txtName);
        psw= (EditText)findViewById(R.id.txtPwd);
        pswc= (EditText)findViewById(R.id.txtPwd2);
        pn= (EditText)findViewById(R.id.phoneNum);
        eml= (EditText)findViewById(R.id.txtEmail);

        button = (Button) findViewById(R.id.btnLogin11);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUsers();
                openToLogin();
            }
        });
        text = (TextView)findViewById(R.id.lnkLogin1);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openToLogin();
            }
        });
    }
    public void openToLogin(){
        Intent intent = new Intent(this,loginPage.class);
        startActivity(intent);

    }

    private void addUsers(){
        String username = un.getText().toString().trim();
        String password = psw.getText().toString().trim();
        String passwordConfrim = pswc.getText().toString().trim();
        String phoneNumber = pn.getText().toString().trim();
        String email = eml.getText().toString().trim();
        if((!TextUtils.isEmpty(username))&&(!TextUtils.isEmpty(password))&&(!TextUtils.isEmpty(passwordConfrim))&&(!TextUtils.isEmpty(phoneNumber))&&(!TextUtils.isEmpty(email))){

            if(password.contentEquals(passwordConfrim)){
                String id = dbr.push().getKey();
                users user = new users(id, username, password, phoneNumber, email);
                System.out.println(user+" , "+user.toString());
                dbr.child(id).setValue(user);
                //Toast.makeText(this,user.toString(),Toast.LENGTH_LONG).show();
                Toast.makeText(this,"user record inserted",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"your password does not match",Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this,"input to signup",Toast.LENGTH_LONG).show();
        }

    }
}