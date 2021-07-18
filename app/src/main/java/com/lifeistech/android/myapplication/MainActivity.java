package com.lifeistech.android.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    TextView  tapText;

    Boolean flag = true;

    Handler mHandler = new Handler();

    private Timer mTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tapText = (TextView) findViewById(R.id.textView7);

    }

    @Override
    protected void onStart(){
        super.onStart();
        changeText();
    }

    private  void  changeText(){
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (flag) {
                            tapText.setVisibility(View.VISIBLE);
                            flag = false;
                            Log.d("Visibility", "VISIBLE");
                        } else {
                            tapText.setVisibility(View.INVISIBLE);
                            flag = true;
                            Log.d("Visibility", "INVISIBLE");
                        }
                    }
                });
            }
        }, 0, 800);
    }

    private void stopTimer(){
        mTimer.cancel();
        mTimer = null;
    }

    @Override
    protected void onStop(){
        super.onStop();
        stopTimer();

    }




    public void start(View view){
        Intent intent = new Intent(this,Main1_2Activity.class);
        startActivity(intent);
    }
}
