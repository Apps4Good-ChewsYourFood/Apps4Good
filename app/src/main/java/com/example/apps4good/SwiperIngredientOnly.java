package com.example.apps4good;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * This class handles displaying the recommended ingredient to the user
 */
public class SwiperIngredientOnly extends AppCompatActivity {
    /**
     * This method creates and displays the page with the ingredient
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swiperingredientonly);
        displayRecommendation();
    }

    /**
     * This method uses helper methods from Controller to calculate a recommendation, and then display it
     */
    public void displayRecommendation() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("recipes");
        SubDatabase s = new SubDatabase();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                HashMap<Integer, Integer> ingredientCount = new HashMap<>();
                for(DataSnapshot ds: snapshot.getChildren()){
                    Recipe r = ds.getValue(Recipe.class);
                    s.addRecipe(r);
                    for(Ingredient ing: r.getIngredients()) {
                        try {
                            //Log.v("Work, Swiper", "valid enter " + ing.getName());
                            ingredientCount.putIfAbsent(Integer.parseInt(ing.getName()), 0);
                            //Log.v("Work, Swiper", "valid 1 " + ing.getName());
                            ingredientCount.put(Integer.parseInt(ing.getName()), 1 + ingredientCount.get(Integer.parseInt(ing.getName())));
                            //Log.v("Work, Swiper", "valid" + ing.getName());
                        } catch (NumberFormatException e) {
                        }
                    }
                }
                Log.v("Work, Swiper", ingredientCount.toString());
                for(String str: ingredientCount.toString().split(",")){
                    Log.v("Work, Swiper", str);
                }

                User recommendUser = Controller.getUser(Checklist1Activity.getSharedPreferences(), Checklist2Activity.getSharedpreferences());
                Ingredient topIngredient = s.getRecommendation(recommendUser).get(0);
                /*
                for(Ingredient ing: s.getRecommendation(recommendUser)){
                    if(! ArrayUtils.contains(Controller.firebaseIngredientIds, ing.getName().toLowerCase(Locale.ROOT))){
                        break;
                    }
                }
                */
                InputStream is = getResources().openRawResource(R.raw.all_ingredients_numbered);
                Object recommendation_text;
                try {
                    recommendation_text = JsonPath.read(is, "$." + topIngredient.getName());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                TextView toDisplayRecommendation = (TextView) findViewById(R.id.recommendationDisplay);
                Log.v("ChecklistActivity1", recommendation_text.toString());
                toDisplayRecommendation.setText(recommendation_text.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    /**
     * A method that opens the Main activity. It is currently not used, but a home button could be added
     *
     * @param v
     */
    private void startMainActivity(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * This method takes the user back to their likes page
     *
     * @param v
     */
    public void startChecklist1(View v) {
        Intent intent = new Intent(this, Checklist1Activity.class);
        startActivity(intent);
    }

    /**
     * takes user back to their likes page. We will implement further functionality that allows it
     * to change the user's preference matrix to reflect that they liked the displayed
     * ingredient
     *
     * @param v allows the onClick method to use this method
     */
    public void clickLike(View v) {
        //add increment corresponding element in preferences matrix
        startChecklist1(v);
    }

    /**
     * takes user back to their likes page. We will implement further functionality that allows it
     * to change the user's preference matrix to reflect that they disliked the displayed
     * ingredient
     *
     * @param v allows the onClick method to use this method
     */
    public void clickDislike(View v) {
        //add decrement corresponding element in preferences matrix
        startChecklist1(v);
    }
}