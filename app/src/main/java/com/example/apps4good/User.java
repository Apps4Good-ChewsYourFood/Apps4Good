package com.example.apps4good;
import android.util.Log;

import java.util.HashMap;

import java.util.HashMap;

/**
 * This class creates a user for our app, Chews Your Food and contains the
 * necessary actions the user needs for the app.
 */
public class User {

    // Data
    private HashMap<Integer, Boolean> preferences;

    // Constructor

    /**
     * The default constructor creates a HashMap that uses an Ingredient Object as
     * the key, and the user's preference about that ingredient as the value. True =
     * the user likes that ingredient; false = the user does not like that
     * ingredient.
     */
    public User() {
        preferences = new HashMap<Integer, Boolean>();
    }

    // Methods

    /**
     * Adds a new preference to the HashMap.
     *
     * @param name   - their name of the Ingredient they are making a decision about
     * @param choice - their decision about the ingredient; True = the user likes
     *               that * ingredient; false = the user does not like that
     *               ingredient.
     */
    public void addPreference(Ingredient name, boolean choice) {
        try{
            preferences.put(Integer.parseInt(name.getName()), choice);
        } catch (NumberFormatException e){
            //Log.v("User", name.toString());
        }
    }

    /**
     * Gets the list of preferences the user has made so far
     *
     * @return - the HashMap of preferences
     */
    public String toString() {
        String text = "";
        /*
         * https://stackoverflow.com/questions/5920135/printing-hashmap-in-java helped
         * me figure how to get both the key and the value while iterating over the
         * HashMap
         */
        for (Object name : preferences.keySet()) {
            String key = name.toString();
            String value = preferences.get(name).toString();
            text += "Ingredient: " + key + " You like to eat this ingredient: " + value + "\n";}
        if (text.isEmpty())
            return "You have not made any choices yet :(";
        else
            return text;
    }

    /**
     * Gets a the HashMap containing the User's preferences base. True corresponds
     * to the user liking the ingredient, and false corresponds to the user
     * disliking the ingredient.
     *
     * @return user's preferences
     */
    public HashMap<Integer, Boolean> getPreferences() {
        return preferences;
    }

}
