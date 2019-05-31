package Project03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;

/*
 * CSCI232: project 3 part1
 * Yuen-Chen Tsou
 * 5/30/2019
 * Create a hash table and via the menu to implement the program.
 * 1. Insert a key
 * 2. Remove a key
 * 3. Search a key
 * 4. Print the hash table
 * 5. Quit
 * Initial the array size to be 4.
 * Quadratic probing to address collision problem, and the array will be increased to double size
 * when load factor is greater than 80%.
 *   
 */
public class HashTableDemo {

	public static void main(String[] args) {
		
		SimpleHashTable<String, Integer> sht = new SimpleHashTable<String, Integer>(4);
	
		Scanner scan = new Scanner(System.in);
		int choice;
		do {
			System.out.println("\nHash Table");
			System.out.println("1. Insert a key");
			System.out.println("2. Remove a key");
			System.out.println("3. Search a key");
			System.out.println("4. Print the hash table");
			System.out.println("5. Quit");
			while (!scan.hasNextInt()) {		// *Ensure user enters an integer.
				scan.next();
				System.out.println("Enter 1 to 5");
			}
			choice = scan.nextInt();
		
			switch (choice) {
			case 1:
				System.out.println("Enter a key: ");
				String key = scan.next();
				System.out.println("Enter a value: ");
				int value = scan.nextInt();
				sht.insert( key, value);
				break;
			case 2:
				System.out.println("Enter key to delete: ");
				if (sht.remove(scan.next()))
					System.out.println("The key deleted.");
				else
					System.out.println("It did not find the key");
				break;
			case 3:
				System.out.println("Enter an key to search: ");
				int index = sht.search(scan.next());
				if (index == -1)
					System.out.println("The key is not in the table.");
				else 
					System.out.println("key: " + sht.getKey(index) + ", value: " + sht.getValue(index));
				break;
			case 4:
				sht.printTable();
				break;
			case 5:
				break;
			default:
				continue;
			}
		}while (choice != 5);
		System.out.println("<end>");
	}
	
}
