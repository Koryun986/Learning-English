package com.samsung.learningenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.samsung.learningenglish.db.LevelOneDbManager;

import java.util.Queue;

public class BeginnerActivity extends AppCompatActivity {
    private LevelOneDbManager dbManager;
    private String[] letters = {"a", "e","i","o","u"};
    private Queue<String> words;
    private Queue<String> missingLetters;
    TextView word;
    TextView btn1;
    TextView btn2;
    TextView btn3;
    TextView btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginner);
        word = findViewById(R.id.word);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        AddWords addWords = new AddWords();
        addWords.start();
        words = dbManager.readWordsFromDb();
        missingLetters = dbManager.readMissLettersFromDb();
        textViewChanges();
    }

    @Override
    protected void onResume() {
        super.onResume();
        dbManager.openDb();
    }

    private void textViewChanges() {
        word.setText(words.poll());
        String letter = missingLetters.poll();
        double random = Math.random()*4;
        if((int)random == 1) {
            btn1.setText(letter);
            double rl;
            do {
                rl = Math.random() * letters.length;
            } while(letter.equals(letters[(int) rl]));
            btn2.setText(letters[(int) rl]);
            do {
                rl = Math.random()*letters.length;
            } while(letter.equals(letters[(int) rl]) || letter.equals(btn2.getText()));
            btn3.setText(letters[(int) rl]);
            do {
                rl = Math.random()*letters.length;
            } while(letter.equals(letters[(int) rl]) || letter.equals(btn2.getText()) || letter.equals(btn3.getText()));
            btn3.setText(letters[(int) rl]);
        }else if ((int)random == 2) {
            btn2.setText(letter);
            double rl;
            do {
                rl = Math.random() * letters.length;
            } while(letter.equals(letters[(int) rl]));
            btn1.setText(letters[(int) rl]);
            do {
                rl = Math.random()*letters.length;
            } while(letter.equals(letters[(int) rl]) || letter.equals(btn1.getText()));
            btn3.setText(letters[(int) rl]);
            do {
                rl = Math.random()*letters.length;
            } while(letter.equals(letters[(int) rl]) || letter.equals(btn1.getText()) || letter.equals(btn3.getText()));
            btn4.setText(letters[(int) rl]);
        }else if ((int)random == 3) {
            btn3.setText(letter);
            double rl;
            do {
                rl = Math.random() * letters.length;
            } while(letter.equals(letters[(int) rl]));
            btn1.setText(letters[(int) rl]);
            do {
                rl = Math.random()*letters.length;
            } while(letter.equals(letters[(int) rl]) || letter.equals(btn1.getText()));
            btn2.setText(letters[(int) rl]);
            do {
                rl = Math.random()*letters.length;
            } while(letter.equals(letters[(int) rl]) || letter.equals(btn1.getText()) || letter.equals(btn2.getText()));
            btn4.setText(letters[(int) rl]);
        }else {
            btn4.setText(letter);
            double rl;
            do {
                rl = Math.random() * letters.length;
            } while(letter.equals(letters[(int) rl]));
            btn1.setText(letters[(int) rl]);
            do {
                rl = Math.random()*letters.length;
            } while(letter.equals(letters[(int) rl]) || letter.equals(btn1.getText()));
            btn2.setText(letters[(int) rl]);
            do {
                rl = Math.random()*letters.length;
            } while(letter.equals(letters[(int) rl]) || letter.equals(btn1.getText()) || letter.equals(btn2.getText()));
            btn3.setText(letters[(int) rl]);
        }
    }

    class AddWords extends Thread {
        @Override
        public void run() {
            super.run();
            dbManager.insertToDb("Fl wer", "o");
            dbManager.insertToDb("W ter", "a");
            dbManager.insertToDb("N me", "a");
            dbManager.insertToDb("Mo th", "u");
        }
    }
}