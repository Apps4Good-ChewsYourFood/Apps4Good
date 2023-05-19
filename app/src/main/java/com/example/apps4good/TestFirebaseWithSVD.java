package com.example.apps4good;


import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TestFirebaseWithSVD {
    public static void test() {
        Recipe e543 = new Recipe("e543");
        e543.addIngredient(new Ingredient("e"));
        e543.addIngredient(new Ingredient("5"));
        e543.addIngredient(new Ingredient("4"));
        e543.addIngredient(new Ingredient("3"));
        //Log.v("TestFirebaseWithSVD", e543.toString());
        //Log.v("TestFirebaseWithSVD", "" + new Ingredient("3").equals(e543.getIngredient(3)));
        //Log.v("TestFirebaseWithSVD", "" + e543.getIngredients().contains(new Ingredient("e")));
        //Log.v("TestFirebaseWithSVD", "1");
        SubDatabase test = new SubDatabase();
        //Log.v("TestFirebaseWithSVD", "2");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //Log.v("TestFirebaseWithSVD", "3");
        DatabaseReference myRef = database.getReference("recipes");
        //Log.v("TestFirebaseWithSVD", myRef.toString());
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    Recipe r = ds.getValue(Recipe.class);
                    test.addRecipe(r);
                }
                //Log.v("TestFirebaseWithSVD", "Size is " + test.getRecipes().size());
                //Log.v("TestFirebaseWithSVD", test.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public static void sharedPreferencesTest(SharedPreferences sharedPreferences) {
        //Log.v("TestFirebaseWithSVD", sharedPreferences.getBoolean("oranges", false) + "");
    }
}
