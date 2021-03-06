// LEAVE THIS FILE IN THE DEFAULT PACKAGE
//  (i.e., DO NOT add 'package cs311.pa1;' or similar)

// DO NOT MODIFY THE EXISTING METHOD SIGNATURES
//  (you may, however, add member fields and additional methods)

// DO NOT INCLUDE LIBRARIES OUTSIDE OF THE JAVA STANDARD LIBRARY
//  (i.e., you may include java.util.ArrayList etc. here, but not junit, apache commons, google guava, etc.)

/**
 * @author Hadis Fetic, Jacob R. Pratt, Bradley Bales
 */

public class Tuple {
	// member fields and other member methods
	private int key;
	private String value;
	private Tuple next;
	private Tuple prev;
	private int size;
	private boolean visited;
	
	public Tuple(int keyP, String valueP)
	{
		this.key = keyP;
		this.value = valueP;
		this.next = null;
		this.prev = null;
	}

	public void setVisted(boolean visited) {
		this.visited = visited;
	}

	public boolean getVisted() {
		return visited;
	}

	public int getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean equals(Tuple t) {
		if (this.key == t.key && this.value.equals(t.value))
			return true;
		return false;
	}

	public void print() {
		Tuple temp = this;
		while (temp != null) {
			System.out.print("[" + temp.key + "," + temp.value + "," + temp.size + "] ");
			temp = temp.next;
		}
	}

	public Tuple search(Tuple t) {
		Tuple temp;
		if (this.equals(t))
			return this;
		temp = this;
		while (temp != null) {
			if (temp.equals(t)) {
				return temp;
			}
			temp = temp.next;
		}
		return null;
	}

	public Tuple getNext() {
		return this.next;
	}

	public Tuple getPrev() {
		return this.prev;
	}
	public void setNext() {
		this.next = null;
	}

	public void setPrev() {
		this.prev = null;
	}

	public void add(Tuple t) {
		if (this.next == null) {
			this.next = t;
			t.prev = this;
		} else {
			this.next.prev = t;
			t.next = this.next;
			t.prev = this;
			this.next = t;
		}
	}

	public void remove() {
		this.next.prev = this.prev;
		this.prev.next = this.next;
	}

	public int getSize() {
		return size;
	}

	public void increaseSize() {
		size++;
	}

	public void setSize(int i) {
		size = i;
	}
	public void decreaseSize() {
		size--;
		if (size == 0) {
			this.remove();
		}
	}

	public void copyLeft() {
		this.prev.key = this.key;
		this.prev.value = this.value;
	}

	public void copyRight() {
		this.next.key = this.key;
		this.next.value = this.value;
	}

}
