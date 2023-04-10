package com.example.apps4good;

import java.util.ArrayList;

/**
 * This Recipe object is capable of storing Ingredients that are used in a
 * certain recipe in an ArrayList and instructions on how to make the Recipe
 *
 * @author Venkat
 *
 */
public class Recipe {
    // Data
    private String name;
    private String instructions;
    private ArrayList<Ingredient> ingredients;

    // Constructor
    /**
     * Default constructor. Constructs a Recipe object
     */
    public Recipe() {
        this.ingredients = new ArrayList<Ingredient>();
    }

    /**
     * Constructs a recipe object with a name
     * @param name the name of the recipe
     */
    public Recipe(String name) {
        this.name = name;
        this.ingredients = new ArrayList<Ingredient>();
    }

    /**
     * Constructor. Constructs a Recipe object with a specified name and instructions
     * @param name the name of the recipe
     * @param instructions instructions on how to make the recipe
     */
    public Recipe(String name, String instructions) {
        this.name = name;
        this.ingredients = new ArrayList<Ingredient>();
        this.instructions = instructions;
    }
    // Methods

    /**
     * Adds the given ingredient to the ingredients ArrayList
     */
    public void addIngredient(Ingredient i) {
        ingredients.add(i);
    }

    /**
     * Adds each ingredient (separated with a specified delimiter) to
     * the Recipe
     * @param input with the names of ingredients separated by the delimiter
     * @param delimiter the String used to split the ingredients
     */
    public void addIngredients(String input, String delimiter) {
        String[] stringredients = input.split(delimiter);
        for (String str : stringredients) {
            ingredients.add(new Ingredient(str));
        }
    }

    /**
     * Removes the last added ingredient from the recipe
     *
     * @return the removed Ingredient
     */
    public Ingredient removeIngredient() {
        return ingredients.remove(ingredients.size() - 1);
    }

    /**
     * Returns the instructions as one string
     * @return the instructions
     */
    public String getInstructions() {
        return instructions;
    }

    /**
     * Returns the ArrayList of Ingredient
     * @return the ingredients
     */
    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * Gets the Ingredient specified by the index
     * @param index the index to fetch the ingredient from
     * @return the Ingredient specified by the index
     */
    public Ingredient getIngredient(int index) {
        return ingredients.get(index);
    }

    /**
     *
     * @return the name of the Recipe
     */
    public String getName() {
        return name;
    }

    /**
     * Changes the recipe to a string
     */
    @Override
    public String toString() {
        String output = name + ": ";
        for (int i = 0; i < ingredients.size(); i++) {
            output += ingredients.get(i) + ", ";
        }
        output = output.substring(0, output.length() - 2);
        return output;
    }
}
