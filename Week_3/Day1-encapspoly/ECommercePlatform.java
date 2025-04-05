package encapspoly;

import java.util.ArrayList;
import java.util.List;

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double calculateDiscount();

    public double calculateFinalPrice() {
        double discount = calculateDiscount();
        double tax = (this instanceof Taxable) ? ((Taxable) this).calculateTax() : 0;
        return price + tax - discount;
    }
}

class Electronics extends Product implements Taxable {
    private double discountPercentage;

    public Electronics(int productId, String name, double price, double discountPercentage) {
        super(productId, name, price);
        this.discountPercentage = discountPercentage;
    }

    public double calculateDiscount() {
        return (getPrice() * discountPercentage) / 100;
    }

    public double calculateTax() {
        return getPrice() * 0.18;  // 18% tax for Electronics
    }

    public String getTaxDetails() {
        return "Electronics Tax: 18%";
    }
}

class Clothing extends Product implements Taxable {
    private double discountAmount;

    public Clothing(int productId, String name, double price, double discountAmount) {
        super(productId, name, price);
        this.discountAmount = discountAmount;
    }

    public double calculateDiscount() {
        return discountAmount;
    }

    public double calculateTax() {
        return getPrice() * 0.12;  // 12% tax for Clothing
    }

    public String getTaxDetails() {
        return "Clothing Tax: 12%";
    }
}

class Groceries extends Product {
    private double discountPercentage;

    public Groceries(int productId, String name, double price, double discountPercentage) {
        super(productId, name, price);
        this.discountPercentage = discountPercentage;
    }

    public double calculateDiscount() {
        return (getPrice() * discountPercentage) / 100;
    }
}

public class ECommercePlatform {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        Electronics e1 = new Electronics(101, "Laptop", 50000, 10);
        Clothing c1 = new Clothing(102, "T-shirt", 1000, 150);
        Groceries g1 = new Groceries(103, "Apple", 200, 5);

        products.add(e1);
        products.add(c1);
        products.add(g1);

        for (Product product : products) {
            System.out.println("Product Name     : " + product.getName());
            System.out.println("Original Price   : " + product.getPrice());
            System.out.println("Final Price      : " + product.calculateFinalPrice());

            if (product instanceof Taxable) {
                System.out.println(((Taxable) product).getTaxDetails());
            }

            System.out.println("------------------------------");
        }
    }
}
