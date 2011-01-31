package com.laguille.belote.view;

import java.util.Observable;
import java.util.Observer;

import com.laguille.belote.model.GameModel;
import com.laguille.belote.model.cardset.CardHand;
import com.laguille.belote.model.cardset.CardTable;

public abstract class View
{
	protected GameModel model;
	
	public View(GameModel model)
	{
		this.model = model;
		this.model.getFirstTeam().getFirstPlayer().getHand().addObserver(handObserver);
		this.model.getTable().addObserver(tableObserver);
	}
	
	protected Observer handObserver = new Observer()
	{

		@Override
		public void update(Observable o, Object arg)
		{
			if (o instanceof CardHand)
			{
				CardHand hand = (CardHand)o;
				System.out.println("Hand:\n" + hand);
			}
		}
		
	};
	
	protected Observer tableObserver = new Observer()
	{
		@Override
		public void update(Observable o, Object arg)
		{
			if (o instanceof CardTable)
			{
				CardTable table = (CardTable)o;
				System.out.println("Table:\n" + table);
			}
			
		}
		
	};
	
	public abstract void askUserName();
	
	public abstract void askBidFirstRound();

	public abstract void askBidSecondRound();
	
	public abstract void askCardToPlay();
	
	public abstract void displayWarning(String message);
}

