import java.util.ArrayList;

// LEAVE THIS FILE IN THE DEFAULT PACKAGE
//  (i.e., DO NOT add 'package cs311.pa1;' or similar)

// DO NOT MODIFY THE EXISTING METHOD SIGNATURES
//  (you may, however, add member fields and additional methods)

// DO NOT INCLUDE LIBRARIES OUTSIDE OF THE JAVA STANDARD LIBRARY
//  (i.e., you may include java.util.ArrayList etc. here, but not junit, apache commons, google guava, etc.)

/**
* @author Hugh Potter
*/

public class HashTable
{
	// member fields and other member methods
	private int size, numElements;
	ArrayList<ArrayList<Tuple>> table;
	HashFunction hash;

	public HashTable(int size)
	{
		// possibly check and see if size will be negative
		this.size = size;
		this.numElements = 0;
		table = new ArrayList<ArrayList<Tuple>>(size);
		hash = new HashFunction(size);
	}

	public int maxLoad()
	{
		if(this.size == 0){
			return 0;
		}
		int max = 0;
		for(ArrayList<Tuple> i : table){
			System.out.print(i.stream().distinct().count());
		}
		return max;
	}

	public float averageLoad()
	{
		// implementation
		return 0;
	}

	public int size()
	{
		return size;
	}

	public int numElements()
	{
		
		return numElements;
	}

	public float loadFactor()
	{
		return 0;
	}

	public void add(Tuple t)
	{
		int tmp = hash.hash(t.getKey());
		//System.out.println(tmp);
		numElements++;
	}

	public ArrayList<Tuple> search(int k)
	{
		return null;
	}

	public int search(Tuple t)
	{
		return 0;
	}

	public void remove(Tuple t)
	{
		numElements--;
	}
}