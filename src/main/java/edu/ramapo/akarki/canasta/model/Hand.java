package edu.ramapo.akarki.canasta.model;

import edu.ramapo.akarki.canasta.exceptions.ImproperMeldException;

import java.util.Vector;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class Hand {
    // list of card that the player has in their hand
    // including the melds
    // the vector at index 0 is the hand cards where as
    // vector at other index are melds
    private Vector<Vector<Card>> mHandCards;

    // is true if the meld has atleast one conasta
    private boolean mHasCanasta;

    /**
     * default constructor
     * 
     * @param none
     * 
     * @return none
     */
    public Hand()
    {
        mHandCards = new Vector<Vector<Card>>(14);
        mHandCards.add(new Vector<Card>());

        mHasCanasta = false;
    }

    /**
     * constructor when hand card and melds cards are passed
     * 
     * @param aHandCards, a string containing the rank and suit of cards. Each
     *                        card is seperated by blank space.
     * @param aMeldCards, astring containing the rank and suit of cards in the
     *                        m_stock. Each card is seperated by blank space and
     *                        each meld is inside '[' and ']'
     * 
     * @return none
     * 
     * @throws ImproperMeldException When the meld containing a invalid card is
     *                                   passed
     */
    public Hand(String aHandCards, String aMeldCards)
            throws ImproperMeldException
    {
        // inializes the hand cards
        this();

        // chekcing it the meld is empty then do nothing for melds
        if (!aMeldCards.isEmpty())
        {
            // populating hte string stream with meldCard
            String[] meldSplited = aMeldCards.split("\\]\\s*\\[|\\[|\\]");

            // populating the mHandCards
            for (String meld : meldSplited)
            {
                if (meld.isBlank())
                {
                    continue;
                }

                String[] meldCardsSplited = meld.split(" +");
                Vector<String> meldCardsNoBlank = new Vector<String>();

                // removing all the blanks
                for (String rankSuit : meldCardsSplited)
                {
                    if (!rankSuit.isBlank())
                    {
                        meldCardsNoBlank.add(rankSuit);
                    }
                }

                // Adding rest to the hand
                for (String rankSuit : meldCardsNoBlank)
                {
                    addCardToHand(new Card(rankSuit));
                }

                // chekcing if this meld was a red three then addCardToHand
                // would automatically make a meld
                if (meldCardsNoBlank.size() == 1 && meldCardsNoBlank
                        .firstElement().substring(0, 1).equals("3"))
                {
                    continue;
                }

                Vector<Integer> cardIdxs = new Vector<Integer>();
                // populating the cardIdx to make a meld out of it
                for (Integer idx = 0; idx < meldCardsNoBlank.size(); ++idx)
                {
                    cardIdxs.add(idx);
                }

                // making a meld
                Pair<Boolean, String> meldReturn = makeMeld(cardIdxs);
                if (Boolean.FALSE.equals(meldReturn.getFirst()))
                {
                    throw new ImproperMeldException(meldReturn.getSecond());
                }
            }
        }

        // spliting the passed hand cards
        String[] handCardsSplited = aHandCards.split(" +");

        // populating the vector at 0th index of mHandCards
        // as the 0th vector is the place where the hand card are placed

        // populating the mHandCards
        for (String rankSuit : handCardsSplited)
        {
            if (!rankSuit.isBlank())
            {
                addCardToHand(new Card(rankSuit));
            }
        }

        /*
         * TODO (BUG): Currently wild cards are left in the hand. Possible
         * solution 1: When the round finishes initializing, loop over the hand
         * and add any wild cards in the hand to a meld. Possible solution 2:
         * When the round finishes initializing, use the computer’s AI to do as
         * much as possible until discard is left.
         */
    }

    // /**
    // * Copy Contructor for Card Class.
    // *
    // * @param aOtherCard, card to copy from
    // *
    // * @return none
    // */
    // public Hand(Hand aOtherhHand)
    // {
    // this(aOtherCard.mRank, aOtherCard.mSuit);
    // }

    /**
     * getter function get if the hand has a canasta or not
     * 
     * @param none
     * 
     * @return boolean, value holded by mHasCanasta
     */
    public boolean getHasCanasta()
    {
        return mHasCanasta;
    }

    /**
     * getter function to get the cards of in the hand, it has actual hand at
     * first index and everthing else is in a meld
     * 
     * @param none
     * 
     * @return vector of vector of card, it has actual hand at first index and
     *         everthing else is in a meld
     */
    public Vector<Vector<Card>> getHand()
    {
        return mHandCards;
    }

    /**
     * getter function to get the cards in a meld
     * 
     * @param none
     * 
     * @return vector of vector of card, it holds all the cards in the hand
     *         except the actual hand
     */
    public Vector<Vector<Card>> getMelds()
    {
        Vector<Vector<Card>> melds = new Vector<Vector<Card>>(
                mHandCards.size() - 1);

        for (int meldIdx = 1; meldIdx < mHandCards.size(); ++meldIdx)
        {
            melds.add(mHandCards.get(meldIdx));
        }

        return melds;
    }

    /**
     * getter function get the number of melds
     * 
     * @param none
     * 
     * @return Integer, holds the number of meld in the hand
     */
    public Integer getTotalMeldNum()
    {
        return mHandCards.size() - 1;
    }

    /**
     * getter function get the number cards in the actual hand--vector at index
     * 0
     * 
     * @param none
     * 
     * @return Integer, holds the number of meld in the hand
     */
    public Integer getTotalHandCardNum()
    {
        return mHandCards.firstElement().size();
    }

    /**
     * getter function to get the card in a meld.
     * 
     * @param aMeldIdx     Integer. It holds the index of the meld to get the
     *                         card from.Pass 0 for meldIdx for actual hand
     * @param aMeldCardIdx Integer. It holds the index of the card at the passed
     *                         meld
     * 
     * @return Card at that is present in the passed
     */
    public Card getCardAtIdx(Integer aMeldIdx, Integer aMeldCardIdx)
    {
        return (mHandCards.get(aMeldIdx).get(aMeldCardIdx));
    }

    /**
     * Getter function to get the actual hand--that is card that
     * 
     * @param none
     * 
     * @return Vector of card containing all the cards that are not in melds of
     *         the player hand
     */
    public Vector<Card> getActualHand()
    {
        return new Vector<Card>(mHandCards.firstElement());
    }

    /**
     * Getter function to get actual hand--that is card that are not in
     * melds--where the all the ranks of the card are seperated into one vector.
     * 
     * @param none
     * 
     * @return Vector of Vector of Card where each Vector of Cards have the same
     *         ranks. All the ranks are in ascending order.
     */
    public Vector<Vector<Card>> getDividedAcualHandCardList()
    {
        // diving out cards at hand according to its rank
        Vector<Vector<Card>> sameRankHandCardList = new Vector<Vector<Card>>();

        Vector<Card> acutalHand = getActualHand();
        Integer numVec = 0;

        for (Card card : acutalHand)
        {

            // checking if the currCard is in the list or not
            if (sameRankHandCardList.isEmpty())
            {
                sameRankHandCardList.add(new Vector<Card>());
                sameRankHandCardList.get(numVec).add(card);
            }
            // if the curCard's rank is same as the last cards in the list
            else if (card.getRank()
                    .equals(sameRankHandCardList.get(numVec).get(0).getRank()))
            {
                sameRankHandCardList.get(numVec).add(card);
            }
            else
            {
                // else it should be smaller so create a new vector and push it
                // back
                sameRankHandCardList.add(new Vector<Card>());
                sameRankHandCardList.get(++numVec).add(card);
            }
        }

        return sameRankHandCardList;
    }

    /**
     * Getter function to get the actual hand--that is card that are not in
     * melds in string format
     * 
     * @param none
     * 
     * @return string, containing the rank and suit of cards which represents
     *         player's actual hand. Each card is seperated by blank space. And
     *         the first rankSuit pair represent the card that is going to be
     *         dealt next.
     */
    String getActualHandString()
    {
        // if the are no card in the hand return ""
        if (mHandCards.firstElement().isEmpty())
        {
            return "";
        }

        // creating actual hand
        StringBuilder actualHandStr = new StringBuilder();
        for (Card card : mHandCards.firstElement())
        {
            actualHandStr.append(card.toString() + " ");
        }

        // removing the last " "
        actualHandStr.deleteCharAt(actualHandStr.length() - 1);

        return actualHandStr.toString();
    }

    /**
     * Getter function to get the actual hand--that is card that are not in
     * melds in string format
     * 
     * @param none
     * 
     * @return string, containing all the cards that are in melds of the player
     *         hand in string format. it is stored as [rs] [rs] [rs rs rs]
     */
    String getMeldsString()
    {
        // if the are no melds return ""
        if (mHandCards.size() == 1)
        {
            return "";
        }

        StringBuilder meldListStr = new StringBuilder();

        // looping over hand's meld

        for (Vector<Card> melds : getMelds())
        {

            meldListStr.append("[");

            for (Card card : melds)
            {

                meldListStr.append(card.toString() + " ");
            }

            // removing the last " "
            meldListStr.deleteCharAt(meldListStr.length() - 1);
            meldListStr.append("] ");
        }

        // removing the last " "
        meldListStr.deleteCharAt(meldListStr.length() - 1);

        return meldListStr.toString();
    }

    /**
     * Getter function to get the actual hand in string format
     * 
     * @param aCardToAdd, object of Card class passed by value. It holds a Card
     *                        object that is added to the hand
     * 
     * @return false if the card to add was red three else true
     */
    public boolean addCardToHand(Card aCardToAdd)
    {
        // adding the card to the hand
        mHandCards.firstElement().add(aCardToAdd);

        // checking if the card was red three
        if (aCardToAdd.getCardType()
                .equals(Card.ENUM_CardType.CARDTYPE_RED_THREE))
        {
            addRed3CardToMeld(mHandCards.firstElement().size() - 1);
            return false;
        }

        // sorting the hand card
        sortMeld(0, false);

        return true;
    }

    // // see if a card can be added to atleast one of the meld or not
    // std::pair<unsigned,std::string> CanAddToMeld( const Card a_cardToAdd )
    // const;

    // // takes the card at index from actual hand and moves
    // // it to a meld if possible
    // std::pair<bool, std::string> AddNaturalCardToMeld( unsigned
    // a_handCardIdx, unsigned a_meldIdx );

    // // takes the wildcard at index from actual hand and moves
    // // it to a meld if possible
    // std::pair<bool, std::string> AddWildCardToMeld( unsigned a_handCardIdx,
    // unsigned a_meldIdx );

    /**
     * To move the the red 3 at index from actual hand and to a new meld if
     * possible
     * 
     * @param aHandCardIdx, a integer. It holds the index of the the card at
     *                          actual hand that need to be moved
     * 
     * @return a pair of < Boolean, String >, < true, "" > if the card was moved
     *         to a meld successfully. else < false, "message string" >
     */
    public Pair<Boolean, String> addRed3CardToMeld(Integer aHandCardIdx)
    {
        if (mHandCards.firstElement().get(aHandCardIdx)
                .getCardType() != Card.ENUM_CardType.CARDTYPE_RED_THREE)
        {
            return new Pair<Boolean, String>(false, "Card at index "
                    + aHandCardIdx.toString() + " is not a red three card");
        }

        // making a new meld at index 1 for the red 3
        mHandCards.add(1, new Vector<Card>());

        // inserting the red 3 at index 1 of mHandCards as a new meld
        // removing the red 3 from actual hand
        return addCardToMeld(aHandCardIdx, 1);
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
    public Pair<Boolean, String> makeMeld(Vector<Integer> aHandCardIdxList)
    {
        // checking if the vector list has at lease 3 card index
        if (aHandCardIdxList.size() < 3)
        {
            return new Pair<Boolean, String>(false,
                    "Meld must have atleast three cards in it.");
        }

        // making sure that all the elements are unique
        Set<Integer> passedHandCard = new HashSet<Integer>(
                aHandCardIdxList.size());

        for (Integer i : aHandCardIdxList)
        {
            if (!passedHandCard.add(i))
            {
                return new Pair<Boolean, String>(false,
                        "All the index of the passed card must be unique.");
            }
        }

        // holds all of the wild cards's idx into another vectorlist that were
        // passed
        Vector<Integer> wildCardindexList = new Vector<Integer>(3);

        // holds all of the natural cards's idx into another vectorlist that
        // were passed
        Vector<Integer> naturalCardindexList = new Vector<Integer>(
                aHandCardIdxList.size());

        // holds all of the passed natural cards's contant pointer into another
        // vectorlist. we use this to see if the rank of all natural cards to
        // meld are the same or not
        Vector<Card> naturalCardList = new Vector<Card>(
                aHandCardIdxList.size());

        for (Integer passedListIdx : aHandCardIdxList)
        {
            Card cardToProcess = mHandCards.firstElement().get(passedListIdx);
            switch (cardToProcess.getCardType())
            {
            case CARDTYPE_NATURAL:
            {
                // saving the natural card index and the card
                naturalCardindexList.add(passedListIdx);

                naturalCardList.add(cardToProcess);
                break;
            }
            case CARDTYPE_WILDCARD:
            {
                // saving the passed index to the wildcard Index List
                wildCardindexList.add(passedListIdx);
                break;
            }
            case CARDTYPE_RED_THREE:
            {
                return new Pair<Boolean, String>(false,
                        "Meld can not have a Red 3.");
            }
            case CARDTYPE_BLACK_THREE:
            {
                return new Pair<Boolean, String>(false,
                        "Meld can not have a Black 3.");
            }
            default:
                break;
            }
        }

        // checking how many wild cards there were in the passed list
        if (wildCardindexList.size() > 3)
        {
            return new Pair<Boolean, String>(false,
                    "Meld can only have at most three wildcards in it.");
        }

        // checking how many natural cards there were in the passed list
        if (naturalCardindexList.size() < 2)
        {
            return new Pair<Boolean, String>(false,
                    "Meld should have atleat two natural card in it.");
        }

        // checking if all the natural cards have the same rank
        for (Card card : naturalCardList)
        {
            if (!card.getRank()
                    .equals(naturalCardList.firstElement().getRank()))
            {
                return new Pair<Boolean, String>(false,
                        "All the ranks of natural card in the meld are not the same.");
            }
        }

        // chekcing if a meld for this rank already exist
        for (Vector<Card> meld : getMelds())
        {
            if (meld.firstElement().getRank()
                    .equals(naturalCardList.firstElement().getRank()))
            {
                return new Pair<Boolean, String>(false,
                        "Meld of the same rank already exist.");
            }
        }

        // all the test were passed to creating a new meld
        // so creating a new meld and adding the cards to the meld
        mHandCards.add(new Vector<Card>());

        // sort the a_handCardIdxList in desending order
        // we need to do this as AddCardToMeld funciton removes the card that
        // was added to the meld from the actual hand thus changing the order
        // of card in teh actual hand.
        // so when we move card starting from the back of the acutal hand as
        // removing the card at from the back does not affect the index of the
        // of the card from at the start
        Collections.sort(aHandCardIdxList, Collections.reverseOrder());

        // holds the return value of AddCardToMeld
        Pair<Boolean, String> returnVal = new Pair<Boolean, String>(true, "");
        Integer meldIndex = mHandCards.size() - 1;

        // adding the card from the back
        for (Integer passedListIdx : aHandCardIdxList)
        {
            returnVal = addCardToMeld(passedListIdx, meldIndex);

            if (Boolean.FALSE.equals(returnVal.getFirst()))
            {
                break;
            }
        }

        // updating m_hasCanasta
        updateCanasta();

        return returnVal;
    }

    /**
     * checks if the actual hand is empty
     * 
     * @param none
     * 
     * @return bolean, true if the actual hand is empty else false
     */
    boolean isActualHandEmpty()
    {
        return mHandCards.firstElement().isEmpty();
    }

    // checks if the meld has at least one wild card
    // boolean MeldHasWildCard( unsigned a_meldIdx ) const;

    // // takes out wild card
    // std::pair<bool,std::string> TakeOutWildCard( unsigned a_meldcardIdx,
    // unsigned a_meldIdx );

    // // removes the card at a_handCardIdx and returns it.
    // Card Discard(unsigned a_handCardIdx);

    // // prints out the hand
    // void PrintHand() const;

    // // tallies up all the point
    // const int TallyPoints( bool a_wentOut ) const;

    // // returns true if the passed meld idx is a valid index
    // bool ValidateMeldIdx( unsigned a_meldIdx ) const { return a_meldIdx <
    // m_handCard.size(); }

    // // returns true if the passed a_CardIdx is a valid index of the passed
    // meld
    // bool ValidateCardIdx( unsigned a_meldIdx, unsigned a_meldcardIdx ) const
    // {
    // return a_meldcardIdx < m_handCard.at( a_meldIdx ).size();
    // }

    /**
     * Takes the card at index from actual hand and moves it to a meld if
     * possible
     * 
     * @param aHandCardIdx, a integer. It holds the index of the the card at
     *                          actual hand that need to be moved
     * @param aMeldIdx,     a integer. It holds the index of the meld to move
     *                          the card to actual hand that need to be moved
     * 
     * @return a pair of < Boolean, String >, < true, "" > if the card was moved
     *         to a meld successfully. else < false, "message string" >
     */
    private Pair<Boolean, String> addCardToMeld(Integer aHandCardIdx,
            Integer aMeldIdx)
    {
        // trying to move the card to the meld
        // a card can move to a meld if the meld is empty,
        // or first card of the meld is a wild card this only happens
        // we are making a new meld and is safe to do as the
        // card are already tested
        // or the rank of the first card in the meld is same as the
        // rank of the passed card,
        // or the passed card is a wild card
        if (mHandCards.get(aMeldIdx).isEmpty()
                || mHandCards.get(aMeldIdx).firstElement().getCardType()
                        .equals(Card.ENUM_CardType.CARDTYPE_WILDCARD)
                || mHandCards.get(aMeldIdx).firstElement().getRank().equals(
                        mHandCards.firstElement().get(aHandCardIdx).getRank())
                || mHandCards.firstElement().get(aHandCardIdx).getCardType()
                        .equals(Card.ENUM_CardType.CARDTYPE_WILDCARD))
        {
            // moving the card to the meld
            mHandCards.get(aMeldIdx)
                    .add(mHandCards.firstElement().get(aHandCardIdx));

            // removing the card from the hand
            mHandCards.firstElement().removeElementAt(aHandCardIdx);

            sortMeld(aMeldIdx, true);
            return new Pair<Boolean, String>(true, "");
        }

        return new Pair<Boolean, String>(false,
                "Card can not be added to the meld");
    }

    /**
     * sorts the card at given meld in decending order.
     * 
     * @param aMeldIdx, a integer. It holds the index of the meld on which the
     *                      sort is to be performed
     * @param aReverse, a boolean. if true sorts by decending order
     * 
     * @return a pair of < Boolean, String >, < true, "" > if the meld was
     *         successfully sorted. else < false, "message string" >
     */
    private Pair<Boolean, String> sortMeld(Integer aMeldIdx, boolean aReverse)
    {
        // validating the passed meld index
        if (aMeldIdx >= mHandCards.size())
        {
            return new Pair<Boolean, String>(false, "Invalid meld index");
        }

        if (aReverse)
        {
            Collections.sort(mHandCards.get(aMeldIdx),
                    Collections.reverseOrder());
        }
        else
        {
            Collections.sort(mHandCards.get(aMeldIdx));
        }
        return new Pair<Boolean, String>(true, "");
    }

    /**
     * to check all the meld for a conasta and update the m_hasCanasta
     * accordingly
     * 
     * @param none
     * 
     * @return true if a changes was made t0 m_hasConasta; else false
     */
    private boolean updateCanasta()
    {
        boolean currCanasta = mHasCanasta;

        // looping over the melds
        for (Vector<Card> meld : getMelds())
        {
            if (isCanasta(meld))
            {
                mHasCanasta = true;
                break;
            }
        }

        return currCanasta == mHasCanasta;
    }

    // checks if the meld is canasta -- i.e. has seven or more cards
    private boolean isCanasta(Vector<Card> meld)
    {
        return (meld.size() >= 7);
    }

}
