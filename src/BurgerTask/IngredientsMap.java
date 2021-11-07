package BurgerTask;

import java.util.HashMap;
import java.util.Map;

public class IngredientsMap {

    public static HashMap<Integer, BaseIngredient> ingredients = new HashMap<Integer, BaseIngredient>();

    public IngredientsMap() {
        ingredients.put(1, new BaseIngredient("соус", 10));
        ingredients.put(2, new BaseIngredient("сыр", 20));
        ingredients.put(3, new BaseIngredient("котлета", 30));

    }

    public static void showIngredients() {
        for (Map.Entry<Integer, BaseIngredient> entry : ingredients.entrySet())
            System.out.println(entry.getKey() + ". " + entry.getValue());
    }

    public static BaseIngredient selectIngredient(int ingredientToFind) {
        return ingredients.get(ingredientToFind);
    }

    public static BaseIngredient findIngredientByName(String ingredientName) {
        BaseIngredient ingredientToReturn = null;
        for (Map.Entry<Integer, BaseIngredient> set : ingredients.entrySet()) {
            if (set.getValue().name.equals(ingredientName.toLowerCase())) {
                ingredientToReturn = set.getValue();
                break;
            }
        }
        return ingredientToReturn;
    }


}