package com.example.android.challengems;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int scoreP1 = 0;
    int scoreP2 = 0;

    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //upload the previously saved score
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        scoreP1 = settings.getInt("scoreSavedP1", 0);
        scoreP2 = settings.getInt("scoreSavedP2", 0);

        displayScoreP1(scoreP1);
        displayScoreP2(scoreP2);
    }

    public void seeMovieP1(View view) {
        scoreP1 = scoreP1 + 1;
        displayScoreP1(scoreP1);
    }

    public void seeShortSeassonP1(View view) {
        scoreP1 = scoreP1 + 2;
        displayScoreP1(scoreP1);
    }

    public void seeLongSeassonP1(View view) {
        scoreP1 = scoreP1 + 4;
        displayScoreP1(scoreP1);
    }

    public void seeMovieP2(View view) {
        scoreP2 = scoreP2 + 1;
        displayScoreP2(scoreP2);
    }

    public void seeShortSeassonP2(View view) {
        scoreP2 = scoreP2 + 2;
        displayScoreP2(scoreP2);
    }

    public void seeLongSeassonP2(View view) {
        scoreP2 = scoreP2 + 4;
        displayScoreP2(scoreP2);
    }

    private void displayScoreP1(int scoreP1) {
        TextView scoreTextView = (TextView) findViewById(R.id.score1_text_view);
        scoreTextView.setText(String.valueOf(scoreP1));
    }

    private void displayScoreP2(int scoreP2) {
        TextView scoreTextView = (TextView) findViewById(R.id.score2_text_view);
        scoreTextView.setText(String.valueOf(scoreP2));
    }

    public void resetScore(View view) {
        scoreP1 = 0;
        scoreP2 = 0;
        displayScoreP1(scoreP1);
        displayScoreP2(scoreP2);
    }

    public void saveScore(View view) {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("scoreSavedP1", scoreP1);
        editor.putInt("scoreSavedP2", scoreP2);
        editor.commit();

        Toast toast = Toast.makeText(getApplicationContext(), R.string.toast_text, Toast.LENGTH_SHORT);
        toast.show();
    }
}
