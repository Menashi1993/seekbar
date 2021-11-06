package com.example.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    TextView myTV,redTV,greenTV,blueTV,opacityTV;
    SeekBar redSeekBar,greenSeekBar,blueSeekBar,opacitySeekBar;
    Button setClr;
    int redClr = 100;
    int greenClr = 100;
    int blueClr = 255;
    int opacity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTV = findViewById(R.id.myTV);
        redTV = findViewById(R.id.redTV);
        greenTV = findViewById(R.id.greenTV);
        blueTV = findViewById(R.id.blueTV);
        opacityTV = findViewById(R.id.opacityTV);

        redSeekBar = findViewById(R.id.redSeekBar);
        greenSeekBar = findViewById(R.id.greenSeekBar);
        blueSeekBar = findViewById(R.id.blueSeekBar);
        opacitySeekBar = findViewById(R.id.opacitySeekBar);

        setClr = findViewById(R.id.setClr);

        setClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redClr = redSeekBar.getProgress();
                greenClr = greenSeekBar.getProgress();
                blueClr = blueSeekBar.getProgress();
                opacity = opacitySeekBar.getProgress();

                redTV.setText(String.valueOf(redClr));
                greenTV.setText(String.valueOf(greenClr));
                blueTV.setText(String.valueOf(blueClr));
                setColorAlpha();
            }
        });

        redSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                redClr = redSeekBar.getProgress();
                redTV.setText(String.valueOf(redClr));
                setColorAlpha();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        greenSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                greenClr = greenSeekBar.getProgress();
                greenTV.setText(String.valueOf(greenClr));
                setColorAlpha();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        blueSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                blueClr = blueSeekBar.getProgress();
                blueTV.setText(String.valueOf(blueClr));
                setColorAlpha();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        opacitySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                opacity = opacitySeekBar.getProgress();
                setColorAlpha();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public void setColorAlpha(){
        myTV.setBackgroundColor(Color.rgb(redClr,greenClr,blueClr));
        myTV.getBackground().setAlpha(opacity);
        NumberFormat alphaPercent = NumberFormat.getPercentInstance();
        opacityTV.setText(String.valueOf(alphaPercent.format((opacity/255.0))));
    }
}