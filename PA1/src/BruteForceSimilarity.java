import java.util.ArrayList;

// LEAVE THIS FILE IN THE DEFAULT PACKAGE
//  (i.e., DO NOT add 'package cs311.pa1;' or similar)

// DO NOT MODIFY THE EXISTING METHOD SIGNATURES
//  (you may, however, add member fields and additional methods)

// DO NOT INCLUDE LIBRARIES OUTSIDE OF THE JAVA STANDARD LIBRARY
//  (i.e., you may include java.util.ArrayList etc. here, but not junit, apache commons, google guava, etc.)

/**
* @author Hugh Potter & Bradley Bales
*/

public class BruteForceSimilarity {

	int sLength;
	ArrayList<String> S, T, //Shingles of s1 and s2 respectfully
			SNoDup, TNoDup; // Without duplication
	int[] occurance1, occurance2;
	
	BruteForceSimilarity(String s1, String s2, int sLength) {
		int i, j, k;
		char[] charr = new char[sLength];
		this.sLength = sLength;
		SNoDup = TNoDup = null;
		
		k = s1.length() - sLength;
		for(i = 0; i < k; i++) {
			for(j = 0; j < sLength; j++) {
				charr[j] = s1.charAt(i + j);
			}
			S.add(new String(charr));
		}
		
		k = s2.length() - sLength;
		for(i = 0; i < k; i++) {
			for(j = 0; j < sLength; j++) {
				charr[j] = s2.charAt(i + j);
			}
			T.add(new String(charr));
		}
		return;
	}
	
	public float lengthOfS1() {
		return vectorLength(S, true); //STUB
	}
	
	public float lengthOfS2() {
		return vectorLength(T, false);
	}
	
	public float similarity() {
		int i, j;
		float d = lengthOfS1() * lengthOfS2(), //Denominator.
				n = 0;
		
		//Determining the numerator. 
		//NOTE: we only have to do this once since the numerator is determined by |i in s1| * |i in s2|, meaning that if one of the elements
		//		existed only in one of the strings, there's no need to find it in the second array.
		if(SNoDup.size() < TNoDup.size()) {
			for(i = 0; i < SNoDup.size(); i++) {
				j = 0;
				while(j < TNoDup.size()) {
					if(SNoDup.get(i).equals(TNoDup.get(j))){
						n += occurance1[i] * occurance2[j];
						break;
					}
					j++;
				}
			}
		}else{
			for(i = 0; i < TNoDup.size(); i++) {
				j = 0;
				while(j < SNoDup.size()) {
					if(TNoDup.get(i).equals(SNoDup.get(j))){
						n += occurance2[i] * occurance1[j];
						break;
					}
					j++;
				}
			}
		}
		
		return n / d;
	}
	
	private float vectorLength(ArrayList<String> list, boolean isS1) {
		int i, j;
		float r = 0;
		ArrayList<String> lis = new ArrayList<String>(list);// Copying so that we can remove elements;
		int[] occurance = new int[lis.size()];
		
		// Getting occurance of each element.
		for(i = 0; i < lis.size(); i++) {
			occurance[i] = 1;
			j = i + 1;
			while(j < lis.size()) {
				if(lis.get(i).equals(lis.get(j))) {
					lis.remove(j);
					occurance[j]++;
				}else {
					j++;
				}
			}
		}
		for(i = 0; i < lis.size(); i++) {
			r += occurance[i]*occurance[i];
		}
		if(isS1) {//Spaghetti code, I know
			occurance1 = occurance;
			SNoDup = new ArrayList<String>(lis);
		}else{
			occurance2 = occurance;
			TNoDup = new ArrayList<String>(lis);
		}
		return (float) Math.sqrt(r); 
	}
}