import java.util.Scanner;
public class TakeOutSimulator {
    private Customer customer;
    private FoodMenu menu;
    private Scanner input;

    TakeOutSimulator(Customer customer, FoodMenu menu) {
        this.customer = customer;
        this.menu = menu;
        input = new Scanner(System.in);
    }

    private <T> T getOutputOnIntInput(String userInputPrompt, IntUserInputRetriever<T> intUserInputRetriever){
        while(true){
            System.out.println(userInputPrompt);

            if(input.hasNextInt()){
                int intInput  = input.nextInt();
                try{
                    return intUserInputRetriever.produceOutputOnIntUserInput(intInput );
                } catch (IllegalArgumentException e){
                    System.out.println(intInput + " is not a valid input. Try Again!");
                }
            }
            else {
                System.out.println("Input needs to be a number, try again.");
                input.next();
            }
        }
    }

    public boolean shouldSimulate(){
        String userPrompt ="Enter 1 to CONTINUE simulation or 0 to EXIT program:";
        IntUserInputRetriever<Boolean> intUserInputRetriever  = new IntUserInputRetriever<>(){
            @Override
            public Boolean produceOutputOnIntUserInput(int selection) throws IllegalArgumentException {
                if(selection == 1){
                    Food lowestCostFood = menu.getLowestCostFood();
                    if (lowestCostFood != null && customer.getMoney() >= lowestCostFood.getPrice()){
                        return true;
                    }
                    else {
                        System.out.println("You don't have enough money to proceed.");
                        return false;
                    }
                }
                else if(selection == 0){
                    return false;
                }
                else{
                    throw new IllegalArgumentException("Invalid input. Please enter 1 or 0.");
                }
            }
        };
        return getOutputOnIntInput(userPrompt, intUserInputRetriever);
    }

    public Food getMenuSelection(){
        String userPrompt = "Today's Menu Options:\n" + menu.toString() + "Please enter the number of the food item you'd like to select:";


        IntUserInputRetriever<Food> intUserInputRetriever = new IntUserInputRetriever<>() {
            @Override
            public Food produceOutputOnIntUserInput(int selection) throws IllegalArgumentException {
                Food selectedFood = menu.getFood(selection);
                if (selectedFood != null) {
                    return selectedFood;
                } else {
                    throw new IllegalArgumentException("Invalid input. Please select a valid menu item.");
                }
            }
        };
        return getOutputOnIntInput(userPrompt, intUserInputRetriever);
    }

    public Boolean isStillOrderingFood(){
        String userPrompt = "Enter 1 to CONTINUE shopping or 0 to CHECKOUT:";
        IntUserInputRetriever<Boolean> intUserInputRetriever = new IntUserInputRetriever<>(){
            @Override
            public Boolean produceOutputOnIntUserInput(int selection){
                if(selection == 1){
                    return true;
                }
                else if (selection == 0){
                    return false;
                }
                else{
                    throw new IllegalArgumentException("Invalid input. Please enter 1 or 0.");
                }
            }
        };
        return getOutputOnIntInput(userPrompt, intUserInputRetriever);
    }

    public void checkoutCustomer(ShoppingBag<Food> shoppingBag){
        System.out.println("Processing payment...");
        int startMoney = customer.getMoney();
        int totalCost = shoppingBag.getTotalPrice();
        int newBalance = startMoney - totalCost;
        if (newBalance >= 0) {
            customer.setMoney(newBalance);
            System.out.println("Your remaining balance is: $" + customer.getMoney());
            System.out.println("Thank you and enjoy your food!");
        } else {
            System.out.println("Insufficient funds. Unable to complete the payment.");
        }
    }

    public void takeOutPrompt(){
        ShoppingBag<Food> shoppingBag = new ShoppingBag<>();
        int customerMoneyLeft = customer.getMoney();

        while (true){
            System.out.println("You have $" + customerMoneyLeft + "left to spend.");

            Food selectedFood = getMenuSelection();

            if (selectedFood.getPrice() > customerMoneyLeft){
                System.out.println("Oops! Looks like you donät have enough money for that. Choose another item or check out");
            }
            else {
                customerMoneyLeft -= selectedFood.getPrice();
                shoppingBag.addItem(selectedFood);
                System.out.println("Added " + selectedFood + " to your shopping bag.");
            }
            if(!isStillOrderingFood()){
                checkoutCustomer(shoppingBag);
                break;
            }

        }
    }

    public void startTakeOutSimulator(){
        System.out.println("Hello, welcome to my restaurant! \n\n Welcome " + customer.getName());
        while(true){
            System.out.println("Ready to order?");
            takeOutPrompt();
            System.out.println("Would you like to place another order or exit the simulation?");
            if(!isStillOrderingFood()){
                System.out.println("Thank you for ordering food!");
                break;
            }
        }

    }
}
