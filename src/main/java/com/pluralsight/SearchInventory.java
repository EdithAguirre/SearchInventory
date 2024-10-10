/*
The application displays the inventory that our store carries.
 */
package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SearchInventory {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();
        Scanner scanner = new Scanner(System.in);
        System.out.println("We carry the following inventory: ");

        // BONUS #2: Sort the products by name before displaying them.
        Collections.sort(inventory, Comparator.comparing(Product::getName));

        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("id: %d - Product: %s - Price: $%.2f\n",
                    p.getId(), p.getName(), p.getPrice());
        }
    }

    // this method loads product objects into inventory
    public static ArrayList<Product> getInventory(){

            // Create an array list of products
            ArrayList<Product> inventory = new ArrayList<Product>();

            // BONUS #1: Replace the code that loaded the ArrayList with code that reads data
            //from a file named inventory.csv. Create a file containing products.
            writeToFile();
            readFromFile(inventory);

        return inventory;
    }

    public static void writeToFile(){
        try {
            // Create buffered writer to write to inventory file
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/inventory.csv"));

            // Write 5 products to the file
            bufferedWriter.write("4567|10' 2x4 (grade B)|9.99\n");
            bufferedWriter.write("1234|Hammer|19.49\n");
            bufferedWriter.write("2345|Box of nails|9.29\n");
            bufferedWriter.write("7894|Tool box|20.99\n");
            bufferedWriter.write("5612|Wrench|5.99\n");

            // Close the bufferedWriter
            bufferedWriter.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void readFromFile(ArrayList<Product> inventory){
        try {
            // Create buffered reader to read from inventory file
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/inventory.csv"));

            // Read the file a line at a time
            String input;
            while((input = bufferedReader.readLine()) != null){
            //  Split the string where you find the pipe ( | ) character
            String[] tokens = input.split("\\|");

            // Use the parts to create a Product object and add the object to the ArrayList
            inventory.add(new Product(Integer.parseInt(tokens[0]),tokens[1],Float.parseFloat(tokens[2])));
            }

            bufferedReader.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}