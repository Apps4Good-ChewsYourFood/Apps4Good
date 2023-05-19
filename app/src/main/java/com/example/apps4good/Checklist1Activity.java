package com.example.apps4good;

import static com.example.apps4good.Controller.ingredientIds;
import static com.example.apps4good.Controller.ingredientStrings;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;


/**
 * This class handles the functionality of the loading page
 */
public class Checklist1Activity extends AppCompatActivity {
    private static final String checklist1Preferences = "checklist1Preferences";
    private static SharedPreferences sharedpreferences;

    /**
     * This method calls the AppCompatActivity's onCreate method and then loads their preferences into checkboxes from sharedPreferences
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.v("Checklist1Activity", "onCreate called");
        setContentView(R.layout.checklist1);
        sharedpreferences = getSharedPreferences(checklist1Preferences, Context.MODE_PRIVATE);
        for (int i = 0; i < ingredientStrings.length; i++) {
            String stringReference = ingredientStrings[i];
            CheckBox elementReference = findViewById(ingredientIds[i]);
            //Log.v("Checklist1Activity", stringReference + ": " + sharedpreferences.getBoolean(stringReference, false));
            elementReference.setChecked(sharedpreferences.getBoolean(stringReference, false));
        }
    }

    /**
     * This method iterates through all checkboxes and then stores the user's preferences
     */
    public void updateSharedPreferences() {
        //Log.v("Checklist1Activity", "onDestroy called");
        sharedpreferences = getSharedPreferences(checklist1Preferences, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        for (int i = 0; i < ingredientStrings.length; i++) {
            String stringReference = ingredientStrings[i];
            CheckBox elementReference = findViewById(ingredientIds[i]);
            //Log.v("Checklist1Activity", stringReference + ": " + elementReference.isChecked());
            editor.putBoolean(stringReference, elementReference.isChecked());
        }
        editor.apply();
    }

    /**
     * Stores the user's likes into SharedPreferences and then starts the MainActivity. It is called by the back button.
     *
     * @param v a parameter necessary for the button functionality to work
     */
    public void startMainActivity(View v) {
        updateSharedPreferences();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * Stores the user's likes into SharedPreferences and then starts Checklist2. It is called by the next button.
     *
     * @param v a parameter necessary for the button functionality to work
     */
    public void startChecklist2(View v) {
        updateSharedPreferences();
        Intent intent = new Intent(this, Checklist2Activity.class);
        startActivity(intent);

    }

    /**
     * gets the shared preferences stored by this method. THis is used in the SwiperActivity class
     *
     * @return user's preferences
     */
    public static SharedPreferences getSharedPreferences() {
        return sharedpreferences;
    }
}