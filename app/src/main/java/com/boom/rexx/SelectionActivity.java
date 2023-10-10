package com.boom.rexx;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class SelectionActivity extends  AppCompatActivity  {
    private final Intent go = new Intent();

    private SharedPreferences transfer;


    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);

        setContentView(R.layout.selection);
        initialize();

    }

    private void initialize() {

        TextView textview3 = findViewById(R.id.textview3);
        TextView textview2 = findViewById(R.id.textview2);
        TextView textview4 = findViewById(R.id.textview4);
        transfer = getSharedPreferences("transfer", Activity.MODE_PRIVATE);

        textview4.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF17B794));
        textview4.setElevation((float)8);
        textview2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF17B794));
        textview2.setElevation((float)8);
        textview3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF17B794));
        textview3.setElevation((float)8);


        textview2.setOnClickListener(_view -> {
            transfer.edit().putString("selection", "signals").commit();
            go.setClass(getApplicationContext(), AdminActivity.class);
            startActivity(go);
        });

        textview3.setOnClickListener(_view -> {
            transfer.edit().putString("selection", "post").commit();
            go.setClass(getApplicationContext(), AdminActivity.class);
            startActivity(go);
        });

        textview4.setOnClickListener(_view -> {
            transfer.edit().putString("selection", "users").commit();
            go.setClass(getApplicationContext(), UsersActivity.class);
            startActivity(go);
        });

    }

    @Override
    public void onBackPressed() {

    }
}
