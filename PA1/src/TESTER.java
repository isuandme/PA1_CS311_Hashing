
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TESTER {
	
	public static void main(String [] args){
		
//		// The name of the file to open.
//        String fileNameS1 = "/Users/Hadis/Documents/com311/pa1/PA1_CS311_Hashing/shak1";
//        String fileNameS2 = "/Users/Hadis/Documents/com311/pa1/PA1_CS311_Hashing/shak2";
//
//        // This will reference one line at a time
//        String line = null;
//        String shak1 = "";
//        String shak2 = "";

        /*
        try {
            FileReader fileReader = new FileReader(fileNameS1);
            FileReader fileReaderS2 = new FileReader(fileNameS2);


            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            BufferedReader bufferedReaderS2 = new BufferedReader(fileReaderS2);
            
      
            while((line = bufferedReader.readLine()) != null) {
                shak1 += line;
            }  

            while((line = bufferedReaderS2.readLine()) != null) {
                shak2 += line;
            } 


            bufferedReader.close(); 
            bufferedReaderS2.close();
        }
        catch(FileNotFoundException ex) {
        	ex.printStackTrace();
        }
        catch(IOException ex) {
        	ex.printStackTrace();
        }
        */
//        shak1 = "A rose is a rose is a rose";
//        shak2 = "A rose is a flower, which is a rose.";
//        //remove white space, punctuation, and convert to lowercase
//        shak1=shak1.replaceAll("\\s+","");
//        shak1=shak1.replaceAll("[^a-zA-Z0-9 ]", ""); 
//        shak1=shak1.toLowerCase();
//        System.out.println(shak1);
//
//        shak2=shak2.replaceAll("\\s+","");
//        shak2=shak2.replaceAll("[^a-zA-Z0-9 ]", ""); 
//        shak2=shak2.toLowerCase();
//        System.out.println(shak2);
//        System.out.println("Shak1: "+ shak1.length() + " Shak2: "+ shak2.length());
//        try
//        {
//        	long t =  System.currentTimeMillis();
//        	BruteForceSimilarity bs = new BruteForceSimilarity(shak1,shak2,8);
//        	
//            System.out.println(bs.similarity());
//            t = System.currentTimeMillis() - t;
//            System.out.println(t);
//        }
//        catch(NullPointerException e)
//        {
//            System.out.println("sLength cannot be larger then either of the strings!");
//        }
       

		//Random rand = new Random();
		int range = 10;
		HashTable table = new HashTable(range);
		Random rand = new Random();
		char[] abc = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		
		for(int i = 0; i < 100; i++){
			String str = new String("");
			for(int j = 0; j < 4; j++){
				int let = rand.nextInt(4);
				str = str + abc[let];
			}
			table.add(new Tuple(rand.nextInt(range), str));
		}
		
		table.printTable();
		System.out.println();
		
		
		
		

	}
}
