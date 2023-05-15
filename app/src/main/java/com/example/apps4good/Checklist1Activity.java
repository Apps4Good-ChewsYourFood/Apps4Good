package com.example.apps4good;
import static com.example.apps4good.Controller.ingredientIds;
import static com.example.apps4good.Controller.ingredientStrings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.SharedPreferencesKt;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;


public class Checklist1Activity extends AppCompatActivity {
    private static final String checklist1Preferences = "checklist1Preferences" ;
    private static SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.v("Checklist1Activity", "onCreate called");
        setContentView(R.layout.checklist1);
        sharedpreferences = getSharedPreferences(checklist1Preferences, Context.MODE_PRIVATE);
        TestFirebaseWithSVD.sharedPreferencesTest(sharedpreferences);
        for(int i = 0; i < ingredientStrings.length; i++){
            String stringReference = ingredientStrings[i];
            CheckBox elementReference = findViewById(ingredientIds[i]);
            //Log.v("Checklist1Activity", stringReference + ": " + sharedpreferences.getBoolean(stringReference, false));
            elementReference.setChecked(sharedpreferences.getBoolean(stringReference, false));
        }
    }

    public void updateSharedPreferences(){
        //Log.v("Checklist1Activity", "onDestroy called");
        sharedpreferences = getSharedPreferences(checklist1Preferences, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        for(int i = 0; i < ingredientStrings.length; i++){
            String stringReference = ingredientStrings[i];
            CheckBox elementReference = findViewById(ingredientIds[i]);
            //Log.v("Checklist1Activity", stringReference + ": " + elementReference.isChecked());
            editor.putBoolean(stringReference, elementReference.isChecked());
        }
        editor.apply();
    }
    @Override
    protected void onPause(){
        super.onPause();

    }
    public void startMainActivity(View v){
        updateSharedPreferences();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void startChecklist2(View v){
        updateSharedPreferences();
        Intent intent = new Intent(this, Checklist2Activity.class);
        startActivity(intent);

    }
    public static SharedPreferences getSharedPreferences(){
        return sharedpreferences;
    }
}