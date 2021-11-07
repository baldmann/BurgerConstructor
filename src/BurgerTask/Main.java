package BurgerTask;

public class Main {
    public static void main(String[] args) {
        Burger burger = new Burger();
        IngredientsMap ingredients = new IngredientsMap();
        ingredients.showIngredients();
        burger.constructBurger(ingredients);
    }
}
