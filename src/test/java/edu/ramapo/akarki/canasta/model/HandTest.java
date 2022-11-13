package edu.ramapo.akarki.canasta.model;

import edu.ramapo.akarki.canasta.exceptions.ImproperMeldException;

import static org.junit.Assert.assertEquals;

import java.util.Vector;
import org.junit.Test;

public class HandTest {
	Hand testhandNoParam = new Hand();

	/**
	 * Test the defualt Hand Constructor
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	@Test
	public void testHandConstructorNoParam()
	{
		assertEquals(false, testhandNoParam.getHasCanasta());
		assertEquals(true, testhandNoParam.getHand().firstElement().isEmpty());
		assertEquals(1, testhandNoParam.getHand().size());
	}

	/**
	 * Test function to test the Hand's constructor for exception.
	 * 
	 * @param none
	 * 
	 * @return none
	 * 
	 * @throws ImproperMeldException this is when the meld has a card that is
	 *                                   not valid
	 */
	@Test(expected = ImproperMeldException.class)
	public void testHandConstructorException() throws ImproperMeldException
	{
		try
		{
			new Hand(" AS AD    J1 J2",
					"[4H 4C 4S 4D 4H 5C 4C 2D]  [6H 6C 6S 6D]  [8H 8C 8S 8D]  [JH JC JS JD]  [3D] [3H]  ");
		}
		catch (ImproperMeldException e)
		{
			throw new ImproperMeldException(e.getMessage());
		}
	}

	/**
	 * Test the Hand Constructor when paramerters are passed
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	@Test
	public void testHandConstructorWithParam()
	{
		try
		{
			Hand mTestHandWithParam = new Hand(" AS AD    J1 J2",
					"[4H 4C 4S 4D 4H 4C 2D]  [6H 6C 6S 6D]  [8H 8C 8S 8D]  [JH JC JS JD]  [3D] [3H]  ");

			Vector<Vector<Card>> expectedVec = new Vector<Vector<Card>>();
			expectedVec.add(new Vector<Card>());
			expectedVec.get(0).add(new Card("J1"));
			expectedVec.get(0).add(new Card("J2"));
			expectedVec.get(0).add(new Card("AD"));
			expectedVec.get(0).add(new Card("AS"));

			expectedVec.add(new Vector<Card>());
			expectedVec.get(1).add(new Card("3H"));

			expectedVec.add(new Vector<Card>());
			expectedVec.get(2).add(new Card("3D"));

			expectedVec.add(new Vector<Card>());
			expectedVec.get(3).add(new Card("4S"));
			expectedVec.get(3).add(new Card("4H"));
			expectedVec.get(3).add(new Card("4H"));
			expectedVec.get(3).add(new Card("4D"));
			expectedVec.get(3).add(new Card("4C"));
			expectedVec.get(3).add(new Card("4C"));
			expectedVec.get(3).add(new Card("2D"));

			expectedVec.add(new Vector<Card>());
			expectedVec.get(4).add(new Card("6S"));
			expectedVec.get(4).add(new Card("6H"));
			expectedVec.get(4).add(new Card("6D"));
			expectedVec.get(4).add(new Card("6C"));

			expectedVec.add(new Vector<Card>());
			expectedVec.get(5).add(new Card("8S"));
			expectedVec.get(5).add(new Card("8H"));
			expectedVec.get(5).add(new Card("8D"));
			expectedVec.get(5).add(new Card("8C"));

			expectedVec.add(new Vector<Card>());
			expectedVec.get(6).add(new Card("JS"));
			expectedVec.get(6).add(new Card("JH"));
			expectedVec.get(6).add(new Card("JD"));
			expectedVec.get(6).add(new Card("JC"));

			assertEquals(true, mTestHandWithParam.getHasCanasta());
			assertEquals(expectedVec, mTestHandWithParam.getHand());
		}
		catch (ImproperMeldException e)
		{
			assertEquals("Exception should not be thrown here",
					"Exception was thrown!!");
		}

	}

	/**
	 * Test the Hand's getHasCanasta()
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	@Test
	public void testGetHasCanasta()
	{
		assertEquals(false, testhandNoParam.getHasCanasta());
	}

	/**
	 * Test the Hand's gethand()
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	@Test
	public void testGetHand()
	{

		Vector<Vector<Card>> expectedVec = new Vector<Vector<Card>>();
		expectedVec.add(new Vector<Card>());
		expectedVec.firstElement().add(new Card("XD"));

		testhandNoParam.addCardToHand(new Card("XD"));
		assertEquals(expectedVec, testhandNoParam.getHand());
	}

	/**
	 * Test the Hand's getMelds()
	 * 
	 * @param none
	 * 
	 * @return none
	 * 
	 * @throws ImproperMeldException
	 */
	@Test
	public void testGetMelds() throws ImproperMeldException
	{
		try
		{
			Hand testHand = new Hand(" AS AD    J1 J2",
					"[4H 4C 4S 4D 4H 4C 2D]  [6H 6C 6S 6D]  [8H 8C 8S 8D]  [JH JC JS JD]  [3D] [3H]  ");
			Vector<Vector<Card>> expectedMeldVecs = new Vector<Vector<Card>>();

			expectedMeldVecs.add(new Vector<Card>());
			expectedMeldVecs.get(0).add(new Card("3H"));

			expectedMeldVecs.add(new Vector<Card>());
			expectedMeldVecs.get(1).add(new Card("3D"));

			expectedMeldVecs.add(new Vector<Card>());
			expectedMeldVecs.get(2).add(new Card("4S"));
			expectedMeldVecs.get(2).add(new Card("4H"));
			expectedMeldVecs.get(2).add(new Card("4H"));
			expectedMeldVecs.get(2).add(new Card("4D"));
			expectedMeldVecs.get(2).add(new Card("4C"));
			expectedMeldVecs.get(2).add(new Card("4C"));
			expectedMeldVecs.get(2).add(new Card("2D"));

			expectedMeldVecs.add(new Vector<Card>());
			expectedMeldVecs.get(3).add(new Card("6S"));
			expectedMeldVecs.get(3).add(new Card("6H"));
			expectedMeldVecs.get(3).add(new Card("6D"));
			expectedMeldVecs.get(3).add(new Card("6C"));

			expectedMeldVecs.add(new Vector<Card>());
			expectedMeldVecs.get(4).add(new Card("8S"));
			expectedMeldVecs.get(4).add(new Card("8H"));
			expectedMeldVecs.get(4).add(new Card("8D"));
			expectedMeldVecs.get(4).add(new Card("8C"));

			expectedMeldVecs.add(new Vector<Card>());
			expectedMeldVecs.get(5).add(new Card("JS"));
			expectedMeldVecs.get(5).add(new Card("JH"));
			expectedMeldVecs.get(5).add(new Card("JD"));
			expectedMeldVecs.get(5).add(new Card("JC"));

			assertEquals(expectedMeldVecs, testHand.getMelds());
		}
		catch (ImproperMeldException e)
		{
			throw new ImproperMeldException(e.getMessage());
		}
	}

	/**
	 * Test the Hand's getTotalMeldNum()
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	@Test
	public void testGetTotalMeldNum()
	{
		assertEquals(0, testhandNoParam.getTotalMeldNum().intValue());
	}

	/**
	 * Test the Hand's getTotalHandCardNum()
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	@Test
	public void testGetTotalHandCardNum()
	{
		assertEquals(0, testhandNoParam.getTotalHandCardNum().intValue());
	}

	/**
	 * Test the Hand's getCardAtIdx()
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	@Test
	public void testGetCardAtIdx()
	{
		testhandNoParam.addCardToHand(new Card("XD"));
		assertEquals(new Card("XD"), testhandNoParam.getCardAtIdx(0, 0));
	}

	/**
	 * Test the Hand's getActualHand()
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	@Test
	public void testGetActualHand()
	{
		testhandNoParam.addCardToHand(new Card("XD"));

		Vector<Card> expectedVec = new Vector<Card>();
		expectedVec.add(new Card("XD"));
		Vector<Card> testhandNoParamVec = testhandNoParam.getActualHand();

		assertEquals(expectedVec, testhandNoParamVec);

		// testing to see if the it is mutable
		testhandNoParamVec.set(0, new Card("XC"));
		assertEquals(expectedVec, testhandNoParam.getActualHand());
		assertEquals(new Card("XC"), testhandNoParamVec.get(0));
	}

	/**
	 * Test the Hand's getDividedAcualHandCardList()
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	@Test
	public void testGetDividedAcualHandCardList()
	{
		testhandNoParam.addCardToHand(new Card("5C"));
		testhandNoParam.addCardToHand(new Card("XD"));
		testhandNoParam.addCardToHand(new Card("XC"));

		Vector<Vector<Card>> expectedVec = new Vector<Vector<Card>>();
		expectedVec.add(new Vector<Card>());
		expectedVec.get(0).add((new Card("5C")));
		expectedVec.add(new Vector<Card>());
		expectedVec.get(1).add((new Card("XC")));
		expectedVec.get(1).add((new Card("XD")));

		assertEquals(expectedVec,
				testhandNoParam.getDividedAcualHandCardList());
	}

	/**
	 * Test the Hand's getActualHandString()
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	@Test
	public void testGetActualHandString()
	{
		testhandNoParam.addCardToHand(new Card("XD"));
		testhandNoParam.addCardToHand(new Card("5C"));
		testhandNoParam.addCardToHand(new Card("3D"));
		testhandNoParam.addCardToHand(new Card("XC"));

		assertEquals("5C XC XD", testhandNoParam.getActualHandString());
	}

	/**
	 * Test the Hand's getMeldsString()
	 * 
	 * @param none
	 * 
	 * @return none
	 * 
	 * @throws ImproperMeldException
	 */
	@Test
	public void testGetMeldsString() throws ImproperMeldException
	{
		testhandNoParam.addCardToHand(new Card("XD"));
		testhandNoParam.addCardToHand(new Card("5C"));
		testhandNoParam.addCardToHand(new Card("XC"));

		assertEquals("", testhandNoParam.getMeldsString());

		testhandNoParam.addCardToHand(new Card("3D"));
		assertEquals("[3D]", testhandNoParam.getMeldsString());

		try
		{
			Hand testHand = new Hand(" AS AD    J1 J2",
					"[4H 4C 4S 4D 4H 4C 2D] [JH JC JS JD J1]  [3D] [3H]  ");
			Vector<Vector<Card>> expectedMeldVecs = new Vector<Vector<Card>>();

			assertEquals("[3H] [3D] [4S 4H 4H 4D 4C 4C 2D] [JS JH JD JC J1]",
					testHand.getMeldsString());
		}
		catch (ImproperMeldException e)
		{
			throw new ImproperMeldException(e.getMessage());
		}

	}

	/**
	 * Test the Hand's addCardToHand()
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	@Test
	public void testAddCardToHand()
	{
		testhandNoParam.addCardToHand(new Card("XD"));

		Vector<Vector<Card>> expectedVec = new Vector<Vector<Card>>();
		expectedVec.add(new Vector<Card>());
		expectedVec.get(0).add(new Card("XD"));

		assertEquals(expectedVec, testhandNoParam.getHand());
	}

	/**
	 * Test the Hand's addRed3CardToMeld()
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	@Test
	public void testAddRed3CardToMeld()
	{
		testhandNoParam.addCardToHand(new Card("3D"));

		Vector<Vector<Card>> expectedVec = new Vector<Vector<Card>>();
		expectedVec.add(new Vector<Card>());
		expectedVec.add(new Vector<Card>());
		expectedVec.get(1).add(new Card("3D"));

		assertEquals(expectedVec, testhandNoParam.getHand());

	}

	/**
	 * Test the Hand's makeMeld()
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	@Test
	public void testMakeMeld()
	{
		// testing a valid meld call
		testhandNoParam.addCardToHand(new Card("XD"));
		testhandNoParam.addCardToHand(new Card("XS"));
		testhandNoParam.addCardToHand(new Card("XC"));
		testhandNoParam.addCardToHand(new Card("XH"));

		Vector<Integer> cardIdxs = new Vector<Integer>();

		cardIdxs.add(0);
		cardIdxs.add(1);
		cardIdxs.add(2);
		cardIdxs.add(3);

		testhandNoParam.makeMeld(cardIdxs);

		Vector<Vector<Card>> expectedVec = new Vector<Vector<Card>>();
		expectedVec.add(new Vector<Card>());
		expectedVec.add(new Vector<Card>());
		expectedVec.get(1).add(new Card("XS"));
		expectedVec.get(1).add(new Card("XH"));
		expectedVec.get(1).add(new Card("XD"));
		expectedVec.get(1).add(new Card("XC"));

		assertEquals(expectedVec, testhandNoParam.getHand());

		// testing for meld when there is only 2 elements

		testhandNoParam.addCardToHand(new Card("J1")); // 0
		testhandNoParam.addCardToHand(new Card("J2")); // 1
		testhandNoParam.addCardToHand(new Card("2H")); // 2
		testhandNoParam.addCardToHand(new Card("2S")); // 3
		testhandNoParam.addCardToHand(new Card("3S")); // 4
		testhandNoParam.addCardToHand(new Card("5H")); // 5
		testhandNoParam.addCardToHand(new Card("XC")); // 6
		testhandNoParam.addCardToHand(new Card("XD")); // 7
		testhandNoParam.addCardToHand(new Card("XS")); // 8

		cardIdxs.clear(); // cardIdxs->
		cardIdxs.add(6); // cardIdxs-> 6
		cardIdxs.add(7); // cardIdxs-> 6, 7
		assertEquals("Meld must have atleast three cards in it.",
				testhandNoParam.makeMeld(cardIdxs).getSecond());

		// testing for when there black 3
		cardIdxs.add(4); // cardIdxs-> 6, 7, 4
		assertEquals("Meld can not have a Black 3.",
				testhandNoParam.makeMeld(cardIdxs).getSecond());

		// testing for when there is repeat of indexs
		cardIdxs.remove(2); // cardIdxs-> 6, 7
		cardIdxs.add(7); // cardIdxs-> 6, 7, 7
		assertEquals("All the index of the passed card must be unique.",
				testhandNoParam.makeMeld(cardIdxs).getSecond());

		// testing for more than 3 wild card
		cardIdxs.remove(2); // cardIdxs-> 6, 7
		cardIdxs.add(0); // cardIdxs-> 6, 7, 0
		cardIdxs.add(1); // cardIdxs-> 6, 7, 0, 1
		cardIdxs.add(2); // cardIdxs-> 6, 7, 0, 1, 2
		cardIdxs.add(3); // cardIdxs-> 6, 7, 0, 1, 2, 3
		assertEquals("Meld can only have at most three wildcards in it.",
				testhandNoParam.makeMeld(cardIdxs).getSecond());

		// testing for atleast 2 natural cars
		cardIdxs.remove(2); // cardIdxs-> 6, 7, 1, 2, 3
		cardIdxs.remove(1); // cardIdxs-> 6, 1, 2, 3
		assertEquals("Meld should have atleat two natural card in it.",
				testhandNoParam.makeMeld(cardIdxs).getSecond());

		// testing for 2 different rank of melds
		cardIdxs.add(5); // cardIdxs-> 6, 1, 2, 3, 5
		assertEquals(
				"All the ranks of natural card in the meld are not the same.",
				testhandNoParam.makeMeld(cardIdxs).getSecond());

		// testing for already existing meld
		cardIdxs.remove(4); // cardIdxs-> 6, 1, 2, 3
		cardIdxs.add(7); // cardIdxs-> 6, 1, 2, 3, 7
		assertEquals("Meld of the same rank already exist.",
				testhandNoParam.makeMeld(cardIdxs).getSecond());
	}

	/**
	 * Test the Hand's isActualHandEmpty()
	 * 
	 * @param none
	 * 
	 * @return none
	 */
	@Test
	public void testIsActualHandEmpty()
	{
		assertEquals(true, testhandNoParam.isActualHandEmpty());

		testhandNoParam.addCardToHand(new Card("3D"));
		assertEquals(true, testhandNoParam.isActualHandEmpty());

		testhandNoParam.addCardToHand(new Card("XD"));
		testhandNoParam.addCardToHand(new Card("5C"));
		testhandNoParam.addCardToHand(new Card("3D"));

		assertEquals(false, testhandNoParam.isActualHandEmpty());
	}

}