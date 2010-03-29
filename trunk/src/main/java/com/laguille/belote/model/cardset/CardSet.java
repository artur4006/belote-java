package com.laguille.belote.model.cardset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;

import com.laguille.belote.model.card.Card;

public abstract class CardSet extends Observable
{
	protected final List<Card> cards;

	public CardSet()
	{
		this.cards = new ArrayList<Card>();
	}
	
	public Card getCard(int index)
	{
		return cards.get(index);
	}
	
	public void sort(Comparator<Card> comparator)
	{
		Collections.sort(cards, comparator);
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for (Card card : cards)
		{
			sb.append(card);
		}
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (!(obj instanceof CardSet))
			return false;
		CardSet cardSet = (CardSet) obj;
		int index = 0;
		while (index < this.cards.size())
		{
			if (!this.cards.get(index).equals(cardSet.cards.get(index)))
					return false;
			index++;
		}
		return true;
	}
	
	public boolean addCard(Card card)
	{
		return contains(card) ? false : cards.add(card);
	}
	
	public boolean removeCard(Card card)
	{
		return cards.remove(card);
	}
	
	public void reset()
	{
		cards.clear();
	}
	
	public boolean contains(Card card)
	{
		return cards.contains(card);
	}

}
