package com.example.apps4good;
import java.util.HashMap;

/**
 * This class creates a user for our app, Chews Your Food and contains the
 * necessary actions the user needs for the app.
 *
 * @author shulinglin
 *
 */
public class User {

    // Data
    public boolean like;
    public Ingredient ingredient;
    private HashMap<Ingredient, Boolean> preferences;

    // Constructor

    /**
     * The default constructor creates a HashMap that uses an Ingredient Object as
     * the key, and the user's preference about that ingredient as the value. True =
     * the user likes that ingredient; false = the user does not like that
     * ingredient.
     */
    public User() {
        preferences = new HashMap<Ingredient, Boolean>();
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
        if (preferences.containsKey(name))
            System.out.println("You've already made a decision about this ingredient");
        else
            preferences.put(name, choice);
    }

    /**
     * Gets the list of preferences the user has made so far
     *
     * @return - the HashMap of preferences
     */


    public HashMap<Ingredient, Boolean> getPreferences() {
        return preferences;
    }

    @Override
    public String toString() {
        String text = "";
        /*
         * https://stackoverflow.com/questions/5920135/printing-hashmap-in-java helped
         * me figure how to get both the key and the value while iterating over the
         * HashMap
         */
        for (Ingredient name : preferences.keySet()) {
            String key = name.toString();
            String value = preferences.get(name).toString();
            text += "\nIngredient: " + key + "-- You like to eat this ingredient: " + value;
        }
        if (text.isEmpty())
            return "You have not made any choices yet :(";
        else
            return text;
    }

}

