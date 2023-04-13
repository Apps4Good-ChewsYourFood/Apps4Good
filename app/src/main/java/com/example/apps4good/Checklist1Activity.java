package com.example.apps4good;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Checklist1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checklist1);
    }
    public void startMainActivity(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void startChecklist2(View v){
        Intent intent = new Intent(this, Checklist2Activity.class);
        startActivity(intent);
    }

}