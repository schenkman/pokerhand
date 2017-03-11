package com.cbschenk.poker.fivecarddraw;

import com.cbschenk.poker.Card;
import org.junit.Test;

import static org.junit.Assert.*;

public class FiveCardDrawTest {

    /**************************************************
     * play(Hand hand1, Hand hand2) - STRAIGHT FLUSH VS
     **************************************************/

    @Test
    public void play_RoyalFlushVsStraightFlush() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_JACK));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_QUEEN));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_KING));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_ACE));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_10));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_JACK));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_QUEEN));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_StraightFlushVsStraightFlushTie() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_JACK));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_QUEEN));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_KING));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_ACE));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_10));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_JACK));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_QUEEN));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_KING));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_ACE));
        //Tie
        assertEquals(null, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_StraightFlushVsFourOfAKind() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_3));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_4));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_6));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_10));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_10));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_10));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_2));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_StraightFlushVsFullHouse() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_3));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_4));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_6));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_10));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_ACE));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_ACE));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_ACE));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_StraightFlushVsFlush() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_3));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_4));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_6));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_3));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_4));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_KING));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_StraightFlushVsStraight() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_3));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_4));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_6));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_5));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_6));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_StraightFlushVsThreeOfAKind() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_3));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_4));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_6));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_StraightFlushVsTwoPair() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_3));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_4));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_6));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_StraightFlushVsOnePair() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_3));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_4));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_6));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_7));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_StraightFlushVsHighCard() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_3));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_4));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_6));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_2));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_4));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    /**************************************************
     * play(Hand hand1, Hand hand2) - FOUR OF A KIND VS
     **************************************************/

    @Test
    public void play_FourOfAKindVsFourOfAKind() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_JACK));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_3));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_10));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_10));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_10));
        assertEquals(hand2, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_FourOfAKindVsFullHouse() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_JACK));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_10));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_ACE));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_ACE));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_ACE));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_FourOfAKindVsFlush() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_JACK));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_3));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_4));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_KING));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_FourOfAKindVsStraight() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_JACK));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_5));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_6));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_FourOfAKindVsThreeOfAKind() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_JACK));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_FourOfAKindVsTwoPair() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_JACK));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_FourOfAKindVsOnePair() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_JACK));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_7));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_FourOfAKindVsHighCard() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_JACK));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_2));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_4));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_ACE));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    /**************************************************
     * play(Hand hand1, Hand hand2) - FULL HOUSE VS
     **************************************************/

    @Test
    public void play_FullHouseVsFullHouse() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_10));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_ACE));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_ACE));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_ACE));
        assertEquals(hand2, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_FullHouseVsFullHouseTiedTwoPair() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_JACK));
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_JACK));
        hand1.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_JACK));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_JACK));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_6));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_6));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_6));
        //High three-pair wins
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_FullHouseVsFlush() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_JACK));
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_JACK));
        hand1.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_3));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_4));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_KING));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_FullHouseVsStraight() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_JACK));
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_JACK));
        hand1.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_5));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_6));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_FullHouseVsThreeOfAKind() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_JACK));
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_JACK));
        hand1.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_FullHouseVsTwoPair() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_JACK));
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_JACK));
        hand1.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_FullHouseVsOnePair() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_JACK));
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_JACK));
        hand1.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_7));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_FullHouseVsHighCard() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_JACK));
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_JACK));
        hand1.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_2));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_4));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_ACE));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    /**************************************************
     * play(Hand hand1, Hand hand2) - FLUSH VS
     **************************************************/

    @Test
    public void play_FlushVsFlush() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_3));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_4));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_KING));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_5));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_JACK));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_ACE));
        assertEquals(hand2, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_FlushVsFlushTie() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_4));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_QUEEN));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_KING));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_2));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_4));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_QUEEN));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_KING));
        //Tie
        assertEquals(null, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_FlushVsFlushTieHighCard() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_3));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_4));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_QUEEN));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_KING));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_5));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_JACK));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_KING));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_FlushVsFlushTieToFifthCard() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_4));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_QUEEN));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_KING));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_3));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_4));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_QUEEN));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_KING));
        assertEquals(hand2, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_FlushVsStraight() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_4));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_5));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_6));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_FlushVsThreeOfAKind() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_4));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_FlushVsTwoPair() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_4));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_FlushVsOnePair() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_4));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_7));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_FlushVsHighCard() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_4));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_2));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_4));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    /**************************************************
     * play(Hand hand1, Hand hand2) - STRAIGHT VS
     **************************************************/

    @Test
    public void play_StraightVsStraight() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_3));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_4));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_6));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_5));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_6));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_7));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_9));
        assertEquals(hand2, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_StraightVsStraightTie() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_3));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_4));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_6));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_2));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_3));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_4));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_5));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_6));
        //Tie
        assertEquals(null, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_StraightVsThreeOfAKind() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_3));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_4));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_6));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_StraightVsTwoPair() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_3));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_4));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_6));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_StraightVsOnePair() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_3));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_4));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_6));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_7));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_StraightVsHighCard() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_3));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_4));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_6));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_2));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_4));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    /**************************************************
     * play(Hand hand1, Hand hand2) - THREE OF A KIND VS
     **************************************************/

    @Test
    public void play_ThreeOfAKindVsThreeOfAKind() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_6));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        assertEquals(hand2, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_ThreeOfAKindVsTwoPair() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_6));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_ThreeOfAKindVsOnePair() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_6));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_7));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_ThreeOfAKindVsHighCard() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_5));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_6));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_2));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_4));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    /**************************************************
     * play(Hand hand1, Hand hand2) - TWO PAIR VS
     **************************************************/

    @Test
    public void play_TwoPairVsTwoPair() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_3));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_3));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_5));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        assertEquals(hand2, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_TwoPairVsTwoPairFullTie() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_3));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_3));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_4));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_4));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_QUEEN));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_3));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_3));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_4));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_4));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_QUEEN));
        assertEquals(null, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_TwoPairVsTwoPairTieHighPair() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_2));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_8));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_ACE));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_7));
        hand2.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        //Win by lower pair
        assertEquals(hand2, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_TwoPairVsTwoPairTieBothPairs() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_8));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_ACE));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_7));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        //Win by high card
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_TwoPairVsOnePair() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_8));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_ACE));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_6));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_TwoPairVsHighCard() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_8));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_6));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_8));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_ACE));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    /**************************************************
     * play(Hand hand1, Hand hand2) - ONE PAIR VS
     **************************************************/

    @Test
    public void play_OnePairVsOnePair() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_6));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_8));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_ACE));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_6));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        assertEquals(hand2, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_OnePairVsOnePairTie() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_6));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_9));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_ACE));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_6));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        //Win by high card
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_OnePairVsOnePairTieWithHighCardTie() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_6));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_9));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        hand1.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_10));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_6));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        //Tie
        assertEquals(null, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_OnePairVsOnePairTieWithHighCardTieUnderPair() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_3));
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_6));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_9));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_3));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_6));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_9));
        //Tie
        assertEquals(null, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_OnePairVsHighCard() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_3));
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_6));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_9));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_3));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_6));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_JACK));
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    /**************************************************
     * play(Hand hand1, Hand hand2) - HIGH CARD VS
     **************************************************/

    @Test
    public void play_HighCardVsHighCard() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_3));
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_6));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_9));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_10));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_3));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_6));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_JACK));
        assertEquals(hand2, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_HighCardVsHighCardTie() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_3));
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_6));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_JACK));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_3));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_6));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_JACK));
        //Drops to second-highest card
        assertEquals(hand1, FiveCardDraw.play(hand1, hand2));
    }

    @Test
    public void play_HighCardVsHighCardTieAllCards() throws Exception {
        Hand hand1 = new Hand();
        hand1.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_3));
        hand1.addCard(new Card(Card.SUIT_SPADES, Card.CARD_6));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        hand1.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_9));
        hand1.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_JACK));
        Hand hand2 = new Hand();
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_3));
        hand2.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_6));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        hand2.addCard(new Card(Card.SUIT_SPADES, Card.CARD_9));
        hand2.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_JACK));
        //Drops to high card suit
        assertEquals(null, FiveCardDraw.play(hand1, hand2));
    }

}