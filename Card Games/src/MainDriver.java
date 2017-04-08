
public class MainDriver {
static final int HANDS = 52;
	
	public static void main(String[] args) {

		Deck deck = new Deck();
		Deck player2 = new Deck();
		
		int player1Score = 0, player2Score = 0;
		for (int i = 0; i < HANDS; i++){
			
			Card c1 = deck.draw();
			Card c2 = player2.draw();
			
			  System.out.println("Card1: " + c1);
			    System.out.println("Card2: " + c2);
			    
			    if(c1.winner(c2))
			     System.out.println("Winner: " + c1);
			    else
			     System.out.println("Winner: " + c2);
			    System.out.println();
			
		}
		
		
		
		// TODO: gameplay
		
		System.out.printf("Final score: Player 1--%d; Player 2--%d", player1Score, player2Score);
		
		
		
		/*
		 * 
		 * 
		 * Deck deck = new Deck();
   
   for(int i = 0; i < 5; i++)
   {
    Card c1 = deck.draw();
    Card c2 = deck.draw();
      
    System.out.println("Card1: " + c1);
    System.out.println("Card2: " + c2);
    
    if(c1.winner(c2))
     System.out.println("Winner: " + c1);
    else
     System.out.println("Winner: " + c2);
    System.out.println();
    /
   }
 }
 }
		 */
		
		
	}

}