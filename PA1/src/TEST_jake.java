import java.util.Random;

public class TEST_jake {

	static public void main(String args[]){
		
		Random rand = new Random();
		
		char[] charArr = "abcd".toCharArray();
		
		HashTable testTable = new HashTable(50);
		
		for(int i = 0; i < 10; i++){
			String str = "";
//			for(int j = 0; j < 4; j++){
//				int r = Math.abs(rand.nextInt() % charArr.length);
//				str = str + charArr[r];
//			}
			//testTable.add(new Tuple(rand.nextInt(), str));
		}
		testTable.printTable();
	}
	
}
