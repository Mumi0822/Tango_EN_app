package com.lifeistech.android.myapplication;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by maedakousuke on 16/03/22.
 */
public class Words{
    private ArrayList<String[]> wordsArray = new ArrayList<>();

    public Words (Context context){
        InputStream inputStream = null;
        BufferedReader reader = null;
        try {
            inputStream = context.getAssets().open("words.csv");
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while((line = reader.readLine()) != null){
                this.wordsArray.add(line.split(","));
            }
        }catch (IOException e) {
            e.getStackTrace();
        }finally {
            try {
                reader.close();
                inputStream.close();
            } catch (IOException e) {
                e.getStackTrace();
            }
        }
    }

    public String[] getWords (int count){
        return wordsArray.get(count);
    }

    public String getEnglish (int count){
        return wordsArray.get(count)[0];
    }

    public String getJapanese (int count){
        return wordsArray.get(count)[1];
    }

    public int getCount () {
        return wordsArray.size();
    }
}
