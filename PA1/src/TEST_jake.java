import java.util.Random;

public class TEST_jake {

	static public void main(String args[]){
		
		
		int elements = 17;
		int range = 10;
		
		
		Random rand = new Random(20);
		char[] charArr = "abcd".toCharArray();
		
		HashTable table = new HashTable(range);
		
		
		/*
		
		for(int i = 0; i < elements; i++){
			String str = "";
			for(int j = 0; j < charArr.length; j++){
				str = str + charArr[rand.nextInt(charArr.length)];
			}
			table.add(new Tuple(rand.nextInt(range), str));
		}
		*/
		
		table.add(new Tuple(20, "Yea"));
		table.add(new Tuple(20, "Yeh"));
		table.add(new Tuple(20, "Yah"));
		table.add(new Tuple(20, "eah"));
		table.add(new Tuple(20, "yeah"));
		table.add(new Tuple(20, "eah"));
		table.add(new Tuple(20, "eahy"));

		table.add(new Tuple(20, "Yeh"));
		table.add(new Tuple(20, "Yah"));
		table.add(new Tuple(20, "eah"));
		table.add(new Tuple(20, "yeah"));
		table.add(new Tuple(20, "eah"));
		table.add(new Tuple(20, "eahy"));
		
		table.printTable();
		System.out.println();
		table.remove(new Tuple(20, "Yea"));
		table.printTable();
		System.out.println();
		
		
		
		
	}
	
}
