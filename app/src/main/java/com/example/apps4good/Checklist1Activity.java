package com.example.apps4good;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.SharedPreferencesKt;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;


public class Checklist1Activity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;

    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checklist1);

        CheckBox apple = (CheckBox) findViewById(R.id.apples);
        CheckBox avo = (CheckBox) findViewById(R.id.avocado);
        CheckBox banana = (CheckBox) findViewById(R.id.bananas);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpreferences.edit();
        if (sharedpreferences.contains("apple") && sharedpreferences.getBoolean("apple", false) == true) {
            apple.setChecked(true);
        } else {
            apple.setChecked(false);
        }

        if (sharedpreferences.contains("banana") && sharedpreferences.getBoolean("banana", false) == true) {
            banana.setChecked(true);
        } else {
            banana.setChecked(false);
        }

            apple.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (apple.isChecked()) {
                        editor.putBoolean("apple", true);
                        editor.apply();
                    } else {
                        editor.putBoolean("apple", false);
                        editor.apply();
                    }
                }
            });

        banana.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if (banana.isChecked()) {
                        editor.putBoolean("banana", true);
                        editor.apply();
                    } else {
                        editor.putBoolean("banana", false);
                        editor.apply();
                    }
                }
            });

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