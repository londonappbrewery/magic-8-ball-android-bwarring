package com.londonappbrewery.magiceightball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get "ask button"
        Button askButton = findViewById(R.id.askButton);

        // answer image view
        final ImageView answerBall = findViewById(R.id.answerImage);

        // answer array
        final int ballArray[] = {R.drawable.ball1,
                R.drawable.ball2,
                R.drawable.ball3,
                R.drawable.ball4,
                R.drawable.ball5
        };

        // set button listener
        askButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("8Ball", "The ask button has been pressed!");

                Random randomNumberGenerator = new Random();

                // generate random number between 0 and 4, inclusive
                answerBall.setImageResource(ballArray[randomNumberGenerator.nextInt(4)]);
            }
        });
    }
}
