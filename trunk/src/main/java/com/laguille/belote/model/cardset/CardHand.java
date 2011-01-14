package com.laguille.belote.model.cardset;

import com.laguille.belote.model.card.Card;

public class CardHand extends CardSet
{

	@Override
	public boolean removeCard(Card card)
	{
		boolean remove = super.removeCard(card);
		if (remove)
		{
			setChanged();
			notifyObservers(card);
		}
		return remove;
	}

	@Override
	public boolean addCard(Card card)
	{
		boolean add = super.addCard(card);
		if (add)
		{
			setChanged();
			notifyObservers(card);
		}
		return add;
	}

	@Override
	public void reset()
	{
		super.reset();
		setChanged();
		notifyObservers();
	}


}
