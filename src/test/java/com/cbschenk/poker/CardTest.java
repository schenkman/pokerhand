package com.cbschenk.poker;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    /************************************************************
     * compareTo(Card other)
     ************************************************************/

    @Test
    public void compareTo_WhenThisCardValueLessThanOtherCardValue() throws Exception {
        Card thisCard = new Card(Card.SUIT_CLUBS, Card.CARD_2);
        Card other = new Card(Card.SUIT_CLUBS, Card.CARD_3);
        assertEquals(-1, thisCard.compareTo(other));
    }

    @Test
    public void compareTo_WhenThisCardValueMoreThanOtherCardValue() throws Exception {
        Card thisCard = new Card(Card.SUIT_CLUBS, Card.CARD_4);
        Card other = new Card(Card.SUIT_CLUBS, Card.CARD_3);
        assertEquals(1, thisCard.compareTo(other));
    }

    @Test
    public void compareTo_WhenThisCardValueEqualsOtherCardValue() throws Exception {
        Card thisCard = new Card(Card.SUIT_CLUBS, Card.CARD_3);
        Card other = new Card(Card.SUIT_DIAMONDS, Card.CARD_3);
        //It compares suits instead, Clubs wins over Diamonds
        assertEquals(1, thisCard.compareTo(other));
    }

    @Test
    public void compareTo_WhenThisCardValueEqualsOtherCardValue2() throws Exception {
        Card thisCard = new Card(Card.SUIT_HEARTS, Card.CARD_3);
        Card other = new Card(Card.SUIT_DIAMONDS, Card.CARD_3);
        //It compares suits instead, Diamonds wins over hearts
        assertEquals(-1, thisCard.compareTo(other));
    }

    @Test
    public void compareTo_WhenCardValuesAndSuitValuesEqual() throws Exception {
        Card thisCard = new Card(Card.SUIT_SPADES, Card.CARD_ACE);
        Card other = new Card(Card.SUIT_SPADES, Card.CARD_ACE);
        assertEquals(0, thisCard.compareTo(other));
    }

}