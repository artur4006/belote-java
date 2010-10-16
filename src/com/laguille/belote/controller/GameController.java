package com.laguille.belote.controller;

import java.util.ArrayList;
import java.util.List;

import com.laguille.belote.model.GameModel;
import com.laguille.belote.model.card.Card;
import com.laguille.belote.model.cardset.CardDeck;
import com.laguille.belote.model.player.Player;
import com.laguille.belote.view.View;

public class GameController
{

	protected GameModel model;
	protected List<View> views;
	protected InterfaceController interfaceController;

	public GameController(GameModel model, View... views)
	{
		this.model = model;
		this.views = new ArrayList<View>();
		this.interfaceController = new InterfaceController(model);
		for (View view : views)
		{
			this.views.add(view);
		}
	}

	public void addView(View view)
	{
		views.add(view);
	}

	public void removeView(View view)
	{
		views.remove(view);
	}

	public void initGame()
	{
		// init names
		this.model.getFirstTeam().getFirstPlayer().setName(
				interfaceController.askUserName());
		this.model.getFirstTeam().getSecondPlayer().setName("Player 2");
		this.model.getSecondTeam().getFirstPlayer().setName("Player 3");
		this.model.getSecondTeam().getSecondPlayer().setName("Player 4");

		// shuffle the deck
		model.getDeck().shuffle();
	}

	public void startGame()
	{

		while (true)
		{

			// distribute the cards
			distributeCardsFirstRound();
			
			// reveal the card on the top of the deck
			Card bidCard = model.getDeck().removeCardOnTop();
			model.setBidCard(bidCard);
			
			// ask for bids
			if (!interfaceController.askBidFirstRound() && !interfaceController.askBidSecondRound())
			{
				// TO CHANGE: ask other players, at the moment it's only the human player
				putCardsBackIntoDeck(model.getDeck(), model.getPlayers());
				continue;
			}
			
			// if bid, distribute
			distributeCardsSecondRound();
			
			// first player round :
			// - ask for choice
			// - ref engine checks choice is valid
			// - remove card from his hand (view should refresh view observer)
			// - set it as the card played (view refreshed via observer)
			// set next player
	
			// same things for all players
	
			// ref engine decides which player wins the round
	
			// cards are transferred to the team card stack

			// and so on for 8 rounds
	
			// ref engine decides the score (capot, dedans, ...)
			
			// 	cards are moved back into the deck:	putCardBackIntoDeck(model.getDeck(), model.getPlayers());

			// change distributer
		}

	}

	/**
	 * This method is used when a round is finished to put the players cards back into the deck
	 * @param deck
	 * @param players
	 */
	protected void putCardsBackIntoDeck(CardDeck deck, Player[] players) {
		for (Player player : players)
		{
			deck.addCards(player.getHand());
			player.getHand().reset();
		}
		
	}

	protected void distributeCardsFirstRound()
	{
		Card card = null;
		Player player = model.getCurrentDistributer();
		for (int i = 0 ; i < model.getPlayers().length ; i++)
		{
			player = model.getNextPlayer(player);
			for (int cardNum = 0; cardNum < 3; cardNum++)
			{
				card = model.getDeck().removeCardOnTop();
				player.getHand().addCard(card);
			}
		}
		for (int i = 0 ; i < model.getPlayers().length ; i++)
		{
			player = model.getNextPlayer(player);
			for (int cardNum = 0; cardNum < 2; cardNum++)
			{
				card = model.getDeck().removeCardOnTop();
				player.getHand().addCard(card);
			}
		}
	}

	protected void distributeCardsSecondRound()
	{
		Card card = null;
		Player player = model.getCurrentDistributer();
		for (int i = 0 ; i < model.getPlayers().length ; i++)
		{
			player = model.getNextPlayer(player);
			if (player.equals(model.getTaker()))
			{
				player.getHand().addCard(model.getBidCard());
				model.setBidCard(null);
				for (int cardNum = 0; cardNum < 2; cardNum++)
				{
					card = model.getDeck().removeCardOnTop();
					player.getHand().addCard(card);
				}
			}
			else
			{
				for (int cardNum = 0; cardNum < 3; cardNum++)
				{
					card = model.getDeck().removeCardOnTop();
					player.getHand().addCard(card);
				}
			}
		}
	}

}
