package com.example.wangf.numberguessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int num1;
    private int num2;
    private int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberPicker();
    }

    public void numberPicker() {
        num1 = 0;
        num2 = 0;
        Random rand = new Random();
        while (num1 == num2) {
            num1 = rand.nextInt(100);
            num2 = rand.nextInt(100);
        }
        Button lButton = (Button) findViewById(R.id.leftButton);
        Button rButton = (Button) findViewById(R.id.rightButton);
        lButton.setText(String.valueOf(num1));
        rButton.setText(String.valueOf(num2));
    }

    public void leftButtonClick(View view) {
        TextView pointsView = (TextView) findViewById(R.id.points);
        if (num1 > num2) {
            points++;
            if (points == 5) {
                Toast.makeText(this, "Congratulations! You are admitted!", Toast.LENGTH_SHORT).show();
                points = 0;
                pointsView.setText(String.valueOf(points));
                numberPicker();
                return;
            }
            Toast.makeText(this, "Great Job!", Toast.LENGTH_SHORT).show();
            pointsView.setText(String.valueOf(points));
        } else {
            points--;
            Toast.makeText(this, "You Are Idiot!", Toast.LENGTH_SHORT).show();
            pointsView.setText(String.valueOf(points));
        }
        numberPicker();
    }

    public void rightButtonClick(View view) {
        TextView pointsView = (TextView) findViewById(R.id.points);
        if (num1 < num2) {
            points++;
            if (points == 5) {
                Toast.makeText(this, "Congratulations! You are admitted!", Toast.LENGTH_SHORT).show();
                points = 0;
                pointsView.setText(String.valueOf(points));
                numberPicker();
                return;
            }
            Toast.makeText(this, "Great Job!", Toast.LENGTH_SHORT).show();
            pointsView.setText(String.valueOf(points));
        } else {
            points--;
            Toast.makeText(this, "You Are Idiot!", Toast.LENGTH_SHORT).show();
            pointsView.setText(String.valueOf(points));
        }
        numberPicker();
    }
}
