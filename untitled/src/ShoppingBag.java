import java.util.HashMap;
import java.util.Map;

public class ShoppingBag <T extends PricedItem<Integer>>{
    private Map<T, Integer> shoppingBag;

    ShoppingBag(){
        shoppingBag = new HashMap<>();
    }

    public void addItem(T item){
        if (shoppingBag.containsKey(item)){
            shoppingBag.put(item, shoppingBag.get(item) + 1);
        } else{
            shoppingBag.put(item, 1);
        }
    }

    public Integer getTotalPrice(){
        int grandTotal = 0;
        for (T item : shoppingBag.keySet()){
            int quantity = shoppingBag.get(item);
            grandTotal += item.getPrice()* quantity;
        }
        return grandTotal;
    }
}
