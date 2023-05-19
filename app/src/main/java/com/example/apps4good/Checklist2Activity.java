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
 * This class handles the functionality of the dislikes page
 */
public class Checklist2Activity extends AppCompatActivity {
    private static final String checklist2Preferences = "checklist2Preferences";
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
        //Log.v("Checklist2Activity", "onCreate called");
        setContentView(R.layout.checklist2);
        sharedpreferences = getSharedPreferences(checklist2Preferences, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        for (int i = 0; i < ingredientStrings.length; i++) {
            String stringReference = ingredientStrings[i];
            CheckBox elementReference = findViewById(ingredientIds[i]);
            //Log.v("Checklist2Activity", stringReference + ": " + sharedpreferences.getBoolean(stringReference, false));
            elementReference.setChecked(sharedpreferences.getBoolean(stringReference, false));
        }
    }

    /**
     * This method iterates through all checkboxes and then stores the user's preferences
     */
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

    /**
     * gets the shared preferences stored by this method. THis is used in the SwiperActivity class
     *
     * @return user's preferences
     */
    public static SharedPreferences getSharedpreferences() {
        return sharedpreferences;
    }

    /**
     * Stores the user's dislikes into SharedPreferences and then starts Checklist1. It is called by the next button.
     *
     * @param v a parameter necessary for the button functionality to work
     */

    public void startChecklist1(View v) {
        updateSharedPreferences();
        Intent intent = new Intent(this, Checklist1Activity.class);
        startActivity(intent);
    }

    /**
     * Stores the user's dislikes into SharedPreferences and then starts Swiper. It is called by the next button.
     *
     * @param v a parameter necessary for the button functionality to work
     */

    public void startSwiperIngredient(View v) {
        updateSharedPreferences();
        Intent intent = new Intent(this, SwiperIngredientOnly.class);
        startActivity(intent);
    }
}