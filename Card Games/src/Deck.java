import java.util.Random;

public class Deck {

	 private Random random;
	 private final int NUMBER_OF_CARDS = 52;
	 private Card[] cards;
	 private CardSuit[] suits;
	 private CardValue[] faces;
	 private int index;
	 
	 public Deck()
	 {
	   suits = CardSuit.values();
	   faces = CardValue.values();  
	   index = 0;
	     
	   cards = new Card[NUMBER_OF_CARDS];
	     
	   for(CardSuit s : suits)
	   {
	    for(CardValue f: faces)
	    {
	     cards[index] = new Card(s, f);
	     index++;
	    }
	   }
	   
	   random = new Random();
	 }

	 // draw method returns a random card
	 public Card draw()
	 {
	   int s = random.nextInt(suits.length);
	   int f = random.nextInt(faces.length);
	   Card card = new Card(suits[s], faces[f]);  
	   return card;
	 }
	 }