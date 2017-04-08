import java.io.*;
import java.util.StringTokenizer;

public class Driver {
	
	public static void main(String[] args) {
					
		AndStrategyComposite andCheck = new AndStrategyComposite();
		andCheck.addStrategy(new Palindrome());
		andCheck.addStrategy(new LongerThanN(6));
		
		OrStrategyComposite orCheck = new OrStrategyComposite();
		orCheck.addStrategy(new Palindrome());
		orCheck.addStrategy(new LongerThanN(6));
		
		CounterDecorator paliAnd6 = new CounterDecorator(andCheck); //Used CounterDecorator to keep count
		CounterDecorator paliOr6 = new CounterDecorator(orCheck);
		
		try {
			/*
			//Gutenberg.txt does not have any palindrome words, so I created another file to test more effectively.

			printWhen("gutenberg.txt", paliAndLonger6);
			System.out.println("Longer than 6 characters and palindrome word count is: " + paliAnd6.count());
			printWhen("gutenberg.txt", paliOrLonger6);
			System.out.println("Longer than 6 characters or palindrome word count is: " + paliOr6.count());
			*/
			
			printWhen("palindromes.txt", paliAnd6);
			System.out.println("Longer than 6 characters and palindrome word count is: " + paliAnd6.count());
			
			printWhen("palindromes.txt", paliOr6);
			System.out.println("Longer than 6 characters or palindrome word count is: " + paliOr6.count());
			
		} catch (IOException e) {
			System.err.println("OOPSie: problems reading the file.");
		}

	}

	public static void printWhen(String filename, CounterDecorator which) throws IOException 
	{	
		BufferedReader infile = new BufferedReader(new FileReader(filename)); // a decorated FileReader!
		String buffer = null;
		
		while((buffer = infile.readLine()) != null) {							// read in a line of text
			StringTokenizer words = new StringTokenizer(buffer);				// chop it up into words
			
			while( words.hasMoreTokens() ) {									// test each word
				String word = words.nextToken();
				if (which.check(word)) {
					System.out.println(word);
				}
			}
		}
		infile.close();
	}
}
