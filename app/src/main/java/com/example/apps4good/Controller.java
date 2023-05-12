package com.example.apps4good;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Controller {
    public static final int[] ingredientIds = {R.id.apples, R.id.bananas, R.id.oranges, R.id.grapes, R.id.mango, R.id.melon, R.id.pineapple, R.id.kiwi, R.id.corn, R.id.broccoli, R.id.brussel_sprouts, R.id.carrots, R.id.avocado, R.id.eggplant, R.id.tomato, R.id.mushrooms, R.id.cucumber, R.id.onion, R.id.peas, R.id.bellpepper, R.id.beef, R.id.chicken, R.id.pork, R.id.veal, R.id.goat, R.id.lamb, R.id.horse, R.id.eggs, R.id.milk, R.id.icecream, R.id.butter, R.id.sourcream, R.id.cheese, R.id.yogurt, R.id.cod, R.id.tuna, R.id.salmon, R.id.sushi, R.id.octopus, R.id.crab, R.id.clam, R.id.mussel, R.id.lobster, R.id.oyster, R.id.wheatbread, R.id.ryebread, R.id.whitebread};
    public static final String[] ingredientStrings = {"apples", "bananas", "oranges", "grapes", "mango", "melon", "pineapple", "kiwi", "corn", "broccoli", "brussel_sprouts", "carrots", "avocado", "eggplant", "tomato", "mushrooms", "cucumber", "onion", "peas", "bellpepper", "beef", "chicken", "pork", "veal", "goat", "lamb", "horse", "eggs", "milk", "icecream", "butter", "sourcream", "cheese", "yogurt", "cod", "tuna", "salmon", "sushi", "octopus", "crab", "clam", "mussel", "lobster", "oyster", "wheatbread", "ryebread", "whitebread" };
    public static final String[] firebaseIngredientIds = {"2064", "2196", " 5412", " 4194", " 5075", " 5152", " 5601", " 4655", " 3108", " 2535", " 270", "2756", " 2123", " 3536", " 6875", " 5721", " 3205", " 5376", " 5527", " 2293", " 2235", " 2849", " 7022", " None", "4678", " 3538", " 5183", " 4503", " 2591", " 6482", " 2823", " 7418", " 3045", " 6918", " 6235", " none", " none", " 3794", " 3011", " 4906", " none", " none" };
    public static User loadLikes(SharedPreferences sharedPreferences){
        User user = new User();
        // Iterate through ingredients
        for(int i = 0; i < ingredientIds.length; i++){
            //make an ingredient object for each
            Ingredient ing = new Ingredient(firebaseIngredientIds[i]);
            //see if the user likes it
            if(sharedPreferences.getBoolean(ingredientStrings[i], false)){
                user.addPreference(ing, true);
            }

            //see if the user dislikes it

        }
        return user;
    }
    public SubDatabase getSubDatabaseFromFirebase(){
        SubDatabase test = new SubDatabase();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("recipes");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds: snapshot.getChildren()){
                    Recipe r = ds.getValue(Recipe.class);
                    test.addRecipe(r);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        return test;
    }

}
