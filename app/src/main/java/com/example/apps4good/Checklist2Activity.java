package com.example.apps4good;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Checklist2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checklist2);
    }

    public void startChecklist1(View v){
        Intent intent = new Intent(this, Checklist1Activity.class);
        startActivity(intent);
    }

}