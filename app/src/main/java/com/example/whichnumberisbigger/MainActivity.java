package com.example.whichnumberisbigger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonLeft;
    private Button buttonRight;
    private TextView textViewScore;
    private TextView textViewQuestion;
    private BiggerNumberGame game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        setListeners();
        Toast.makeText(this, "Loading Complete!", Toast.LENGTH_SHORT).show();
        game = new BiggerNumberGame(0, 1000000);
        updateGameDisplay();

    }

    private void updateGameDisplay() {
        game.generateRandomNumbers();
        buttonLeft.setText(String.valueOf(game.getNumber1()));
        buttonRight.setText(String.valueOf(game.getNumber2()));
        textViewScore.setText(String.valueOf(game.getScore()));
        textViewQuestion.setText(String.valueOf(game.getQuestion()));

    }

    private void setListeners() {
        // creating an Anonymous Inner Class that implements View.OnClickListener
        // overriding the one abstract method onClick(View v)
        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, game.checkAnswer(game.getNumber1()),
                        Toast.LENGTH_SHORT).show();
                updateGameDisplay();

            }
        });
        buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, game.checkAnswer(game.getNumber2()),
                        Toast.LENGTH_SHORT).show();
                updateGameDisplay();
            }
        });
    }

    private void wireWidgets() {
        buttonLeft = findViewById(R.id.button_main_left);
        buttonRight = findViewById(R.id.button_main_right);
        textViewQuestion = findViewById(R.id.textView_main_text);
        textViewScore = findViewById(R.id.textView_main_score);
    }
}
