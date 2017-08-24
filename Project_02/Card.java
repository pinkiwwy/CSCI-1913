//Name: Wing Yi Wong

package Project2;

import java.util.Random;

//CARD. A playing card. It's immutable.

final class Card
{
	//RANK NAME. Printable names of card ranks.
	private static final String [] rankName =
		{
			"ace",     //   0
			"two",     //   1
			"three",   //   2
			"four",    //   3
			"five",    //   4
			"six",     //   5
			"seven",   //   6
			"eight",   //   7
			"nine",    //   8
			"ten",     //   9
			"jack",    //  10
			"queen",   //  11
			"king"     //  12
		};

	//SUIT NAME. Printable names of card suits.
	private static final String [] suitName =
		{
			"spade",   //  0
			"heart",   //  1
			"diamond", //  2
			"club"     //  3
		};

	private int rank;  //  Card rank, between 0 and 12 inclusive.
	private int suit;  //  Card suit, between 0 and  3 inclusive.

	//CARD. Constructor. Make a new CARD with the given RANK and SUIT.

	public Card(int rank, int suit)
	{
		if (0 <= suit && suit <= 3 && 0 <= rank && rank <= 12)
		{
			this.rank = rank;
			this.suit = suit;
		}
		else
		{
			throw new IllegalArgumentException("No such card.");
		}
	}

	//GET RANK. Return the RANK of this card.

	public int getRank()
	{
		return rank;
	}

	//GET SUIT. Return the SUIT of this card.

	public int getSuit()
	{
		return suit;
	}

	//TO STRING. Return a string that describes this card, for printing only. For
	//example, we might return "the queen of diamonds" or "the ace of hearts".

	public String toString()
	{
		return "the " + rankName[rank] + " of " + suitName[suit] + "s";
	}
}

//class Deck: Each instance represents a deck of Card's
class Deck
{
	private Card[] cards;
	private static final int defaultSize = 52;	
	private Random r = new Random();
	private int numberDealt;
	
	//Constructor
	public Deck()
	{
		int count = 0;
		cards = new Card[defaultSize];	//array card can hold default size of elements
		for (int i = 0; i<=3; i++)
		{
			for (int j = 0; j<= 12; j++)
			{
				cards[count] = new Card(j,i);
				count ++;
			}
		}
	}
	
	public void shuffle()
	{
		if (numberDealt !=0)	//check if any cards in array have been dealt 
		{
			throw new IllegalStateException("Cannot shuffle a deck after the dealing has started");
		}
		for (int i = cards.length-1; i>=1; i--)
		{
			int j = r.nextInt(i);
			Card temp = cards[i];	//exchange the array at indexes i and j using temp
			cards[i] = cards[j];
			cards[j] = temp;
		}
	}
	
	public boolean canDeal()
	{
		return (numberDealt < defaultSize -1);	//check if any cards have not been dealt
	}
	
	public Card deal()
	{
		if (canDeal())
		{
			numberDealt ++;		//count the number of cards have been dealt
			return cards[numberDealt];	//return the NEXT card from the array
		}
		else
		{
			throw new IllegalStateException("No more cards remain to be dealt");
		}
	}
}

//class Tableau: each instance represents a row of piles of Card's
class Tableau
{
	private class Pile	//nested class inside class Tableau
	{
		private Card card;
		private Pile next;
		
		private Pile(Card card, Pile next)	//two slots in constructor
		{
			this.card = card;
			this.next = next;
		}	
	}
	private Pile top;
	
	public Tableau()	//constructor of Tableau
	{
		top = new Pile(null, null);	//make a new empty instance of Tableau
	}
	
	private void addPile(Card card)	//add card to top of pile's
	{
		top = new Pile(card, top);
		System.out.println("Added " + card + ".");
	}
	
	private boolean canMerge()	//test if there are two or more piles && if can put on
	{
		return (hasManyPiles() && canPutOn(top.card, top.next.card));
	}
	
	private boolean canPutOn(Card left, Card right)	//test if pile with left on top can put on pile with right on top
	{
		return ((left.getSuit() == right.getSuit() && left.getRank()<right.getRank()) || 
					left.getSuit() != right.getSuit() && left.getRank()>right.getRank());	
	}
	
	private boolean hasManyPiles()	//test if there are two or more piles
	{
		return (top.card != null && top.next.card != null); 
	}
	
	private void mergeTwoPiles()	//merge the first two piles into one
	{
		if (canMerge())
		{
			
			Pile temp = top.next;
			top.next= temp.next;
			System.out.println("Merged "+ top.card + " and the "+ temp.card );
		}
	}
	
	private void results()	//win if exactly one pile left
	{
		if (!hasManyPiles() && top.card != null)
			System.out.println("Won the game");
		else
			System.out.println("Lost the game");
	}
	
	public void play()	//play the game using classes Card, Deck and methods in Tableau
	{
		Deck game = new Deck();	//create 52 card by calling Deck
		game.shuffle();	//using shuffle in class Deck
		while (game.canDeal())	
		{
			addPile(game.deal());	
			while (canMerge())
			{
				mergeTwoPiles();
			}
		}
		results();	//print result at the end
	}	
}

//Driver class
class Driver
{
	public static void main(String[] args)
	{
		Tableau start = new Tableau();	//create instance of Tableau
		start.play();	//using the play method in Tableau
	}
}
