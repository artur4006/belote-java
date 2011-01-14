package com.laguille.belote.model.player;

import com.laguille.belote.model.cardset.CardStack;


public class Team
{
	protected final Player firstPlayer, secondPlayer;
	protected Integer score;
	protected final CardStack cardStack;
	
	public Team()
	{
		firstPlayer = new Player();
		secondPlayer = new Player();
		cardStack = new CardStack();
		score = 0;
	}
	
	public Player getFirstPlayer()
	{
		return firstPlayer;
	}

	public Player getSecondPlayer()
	{
		return secondPlayer;
	}

	public Integer getScore()
	{
		return score;
	}

	public void addScore(Integer score)
	{
		this.score += score;
	}

	public void resetScore()
	{
		this.score = 0;
	}

	public CardStack getCardStack()
	{
		return cardStack;
	}

	public boolean isTaker()
	{
		return (firstPlayer.isTaker() || secondPlayer.isTaker());
	}
}
