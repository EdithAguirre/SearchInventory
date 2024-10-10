/*
The application displays the inventory that our store carries
 */
package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchInventory {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();
        Scanner scanner = new Scanner(System.in);
        System.out.println("We carry the following inventory: ");
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("id: %d %s - Price: $%.2f\n",
                    p.getId(), p.getName(), p.getPrice());
        }
    }

    // this method loads product objects into inventory
    public static ArrayList<Product> getInventory(){
        ArrayList<Product> inventory = new ArrayList<Product>();

        // create an initial inventory of at least 5 products
        inventory.add(new Product(4567,"10' 2x4 (grade B)",9.99f));
        inventory.add(new Product(1234,"Hammer",19.49f));
        inventory.add(new Product(2345,"Box of nails", 9.29f));
        inventory.add(new Product(7894,"Tool box", 20.99f));
        inventory.add(new Product(5612,"Wrench",5.99f));

        return inventory;
    }
}
