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
     * Default constructor. Constructs a Recipe object and creates an ArrayList to
     * store Ingredient objects
     */
    public Recipe() {
        this.ingredients = new ArrayList<Ingredient>();
    }

    public Recipe(String name) {
        this.name = name;
        this.ingredients = new ArrayList<Ingredient>();
    }

    /**
     * Constructor. Constructs a Recipe object with a specified instructions and
     * creates an ArrayList to store Ingredient objects
     *
     * @param instructions - the instructions for the recipe
     */
    public Recipe(String name, String instructions) {
        this.name = name;
        this.ingredients = new ArrayList<Ingredient>();
        this.instructions = instructions;
    }
    // Methods

    /**
     * Adds the given ingredient to the ingredients ArrayList
     *
     * @param i - the Ingredient object that is being added to the ArrayList
     */
    public void addIngredient(Ingredient i) {
        ingredients.add(i);
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
     * Gets the instructions for the recipe
     *
     * @return - the instructions for the recipe
     */
    public String getInstructions() {
        return instructions;
    }

    /**
     * Sets the instructions for the recipe
     *
     * @param instructions - the instructions to set
     */
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    /**
     * Gets the ingredients of the recipe
     *
     * @return the ingredients as Ingredient objects
     */
    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * Sets the ingredients ArrayList to the given input
     *
     * @param - an ArrayList of Ingredients to set as the ingredients of the receipe
     */
    public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
    }
     
     /*
     * Gets the Ingredient at the specified index
     *
     * @param index - the index of Ingredient in the ingredients ArrayList
     * @return the Ingredient specified by the index
     */
    public Ingredient getIngredient(int index) {
        return ingredients.get(index);
    }

    /** 
     * Gets the name of the Recipe
     *
     * @return the name of the Recipe
     */
    public String getName() {
        return name;
    }

    /**
     * @return the name of the Recipe object and the Ingredients for that recipe
     */
    @Override
    public String toString() {
        String output = name + ": ";
        for(int i = 0; i < ingredients.size(); i ++) {
            output += ingredients.get(i) + ", ";
        }
        output = output.substring(0, output.length() - 2);
        return output;
    }
}
