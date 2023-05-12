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
    private SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("Checklist1Activity", "onCreate called");
        setContentView(R.layout.checklist1);
        sharedpreferences = getSharedPreferences(checklist1Preferences, Context.MODE_PRIVATE);
        TestFirebaseWithSVD.sharedPreferencesTest(sharedpreferences);
        for(int i = 0; i < ingredientStrings.length; i++){
            String stringReference = ingredientStrings[i];
            CheckBox elementReference = findViewById(ingredientIds[i]);
            Log.v("Checklist1Activity", stringReference + ": " + sharedpreferences.getBoolean(stringReference, false));
            elementReference.setChecked(sharedpreferences.getBoolean(stringReference, false));
        }
    }

    public void updateSharedPreferences(){
        Log.v("Checklist1Activity", "onDestroy called");
        sharedpreferences = getSharedPreferences(checklist1Preferences, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        for(int i = 0; i < ingredientStrings.length; i++){
            String stringReference = ingredientStrings[i];
            CheckBox elementReference = findViewById(ingredientIds[i]);
            Log.v("Checklist1Activity", stringReference + ": " + elementReference.isChecked());
            editor.putBoolean(stringReference, elementReference.isChecked());
        }
        editor.apply();
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
}







        /*
        CheckBox apple = findViewById(R.id.apples);
        CheckBox banana = findViewById(R.id.bananas);
        CheckBox oranges =  findViewById(R.id.oranges);
        CheckBox grapes = findViewById(R.id.grapes);
        CheckBox mango = findViewById(R.id.mango);
        CheckBox melon = findViewById(R.id.melon);
        CheckBox pineapple = findViewById(R.id.pineapple);
        CheckBox kiwi = findViewById(R.id.kiwi);
        CheckBox corn = findViewById(R.id.corn);
        CheckBox broccoli = findViewById(R.id.broccoli);
        CheckBox brusselsprouts = findViewById(R.id.brussel_sprouts);
        CheckBox carrots = findViewById(R.id.carrots);
        CheckBox avocado = findViewById(R.id.avocado);
        CheckBox eggplant = findViewById(R.id.eggplant);
        */
        /*
        CheckBox tomato = findViewById(R.id.tomato);
        CheckBox mushrooms = findViewById(R.id.mushrooms);
        CheckBox cucumber = findViewById(R.id.cucumber);
        CheckBox onion = findViewById(R.id.onion);
        CheckBox peas = findViewById(R.id.peas);
        CheckBox bellpepper = findViewById(R.id.bellpepper);

        sharedpreferences = getSharedPreferences(checklist1Preferences, Context.MODE_PRIVATE);

        final SharedPreferences.Editor editor = sharedpreferences.edit();

        if (sharedpreferences.getBoolean("apple", false)) {
            apple.setChecked(true);
        }

        if (sharedpreferences.getBoolean("banana", false)) {
            banana.setChecked(true);
        }

        if (sharedpreferences.getBoolean("oranges", false)) {
            oranges.setChecked(true);
        }

        if (sharedpreferences.getBoolean("grapes", false)) {
            grapes.setChecked(true);
        }

        if (sharedpreferences.getBoolean("mango", false)) {
            mango.setChecked(true);
        }

        if (sharedpreferences.getBoolean("melon", false)) {
            melon.setChecked(true);
        }

        if (sharedpreferences.getBoolean("pineapple", false)) {
            pineapple.setChecked(true);
        }

        if (sharedpreferences.getBoolean("kiwi", false)) {
            kiwi.setChecked(true);
        }

        if (sharedpreferences.getBoolean("corn", false)) {
            corn.setChecked(true);
        }

        if (sharedpreferences.getBoolean("broccoli", false)) {
            broccoli.setChecked(true);
        }

        if (sharedpreferences.getBoolean("brussel_sprouts", false)) {
            brusselsprouts.setChecked(true);
        }

        if (sharedpreferences.getBoolean("carrots", false)) {
            carrots.setChecked(true);
        }

        if (sharedpreferences.getBoolean("avocado", false)) {
            avocado.setChecked(true);
        }

        if (sharedpreferences.getBoolean("eggplant", false)) {
            eggplant.setChecked(true);
        }

        if (sharedpreferences.getBoolean("tomato", false)) {
            tomato.setChecked(true);
        }

        if (sharedpreferences.getBoolean("mushrooms", false)) {
            mushrooms.setChecked(true);
        }

        if (sharedpreferences.getBoolean("cucumber", false)) {
            cucumber.setChecked(true);
        }

        if (sharedpreferences.getBoolean("onion", false)) {
            onion.setChecked(true);
        }

        if (sharedpreferences.getBoolean("peas", false)) {
            peas.setChecked(true);
        }

        if (sharedpreferences.getBoolean("bellpepper", false)) {
            bellpepper.setChecked(true);
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

        oranges.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (oranges.isChecked()) {
                    editor.putBoolean("oranges", true);
                    editor.apply();
                } else {
                    editor.putBoolean("oranges", false);
                    editor.apply();
                }
            }
        });

        grapes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (grapes.isChecked()) {
                    editor.putBoolean("grapes", true);
                    editor.apply();
                } else {
                    editor.putBoolean("grapes", false);
                    editor.apply();
                }
            }
        });

        mango.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (mango.isChecked()) {
                    editor.putBoolean("mango", true);
                    editor.apply();
                } else {
                    editor.putBoolean("mango", false);
                    editor.apply();
                }
            }
        });

        melon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (melon.isChecked()) {
                    editor.putBoolean("melon", true);
                    editor.apply();
                } else {
                    editor.putBoolean("melon", false);
                    editor.apply();
                }
            }
        });

        pineapple.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (pineapple.isChecked()) {
                    editor.putBoolean("pineapple", true);
                    editor.apply();
                } else {
                    editor.putBoolean("pineapple", false);
                    editor.apply();
                }
            }
        });

        kiwi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (kiwi.isChecked()) {
                    editor.putBoolean("kiwi", true);
                    editor.apply();
                } else {
                    editor.putBoolean("kiwi", false);
                    editor.apply();
                }
            }
        });

        corn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (corn.isChecked()) {
                    editor.putBoolean("corn", true);
                    editor.apply();
                } else {
                    editor.putBoolean("corn", false);
                    editor.apply();
                }
            }
        });

        broccoli.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.v("Checklist1Activity", Boolean.toString(broccoli.isChecked()));
                if (broccoli.isChecked()) {
                    editor.putBoolean("broccoli", true);
                    editor.apply();
                } else {
                    editor.putBoolean("broccoli", false);
                    editor.apply();
                }
            }
        });

        brusselsprouts.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (brusselsprouts.isChecked()) {
                    editor.putBoolean("brussel_sprouts", true);
                    editor.apply();
                } else {
                    editor.putBoolean("brussel_sprouts", false);
                    editor.apply();
                }
            }
        });

        carrots.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (carrots.isChecked()) {
                    editor.putBoolean("carrots", true);
                    editor.apply();
                } else {
                    editor.putBoolean("carrots", false);
                    editor.apply();
                }
            }
        });

        avocado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (avocado.isChecked()) {
                    editor.putBoolean("avocado", true);
                    editor.apply();
                } else {
                    editor.putBoolean("avocado", false);
                    editor.apply();
                }
            }
        });

        eggplant.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (eggplant.isChecked()) {
                    editor.putBoolean("eggplant", true);
                    editor.apply();
                } else {
                    editor.putBoolean("eggplant", false);
                    editor.apply();
                }
            }
        });

        tomato.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (tomato.isChecked()) {
                    editor.putBoolean("tomato", true);
                    editor.apply();
                } else {
                    editor.putBoolean("tomato", false);
                    editor.apply();
                }
            }
        });

        mushrooms.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (mushrooms.isChecked()) {
                    editor.putBoolean("mushrooms", true);
                    editor.apply();
                } else {
                    editor.putBoolean("mushrooms", false);
                    editor.apply();
                }
            }
        });

        cucumber.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (cucumber.isChecked()) {
                    editor.putBoolean("cucumber", true);
                    editor.apply();
                } else {
                    editor.putBoolean("cucumber", false);
                    editor.apply();
                }
            }
        });

        onion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (onion.isChecked()) {
                    editor.putBoolean("onion", true);
                    editor.apply();
                } else {
                    editor.putBoolean("onion", false);
                    editor.apply();
                }
            }
        });

        peas.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (peas.isChecked()) {
                    editor.putBoolean("peas", true);
                    editor.apply();
                } else {
                    editor.putBoolean("peas", false);
                    editor.apply();
                }
            }
        });

        bellpepper.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (bellpepper.isChecked()) {
                    editor.putBoolean("bellpepper", true);
                    editor.apply();
                } else {
                    editor.putBoolean("bellpepper", false);
                    editor.apply();
                }
            }
        });
        */