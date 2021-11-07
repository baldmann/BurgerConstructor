package BurgerTask;

import java.util.*;

public class Burger {
    private List<BaseIngredient> ingredientList = new ArrayList();
    private final int BASE_PRICE = 50;

    private void addIngredient(BaseIngredient ingredient) {
        if (ingredient != null) {
            ingredientList.add(ingredient);
        }
    }

    private int getCost() {
        int cost = BASE_PRICE;

        for (BaseIngredient item : ingredientList) {
            cost += item.getPrice();
        }
        return cost;
    }


    private void displayFinalBurger() {
        Set<BaseIngredient> set = new HashSet<BaseIngredient>(ingredientList);
        for (BaseIngredient item : set) {
            System.out.println(Collections.frequency(ingredientList, item) + " x " + item.getName() + " = " + (Collections.frequency(ingredientList, item) * item.getPrice()));
        }
        System.out.println("Total Cost " + this.getCost());
    }

    private void displayNewBurger() {
        System.out.println("Стоимость бургера - " + BASE_PRICE);
    }

    public  void constructBurger(IngredientsMap ingredients) {
        boolean toExit = false;
        int count = 1;
        displayNewBurger();
        do {
            int parsedChoice = 0;
            System.out.print("Выберите " + count + "-й ингредиент: ");
            Scanner scan = new Scanner(System.in);
            String choice = scan.nextLine();
            try {
                parsedChoice = Integer.parseInt(choice);
            } catch (NumberFormatException exception) {
                if (choice.equals("нет")) {
                    displayFinalBurger();
                    toExit = true;
                } else {
                    BaseIngredient foundIngredient = ingredients.findIngredientByName(choice);
                    if (foundIngredient != null) {
                        count = addAndCount(count, foundIngredient);
                    }

                }
            }

            if (parsedChoice >= 1 && parsedChoice <= 3) {
                count = addAndCount(count, ingredients.selectIngredient(parsedChoice));
            }
        }
        while (!toExit);
    }

    private int addAndCount(int count, BaseIngredient foundIngredient) {
       addIngredient(foundIngredient);
       displayFinalBurger();
        count++;
        System.out.println("Хотите добавить еще ингредиент?");
        return count;
    }
}
