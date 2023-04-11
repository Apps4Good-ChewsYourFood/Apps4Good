package com.example.apps4good;

public class ClassTester {

    // This is the code I used to test our classes in eclipse
    public static void main(String[] args) {
        Ingredient salmon = new Ingredient("salmon");
        Ingredient broccoli = new Ingredient("broccoli");
        Ingredient vanilla = new Ingredient("vanilla");
        Ingredient marshmallow = new Ingredient("marshmallow");
        Ingredient water = new Ingredient("water");
        System.out.println("This should say water: " + water.toString());

        User McShukat = new User();
        McShukat.addPreference(water, true);
        McShukat.addPreference(broccoli, false);
        McShukat.addPreference(marshmallow, false);
        McShukat.addPreference(salmon, true);
        System.out.println("McShukat's preferences:" + McShukat.toString());

        Recipe ew = new Recipe();
        ew.addIngredient(vanilla);
        ew.addIngredient(water);
        System.out.println("The ingredients in the ew recipe " + ew.getIngredients().toString());

        System.out.println("Is salmon the same as water? " + salmon.equals(water));

        Ingredient meltedIce = new Ingredient("water");
        System.out.println("Is melted ice the same as water? " + meltedIce.equals(water));

    }
}
