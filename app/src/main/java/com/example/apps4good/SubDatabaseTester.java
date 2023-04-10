package com.example.apps4good;

import java.util.Arrays;
//import Jama.SingularValueDecomposition;

public class SubDatabaseTester {

    public static void main(String[] args) {
        // Initializing all the objects
        SubDatabase tester = new SubDatabase();
        Ingredient apple = new Ingredient("Apple");
        Ingredient strawberry = new Ingredient("Strawberry");
        Ingredient oats = new Ingredient("Oats");
        Ingredient honey = new Ingredient("Honey");
        Ingredient milk = new Ingredient("Milk");

        Recipe oatmeal = new Recipe("Oatmeal");
        Recipe fruitSalad = new Recipe("Fruit Salad");
        Recipe honeyOat = new Recipe("Honey Oat Cheerios");

        // Adding the ingredients to oatmeal
        oatmeal.addIngredient(apple);
        oatmeal.addIngredient(oats);
        oatmeal.addIngredient(milk);

        // Adding ingredients to fruit salad
        fruitSalad.addIngredient(strawberry);
        fruitSalad.addIngredient(apple);

        // Adding ingredients to Cheerios
        honeyOat.addIngredient(milk);
        honeyOat.addIngredient(oats);
        honeyOat.addIngredient(honey);

        // Adding recipes to tester
        tester.addRecipe(oatmeal);
        tester.addRecipe(fruitSalad);
        tester.addRecipe(honeyOat);

        // Printing all of the ingredients in tester
        System.out.println(tester);
        // Printing the Matrix representation of the tester. Each column corresponds to a
        System.out.println(Arrays.deepToString(tester.toMatrix()));

        // Creating a new user and adding their preferences
        User user = new User();
        user.addPreference(milk, true);
        user.addPreference(honey, true);
        user.addPreference(apple, true);

        // Output the recommendation!
        System.out.println(user);
        for(int i = 0; i < tester.getIngredients().size(); i++) {
            System.out.println("\n\nrec" + i);
            System.out.println(tester.getRecommendation(user, i));
        }
    }
}
