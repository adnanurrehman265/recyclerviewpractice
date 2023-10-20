package com.example.recyclerviewpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.recyclerviewpractice.MainActivity;
import com.example.recyclerviewpractice.R;

public class splash extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash);

            // Create a delay using a Thread or Handler
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Start the main activity
                    Intent intent = new Intent(splash.this, MainActivity.class);
                    startActivity(intent);
                    finish(); // Finish the splash activity to prevent going back to it
                }
            }, 2000); // Delay for 2 seconds (adjust as needed)

        }
    }
