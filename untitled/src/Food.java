public class Food implements PricedItem<Integer> {
    private String name;
    private int price;
    private String description;
    public Food(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    @Override
    public void setPrice(Integer price){
        this.price = price;
    }
    @Override
    public Integer getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return "Enjoy " + name + ": " + description + ", At the cost off: $" + price + ".";
    }

}
