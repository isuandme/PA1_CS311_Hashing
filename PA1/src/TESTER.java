import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TESTER {
	
	public static void main(String [] args){

		Random rand = new Random();
		int range = 12;
		HashTable table = new HashTable(range);
		
		Scanner userInput = new Scanner(System.in);
		
		table.add(new Tuple(4, "你"));
		table.add(new Tuple(5, "Yes"));
		table.add(new Tuple(6, "Okay"));
		table.add(new Tuple(7, "Fine"));
		table.add(new Tuple(8, "Whynot"));
		table.add(new Tuple(rand.nextInt(range), "wubble"));
		table.add(new Tuple(rand.nextInt(range), "Dubble"));
		table.add(new Tuple(4, "你"));
		table.add(new Tuple(rand.nextInt(range), "好"));
		table.add(new Tuple(rand.nextInt(range), "Yes"));
		table.add(new Tuple(rand.nextInt(range), "Okay"));
		table.add(new Tuple(rand.nextInt(range), "Fine"));
		table.add(new Tuple(rand.nextInt(range), "Whynot"));
		table.add(new Tuple(rand.nextInt(range), "wubble"));
		table.add(new Tuple(rand.nextInt(range), "Dubble"));
		table.add(new Tuple(rand.nextInt(range), "你"));
		table.add(new Tuple(rand.nextInt(range), "好"));
		table.add(new Tuple(rand.nextInt(range), "Yes"));
		table.add(new Tuple(rand.nextInt(range), "Okay"));
		table.add(new Tuple(rand.nextInt(range), "Fine"));
		table.add(new Tuple(rand.nextInt(range), "Whynot"));
		table.add(new Tuple(rand.nextInt(range), "wubble"));
		table.add(new Tuple(rand.nextInt(range), "Dubble"));
		table.add(new Tuple(rand.nextInt(range), "你"));
		table.add(new Tuple(rand.nextInt(range), "好"));
		table.add(new Tuple(rand.nextInt(range), "Yes"));
		table.add(new Tuple(rand.nextInt(range), "Okay"));
		table.add(new Tuple(rand.nextInt(range), "Fine"));
		table.add(new Tuple(rand.nextInt(range), "Whynot"));
		table.add(new Tuple(rand.nextInt(range), "wubble"));
		table.add(new Tuple(rand.nextInt(range), "Dubble"));
		table.add(new Tuple(rand.nextInt(range), "你"));
		table.add(new Tuple(rand.nextInt(range), "好"));
		table.add(new Tuple(rand.nextInt(range), "Yes"));
		table.add(new Tuple(rand.nextInt(range), "Okay"));
		table.add(new Tuple(rand.nextInt(range), "Fine"));
		table.add(new Tuple(rand.nextInt(range), "Whynot"));
		table.add(new Tuple(rand.nextInt(range), "wubble"));
		table.add(new Tuple(rand.nextInt(range), "Dubble"));
		table.add(new Tuple(rand.nextInt(range), "你"));
		table.add(new Tuple(rand.nextInt(range), "好"));
		table.add(new Tuple(rand.nextInt(range), "Yes"));
		table.add(new Tuple(rand.nextInt(range), "Okay"));
		table.add(new Tuple(rand.nextInt(range), "Fine"));
		table.add(new Tuple(rand.nextInt(range), "Whynot"));
		table.add(new Tuple(rand.nextInt(range), "wubble"));
		table.add(new Tuple(rand.nextInt(range), "Dubble"));
		table.add(new Tuple(rand.nextInt(range), "你"));
		table.add(new Tuple(4, "你"));
		
		table.printTable();
		/*
		 * 
		 * The following tests the search(Tuple t); method.
		 * 
		Tuple test1 = new Tuple(4, "你");
		int i = table.search(test1);
		System.out.println();
		System.out.println("Test 1: " + i);	
		*/
		
		
		/*
		 * This method Tests the search(int k): method.
		 *
		int k = 4;
		ArrayList<Tuple> test1 = table.search(k);
		System.out.println();
		System.out.print("ArrayList Pulled with " + k + " key value:  -->  ");
		for(int i = 0; i < test1.size(); i++){
			test1.get(i).print();
		}
		*/
		
		/*
		 * The follwing code tests the remove method in HashTable
		 */
		System.out.println();
		System.out.println();
		System.out.println();
		Tuple test2 = new Tuple(4, "你");
		table.remove(test2);
		table.printTable();
		
		
		
		
		
		userInput.close();
	}
}
