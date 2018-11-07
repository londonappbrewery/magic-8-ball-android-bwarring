package com.londonappbrewery.magiceightball;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        EditText etQuestion = findViewById(R.id.questionEditText);
        Editable question = etQuestion.getText();
        String questionStr = question.toString();

        // hide soft keyboard on leaving question edit text field
        https://stackoverflow.com/questions/1109022/close-hide-the-android-soft-keyboard
        */
        EditText etQuestion = findViewById(R.id.questionEditText);
        etQuestion.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        });

        // get "ask button"
        Button askButton = findViewById(R.id.askButton);

        // answer image view
        final ImageView ivAnswerBall = findViewById(R.id.image_eightBall);

        // answer array
        final int ballArray[] = {R.drawable.ball1,
                R.drawable.ball2,
                R.drawable.ball3,
                R.drawable.ball4,
                R.drawable.ball5
        };

        //


        // set button listener
        askButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("8Ball", "The ask button has been pressed!");

                Random randomNumberGenerator = new Random();

                // generate random number between 0 and 4, inclusive
                ivAnswerBall.setImageResource(ballArray[randomNumberGenerator.nextInt(4)]);
            }
        });
    }
/*
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }

        if (view.getWindowToken() == null){
            imm.hideSoftInputFromWindow(view.getRootView().getWindowToken(), 0);
        }else {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
*/
}
