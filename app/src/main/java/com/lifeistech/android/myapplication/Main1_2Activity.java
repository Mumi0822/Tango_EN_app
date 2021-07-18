package com.lifeistech.android.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

;

public class Main1_2Activity extends AppCompatActivity {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Words word = null;
    EditText editText;
    EditText editText2;
    int spoint;
    int epoint;
    String text;
    String text2;
    int es;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1_2);
        word = new Words(this);
        editText = (EditText)findViewById(R.id.edittext);
        editText2 = (EditText)findViewById(R.id.edittext2);
        editText.selectAll();
        editText.setText("1");
        editText2.setText(String.valueOf(word.getCount()));


    }
    public void start(View view){
        text = editText.getText().toString();
        text2 = editText2.getText().toString();
        spoint = Integer.parseInt(text);
        epoint = Integer.parseInt(text2);
        es = epoint - spoint;
        if(es > 1 && epoint <= word.getCount()){
            pref = getSharedPreferences("savedata",MODE_PRIVATE);
            editor = pref.edit();
            editor.putInt("spoint",spoint);
            editor.putInt("epoint",epoint);
            editor.apply();
            Intent intent = new Intent(this,Main2Activity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this,"範囲を選択し直して下さい。",Toast.LENGTH_LONG).show();
        }

    }
    public void back(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
