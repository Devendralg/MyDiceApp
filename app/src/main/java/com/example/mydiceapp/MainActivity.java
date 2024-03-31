package com.example.mydiceapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView dice1 = findViewById(R.id.imgDice1);
        ImageView dic2 = findViewById(R.id.imgDice2);

        int [] diceImages = {R.drawable.dice_one,R.drawable.dice_two,R.drawable.three,R.drawable.four,
        R.drawable.five,R.drawable.six};

        Button btnRoll = findViewById(R.id.btnRollDice);
        MediaPlayer mp = MediaPlayer.create(this,R.raw.dice_music);
        btnRoll.setOnClickListener(view -> {
            Log.i("myDice","Button is tapped now!");
            Random rndObj = new Random();
            int myRandomNumber = rndObj.nextInt(5); // 0...6
            Log.i("myDice","Generated Random Number is " + myRandomNumber);
            mp.start();

            dice1.setImageResource(diceImages[myRandomNumber]);
            myRandomNumber =rndObj.nextInt(5);
            dic2.setImageResource(diceImages[myRandomNumber]);

            YoYo.with(Techniques.Shake)
                    .duration(500)
                    .repeat(0)
                    .playOn(dice1);
            YoYo.with(Techniques.Shake)
                    .duration(500)
                    .repeat(0)
                    .playOn(dic2);



        });
    }
}