import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem{
   private String itemName;
   private double itemPrice;
   WarehouseItem(String itemName, double itemPrice){
       this.itemName = itemName;
       this.itemPrice = itemPrice;
   }
   public String getItemName(){
       return this.itemName;
   }
   public double getItemPrice(){
       return this.itemPrice;
   }
   public abstract void display();
}
class Electronic extends WarehouseItem{
   Electronic(String name, double price){
       super(name, price);
   }
   public void display(){
       System.out.println("Electronic name is" + getItemName() + " and price is" + getItemPrice());
   }
}
class Groceriees extends WarehouseItem {
   Groceriees(String name, double price){
       super(name, price);
   }
   public void display(){
       System.out.println("Groceries name is" + getItemName() + " and price is" + getItemPrice());
   }
}
class Furniture extends WarehouseItem{
   Furniture(String name, double price){
       super(name,price);
   }
   public void display(){
       System.out.println("Furniture name is" + getItemName() + " and price is" + getItemPrice());
   }
}
class storage<T extends WarehouseItem>{
   private List<T> items;
   public storage(){
       items = new ArrayList<>();
   }
   public void addItem(T item){
       items.add(item);
   }
   public T getItems(int index){
       return items.get(index);
   }
   public List<T> getAllItems(){
       return items;
   }
}
class WarehouseUtils {
   public static void displayAllItems(List<? extends WarehouseItem> items) {
       for (WarehouseItem item : items) {
           item.display();
       }
   }
}

public class Generics {
   public static void main(String[] args) {
       storage<Electronic> electronicsStorage = new storage<>();
       storage<Groceriees> groceriesStorage = new storage<>();
       storage<Furniture> furnitureStorage = new storage<>();

       electronicsStorage.addItem(new Electronic("Laptop", 1200.00));
       electronicsStorage.addItem(new Electronic("Smartphone", 800.00));

       groceriesStorage.addItem(new Groceriees("Apple", 2.50));
       groceriesStorage.addItem(new Groceriees("Milk", 1.20));

       furnitureStorage.addItem(new Furniture("Chair", 75.00));
       furnitureStorage.addItem(new Furniture("Table", 150.00));

       // Display all Electronics
       System.out.println("--- Electronics ---");
       WarehouseUtils.displayAllItems(electronicsStorage.getAllItems());

       // Display all Groceries
       System.out.println("\n--- Groceries ---");
       WarehouseUtils.displayAllItems(groceriesStorage.getAllItems());

       // Display all Furniture
       System.out.println("\n--- Furniture ---");
       WarehouseUtils.displayAllItems(furnitureStorage.getAllItems());
   }
}