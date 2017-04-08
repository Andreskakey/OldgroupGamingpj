import java.io.*;
import java.util.StringTokenizer;

public class IntDriver {
	
	public static void main(String[] args) {
					
		try {
			printWhen("numbers.txt", new IsOddStrategy());
			printWhen("numbers.txt", new OldSchoolIsOddStrategy());	
		} 
		catch (IOException e) {
			System.err.println("OOPSie: problems reading the file.");
		}

	}

	public static void printWhen(String filename, CheckIntStrategy which) throws IOException 
	{	
		BufferedReader infile = new BufferedReader(new FileReader(filename)); 	// a decorated FileReader!
		String buffer = null;
		
		while((buffer = infile.readLine()) != null) {							// read in a line of text
			StringTokenizer words = new StringTokenizer(buffer);				// chop it up into words
			
			while( words.hasMoreTokens() ) {									// test each word
				int number = Integer.parseInt(words.nextToken());				// Parse string to integer
				if (which.check(number)) {
					System.out.println(number);
				}
			}
		}
		infile.close();
	}
	
	//Overloaded function to be able to handle OldSchoolIsOddStrategy arguments, since it extends CheckStrategy
	
	public static void printWhen(String filename, CheckStrategy which) throws IOException
	{	
		BufferedReader infile = new BufferedReader(new FileReader(filename)); 	// a decorated FileReader!
		String buffer = null;
		
		while((buffer = infile.readLine()) != null) {							// read in a line of text
			StringTokenizer words = new StringTokenizer(buffer);				// chop it up into words
			
			while( words.hasMoreTokens() ) {									// test each word
				String s = words.nextToken();						
				if (which.check(s)) {
					System.out.println(s);
				}
			}
		}
		infile.close();
	}
}
