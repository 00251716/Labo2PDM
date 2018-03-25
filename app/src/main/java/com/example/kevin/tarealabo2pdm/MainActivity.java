package com.example.kevin.tarealabo2pdm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button player1b, player2b, reset;

    private Integer score1, score2;

    private TextView count1, count2, d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score1 = 0;
        score2 = 0;
        reset = findViewById(R.id.reset);
        count1 = findViewById(R.id.player1C);
        count2 = findViewById(R.id.player2C);
        d = findViewById(R.id.deuce);
        player1b = findViewById(R.id.player1B);
        player2b = findViewById(R.id.player2B);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score1 = 0;
                score2 = 0;
                count1.setText(String.valueOf(score1));
                count2.setText(String.valueOf(score2));
                d.setText("");
                player1b.setEnabled(true);
                player2b.setEnabled(true);
            }
        });

        player1b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score1 = Integer.parseInt(count1.getText().toString());

                if (score1 == 0) score1 = 15;
                else if (score1 == 15) score1 = 30;
                else if (score1 == 30) {
                    if(score2==40) d.setText("Deuce");
                    score1=40;
                }
                else if (score1 == 40) {
                    if (score2 < 40) {
                        score1 = 45;
                        d.setText("Player 1 has won the game");
                        player1b.setEnabled(false);
                        player2b.setEnabled(false);
                    } else if(score2==40) score1=45;
                    else if(score2 ==45) score1=45;
                } else if(score1 == 45) {
                    score1 = 50;
                    d.setText("Player 1 has won the game");
                    player1b.setEnabled(false);
                    player2b.setEnabled(false);
                }

                count1.setText(String.valueOf(score1));
            }
        });

        player2b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score2 = Integer.parseInt(count2.getText().toString());

                if (score2 == 0) score2 = 15;
                else if (score2 == 15) score2 = 30;
                else if (score2 == 30) {
                    if(score1 == 40) d.setText("Deuce");
                    score2=40;
                }
                else if (score2 == 40) {
                    if (score1 < 40) {
                        score2 = 45;
                        d.setText("Player 2 has won the game");
                        player1b.setEnabled(false);
                        player2b.setEnabled(false);
                    } else if (score1 == 40) score2 = 45;
                    else if(score1 == 45) score2 = 45;
                } else if(score2==45){
                    score2=50;
                    d.setText("Player 2 has won the game");
                    player2b.setEnabled(false);
                    player1b.setEnabled(false);
                }

                count2.setText(String.valueOf(score2));
            }
        });


    }
}

