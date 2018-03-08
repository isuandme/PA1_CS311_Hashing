import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

// LEAVE THIS FILE IN THE DEFAULT PACKAGE
//  (i.e., DO NOT add 'package cs311.pa1;' or similar)

// DO NOT MODIFY THE EXISTING METHOD SIGNATURES
//  (you may, however, add member fields and additional methods)

// DO NOT INCLUDE LIBRARIES OUTSIDE OF THE JAVA STANDARD LIBRARY
//  (i.e., you may include java.util.ArrayList etc. here, but not junit, apache commons, google guava, etc.)

/**
 * @author Jacob R. Pratt, ,
 */

public class HashTable {

	private int size, totalElements;
	private HashFunction hash;
	private Tuple[] table;
	private int[] tableSize;

	public HashTable(int size) {
		this.totalElements = 0;
		this.size = findPrime(size);
		this.hash = new HashFunction(size);
		this.table = new Tuple[this.size];
		this.tableSize = new int[this.size];
	}

	public float loadFactor() {
		return ((float) numElements()) / ((float) size);
	}

	public int maxLoad() {
		int max = 0;
		for (int i = 0; i < tableSize.length; i++) {
			if (tableSize[i] > max)
				max = tableSize[i];
		}
		return max;
	}

	public float averageLoad() {
		int sum = 0;
		for (int i = 0; i < this.tableSize.length; i++) {
			sum = sum + tableSize[i];
		}
		int count = 0;
		for (int i = 0; i < this.table.length; i++) {
			if (table[i] != null)
				count++;
		}
		return (float) sum / count;
	}

	public int size() {
		return this.size;
	}

	public int numElements() {
		int count = 0;
		for (int i = 0; i < this.size; i++) {
			count = count + this.tableSize[i];
		}
		return count;
	}

	public void add(Tuple t) {
		if (loadFactor() > (float) 0.7) {
			this.printTable();
			System.out.println();
			System.out.println("-------------------------------------------------------------------------------------------");
			System.out.println();
			this.resize();
		}
		int h = hash.hash(t.getKey());
		if (table[h] == null) {
			this.table[h] = new Tuple(t.getKey(), t.getValue());
			this.table[h].increaseSize();
			this.tableSize[h]++;
		} else {
			Tuple temp = this.table[h].search(t);
			if (temp == null) {
				this.table[h].add(t);
				this.table[h].getNext().increaseSize();
				this.tableSize[h]++;
			} else {
				temp.increaseSize();
			}
		}
	}

	private void resize() {
		this.size = findPrime(this.size * 2);
		this.hash = new HashFunction(this.size);
		Tuple[] oldTable = this.table;
		this.table = new Tuple[this.size];
		this.tableSize = new int[this.size];
		for (int i = 0; i < oldTable.length; i++) {
			if(oldTable[i] != null){
				Tuple temp = oldTable[i];
				while(temp != null){
					this.add(temp);
					temp = temp.getNext();
				}
			}
		}
	}

	public Tuple[] getTable() {
		return table;
	}

	public ArrayList<Tuple> search(int k) {
		ArrayList<Tuple> ret = new ArrayList<Tuple>();
		int h = hash.hash(k);
		Tuple cur = table[h];
		while(cur != null) {
			ret.add(cur);  		
			cur = cur.getNext();
		}
		return ret;
	}

	public int search(Tuple t) {
		int num = 0;
		int h = hash.hash(t.getKey());
		Tuple cur = table[h];
		while(cur != null){
			if(cur.equals(t))
				num = cur.getSize();
		}
		return num;
	}

	public void remove(Tuple t) {
		int h = hash.hash(t.getKey());
		Tuple cur = table[h];
		while (cur != null) {
			if (cur.getPrev() == null) {

				table[h] = cur.getNext();
				cur.copyLeft();
				cur.remove();
			}
			if (cur.getNext() == null) {

			}
			if (cur.equals(t)) {
				cur.remove();
				break;
			}
			cur = cur.getNext();
		}
	}

	/******************** BELOW ARE PRINT METHODS ******************/

	public void printTable() {
		for (int i = 0; i < this.size; i++) {
			if (table[i] == null) {
				System.out.println("<null>");
				continue;
			} else {
				System.out.print("Hash<" + i + ">: ");
				table[i].print();
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("Based of a generation of 100 random strings.");
		System.out.println("	FIELD: tableSize: " + Arrays.toString(this.tableSize));
		System.out.println("	numElements(): " + this.numElements() + "  <--- independent elements");
		System.out.println("	maxLoad(): " + this.maxLoad());
		System.out.println("	size(): " + this.size());
		System.out.println("	loadFactor(): " + this.loadFactor());
		System.out.println("	averageLoad(): " + this.averageLoad());
	}

	/************* PRIME FUNCTIONS BELOW *******************/

	private int findPrime(int n) {
		boolean found = false;
		int num = n;
		while (!found) {
			if (isPrime(num))
				return num;
			num++;
		}
		return -1;
	}

	private boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++)
			if (n % i == 0)
				return false;
		return true;
	}
}