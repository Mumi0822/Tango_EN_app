package com.lifeistech.android.myapplication;

import android.content.ClipboardManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    TextView text;
    TextView text2;
    Words word = null;
    Button btn;
    Button btb;
    int i;
    boolean w = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        word = new Words(this);
        pref = getSharedPreferences("savedata",MODE_PRIVATE);
        editor = pref.edit();
        i = pref.getInt("spoint",1)-1;
        text = (TextView)findViewById(R.id.textView);
        text2 = (TextView)findViewById(R.id.textView5);
        btn = (Button)findViewById(R.id.button3);
        btb = (Button)findViewById(R.id.button4);
        text.setText(word.getEnglish(i));
        text2.setText("No."+(i+1));
        btb.setEnabled(false);
    }
    public void next(View view){
        i++;
        text.setText(word.getEnglish(i));
        text2.setText("No."+(i+1));
        w = true;
        btb.setEnabled(true);
        if(i == pref.getInt("epoint",word.getCount())-1){
            btn.setEnabled(false);
        }else{
            btn.setEnabled(true);
        }
    }
    public void back(View view){
        i--;
        text.setText(word.getEnglish(i));
        text2.setText("No."+(i+1));
        w = true;
        btn.setEnabled(true);
        if(i == pref.getInt("spoint",1)-1){
            btb.setEnabled(false);
        }else{
            btb.setEnabled(true);
        }
    }
    public void bottom(View view){
        if(w == true){
            text.setText(word.getJapanese(i));
            w = false;
        }else{
            text.setText(word.getEnglish(i));
            w = true;
        }
    }
    public void title(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void copy(View view){
        ClipboardManager cm = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        cm.setText(word.getEnglish(i));
        Toast.makeText(this,word.getEnglish(i)+"をクリップボードにコピーしました。", Toast.LENGTH_SHORT).show();
    }
}
