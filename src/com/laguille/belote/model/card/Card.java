package com.laguille.belote.model.card;

public class Card
{

	protected CardColor color;
	protected CardValue value;

	public Card(CardColor color, CardValue value)
	{
		this.color = color;
		this.value = value;
	}

	public CardColor getColor()
	{
		return color;
	}

	public void setColor(CardColor color)
	{
		this.color = color;
	}

	public CardValue getValue()
	{
		return value;
	}

	public void setValue(CardValue value)
	{
		this.value = value;
	}

	public Integer getPoints(CardColor trumpColor)
	{
		if (value == CardValue.NINE && color == trumpColor)
			return 14;
		if (value == CardValue.JACK && color == trumpColor)
			return 20;
		if (value == CardValue.JACK && color != trumpColor)
			return 2;
		if (value == CardValue.QUEEN)
			return 3;
		if (value == CardValue.KING)
			return 4;
		if (value == CardValue.ACE)
			return 11;
		if (value == CardValue.TEN)
			return 10;
		return 0;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (!(obj instanceof Card))
			return false;
		Card card = (Card) obj;
		if (this.color == card.getColor() && this.value == card.getValue())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public String toString()
	{
		return String.format("%s %s\n", getValue(), getColor());
	}

}
