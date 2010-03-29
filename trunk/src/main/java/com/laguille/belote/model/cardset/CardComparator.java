package com.laguille.belote.model.cardset;

import java.util.Comparator;

import com.laguille.belote.model.card.Card;
import com.laguille.belote.model.card.CardColor;

public class CardComparator implements Comparator<Card>
{

	protected static CardColor trumpColor;
	// the played color is used when comparing different card values during a
	// play
	// it would not be used when sorting out a player hand
	protected static CardColor playedColor;
	protected static CardComparator instance = new CardComparator();

	private CardComparator()
	{
	}

	public static CardComparator instance()
	{
		CardComparator.trumpColor = null;
		CardComparator.playedColor = null;
		return instance;
	}

	public static CardComparator instance(CardColor trumpColor)
	{
		CardComparator.trumpColor = trumpColor;
		CardComparator.playedColor = null;
		return instance;
	}

	public static CardComparator instance(CardColor trumpColor,
			CardColor playedColor)
	{
		CardComparator.trumpColor = trumpColor;
		CardComparator.playedColor = playedColor;
		return instance;
	}

	@Override
	public int compare(Card c1, Card c2)
	{
		if (CardComparator.trumpColor == null
				|| CardComparator.playedColor == null)
		{
			// no card has been yet played (it happens when we sort out a
			// player's hand), so arbitrary sorting depending on the ordinal
			// value of the card color
			return new Integer(c1.getColor().ordinal()).compareTo(new Integer(
					c2.getColor().ordinal()));
		}
		else if (c1.getColor() == c2.getColor())
		{
			return c1.getPoints(CardComparator.trumpColor).compareTo(
					c2.getPoints(CardComparator.trumpColor));
		}
		else if (CardComparator.trumpColor != null
				&& c1.getColor() == trumpColor)
		{
			return 1;
		}
		else if (CardComparator.trumpColor != null
				&& c2.getColor() == trumpColor)
		{
			return -1;
		}
		else if (CardComparator.playedColor != null
				&& c1.getColor() == CardComparator.playedColor)
		{ // c2 had to discard
			return 1;
		}
		else if (CardComparator.playedColor != null
				&& c2.getColor() == CardComparator.playedColor)
		{ // c1 had to discard
			return -1;
		}
		else
		// both c1 and c2 had to discard
		{
			return 0;
		}
	}

}
