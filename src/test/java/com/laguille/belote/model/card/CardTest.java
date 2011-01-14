/**
 * 
 */
package com.laguille.belote.model.card;

import junit.framework.Assert;

import org.junit.Test;

/**
 * @author guillaume
 * 
 */
public class CardTest
{

	@Test
	public void assertEquals()
	{
		Card c1 = new Card(CardColor.DIAMOND, CardValue.NINE);
		Card c2 = new Card(CardColor.DIAMOND, CardValue.SEVEN);
		Card c3 = new Card(CardColor.DIAMOND, CardValue.NINE);
		Assert.assertEquals(c1, c3);
		Assert.assertFalse(c1.equals(c2));
	}

}
