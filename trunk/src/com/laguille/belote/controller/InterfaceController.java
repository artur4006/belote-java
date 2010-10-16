package com.laguille.belote.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.laguille.belote.model.GameModel;
import com.laguille.belote.model.card.CardColor;

public class InterfaceController
{

	protected GameModel model;

	public InterfaceController(GameModel model)
	{
		this.model = model;
	}

	public String askUserName()
	{
		System.out.println("Enter your name: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String userName = null;

		try
		{
			userName = br.readLine();
			while (userName == null || userName.isEmpty())
			{
				System.out.println("Please provide a username.\n");
				userName = br.readLine();
			}
		}
		catch (IOException ioe)
		{
			System.out.println("IO error trying to read your name!");
			System.exit(1);
		}
		return userName;
	}
	
	// TODO
	public boolean askBidFirstRound() 
	{ 
		System.out.println("The bid card is: " + model.getBidCard() + "\n");
		System.out.println("Do you want to take? (Y/N)\n");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String answer = null;

		try
		{
			answer = br.readLine();
			while (answer == null || !answer.matches("[YN]"))
			{
				System.out.println("Do you want to take? (Y/N)\n");
				answer = br.readLine();
			}
		}
		catch (IOException ioe)
		{
			System.out.println("IO error trying to read your answer!");
			System.exit(1);
		}
	
		if (answer.equals("Y"))
		{
			model.getFirstTeam().getFirstPlayer().setIsTaker(true);
			return true;
		}
		else
			return false; 
	}

	// TODO
	public boolean askBidSecondRound() 
	{ 
		System.out.println("Second Round: Indicate the color you want to take (D/H/C/S or N): \n");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String answer = null;

		try
		{
			answer = br.readLine();
			while (answer == null || !answer.matches("[DHCSN]"))
			{
				System.out.println("Second Round: Indicate the color you want to take (D/H/C/S or N): \n");
				answer = br.readLine();
			}
		}
		catch (IOException ioe)
		{
			System.out.println("IO error trying to read your answer!");
			System.exit(1);
		}
	
		if (answer.equals("N"))
			return false;
		else
		{
			if (answer.equals("D"))
			{
				model.setTrumpColor(CardColor.DIAMOND);
			}
			else if (answer.equals("H"))
			{
				model.setTrumpColor(CardColor.HEART);
			}
			else if (answer.equals("C"))
			{
				model.setTrumpColor(CardColor.CLUB);
			}
			else if (answer.equals("S"))
			{
				model.setTrumpColor(CardColor.SPADE);
			}
			model.getFirstTeam().getFirstPlayer().setIsTaker(true);
			return true;
		}

	}
	
}
