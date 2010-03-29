/**
 * 
 */
package com.laguille.belote.model.card;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import com.laguille.belote.model.cardset.CardComparator;
import com.laguille.belote.model.cardset.CardDeck;
import com.laguille.belote.model.cardset.CardHand;

/**
 * @author guillaume
 * 
 */
public class CardComparatorTest
{

	static CardDeck deck;
	static CardColor trumpColor;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		deck = CardDeck.getInstance();
		trumpColor = CardColor.HEART;
	}

	@Test
	public void sortCardsNoTrump()
	{
		deck.sort(CardComparator.instance());
		
		CardHand expected = new CardHand();
		for (CardColor color : CardColor.values())
		{
			buildCardSetNoTrumpColor(expected, color);
		}
		Assert.assertEquals(expected, deck);
	}

	@Test
	public void sortCardsWithTrump()
	{
		deck.sort(CardComparator.instance(trumpColor, trumpColor));

		CardHand expected = new CardHand();
		for (CardColor color : CardColor.values())
		{
			if (color != trumpColor)
				buildCardSetNoTrumpColor(expected, color);
		}
		buildCardSetTrumpColor(expected, trumpColor);
		Assert.assertEquals(expected, deck);
	}
	
	private List<Card> buildCardSetNoTrumpColor(CardHand hand, CardColor color)
	{
		List<Card> cards = new ArrayList<Card>();
		hand.addCard(new Card(color, CardValue.SEVEN));
		hand.addCard(new Card(color, CardValue.EIGHT));
		hand.addCard(new Card(color, CardValue.NINE));
		hand.addCard(new Card(color, CardValue.JACK));
		hand.addCard(new Card(color, CardValue.QUEEN));
		hand.addCard(new Card(color, CardValue.KING));
		hand.addCard(new Card(color, CardValue.TEN));
		hand.addCard(new Card(color, CardValue.ACE));
		return cards;
	}

	private List<Card> buildCardSetTrumpColor(CardHand hand, CardColor color)
	{
		List<Card> cards = new ArrayList<Card>();
		hand.addCard(new Card(color, CardValue.SEVEN));
		hand.addCard(new Card(color, CardValue.EIGHT));
		hand.addCard(new Card(color, CardValue.QUEEN));
		hand.addCard(new Card(color, CardValue.KING));
		hand.addCard(new Card(color, CardValue.TEN));
		hand.addCard(new Card(color, CardValue.ACE));
		hand.addCard(new Card(color, CardValue.NINE));
		hand.addCard(new Card(color, CardValue.JACK));
		return cards;
	}

}