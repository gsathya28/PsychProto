package com.clairvoyance.psychproto;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Locale;

public class TimerActivity extends AppCompatActivity {

    TextView timeView;
    ToggleButton startStopButton;
    Button resetButton;

    long millisecondTime, startTime, timeBuff, updateTime = 0L;
    int seconds, minutes, milliseconds;

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        handler = new Handler();
        getLayoutData();
        setLayoutListeners();
    }


    void getLayoutData(){
        timeView = findViewById(R.id.timeView);
        startStopButton = findViewById(R.id.startstopButton);
        resetButton = findViewById(R.id.resetButton);
    }

    void setLayoutListeners(){
        startStopButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    // When the timer starts
                    startTime = SystemClock.uptimeMillis();
                    handler.postDelayed(stopwatch, 0);
                    resetButton.setEnabled(false);
                }
                else{
                    // When the timer stops
                    timeBuff += millisecondTime;
                    handler.removeCallbacks(stopwatch);
                    resetButton.setEnabled(true);
                }
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                milliseconds = 0;
                seconds = 0;
                minutes = 0;
                millisecondTime = 0L;
                startTime = 0L;
                timeBuff = 0L;
                updateTime = 0L;

                timeView.setText("00:00:00");
            }
        });
    }

    public Runnable stopwatch = new Runnable() {
        @Override
        public void run() {
            millisecondTime = SystemClock.uptimeMillis() - startTime;
            updateTime = timeBuff + millisecondTime;

            seconds = (int) (updateTime / 1000);
            minutes = seconds / 60;
            seconds = seconds % 60;
            milliseconds = (int) (updateTime % 1000);

            String timeString = "" + minutes + ":" + String.format(Locale.ENGLISH,"%02d", seconds) + ":" + String.format(Locale.ENGLISH, "%03d", milliseconds);
            timeView.setText(timeString);

            handler.postDelayed(this, 0);
        }
    };


}
