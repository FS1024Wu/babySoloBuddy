package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class retrievePage extends AppCompatActivity {
    private Button button;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_retrieve);
        button = (Button) findViewById(R.id.buttonSignUp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openToLogin();
            }
        });
        text = (TextView)findViewById(R.id.lnkLogin);
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
}
