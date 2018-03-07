// LEAVE THIS FILE IN THE DEFAULT PACKAGE
//  (i.e., DO NOT add 'package cs311.pa1;' or similar)

// DO NOT MODIFY THE EXISTING METHOD SIGNATURES
//  (you may, however, add member fields and additional methods)

// DO NOT INCLUDE LIBRARIES OUTSIDE OF THE JAVA STANDARD LIBRARY
//  (i.e., you may include java.util.ArrayList etc. here, but not junit, apache commons, google guava, etc.)

/**
* @author Hugh Potter
*/

public class HashStringSimilarity
{
	// member fields and other member methods
	Tuple[] S, T;
	HashTable SH, TH;
	public HashStringSimilarity(String s1, String s2, int sLength)
	{
		S = new Tuple[s1.length() - sLength + 1];
		T = new Tuple[s2.length() - sLength + 1];
		
		SH = new HashTable(s1.length() - sLength + 1);
		TH = new HashTable(s2.length() - sLength + 1);
		
		char[] charr = new char[sLength];
		char[] charrS2 = new char[sLength];
		int hashValue = 0, firstVal = 0, hashValueS2 = 0, firstValS2 = 0, alpha = 31, alphaPow = 31;
		
		hashValue = s1.charAt(sLength-1);
		charr[sLength - 1] = s1.charAt(sLength-1);
		hashValueS2 = s2.charAt(sLength-1);
		charrS2[sLength - 1] = s2.charAt(sLength-1);
		
		for(int i = sLength - 2; i >= 0; i --){
			charr[i] = s1.charAt(i);
			charrS2[i] = s2.charAt(i);
			if(i == 0){
				firstVal = Math.abs(s1.charAt(i) * alphaPow);
				hashValue = Math.abs(hashValue + firstVal);
				
				firstValS2 = Math.abs(s2.charAt(i) * alphaPow);
				hashValueS2 = Math.abs(hashValueS2 + firstValS2);
			}else{
				hashValue = Math.abs(hashValue + Math.abs(s1.charAt(i) * alphaPow));
				hashValueS2 = Math.abs(hashValueS2 + Math.abs(s2.charAt(i) * alphaPow));
				alphaPow = alphaPow * alpha;
			}
		}
		S[0] = new Tuple(hashValue, new String(charr));
		SH.add(S[0]);
		T[0] = new Tuple(hashValueS2, new String(charrS2));
		TH.add(T[0]);
		
		for(int i = 1; i <= s1.length() - sLength; i++ ){
			hashValue = Math.abs(((hashValue - firstVal)*alpha) + s1.charAt(i + sLength - 1));
			firstVal = Math.abs(s1.charAt(i) *alphaPow);
			S[i] = new Tuple(hashValue, s1.substring(i, i+ sLength));
			SH.add(S[i]);
		}
		
		for(int i = 1; i <= s2.length() - sLength; i++ ){
			hashValueS2 = Math.abs(((hashValueS2 - firstValS2)*alpha) + s2.charAt(i + sLength - 1));
			firstValS2 = Math.abs(s2.charAt(i) *alphaPow);
			T[i] = new Tuple(hashValueS2, s2.substring(i, i + sLength));
			TH.add(T[i]);
		}
	}

	public float lengthOfS1()
	{
		// implementation
		return 0;
	}

	public float lengthOfS2()
	{
		// implementation
		return 0;
	}

	public float similarity()
	{
		// implementation
		return 0;
	}
}