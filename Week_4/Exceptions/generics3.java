
interface Category {
   String categoryName();
}

class BookCategory implements Category {
   @Override
   public String categoryName() {
       return "Book";
   }
}

class ClothingCategory implements Category {
   @Override
   public String categoryName() {
       return "Clothing";
   }
}

class GadgetsCategory implements Category {
   @Override
   public String categoryName() {
       return "Gadgets";
   }
}

class Product<T extends Category> {
   private String name;
   private double price;
   private T category;

   Product(String name, double price, T category) {
       this.name = name;
       this.price = price;
       this.category = category;
   }

   public String getName() {
       return this.name;
   }

   public double getPrice() {
       return this.price;
   }

   public T getCategory() {
       return this.category;
   }

   public void setPrice(double price) {
       this.price = price;
   }

   public void display() {
       System.out.println("Product name: " + getName() +
               ", price: $" + getPrice() +
               ", category: " + getCategory().categoryName());
   }
}

class MarketplaceUtils {
   public static <T extends Category> void applyDiscount(Product<T> product, double percentage) {
       double discountAmount = product.getPrice() * (percentage / 100.0);
       double newPrice = product.getPrice() - discountAmount;
       product.setPrice(newPrice);
       System.out.println("Discount applied to " + product.getName() + "! New price: $" + newPrice);
   }
}

public class dynamic {
   public static void main(String[] args) {
       // Create Products
       Product<BookCategory> book = new Product<>("Java Programming", 50.0, new BookCategory());
       Product<ClothingCategory> tshirt = new Product<>("Graphic T-shirt", 20.0, new ClothingCategory());
       Product<GadgetsCategory> smartphone = new Product<>("Smartphone X", 999.0, new GadgetsCategory());

       // Display Products
       book.display();
       tshirt.display();
       smartphone.display();

       System.out.println("\n--- Applying Discounts ---");

       // Apply Discounts
       MarketplaceUtils.applyDiscount(book, 10);       // 10% off
       MarketplaceUtils.applyDiscount(tshirt, 20);     // 20% off
       MarketplaceUtils.applyDiscount(smartphone, 5);  // 5% off

       // Display Products after Discount
       System.out.println("\n--- After Discount ---");
       book.display();
       tshirt.display();
       smartphone.display();
   }

}
