package BurgerTask;


public class BaseIngredient {
    String name;
    int price;

    public BaseIngredient(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }


    @Override
    public String toString() {
        return name + " - Цена:" + price;
    }
}
