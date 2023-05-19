package com.example.apps4good;

import android.content.SharedPreferences;
import android.util.Log;

/**
 * This class with static methods handles some useful functionality used across activities and
 * contains hard-coded information about ingredients
 * ROOM TO IMPROVE: the ingredient data in this class is the only data that is considered. Some of
 * the ingredients with checkboxes are not included, because they are not present in the recipes
 * currently in the database.
 */
public class Controller {
    public static final int[] ingredientIds = {R.id.apples, R.id.bananas, R.id.oranges, R.id.grapes, R.id.mango, R.id.melon, R.id.pineapple, R.id.kiwi, R.id.corn, R.id.broccoli, R.id.brussel_sprouts, R.id.carrots, R.id.avocado, R.id.eggplant, R.id.tomato, R.id.mushrooms, R.id.cucumber, R.id.onion, R.id.peas, R.id.bellpepper, R.id.beef, R.id.chicken, R.id.pork, R.id.veal, R.id.goat, R.id.lamb, R.id.horse, R.id.eggs, R.id.milk, R.id.icecream, R.id.butter, R.id.sourcream, R.id.cheese, R.id.yogurt, R.id.cod, R.id.tuna, R.id.salmon, R.id.sushi, R.id.octopus, R.id.crab, R.id.clam, R.id.mussel, R.id.lobster, R.id.oyster, R.id.wheatbread, R.id.ryebread, R.id.whitebread};
    public static final String[] ingredientStrings = {"apples", "bananas", "oranges", "grapes", "mango", "melon", "pineapple", "kiwi", "corn", "broccoli", "brussel_sprouts", "carrots", "avocado", "eggplant", "tomato", "mushrooms", "cucumber", "onion", "peas", "bellpepper", "beef", "chicken", "pork", "veal", "goat", "lamb", "horse", "eggs", "milk", "icecream", "butter", "sourcream", "cheese", "yogurt", "cod", "tuna", "salmon", "sushi", "octopus", "crab", "clam", "mussel", "lobster", "oyster", "wheatbread", "ryebread", "whitebread"};
    public static final String[] firebaseIngredientIds = {"2064", "2196", "5412", "4194", "5075", "5152", "5601", "4655", "3108", "2535", "270", "2756", "2123", "3536", "6875", "5721", "3205", "5376", "5527", "2293", "2235", "2849", "2238", "7022", "None", "4678", "3558", "5183", "4503", "2591", "6482", "2823", "7418", "3045", "6918", "6235", "none", "none", "none", "3797", "3011", "5281", "4906", "none", "none", "none", "none", "none"};
    public static SubDatabase subDatabase = new SubDatabase();

    /**
     * This method loads the user while
     *
     * @param sharedPreferencesLikes   from the Checklist1 Activity
     * @param sharedPreferencesDislikes from the Checklist2 Activity
     * @return a User object containing the likes and dislikes of the inputs
     */
    public static User getUser(SharedPreferences sharedPreferencesLikes, SharedPreferences sharedPreferencesDislikes) {
        User user = new User();
        // Iterate through ingredients
        for (int i = 0; i < ingredientIds.length; i++) {
            //Log.v("Controller", ingredientIds[i] + " "+ ingredientStrings[i] + " "+ firebaseIngredientIds[i]);
            //make an ingredient object for each
            Ingredient ing = new Ingredient(firebaseIngredientIds[i]);
            //see if the user likes it
            if (sharedPreferencesLikes.getBoolean(ingredientStrings[i], false)) {
                user.addPreference(ing, true);
            } else if (sharedPreferencesDislikes.getBoolean(ingredientStrings[i], false)) {
                user.addPreference(ing, false);
            }
        }
        Log.v("Work, Controller", user.toString());
        return user;
    }
}
