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
		int hashValue = 0, alpha = 31, alphaPow = 31;
		
		
		// implementation
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