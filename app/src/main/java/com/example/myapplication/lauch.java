package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class lauch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_lauch);

            TextView textView1 = (TextView) findViewById(R.id.beginTrips);
        ImageView imageView1 = (ImageView) findViewById(R.id.beginTrip) ;
            textView1.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {

                    Intent intent;
                    intent = new Intent(lauch.this,scanTagPage.class);
                    startActivity(intent);
                }

            });
        imageView1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent;
                intent = new Intent(lauch.this,scanTagPage.class);
                startActivity(intent);
            }

        });
        }

    public void onClick(View view) {
        Intent intent;
        intent = new Intent(lauch.this,scanTagPage.class);
        startActivity(intent);
    }
}
