package Project03;

import java.io.IOException;
import java.io.FileNotFoundException;

/*
 * Create an array Node to implement the key and value
 */
public class SimpleHashTable<Key, Value> {

	int numKeys;		// the number of keys
	int tableSize;		// the size of the array
	Node[] sht;
		
	private static class Node {
		Object keys;
		Object vals;	
		
		public Node(Object key, Object val) {
			this.keys = key;
			this.vals = val;
		}
	}

	/*
	 * Implementation of the array size
	 */
	public SimpleHashTable(int size) {
		this.tableSize = size;
		sht = new Node[tableSize];
	}
	/*
	 * return the key  
	 */
	public Object getKey(int index) {
		return sht[index].keys;
	}
	/*
	 * return the value
	 */
	public Object getValue(int index) {
		return sht[index].vals;
	}
	
	/*
	 * return the hash code
	 */
	public int getCode(Key key) {
		int i = key.hashCode() % tableSize;
		return i;
	}

	/*
	 * resize the array and re-hashed the contents into the new array.  
	 */
	public void resize(int size) {
		SimpleHashTable<Key, Value> temp = new SimpleHashTable<Key, Value>(size);
		for (int i=0; i<tableSize; i++) {
			if (sht[i] != null) 
				temp.insert((Key) sht[i].keys,(Value) sht[i].vals);
		}
		this.tableSize = temp.tableSize;
		this.numKeys = temp.numKeys;
		this.sht = temp.sht;
	}
	
	/*
	 * insert a key into the hash table
	 */
	public void insert(Key tk, Value tv) {
		if (tk == null || tv == null ) {
			throw new IllegalArgumentException("The argument is null");
		}
		
		int hashKey = getCode(tk);			// get hash code
		int qp=hashKey;
		int cons=1;
		
		do {

			if (sht[qp] == null) {
				sht[qp] = new Node(tk, tv); // insert the key
				numKeys++;					// increase the number of keys 
				if ((double) numKeys/tableSize >= 0.8) {		// resize hash table when load factor greater than 80%.
					System.out.println("array size: " + tableSize + " load factor: " + (double) numKeys/tableSize + ", now resize it.");
					resize( tableSize*2);			// double size to resize
				}
				return;
			}
			if (tk.equals(sht[qp].keys)) {	// duplicate key
				System.out.println("Duplicate!");
				return;
			}
			
			qp = (hashKey + (cons*cons)) % tableSize; // quadratic probing
			cons++;
		} while(qp != hashKey);	
		System.out.println("Can not find a space.");		
	}
	
	/*
	 * search a key
	 */
	public int search(Key key) {
		if (key == null )
			throw new IllegalArgumentException("The argument is null");
		int hashKey = getCode(key);
		int qp=hashKey;
		int cons=1;
		
		while(sht[qp] != null) 
		{
			if(key.equals(sht[qp].keys))	// return the index of hash table when key is found
				return qp;
			qp = (hashKey + (cons*cons)) % tableSize; // quadratic probing
			cons++;
		}
		return -1;
	}
	
	/* 
	 * remove a key from the hash table
	 */
	public boolean remove(Key key) {
		int index = search(key);	// return -1 if the key doesn't exist in the table
		if (index == -1) 
			return false;
		
		sht[index] = null;		// remove the node
		numKeys--;				// decrease the number of keys
		return true;	
	}
	
	/*
	 * print the key and value from the table
	 */
	public void printTable() {
		for (int i=0; i<tableSize; i++) {
			if (sht[i] != null) 
				System.out.println("Key: " + sht[i].keys + ", Value: " + sht[i].vals + ", Index: " + i);
		}
	}
}
/*	
	public static void main(String[] args) {
		SimpleHashTable<String, Integer> sht = new SimpleHashTable<String, Integer>();
		sht.insert("one", 10);
		sht.insert("two", 11);
		sht.insert("three", 12);
		sht.insert("four", 13);
		sht.insert("five", 14);
		
		for (int i=0; i<sht.tableSize; i++) {
			if (sht.sht[i] != null) {
				Node x = sht.sht[i];
				System.out.println(x.keys + " " + x.vals);
			}
		}
	}
}

*/

