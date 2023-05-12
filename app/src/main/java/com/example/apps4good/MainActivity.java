package com.example.apps4good;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("MainActivity", "Launch is successful");
        setContentView(R.layout.activity_main);
        TestFirebaseWithSVD.test();
    }

    public void startChecklist1(View v){
        Intent intent = new Intent(this, Checklist1Activity.class);
        startActivity(intent);
    }

}