package com.example.apps4good;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    /**
     * The method that is called when the main activity is created
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Starts Checklist 1. This method is called when the next button is clicked on the loading page
     *
     * @param v a required parameter for the onClick method to work correctly
     */
    public void startChecklist1(View v) {
        Intent intent = new Intent(this, Checklist1Activity.class);
        startActivity(intent);
    }

}