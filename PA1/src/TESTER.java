
public class TESTER {

	public static void main(String [ ] args){
		
		HashTable table = new HashTable(10);
		HashFunction hash = new HashFunction(10);
		
		table.add(new Tuple(1, "Hello"));			
		table.add(new Tuple(1, "Goodbye"));
		table.add(new Tuple(2, "hello"));
		table.add(new Tuple(1, "yes"));
		table.add(new Tuple(3, "no"));
		table.add(new Tuple(2, "yesagain"));
		table.add(new Tuple(1, "noagain"));
		table.add(new Tuple(1, "yes"));
		table.add(new Tuple(1, "yes"));
		table.add(new Tuple(1, "NO!"));
			
		table.maxLoad();
			
	}
}