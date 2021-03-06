import java.util.ArrayList;

// LEAVE THIS FILE IN THE DEFAULT PACKAGE
//  (i.e., DO NOT add 'package cs311.pa1;' or similar)

// DO NOT MODIFY THE EXISTING METHOD SIGNATURES
//  (you may, however, add member fields and additional methods)

// DO NOT INCLUDE LIBRARIES OUTSIDE OF THE JAVA STANDARD LIBRARY
//  (i.e., you may include java.util.ArrayList etc. here, but not junit, apache commons, google guava, etc.)

/**
* @author Hadis Fetic, Jacob R. Pratt, Bradley Bales
*/

public class HashCodeSimilarity
{

		Tuple[] SnoDup, TnoDup;
		HashTable SH, TH, UH;
		public HashCodeSimilarity(String s1, String s2, int sLength)
		{
			
			if(sLength> s1.length() || sLength > s2.length() ||sLength <= 0){
				throw new NullPointerException();
			}
			
			int dupCount = 1;
			
			Tuple dupTest;

			SnoDup = new Tuple[s1.length() - sLength + 1];
			TnoDup = new Tuple[s2.length() - sLength + 1];
			
			SH = new HashTable(s1.length() - sLength + 1);
			TH = new HashTable(s2.length() - sLength + 1);
			
			char[] charr = new char[sLength];
			char[] charrS2 = new char[sLength];
			long hashValue = 0, firstVal = 0, hashValueS2 = 0, firstValS2 = 0;
			long alpha = 31, alphaPow = 31;
			
			hashValue = s1.charAt(sLength-1);
			charr[sLength - 1] = s1.charAt(sLength-1);
			hashValueS2 = s2.charAt(sLength-1);
			charrS2[sLength - 1] = s2.charAt(sLength-1);
			
			if(sLength == 1){
				firstVal = hashValue;
				firstValS2 = hashValueS2;
				alphaPow = 1;
				alpha = 1;
			}
			
			for(int i = sLength - 2; i >= 0; i --){
				charr[i] = s1.charAt(i);
				charrS2[i] = s2.charAt(i);
				if(i == 0){
					firstVal = (int) Math.abs(s1.charAt(i) * alphaPow);
					hashValue = Math.abs(hashValue + firstVal);
					
					firstValS2 = (int) Math.abs(s2.charAt(i) * alphaPow);
					hashValueS2 = Math.abs(hashValueS2 + firstValS2);
				}else{
					hashValue =  Math.abs(hashValue + Math.abs(s1.charAt(i) * alphaPow));
					hashValueS2 = Math.abs(hashValueS2 + Math.abs(s2.charAt(i) * alphaPow));
					alphaPow = alphaPow * alpha;
				}
			}
			SnoDup[0] = new Tuple((int) hashValue, "");
			SH.add(new Tuple((int) hashValue, ""));

			TnoDup[0] = new Tuple((int) hashValueS2, "");
			TH.add(new Tuple((int) hashValueS2, ""));

			
			for(int i = 1; i <= s1.length() - sLength; i++ ){
				hashValue = Math.abs(((hashValue - firstVal)*alpha) + s1.charAt(i + sLength - 1));
				firstVal = Math.abs(s1.charAt(i) *alphaPow);
				dupTest = new Tuple((int) hashValue, "");
				if(SH.search(dupTest) == 0){
					SnoDup[dupCount]=dupTest;
					dupCount ++;
				}
				SH.add(new Tuple((int) hashValue, ""));
			}
			
			dupCount = 1;
			for(int i = 1; i <= s2.length() - sLength; i++ ){
				hashValueS2 = Math.abs(((hashValueS2 - firstValS2)*alpha) + s2.charAt(i + sLength - 1));
				firstValS2 = Math.abs(s2.charAt(i) *alphaPow);
				dupTest = new Tuple((int) hashValueS2, "");
				if(TH.search(dupTest) == 0){
					TnoDup[dupCount]=dupTest;
					dupCount ++;
				}
				TH.add(new Tuple((int) hashValueS2, ""));
			}
		}

		public float lengthOfS1()
		{
			// implementation
			return vectorLength(true);
		}

		public float lengthOfS2()
		{
			// implementation
			return vectorLength(false);
		}

		public float similarity()
		{
			float d = lengthOfS1() * lengthOfS2(), //Denominator.
					n = 0;
			
			for(int i = 0; i< SnoDup.length; i ++){
				if(SnoDup[i] == null){
					break;
				}
				n += SH.search(SnoDup[i]) * TH.search(SnoDup[i]);
			}

			return n/d;
		}
		
		private float vectorLength(boolean SorT) {
			int value = 0;
			int counter = 0;
			Tuple[] dup;
			HashTable tmpTable;
			
			//Determine which set we are dealing with, and assigns tmp as a reference;
			if(SorT){
				tmpTable = SH;
				dup = SnoDup;
			}else{
				tmpTable = TH;
				dup = TnoDup;
			}
			
			for(int i = 0; i < dup.length; i++)
			{
				if(dup[i] == null){
					break;
				}
				counter = tmpTable.search(dup[i]);
				
				value += counter *counter;
				
			}

			return (float) Math.sqrt(value);
		}
}