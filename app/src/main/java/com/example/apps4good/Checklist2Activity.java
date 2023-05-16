package com.example.apps4good;

import static com.example.apps4good.Controller.ingredientIds;
import static com.example.apps4good.Controller.ingredientStrings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;

import java.util.Arrays;

public class Checklist2Activity extends AppCompatActivity {
    private static final String checklist2Preferences = "checklist2Preferences" ;
    private static SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.v("Checklist2Activity", "onCreate called");
        setContentView(R.layout.checklist2);
        sharedpreferences = getSharedPreferences(checklist2Preferences, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        for(int i = 0; i < ingredientStrings.length; i++){
            String stringReference = ingredientStrings[i];
            CheckBox elementReference = findViewById(ingredientIds[i]);
            //Log.v("Checklist2Activity", stringReference + ": " + sharedpreferences.getBoolean(stringReference, false));
            elementReference.setChecked(sharedpreferences.getBoolean(stringReference, false));
        }
    }

    public void updateSharedPreferences() {
        //Log.v("Checklist2Activity", "onDestroy called");
        sharedpreferences = getSharedPreferences(checklist2Preferences, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        for (int i = 0; i < ingredientStrings.length; i++) {
            String stringReference = ingredientStrings[i];
            CheckBox elementReference = findViewById(ingredientIds[i]);
            //Log.v("Checklist2Activity", stringReference + ": " + elementReference.isChecked());
            editor.putBoolean(stringReference, elementReference.isChecked());
        }
        editor.apply();
    }
    public static SharedPreferences getSharedpreferences(){
        return sharedpreferences;
    }

    public void startChecklist1(View v){
        updateSharedPreferences();
        Intent intent = new Intent(this, Checklist1Activity.class);
        startActivity(intent);
    }
    public void startSwiperIngredient(View v){
        updateSharedPreferences();
        Intent intent = new Intent(this, SwiperIngredientOnly.class);
        startActivity(intent);
    }
    private void print(double[][] m){
        for (double[] row: m){
            Log.v("CheckListActivity1", Arrays.toString(row));
        }
    }
}