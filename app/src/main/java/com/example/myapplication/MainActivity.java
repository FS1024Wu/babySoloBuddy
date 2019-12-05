package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static int TIME_OUT = 4000;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, loginPage.class);
                startActivity(intent);
            }
        }, TIME_OUT);



    }
//
////        Handler handler = new Handler();
////        handler.postDelayed(new Runnable() {
////            @Override
////            public void run() {
////                Intent intent = new Intent(MainActivity.this, mainPage.class);
////                startActivity(intent);
////                Intent intent1 = new Intent(MainActivity.this, loadingPage.class);
////                startActivity(intent1);
////                finish();
////
////            }
////        },TIME_OUT);
//    }
//    public void openLoadingPage(){
//        Intent intent =  new Intent(this, loadingPage.class);
//        startActivity(intent);
//    }


}