package edu.ramapo.akarki.cansata.model;

final class ValidRankSuit {
    // p_rankList lists all the rank of card in a standard deck
	// of card and last J for Joker
	final static String p_rankList = "23456789XJQKAJ";

	// p_suitList lists all the suit of card in a standard deck
	// of card and 1 and 2 for Joker
	// S = spade, C = club, H = heart, and D = diamond
	final static String p_suitList = new String("SCHD12");

	/**
	Contructor for ValidRankSuit Class.
	@param none
	@return none
	*/
	private ValidRankSuit() {}
	
	/**
	Checks if the passed rank is valid rank or not.
	@param a_rank, a const character. It holds the rank that needs to be 
		validated
	@return boolean value, true if a_rank is valid
	*/
	static boolean IsRankValid( final Character a_rank )
	{
		return p_rankList.indexOf( a_rank) != -1;
	}

	/**
	Checks if the passed suit is valid suit or not. 
	@param a_suit, a const character. It holds the suit that needs to be 
		validated
	@return boolean value, true if a_suit is valid
	*/
	static boolean IsSuitValid( final char a_suit )
	{
		return p_suitList.indexOf( a_suit) != -1;
	}

	/**
	Checks if the passed a_rankSuit is valid or not.
	@param a_rankSuit, a const string. It holds the rank and suit that needs to
		be validated. The rank is the 0th character and suit is the 1th 
		character
	@return boolean value, true if a_suit is valid
	*/	
	static boolean IsRankSuitValid( final String a_rankSuit)
	{
		return a_rankSuit.length() == 2
				&& IsRankValid(a_rankSuit.charAt(0))
				&& IsSuitValid(a_rankSuit.charAt(1));
	}
}
