package edu.ramapo.akarki.canasta.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CardTest {
	Card mTestNaturalCard = new Card("A", "C");
	Card mTest10Card = new Card("X", "H");
	Card mTestRedThreeCard = new Card("3", "D");
	Card mTestJokerCard = new Card("J", "1");
	Card mTestBlackThreeCard = new Card("3", "S");
	Card mTestWildCardCard = new Card("2", "H");

	/**
	 * Unit test the Card Constructor for illegal arguments
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCardConstructorException()
	{
		new Card("B", "D");
	}

	/**
	 * Unit test the Card Constructor for illegal arguments
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	@Test
	public void testCardCopyConstructor()
	{
		Card copy = new Card(mTestNaturalCard);

		assertEquals(copy, mTestNaturalCard);
	}

	/**
	 * Unit test the Card"s getCardType function
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	@Test
	public void testGetCardType()
	{
		assertEquals(Card.ENUM_CardType.CARDTYPE_NATURAL,
				mTestNaturalCard.getCardType());
		assertEquals(Card.ENUM_CardType.CARDTYPE_NATURAL,
				mTest10Card.getCardType());
		assertEquals(Card.ENUM_CardType.CARDTYPE_RED_THREE,
				mTestRedThreeCard.getCardType());
		assertEquals(Card.ENUM_CardType.CARDTYPE_WILDCARD,
				mTestJokerCard.getCardType());
		assertEquals(Card.ENUM_CardType.CARDTYPE_BLACK_THREE,
				mTestBlackThreeCard.getCardType());
		assertEquals(Card.ENUM_CardType.CARDTYPE_WILDCARD,
				mTestWildCardCard.getCardType());
	}

	/**
	 * Unit test the Card"s getPoint function
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	@Test
	public void testGetPoint()
	{
		assertEquals(20, mTestNaturalCard.getPoint());
		assertEquals(10, mTest10Card.getPoint());
		assertEquals(100, mTestRedThreeCard.getPoint());
		assertEquals(50, mTestJokerCard.getPoint());
		assertEquals(5, mTestBlackThreeCard.getPoint());
		assertEquals(20, mTestWildCardCard.getPoint());
	}

	/**
	 * Unit test the Card"s getRank function
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	@Test
	public void testGetRank()
	{
		assertEquals("A", mTestNaturalCard.getRank());
		assertEquals("X", mTest10Card.getRank());
		assertEquals("3", mTestRedThreeCard.getRank());
		assertEquals("J", mTestJokerCard.getRank());
		assertEquals("3", mTestBlackThreeCard.getRank());
		assertEquals("2", mTestWildCardCard.getRank());
	}

	/**
	 * Unit test the Card"s getSuit function
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	@Test
	public void testGetSuit()
	{
		assertEquals("C", mTestNaturalCard.getSuit());
		assertEquals("H", mTest10Card.getSuit());
		assertEquals("D", mTestRedThreeCard.getSuit());
		assertEquals("1", mTestJokerCard.getSuit());
		assertEquals("S", mTestBlackThreeCard.getSuit());
		assertEquals("H", mTestWildCardCard.getSuit());
	}

	/**
	 * Unit test the Card"s getRankSuit function
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	@Test
	public void testGetRankSuit()
	{
		assertEquals("AC", mTestNaturalCard.getRankSuit());
		assertEquals("XH", mTest10Card.getRankSuit());
		assertEquals("3D", mTestRedThreeCard.getRankSuit());
		assertEquals("J1", mTestJokerCard.getRankSuit());
		assertEquals("3S", mTestBlackThreeCard.getRankSuit());
		assertEquals("2H", mTestWildCardCard.getRankSuit());
	}

	/**
	 * Unit test the Card"s hascodes() function
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	@Test
	public void testCardHashCode()
	{
		Card m_testCopyNaturalCard = new Card("A", "C");

		assertTrue(mTestNaturalCard.equals(m_testCopyNaturalCard)
				&& m_testCopyNaturalCard.equals(mTestNaturalCard));
		assertEquals(mTestNaturalCard.hashCode(),
				m_testCopyNaturalCard.hashCode());
	}

	/**
	 * Unit test the Card"s equals() function
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	@Test
	public void testEqualsCards()
	{
		Card m_testCopyNaturalCard = new Card("A", "C");

		assertEquals(true, mTestNaturalCard.equals(mTestNaturalCard));
		assertEquals(true, mTestNaturalCard.equals(m_testCopyNaturalCard));
		assertEquals(false, mTestNaturalCard.equals(mTest10Card));
		assertEquals(false, mTestNaturalCard.equals(null));
	}

	/**
	 * Unit test the Card"s compareTo() function
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	@Test
	public void testCompareToCards()
	{
		// AC and XH
		assertEquals(1, mTestNaturalCard.compareTo(mTest10Card));
		assertEquals(0, mTestNaturalCard.compareTo(mTestNaturalCard));
		assertEquals(-1, mTest10Card.compareTo(mTestNaturalCard));

		// XH and 3D
		assertEquals(-1, mTestRedThreeCard.compareTo(mTest10Card));
		assertEquals(0, mTestRedThreeCard.compareTo(mTestRedThreeCard));
		assertEquals(1, mTest10Card.compareTo(mTestRedThreeCard));

		// XH and J1
		assertEquals(-1, mTestJokerCard.compareTo(mTest10Card));
		assertEquals(0, mTestJokerCard.compareTo(mTestJokerCard));
		assertEquals(1, mTest10Card.compareTo(mTestJokerCard));
	}
}