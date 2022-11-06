package com.vitor.btcwallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView splash_image;
    private Button new_wallet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();

        getSupportActionBar().hide();

        splashScreen();

        new_wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, GenerateNewWallet.class);
                startActivity(myIntent);
            }
        });
    }

    private void initializeComponents(){
        splash_image=findViewById(R.id.splash_image);
        new_wallet=findViewById(R.id.new_wallet);
    }

    private void  splashScreen(){
        splash_image.postDelayed(new Runnable() {
            @Override
            public void run() {
                splash_image.setImageAlpha(0);
            }
        }, 2000);
    }

}