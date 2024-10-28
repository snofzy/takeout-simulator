import java.util.ArrayList;
import java.util.List;

public class FoodMenu {
    private List<Food> menu;

    public FoodMenu() {
        menu = new ArrayList<>();
        Food item1 = new Food("pizza", 9, "A very cheesy one");
        menu.add(item1);
        Food item2 = new Food("Hamburger", 7, "A very meety one");
        menu.add(item2);
        Food item3 = new Food("Soup", 8, "A very slippery one");
        menu.add(item3);
    }

    @Override
    public String toString() {
        StringBuilder totalString = new StringBuilder();
        for (int i = 0; i < menu.size(); i++) {
            Food food = menu.get(i);
            totalString.append(i + 1).append(". ").append(food.toString()).append("\n");
        }
        return totalString.toString();
    }

    public Food getFood(int index){
        int adjustedIndex = index - 1;

        try {
            return menu.get(adjustedIndex);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public Food getLowestCostFood(){
        if (menu.isEmpty()) {
            return null;
        }
        Food cheapestFood = menu.get(0);

        for(Food food : menu){
            if(food.getPrice() < cheapestFood.getPrice()){
                cheapestFood = food;
            }
        }
        return cheapestFood;
    }
}
