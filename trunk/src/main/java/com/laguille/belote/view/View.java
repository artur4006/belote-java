package com.laguille.belote.view;

import java.util.Observable;
import java.util.Observer;

import com.laguille.belote.model.GameModel;
import com.laguille.belote.model.cardset.CardHand;

public abstract class View
{
	protected GameModel model;
	
	public View(GameModel model)
	{
		this.model = model;
		this.model.getFirstTeam().getFirstPlayer().getHand().addObserver(handObserver);
	}
	
	protected Observer handObserver = new Observer()
	{

		@Override
		public void update(Observable o, Object arg)
		{
			System.out.println("Hand: " + (CardHand)o);
			
		}
		
	};
}
