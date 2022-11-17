package edu.ramapo.akarki.canasta.model;

import java.util.Vector;

public class Player {
	// cards of the player
	protected Hand mPlayerHand;

	// holds the point of the player
	protected Integer mTotalPoints;

	// holds the state of to whether to show menu that
	// before the turn actually starts
	protected boolean mShowBeforeTurnMenu;

	// holds the state of current turn
	// is true if this is the start of the turn
	protected boolean mIsStartOfTurn;

	// holds the value of it the player went out
	protected boolean mWentOut;

	/**
	 * default constructor
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	Player()
	{
		mPlayerHand = new Hand();
		mTotalPoints = 0;
		mShowBeforeTurnMenu = true;
		mIsStartOfTurn = true;
		mWentOut = false;

	}

	/**
	 * construct a Player object and to populate its member variables
	 * m_playerHand is populated using the passed parameter.
	 * 
	 * @param a_totalScore, a unsinged integer containing the player's total
	 *                          score.
	 * @param a_handCards,  a string containing the rank and suit of cards. Each
	 *                          card is seperated by blank space.
	 * @param a_meldCards,  a string containing the rank and suit of cards in
	 *                          the m_stock. Each card is seperated by blank
	 *                          space and each meld is inside '[' and ']'
	 * 
	 * @return none
	 */
	Player(Integer aTotalScore, String aHandCards, String aMeldCards)
	{

	}

	/**
	 * To create a new Player object and copy the passed Player object's member
	 * variables data into the newly created Player object
	 * 
	 * @param aOtherPlayer, a object of Player class passed. It holds a Player
	 *                          object to be copied.
	 * 
	 * @return none
	 */
	Player(Player aOtherPlayer)
	{}

	/**
	 * toString funciton
	 * 
	 * @param none
	 * 
	 * @return card in the hand in the printed format
	 */
	@Override
	public String toString()
	{
		return mPlayerHand.toString();
	}

	/**
	 * gets the saved current point
	 * 
	 * @param none
	 * 
	 * @return total point of the player
	 */
	int getTotalPoint()
	{
		return mTotalPoints;
	}

	/**
	 * Get players actual hand
	 * 
	 * @param none
	 * 
	 * @return Vector of Cards object that holds player's actual hand
	 */
	Vector<Card> getActualHand()
	{
		return mPlayerHand.getActualHand();
	}

	/**
	 * Get players melds
	 * 
	 * @param none
	 * 
	 * @return Vector of Vector Cards object that holds player's melds
	 */
	Vector<Vector<Card>> getMelds()
	{
		return mPlayerHand.getMelds();
	}

	/**
	 * Get players actual hand in string format
	 * 
	 * @param none
	 * 
	 * @return String that holds player's actual hand in printed format
	 */
	String getActualHandString()
	{
		return mPlayerHand.getActualHandString();
	}

	/**
	 * Get players melds in string format
	 * 
	 * @param none
	 * 
	 * @return String that holds player's meld in printed format
	 */
	String getMeldsString()
	{
		return mPlayerHand.getMeldsString();
	}

	/**
	 * Get players went_out status
	 * 
	 * @param none
	 * 
	 * @return players went_out status
	 */
	boolean getPlayerWentOutStatus()
	{
		return mWentOut;
	}

	/**
	 * get players before_turn_flag status
	 * 
	 * @param none
	 * 
	 * @return players before_turn_flag status
	 */
	boolean getTurnStartFlag()
	{
		return mIsStartOfTurn;
	}

	/**
	 * getter funciton to get the actual hand in divided format where each ranks
	 * are seperated into its own list
	 * 
	 * @param none
	 * 
	 * @return Vector of Vector of Card where each Vector of Cards have the same
	 *         ranks. All the ranks are in ascending order.
	 */
	Vector<Vector<Card>> getDividedAcualHandCardList()
	{
		return mPlayerHand.getDividedAcualHandCardList();
	}

	/**
	 * set players went_out status
	 * 
	 * @param aPlayerWentOut players went_out status
	 * 
	 * @return true to indicate success
	 */
	boolean setPlayerWentOutStatus(boolean aPlayerWentOut)
	{
		mWentOut = aPlayerWentOut;
		return true;
	}

	/**
	 * set players before_turn_flag status
	 * 
	 * @param aShowBeforeTurnMenu players before_turn_flag status
	 * 
	 * @return true to indicate success
	 */
	boolean setPlayerBeforeTurnMenuFlag(boolean aShowBeforeTurnMenu)
	{
		mShowBeforeTurnMenu = aShowBeforeTurnMenu;
		return true;
	}

	/**
	 * set players turn_start_flag status
	 * 
	 * @param aShowTurnStartMenu players turn_start_flag status
	 * 
	 * @return true to indicate success
	 */
	boolean setTurnStartFlag(boolean aShowTurnStartMenu)
	{
		mIsStartOfTurn = aShowTurnStartMenu;
		return true;
	}

	/**
	 * Contains the logic for start of the turn asks user for what to do
	 * 
	 * @param aOtherPlayerMeld vector of vector of cards that holds the melds
	 *                             that are in the other player's hand
	 * @param aDiscardPile     vector of cards that holds all the cards that are
	 *                             currently in discard pile
	 * 
	 * @return pair of <integer , std::vector<unsigned>>. The first interger
	 *         indicates where this was--that is beforeTurnStartLogic == 1,
	 *         turnStartLlogic == 2, or afterTurnStartLogic == 3 or 10 for
	 *         invalid input. the second is vector of unsinged integer whose
	 *         first element is always the sub menu index or 10 for invalid
	 *         input and every thing after that is what the it sub menus's
	 *         funciton needs
	 */
	Pair<Integer, Vector<Integer>> playerTurnController(
			Vector<Vector<Card>> aOtherPlayerMeld, Vector<Card> aDiscardPile)
	{
		return new Pair<Integer, Vector<Integer>>(0, new Vector<Integer>());
	}

	/**
	 * Contains the controller for before a turn starts and asks the user to
	 * chose from "Save the game", "Take a turn" , or "Quit the game and go to
	 * main menu"
	 * 
	 * @param nones
	 * 
	 * @return Pair of <Integer , Vector<Integer>>. The first interger indicates
	 *         this was--that is beforeTurnStartLogic so it is always 1. the
	 *         second is vector of unsinged integer of size 1 and the the
	 *         vector's first element is the sub menu index.
	 */
	Pair<Integer, Vector<Integer>> beforeTurnStartControl()
	{
		return new Pair<Integer, Vector<Integer>>(0, new Vector<Integer>());
	}

	/**
	 * Contains the controller for turn starts. this is executed when two is
	 * selected from beforeTurnStartControl. It asks user to chose from "draw a
	 * card from deck", "pick up the discard pile", "Ask for Help", "show
	 * discard pile", or "show stock card (for debugging)"
	 * 
	 * @param aDiscardPile, vector of cards that contains the discard pile
	 * 
	 * @return Pair of <Integer , Vector<Integer>>. The first interger indicates
	 *         this was--that is TurnStartconstrol so it is always 2. the second
	 *         is vector of unsinged integer of size 1 and the the vector's
	 *         first element is the sub menu index. Algorithm:
	 */
	Pair<Integer, Vector<Integer>> turnStartControl(Vector<Card> aDiscardPile)
	{

		return new Pair<Integer, Vector<Integer>>(0, new Vector<Integer>());
	}

	/**
	 * Contains the controller for turn to continue.aftere the player has either
	 * drawn a card or picked up the discard pile. It asks user to chose from
	 * "draw a card from deck", "pick up the discard pile", "Ask for Help",
	 * "show discard pile", "show stock card (for debugging)",
	 * 
	 * @param aDiscardPile, vector of cards that contains the discard pile
	 * 
	 * @return Pair of <Integer , Vector<Integer>>. The first interger indicates
	 *         this was--that is TurnStartconstrol so it is always 3. the second
	 *         is vector of unsinged integer the the vector's first element is
	 *         the sub menu index. rest of the element depends on the submenu
	 *         chosen
	 */
	Pair<Integer, Vector<Integer>> turnContinueControl(
			Vector<Vector<Card>> aOtherPlayerMeld, Vector<Card> aDiscardPile)
	{
		return new Pair<Integer, Vector<Integer>>(0, new Vector<Integer>());
	}

	/**
	 * adds the passed points to the total points
	 * 
	 * @param aPointsToAdd, integer. holds the points to add to the total
	 * 
	 * @return true to indicate success
	 */
	boolean addToTotalPoints(int aPointsToAdd)
	{
		mTotalPoints += aPointsToAdd;
		return true;
	}

	/**
	 * tallys the hand Point
	 * 
	 * @param none
	 * 
	 * @return tallied hand Point
	 */
	int tallyHandPoint()
	{
		return mPlayerHand.tallyPoints(mWentOut);
	}

	/**
	 * adds the drawn card to the deck
	 * 
	 * @param aDrawnCard, object of Card Class. card to add to hand class
	 * 
	 * @return false if the card to add was red three else true
	 */
	boolean addCardToHand(Card aDrawnCard)
	{
		return mPlayerHand.addCardToHand(aDrawnCard);
	}

	/**
	 * Empties the cards in the hand
	 * 
	 * @param none
	 * 
	 * @return true to indicate success
	 */
	boolean emptyHand()
	{
		mPlayerHand = new Hand();
		return true;
	}

	/**
	 * Tries to add the card at passed index to a already existing meld.
	 * 
	 * @param aHandCardIdx, a integer. It holds the index of the the card at
	 *                          actual hand that need to be moved
	 * @param aMeldIdx,     a integer. It holds the index of the meld to move
	 *                          the card to actual hand that need to be moved
	 * 
	 * @return a pair of < Boolean, String >, < true, "" > if the card was moved
	 *         to a meld successfully. else < false, "message string" >
	 */
	Pair<Boolean, String> addToMeld(Integer aHandCardIdx, Integer aMeldIdx)
	{
		return new Pair<Boolean, String>(false, "");
	}

	/**
	 * Tries to see if the passed card can be added to the meld or not
	 * 
	 * @param aCardToAddd, object of Card class. It holds a Card object that is
	 *                         used to check if it can be added or not
	 * 
	 * @return a pair of < Integer, string >, < meldIdx, "" > if the card can be
	 *         added to a meld then the first of the pair is the index of meld
	 *         where it can be added. else < -1, "message string" >
	 */
	Pair<Integer, String> canAddToMeld(Card aCardToAdd)
	{
		return mPlayerHand.canAddToMeld(aCardToAdd);
	}

	/**
	 * To make a vaild meld
	 * 
	 * @param aHandCardIdxList, a vector of integer. It holds the indexs of the
	 *                              card that are to be used to create a meld.
	 * 
	 * @return a pair of < Boolean, String >. < true, "" > if a meld was
	 *         successfully made. else < false, message string >
	 */
	Pair<Boolean, String> makeNewMeld(Vector<Integer> aHandCardIdxList)
	{
		return mPlayerHand.makeMeld(aHandCardIdxList);
	}

	/**
	 * takes out wild card
	 * 
	 * @param aMeldcardIdx, a integer. It holds the index of the card in meld
	 *                          that is to be taken out
	 * @param aMeldIdx,     a integer. It holds the index of the meld from where
	 *                          the card is to be taken out from
	 * 
	 * @return a pair of < Boolean, String >, < true, "" > if wild card was
	 *         taken out successfully . else < false, "message string" >
	 */
	Pair<Boolean, String> takeOutWildCard(Integer aMeldcardIdx,
			Integer aMeldIdx)
	{
		return mPlayerHand.takeOutWildCard(aMeldcardIdx, aMeldIdx);
	}

	/**
	 * Removes the card at a_handCardIdx and returns it. the index should be
	 * validated before hand
	 * 
	 * @param aHandCardIdx, a integer. It holds the index of the the card at
	 *                          actual hand that need to be removed
	 * 
	 * @return object of Card, holds the card that was discarded
	 */
	Card discard(Integer aHandCardIdx)
	{
		return mPlayerHand.discard(aHandCardIdx);
	}

	/**
	 * Adds all the card in to the actual hand of the player
	 * 
	 * @param aDiscardPile, a vector of card passed by value. It hold all the
	 *                          cards discarded by both player that needs to be
	 *                          added to this player's actual hand
	 * 
	 * @return true to indicate that discard pile was successfully added to
	 *         player's actual hand
	 */
	boolean pickUpDiscardPile(Vector<Card> aDiscardPile)
	{
		return false;
	}

	/**
	 * Verifies that the passed meld index is valid or not
	 * 
	 * @param aMeldIdx, a integer. It holds the index of the meld that is to be
	 *                      validated
	 * 
	 * @return true if the passed meld idx is a valid meld index, else false
	 */
	boolean validateMeldIdx(Integer aMeldIdx)
	{
		return mPlayerHand.validateMeldIdx(aMeldIdx);
	}

	// returns true if the passed aCardIdx is a valid index of the passed meld
	/**
	 * default constructor
	 * 
	 * @param none
	 * 
	 * @return card in the hand in the printed format
	 */
	boolean validateCardIdx(Integer aMeldIdx, Integer aCardIdx)
	{
		return mPlayerHand.validateCardIdx(aMeldIdx, aCardIdx);
	}

	/**
	 * Verifies that the passed meld index is valid or not
	 * 
	 * @param aMeldCardIdx, a integer. It holds the index of the card that is to
	 *                          be validated
	 * @param aMeldIdx,     a integer. It holds the index of the meld that the
	 *                          card needes to be validated for
	 * 
	 * @return true if the passed aCardIdx is a valid index of the passed meld
	 */
	boolean canGoOut()
	{
		return mPlayerHand.isActualHandEmpty() && mPlayerHand.getHasCanasta();
	}

	/**
	 * Resets playe's hand and flag to prepare for new round
	 * 
	 * @param none
	 * 
	 * @return ool to indicate a successfull reset
	 */
	boolean resetPlayerForNewRound()
	{
		return false;
	}

	/**
	 * Checks to see if we can pick up the discarded pile
	 * 
	 * @param aDiscardPile a vector of cards that contains the discard pile
	 * 
	 * @return boolean value, returns true if we can pick up the discard pile
	 *         else returns false.
	 */
	boolean canPickUpDiscardPile(Vector<Card> aDiscardPile)
	{
		return false;
	}

	/**
	 * validate that rhe passed string is a number that is between lowerLimit
	 * and upperLimit inclusively. if yes return the integer else -1
	 * 
	 * @param aNumToValidate,       a string containing the number that is to be
	 *                                  validated
	 * @param aInclusiveLowerBound, unsigned integer. lower bound that the
	 *                                  passed number can be. It includes
	 *                                  itself.
	 * @param aInclusiveUpperBound, unsigned integer. upper bound that the
	 *                                  passed number can be. It includes itself
	 * 
	 * @return interger. if the passed number is valid then it returns the
	 *         number as a interger. else returns -1
	 */
	protected Integer validateNumber(String aNumToValidate,
			Integer aInclusiveLowerBound, Integer aInclusiveUpperBound)
	{
		return 0;
	}
}
