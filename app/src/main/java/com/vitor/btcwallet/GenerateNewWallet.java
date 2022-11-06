package com.vitor.btcwallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GenerateNewWallet extends AppCompatActivity {
    private TextView word_1, word_2, word_3, word_4, word_5, word_6, word_7, word_8, word_9, word_10, word_11, word_12, word_13, word_14, word_15, word_16, word_17, word_18, word_19, word_20, word_21, word_22, word_23, word_24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_new_wallet);

        getSupportActionBar().hide();

        List seed_phrase = new ArrayList<>();
        seed_phrase = get_seed_phrase();

        List words_views = get_text_views();
        showSeedPhrase(seed_phrase, words_views);
    }

    private void showSeedPhrase(List seed, List words_views){
        for (int i = 0; i < 24;) {
            String seed_word_1 = i+1+". " + (String) seed.get(i);
            TextView word_view = (TextView) words_views.get(i);
            word_view.setText(seed_word_1);
            i++;
        }
    }

    private List get_text_views(){
        List words_lists = new ArrayList<>();

        words_lists.add(findViewById(R.id.word_1));
        words_lists.add(findViewById(R.id.word_2));
        words_lists.add(findViewById(R.id.word_3));
        words_lists.add(findViewById(R.id.word_4));
        words_lists.add(findViewById(R.id.word_5));
        words_lists.add(findViewById(R.id.word_6));
        words_lists.add(findViewById(R.id.word_7));
        words_lists.add(findViewById(R.id.word_8));
        words_lists.add(findViewById(R.id.word_9));
        words_lists.add(findViewById(R.id.word_10));
        words_lists.add(findViewById(R.id.word_11));
        words_lists.add(findViewById(R.id.word_12));
        words_lists.add(findViewById(R.id.word_13));
        words_lists.add(findViewById(R.id.word_14));
        words_lists.add(findViewById(R.id.word_15));
        words_lists.add(findViewById(R.id.word_16));
        words_lists.add(findViewById(R.id.word_17));
        words_lists.add(findViewById(R.id.word_18));
        words_lists.add(findViewById(R.id.word_19));
        words_lists.add(findViewById(R.id.word_20));
        words_lists.add(findViewById(R.id.word_21));
        words_lists.add(findViewById(R.id.word_22));
        words_lists.add(findViewById(R.id.word_23));
        words_lists.add(findViewById(R.id.word_24));

        return words_lists;
    }

    private String[] get_bip39_list() throws IOException {
        String text = "";
        try {
            InputStream is = getAssets().open("bip39.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text = new String(buffer);
        }catch (IOException ex){
            ex.printStackTrace();
        }
        String[] arrOfStr = text.split("\n", 2048);
        return arrOfStr;
    }

    private List get_seed_phrase(){
        String[] bip39_list = {};

        try {
            bip39_list = get_bip39_list();
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("MyTests", "File not founded");
        }

        List seed_phrase = new ArrayList<>();

        for (int i = 0; i < 24;) {
            int randomNumber = getRandomNumber(0, 2048);
            Log.d("MyTests", bip39_list[randomNumber]);

            seed_phrase.add(bip39_list[randomNumber]);
            i++;
        }

        Log.d("MyTests", String.valueOf(seed_phrase.get(0)));
        return seed_phrase;
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}