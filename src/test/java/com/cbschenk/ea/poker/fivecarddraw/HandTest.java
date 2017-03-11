package com.cbschenk.ea.poker.fivecarddraw;

import com.cbschenk.ea.poker.Card;
import org.junit.Test;

import static org.junit.Assert.*;

public class HandTest {


    /************************************************************
     * getHandType()
     ************************************************************/
    @Test
    public void getHandType_StraightFlush() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_JACK));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_QUEEN));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_KING));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_ACE));
        assertEquals(Hand.HAND_STRAIGHT_FLUSH, hand.getHandType());
    }


    @Test
    public void getHandType_FourOfAKind() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_10));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_10));
        hand.addCard(new Card(Card.SUIT_SPADES, Card.CARD_10));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_ACE));
        assertEquals(Hand.HAND_FOUR_OF_A_KIND, hand.getHandType());
    }

    @Test
    public void getHandType_FourOfAKindShifted() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_9));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_10));
        hand.addCard(new Card(Card.SUIT_SPADES, Card.CARD_10));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_10));
        assertEquals(Hand.HAND_FOUR_OF_A_KIND, hand.getHandType());
    }

    @Test
    public void getHandType_FullHouse() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_10));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_10));
        hand.addCard(new Card(Card.SUIT_SPADES, Card.CARD_ACE));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_ACE));
        assertEquals(Hand.HAND_FULL_HOUSE, hand.getHandType());
    }

    @Test
    public void getHandType_FullHouseSwapped() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_10));
        hand.addCard(new Card(Card.SUIT_SPADES, Card.CARD_ACE));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_ACE));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_ACE));
        assertEquals(Hand.HAND_FULL_HOUSE, hand.getHandType());
    }

    @Test
    public void getHandType_Flush() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_5));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_6));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_9));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_10));
        assertEquals(Hand.HAND_FLUSH, hand.getHandType());
    }

    @Test
    public void getHandType_Straight() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_8));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_9));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_10));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_JACK));
        assertEquals(Hand.HAND_STRAIGHT, hand.getHandType());
    }

    @Test
    public void getHandType_ThreeOfAKindFront() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_5));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        assertEquals(Hand.HAND_THREE_OF_A_KIND, hand.getHandType());
    }

    @Test
    public void getHandType_ThreeOfAKindMid() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_2));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        assertEquals(Hand.HAND_THREE_OF_A_KIND, hand.getHandType());
    }

    @Test
    public void getHandType_ThreeOfAKindBack() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_4));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_7));
        assertEquals(Hand.HAND_THREE_OF_A_KIND, hand.getHandType());
    }

    @Test
    public void getHandType_TwoPairFront() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_2));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_2));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        assertEquals(Hand.HAND_TWO_PAIR, hand.getHandType());
    }

    @Test
    public void getHandType_TwoPairEnd() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_2));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_7));
        assertEquals(Hand.HAND_TWO_PAIR, hand.getHandType());
    }

    @Test
    public void getHandType_TwoPairSplit() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_5));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_7));
        assertEquals(Hand.HAND_TWO_PAIR, hand.getHandType());
    }

    @Test
    public void getHandType_OnePairFront() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_2));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_2));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_6));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        assertEquals(Hand.HAND_ONE_PAIR, hand.getHandType());
    }

    @Test
    public void getHandType_OnePairMid() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_2));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_5));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        assertEquals(Hand.HAND_ONE_PAIR, hand.getHandType());
    }

    @Test
    public void getHandType_OnePairEnd() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_2));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_4));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_7));
        assertEquals(Hand.HAND_ONE_PAIR, hand.getHandType());
    }

    @Test
    public void getHandType_HighCard() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_2));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_5));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_9));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_10));
        assertEquals(Hand.HAND_HIGH_CARD, hand.getHandType());
    }


    /************************************************************
     * getHandType() - Setting of extra information for hand
     ************************************************************/

    @Test
    public void getHandType_StraightFlushSetsHighCard() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_JACK));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_QUEEN));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_KING));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_ACE));
        hand.getHandType();
        assertEquals(new Card(Card.SUIT_DIAMONDS, Card.CARD_ACE),hand.getHighCard());
    }

    @Test
    public void getHandType_FourOfAKindSetsCard() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_4));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_10));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_10));
        hand.addCard(new Card(Card.SUIT_SPADES, Card.CARD_10));
        hand.getHandType();
        assertEquals(Card.CARD_10, hand.getFourOfAKindCard().value);
    }

    @Test
    public void getHandType_FourOfAKindSetsOffCard() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_4));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_10));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_10));
        hand.addCard(new Card(Card.SUIT_SPADES, Card.CARD_10));
        hand.getHandType();
        assertEquals(new Card(Card.SUIT_DIAMONDS, Card.CARD_4), hand.getFourOfAKindOffCard());
    }

    @Test
    public void getHandType_FullHouseSetsPairCard() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_10));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_10));
        hand.addCard(new Card(Card.SUIT_SPADES, Card.CARD_ACE));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_ACE));
        hand.getHandType();
        assertEquals(Card.CARD_ACE, hand.getFirstPairCard().value);
    }

    @Test
    public void getHandType_FullHouseSetsThreeOfAKindCard() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_10));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_10));
        hand.addCard(new Card(Card.SUIT_SPADES, Card.CARD_ACE));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_ACE));
        hand.getHandType();
        assertEquals(Card.CARD_10, hand.getThreeOfAKindCard().value);
    }

    @Test
    public void getHandType_FullHouseSwappedSetsPairCard() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_10));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_ACE));
        hand.addCard(new Card(Card.SUIT_SPADES, Card.CARD_ACE));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_ACE));
        hand.getHandType();
        assertEquals(Card.CARD_10, hand.getFirstPairCard().value);
    }

    @Test
    public void getHandType_FullHouseSwappedThreeOfAKindCard() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_10));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_ACE));
        hand.addCard(new Card(Card.SUIT_SPADES, Card.CARD_ACE));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_ACE));
        hand.getHandType();
        assertEquals(Card.CARD_ACE, hand.getThreeOfAKindCard().value);
    }

    @Test
    public void getHandType_FlushSetsHighCard() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_5));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_6));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_9));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_10));
        hand.getHandType();
        assertEquals(new Card(Card.SUIT_CLUBS, Card.CARD_10), hand.getHighCard());
    }

    @Test
    public void getHandType_ThreeOfAKindSetsCard() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_2));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        hand.getHandType();
        assertEquals(Card.CARD_3, hand.getThreeOfAKindCard().value);
    }

    @Test
    public void getHandType_TwoPairSetsFirstPairCard() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_5));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_7));
        hand.getHandType();
        assertEquals(Card.CARD_3, hand.getFirstPairCard().value);
    }

    @Test
    public void getHandType_TwoPairSetsSecondPairCard() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_5));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_7));
        hand.getHandType();
        assertEquals(Card.CARD_7, hand.getSecondPairCard().value);
    }

    @Test
    public void getHandType_OnePairSetsFirstPairCard() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_2));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_2));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_6));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        hand.getHandType();
        assertEquals(Card.CARD_2, hand.getFirstPairCard().value);
    }

    @Test
    public void getHandType_HighCardSetsHighCard() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_2));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_5));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_9));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_10));
        hand.getHandType();
        assertEquals(Card.CARD_10, hand.getHighCard().value);
    }

    /************************************************************
     * getRank() - Checking encodings for each hand type
     ************************************************************/

    @Test
    public void getRank_StraightFlush() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_JACK));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_QUEEN));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_KING));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_ACE));
        int encoding = (Hand.HAND_STRAIGHT_FLUSH << 20)
                +(Card.CARD_ACE << 16); //high card value
        assertEquals(encoding, hand.getRank());
    }

    @Test
    public void getRank_FourOfAKind() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_5));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_5));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_5));
        hand.addCard(new Card(Card.SUIT_SPADES, Card.CARD_5));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_8));
        int encoding = (Hand.HAND_FOUR_OF_A_KIND << 20)
                +(Card.CARD_5 << 16); //four of a kind value
        assertEquals(encoding, hand.getRank());
    }

    @Test
    public void getRank_FullHouse() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_5));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_5));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_7));
        hand.addCard(new Card(Card.SUIT_SPADES, Card.CARD_7));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_7));
        int encoding = (Hand.HAND_FULL_HOUSE << 20)
                +(Card.CARD_7 << 16); //three of a kind value
        assertEquals(encoding, hand.getRank());
    }

    @Test
    public void getRank_Flush() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_5));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_JACK));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_KING));
        int encoding = (Hand.HAND_FLUSH << 20)
                +(Card.CARD_KING << 16) //card 5 value
                +(Card.CARD_JACK << 12) //card 4 value
                +(Card.CARD_8 << 8)     //card 3 value
                +(Card.CARD_7 << 4)     //card 2 value
                +(Card.CARD_5);         //card 1 value
        assertEquals(encoding, hand.getRank());
    }

    @Test
    public void getRank_Straight() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_5));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_6));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        int encoding = (Hand.HAND_STRAIGHT << 20)
                +(Card.CARD_9 << 16) //card 5 value
                +(Card.CARD_8 << 12) //card 4 value
                +(Card.CARD_7 << 8)  //card 3 value
                +(Card.CARD_6 << 4)  //card 2 value
                +(Card.CARD_5);      //card 1 value
        assertEquals(encoding, hand.getRank());
    }

    @Test
    public void getRank_ThreeOfAKind() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_5));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_6));
        hand.addCard(new Card(Card.SUIT_SPADES, Card.CARD_6));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_6));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_7));
        int encoding = (Hand.HAND_THREE_OF_A_KIND << 20)
                +(Card.CARD_6 << 16); //three of a kind value
        assertEquals(encoding, hand.getRank());
    }

    @Test
    public void getRank_TwoPair() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_SPADES, Card.CARD_4));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_9));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        int encoding = (Hand.HAND_TWO_PAIR << 20)
                +(Card.CARD_9 << 16) //high pair value
                +(Card.CARD_3 << 12) //low pair value
                +(Card.CARD_4 << 8); //remaining card value
        assertEquals(encoding, hand.getRank());
    }

    @Test
    public void getRank_OnePair() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_2));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_SPADES, Card.CARD_JACK));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_JACK));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_QUEEN));
        int encoding = (Hand.HAND_ONE_PAIR << 20)
                +(Card.CARD_JACK << 16)  //low pair value
                +(Card.CARD_QUEEN << 12) //remaining card value 3
                +(Card.CARD_3 << 8)      //remaining card value 2
                +(Card.CARD_2 << 4);     //remaining card value 1
        assertEquals(encoding, hand.getRank());
    }

    @Test
    public void getRank_HighCard() throws Exception {
        Hand hand = new Hand();
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_2));
        hand.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_3));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        hand.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_9));
        hand.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_KING));
        int encoding = (Hand.HAND_HIGH_CARD << 20)
                +(Card.CARD_KING << 16) //card 5 value
                +(Card.CARD_9 << 12)    //card 4 value
                +(Card.CARD_7 << 8)     //card 3 value
                +(Card.CARD_3 << 4)     //card 2 value
                +(Card.CARD_2);         //card 1 value
        assertEquals(encoding, hand.getRank());
    }
}