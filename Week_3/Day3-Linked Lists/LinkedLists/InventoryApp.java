package DataStructures.LinkedLists;

class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    private Item head = null;

    public void addItemAtBeginning(Item newItem) {
        newItem.next = head;
        head = newItem;
    }

    public void addItemAtEnd(Item newItem) {
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newItem;
    }

    public void addItemAtPosition(Item newItem, int position) {
        if (position <= 1 || head == null) {
            addItemAtBeginning(newItem);
            return;
        }
        Item temp = head;
        int count = 1;
        while (temp.next != null && count < position - 1) {
            temp = temp.next;
            count++;
        }
        newItem.next = temp.next;
        temp.next = newItem;
    }

    public void removeItemById(int itemId) {
        if (head == null) return;
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public void updateQuantity(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
    }

    public void searchById(int itemId) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                printItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    public void searchByName(String name) {
        Item temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                printItem(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Item with name '" + name + "' not found.");
        }
    }

    public void calculateTotalValue() {
        Item temp = head;
        double total = 0;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + total);
    }

    public void sortByName(boolean ascending) {
        head = mergeSort(head, ascending, true);
    }

    public void sortByPrice(boolean ascending) {
        head = mergeSort(head, ascending, false);
    }

    private Item mergeSort(Item head, boolean ascending, boolean byName) {
        if (head == null || head.next == null) return head;
        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;

        Item left = mergeSort(head, ascending, byName);
        Item right = mergeSort(nextOfMiddle, ascending, byName);

        return merge(left, right, ascending, byName);
    }

    private Item merge(Item a, Item b, boolean ascending, boolean byName) {
        if (a == null) return b;
        if (b == null) return a;

        boolean condition;
        if (byName) {
            condition = ascending ? a.itemName.compareToIgnoreCase(b.itemName) <= 0 : a.itemName.compareToIgnoreCase(b.itemName) > 0;
        } else {
            condition = ascending ? a.price <= b.price : a.price > b.price;
        }

        if (condition) {
            a.next = merge(a.next, b, ascending, byName);
            return a;
        } else {
            b.next = merge(a, b.next, ascending, byName);
            return b;
        }
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void displayInventory() {
        Item temp = head;
        if (temp == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        while (temp != null) {
            printItem(temp);
            temp = temp.next;
        }
    }

    private void printItem(Item item) {
        System.out.println("ID: " + item.itemId + ", Name: " + item.itemName +
                           ", Quantity: " + item.quantity + ", Price: " + item.price);
    }
}

public class InventoryApp {
    public static void main(String[] args) {
        Inventory inv = new Inventory();

        inv.addItemAtEnd(new Item("Laptop", 101, 10, 75000));
        inv.addItemAtBeginning(new Item("Mouse", 102, 50, 500));
        inv.addItemAtPosition(new Item("Keyboard", 103, 30, 1000), 2);

        System.out.println("Inventory:");
        inv.displayInventory();

        System.out.println("\nSearch by ID:");
        inv.searchById(102);

        System.out.println("\nSearch by Name:");
        inv.searchByName("Keyboard");

        System.out.println("\nUpdating Quantity of ID 101...");
        inv.updateQuantity(101, 8);

        System.out.println("\nTotal Inventory Value:");
        inv.calculateTotalValue();

        System.out.println("\nSorted by Name (Asc):");
        inv.sortByName(true);
        inv.displayInventory();

        System.out.println("\nSorted by Price (Desc):");
        inv.sortByPrice(false);
        inv.displayInventory();

        System.out.println("\nRemoving Item with ID 103...");
        inv.removeItemById(103);
        inv.displayInventory();
    }
}

