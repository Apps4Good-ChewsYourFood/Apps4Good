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
        CheckBox banana = (CheckBox) findViewById(R.id.bananas);
        CheckBox oranges = (CheckBox) findViewById(R.id.oranges);
        CheckBox grapes = (CheckBox) findViewById(R.id.grapes);
        CheckBox mango = (CheckBox) findViewById(R.id.mango);
        CheckBox melon = (CheckBox) findViewById(R.id.melon);
        CheckBox pineapple = (CheckBox) findViewById(R.id.pineapple);
        CheckBox Kiwi = (CheckBox) findViewById(R.id.kiwi);
        CheckBox corn = (CheckBox) findViewById(R.id.corn);
        CheckBox broccoli = (CheckBox) findViewById(R.id.broccoli);
        CheckBox brussel = (CheckBox) findViewById(R.id.brussel_sprouts);
        CheckBox carrots = (CheckBox) findViewById(R.id.carrots);
        CheckBox avocado = (CheckBox) findViewById(R.id.avocado);
        CheckBox eggplant = (CheckBox) findViewById(R.id.eggplant);
        CheckBox tomato = (CheckBox) findViewById(R.id.tomato);
        CheckBox mushroom = (CheckBox) findViewById(R.id.mushrooms);
        CheckBox cucumber = (CheckBox) findViewById(R.id.cucumber);
        CheckBox onion = (CheckBox) findViewById(R.id.onion);
        CheckBox peas = (CheckBox) findViewById(R.id.peas);
        CheckBox bellpepper = (CheckBox) findViewById(R.id.bellpepper);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpreferences.edit();
        if (sharedpreferences.contains("apple") && sharedpreferences.getBoolean("apple", false) == true) {
            apple.setChecked(true);
        }

        if ( sharedpreferences.getBoolean("banana", false) == true) {
            banana.setChecked(true);
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