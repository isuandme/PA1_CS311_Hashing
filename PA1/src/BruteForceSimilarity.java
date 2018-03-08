import java.util.ArrayList;

// LEAVE THIS FILE IN THE DEFAULT PACKAGE
//  (i.e., DO NOT add 'package cs311.pa1;' or similar)

// DO NOT MODIFY THE EXISTING METHOD SIGNATURES
//  (you may, however, add member fields and additional methods)

// DO NOT INCLUDE LIBRARIES OUTSIDE OF THE JAVA STANDARD LIBRARY
//  (i.e., you may include java.util.ArrayList etc. here, but not junit, apache commons, google guava, etc.)

/**
* @author Hadis Fetic
*/

//Created a Pair because I didnt want to change Tuple
class Pair{
	private String value;
	private int count;
	Pair(String value){
		this.value = value;
		this.count = 0;
	}
	
	public String getVal(){
		return value;
	}
	public int getCount(){
		return count;
	}
	public void setCount(int i){
		count = i;
	}
}
public class BruteForceSimilarity {

	int sLength;
	Pair[] S, T, SnoDup, TnoDup; //Shingles of s1 and s2 respectfully
	
	BruteForceSimilarity(String s1, String s2, int sLength) {
		int k;
		//check to see if sLength is larger then either string.
		if(sLength> s1.length() || sLength > s2.length()){
			throw new NullPointerException();
		}
		//initialize all the values;
		S 			 = new Pair[s1.length() - sLength + 1];
		T 			 = new Pair[s2.length() - sLength + 1];
		
		//we cannot have more duplicates then substrings so this is as large of an array as we need.
		SnoDup 		 = new Pair[s1.length() - sLength + 1];
		TnoDup 		 = new Pair[s2.length() - sLength + 1];
		char[] charr = new char[sLength];
		this.sLength = sLength;
		
		
		//create a Mset of pair values 
		k = s1.length() - sLength;
		for(int i = 0; i <= k; i++) 
		{
			for(int j = 0; j < sLength; j++) 
			{
				charr[j] = s1.charAt(i + j);
			}
			S[i] = new Pair(new String(charr));
		}
		
		k = s2.length() - sLength;
		for(int i = 0; i <= k; i++) 
		{
			for(int j = 0; j < sLength; j++) 
			{
				charr[j] = s2.charAt(i + j);
			}
			T[i] = new Pair(new String(charr));
		}
		return;
	}
	
	public float lengthOfS1() 
	{
		return vectorLength(S,true); //STUB
	}
	
	public float lengthOfS2() 
	{
		return vectorLength(T,false);
	}
	
	public float similarity() 
	{
		float d = lengthOfS1() * lengthOfS2(), //Denominator.
				n = 0;
		
		
		for(int i = 0; i < SnoDup.length; i++)
		{
			//If we reached a null value that means we have no more pairs and can break out of the loop.
			if(SnoDup[i] == null)
			{
				break;
			}
			
			for(int j = 0; j < TnoDup.length; j++)
			{
				//We ran out of pairs.
				if(TnoDup[j] == null)
				{
					break;
				}
				
				if(SnoDup[i].getVal().equals(TnoDup[j].getVal())){
					n += SnoDup[i].getCount() * TnoDup[j].getCount();
					break;
				}
				
			}
			
		}
	
		System.out.println(n);
		return n / d;
	}
	
	private float vectorLength(Pair[] list,boolean SorT) {
		int value = 0;
		
		//we need a count to keep track of where to add new duplicate pair.
		int dupCount = 0;
		int counter;
		Pair[] tmp;
		int testCount = 0;
		
		//Determine which set we are dealing with, and assigns tmp as a reference;
		int totalNum = 0;
		if(SorT){
			tmp = SnoDup;

		}else{
			tmp = TnoDup;

		}
		for(int i = 0; i < list.length; i++){
			counter = 1;
			
			//If we already visited this value then skip this iteration.
			if(list[i].getCount() == 1){
				continue;
			}
			
			//indicate we have visited this value now.
			list[i].setCount(1);
			
			
			tmp[dupCount] = new Pair(list[i].getVal());

			for (int j = i; j < list.length; j++){
				if (list[i].getVal().equals(list[j].getVal()) && list[j].getCount() == 0){
					list[j].setCount(1);
					counter++;}
			}

			tmp[dupCount].setCount(counter);
			dupCount ++;
			if(counter > 2){
				testCount ++;
			}
        	value += counter*counter;
		}
		
		//apparently Math.sqrt is O(1)
		System.out.println( value);
		return (float) Math.sqrt(value);
	}
}
