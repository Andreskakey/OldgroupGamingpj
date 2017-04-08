
public class Card {
	
	 private  CardSuit suit;
	 private CardValue face;
	 public Card(CardSuit aSuit, CardValue aFace)
     {
   suit = aSuit;
         face = aFace;       
     }

 
// toString method
 public String toString()
     {
       return face + " of " + suit;    
     }
 


public boolean winner(Card c) {
		// TODO: complete this method definition
	
	// winner method return the winner of two cards

	   if(face.compareTo(c.face) > 0)
	    return true;
	   else if(face.compareTo(c.face) == 0 && suit.compareTo(c.suit) >= 0)
	    return true;
	   else
	    return false;
	 }

}

