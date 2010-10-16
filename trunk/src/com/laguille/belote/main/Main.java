package com.laguille.belote.main;

import com.laguille.belote.controller.GameController;
import com.laguille.belote.model.GameModel;
import com.laguille.belote.view.View;
import com.laguille.belote.view.console.ConsoleInterface;

public class Main
{
	public static void main(String[] args)
	{
		GameModel model = new GameModel();
		View view = new ConsoleInterface(model);
		GameController controller = new GameController(model, view);
		controller.initGame();
		controller.startGame();
		
//		model.getFirstTeam().getFirstPlayer().getHand().addCard(model.getDeck().getCard(25));
//		model.getFirstTeam().getFirstPlayer().getHand().addCard(model.getDeck().getCard(24));
//		model.getFirstTeam().getFirstPlayer().getHand().addCard(model.getDeck().getCard(11));
	}
}
