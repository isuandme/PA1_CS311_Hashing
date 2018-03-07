// LEAVE THIS FILE IN THE DEFAULT PACKAGE
//  (i.e., DO NOT add 'package cs311.pa1;' or similar)

// DO NOT MODIFY THE EXISTING METHOD SIGNATURES
//  (you may, however, add member fields and additional methods)

// DO NOT INCLUDE LIBRARIES OUTSIDE OF THE JAVA STANDARD LIBRARY
//  (i.e., you may include java.util.ArrayList etc. here, but not junit, apache commons, google guava, etc.)

/**
* @author Jacob Pratt & 
*/

public class Tuple
{
	// member fields and other member methods
	private int key;
	private String value;
	private Tuple next;
	private Tuple prev;
	private int size;
	
	public Tuple(){
		this.key = 0;
		this.next = null;
		this.prev = null;
		this.size = 0;
	}
	
	public Tuple(int keyP, String valueP)
	{
		this.key = keyP;
		this.value = valueP;
	}
	
	public int getKey()
	{
		return key;
	}
	public String getValue()
	{
		return value;
	}
	public boolean equals(Tuple t)
	{
		if(this.key == t.key && this.value.equals(t.value))
			return true;	
		return false;
	}
	
	/**
	 * Prints out the linked list of tupples starting at the element [i] that it
	 * is called from. 
	 */
	public void print(){
		Tuple temp = this;
		while(temp != null){
			System.out.print("[" + temp.key + "," + temp.value + "] ");
			temp = temp.next;
		}
	}
	
	/**
	 * Standard get next thing whatever.
	 * @return Tuple
	 */
	public Tuple getNext(){
		return this.next;
	}
	
	/**
	 * GETS THE PREVIOUS ONE DUHHH
	 * @return Tuple
	 */
	public Tuple getPrev(){
		return this.prev;
	}
	
	/**
	 * Adds a Tuple tot he beginning of the list this is because 
	 * it should only cost O(1)
	 * @param Tuple t
	 * @return nothing
	 */
	public void add(Tuple t){
		if(this.next == null){
			this.next = t;
			t.prev = this;
		} else {
			this.next.prev = t;
			t.next = this.next;
			t.prev = this;
			this.next = t;
		}
		size++;
	}
	
	public void remove(){
		if(this.next == null){
			this.prev.next = null;
		} else if(this.prev == null){
			this.key = this.next.key;
			this.value = this.next.value;
			this.next.remove();
		} else {
			this.next.prev = this.prev;
			this.prev.next = this.next;
		}
	}

	public int getSize() {
		return size;
	}
}