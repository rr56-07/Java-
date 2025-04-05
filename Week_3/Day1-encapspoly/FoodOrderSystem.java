package encapspoly;
import java.util.*;

interface Discountable {
    void applyDiscount(double percentage);
    String getDiscountDetails();
}

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemDetails() {
        return "Item: " + itemName + ", Price: ₹" + price + ", Quantity: " + quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract double calculateTotalPrice();
}

class VegItem extends FoodItem implements Discountable {
    private double discount = 0;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        double total = getPrice() * getQuantity();
        return total - (total * discount / 100);
    }

    public void applyDiscount(double percentage) {
        discount = percentage;
    }

    public String getDiscountDetails() {
        return "Veg Item Discount: " + discount + "%";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double discount = 0;
    private final double nonVegCharge = 20;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        double total = (getPrice() + nonVegCharge) * getQuantity();
        return total - (total * discount / 100);
    }

    public void applyDiscount(double percentage) {
        discount = percentage;
    }

    public String getDiscountDetails() {
        return "Non-Veg Item Discount: " + discount + "%";
    }
}

public class FoodOrderSystem {
    public static void processOrder(List<FoodItem> items) {
        for (FoodItem item : items) {
            System.out.println(item.getItemDetails());
            if (item instanceof Discountable) {
                Discountable d = (Discountable) item;
                d.applyDiscount(10); // apply 10% discount
                System.out.println(d.getDiscountDetails());
            }
            System.out.println("Total Price: ₹" + item.calculateTotalPrice());
            System.out.println("----------------------------------");
        }
    }

    public static void main(String[] args) {
        List<FoodItem> orderList = new ArrayList<>();
        orderList.add(new VegItem("Paneer Tikka", 150, 2));
        orderList.add(new NonVegItem("Chicken Biryani", 200, 1));

        processOrder(orderList);
    }
}

