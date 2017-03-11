package com.cbschenk.poker.fivecarddraw;

import com.cbschenk.poker.Card;

public class FiveCardDraw {

    //Winning hand is returned, otherwise null if tie
    public static Hand play(Hand hand1, Hand hand2) {
        int hand1Rank = hand1.getRank();
        int hand2Rank = hand2.getRank();
        if (hand1Rank > hand2Rank) {
            return hand1;
        } else if (hand1Rank < hand2Rank) {
            return hand2;
        } else {
            //Tie!
            return null;
        }
    }

    /**
     * Let's make some examples and print them out to the screen
     * @param args
     */
    public static void main(String[] args) {
        //Straight Flush
        Hand straightFlush = new Hand();
        straightFlush.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_2));
        straightFlush.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_3));
        straightFlush.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_4));
        straightFlush.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_5));
        straightFlush.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_6));
        //Four of a Kind
        Hand fourOfAKind = new Hand();
        fourOfAKind.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_10));
        fourOfAKind.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        fourOfAKind.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_10));
        fourOfAKind.addCard(new Card(Card.SUIT_SPADES, Card.CARD_10));
        fourOfAKind.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_2));
        //Full House
        Hand fullHouse = new Hand();
        fullHouse.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_10));
        fullHouse.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        fullHouse.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_ACE));
        fullHouse.addCard(new Card(Card.SUIT_SPADES, Card.CARD_ACE));
        fullHouse.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_ACE));

        //Two Pair (first)
        Hand twoPairFirst = new Hand();
        twoPairFirst.addCard(new Card(Card.SUIT_SPADES, Card.CARD_8));
        twoPairFirst.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_8));
        twoPairFirst.addCard(new Card(Card.SUIT_SPADES, Card.CARD_9));
        twoPairFirst.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_9));
        twoPairFirst.addCard(new Card(Card.SUIT_SPADES, Card.CARD_10));
        //Two Pair (second, tie)
        Hand twoPairSecond = new Hand();
        twoPairSecond.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_8));
        twoPairSecond.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        twoPairSecond.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_9));
        twoPairSecond.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        twoPairSecond.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        //Two Pair (high card)
        Hand twoPairHighCard = new Hand();
        twoPairHighCard.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_8));
        twoPairHighCard.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        twoPairHighCard.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_9));
        twoPairHighCard.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        twoPairHighCard.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_JACK));
        //Two Pair (high second pair)
        Hand twoPairSecondPair = new Hand();
        twoPairSecondPair.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_4));
        twoPairSecondPair.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_8));
        twoPairSecondPair.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        twoPairSecondPair.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_JACK));
        twoPairSecondPair.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_JACK));

        //Play
        playAndPrintResult(straightFlush, fourOfAKind);
        playAndPrintResult(fullHouse, fourOfAKind);
        playAndPrintResult(twoPairFirst, twoPairSecond);
        playAndPrintResult(twoPairFirst, twoPairHighCard);
        playAndPrintResult(twoPairFirst, twoPairSecondPair);
        playAndPrintResult(fullHouse, twoPairFirst);


        System.out.println();
        System.out.println("*************************");
        System.out.println("*** For more examples *** => src/test/com/cbschenk/poker/fivecarddraw/FiveCardDrawTest.java");
        System.out.println("*************************");
    }


    private static void playAndPrintResult(Hand hand1, Hand hand2) {
        Hand winner = play(hand1, hand2);
        String result;
        if (winner == null) {
            result = "(-) vs. (-)";
        } else if (winner.equals(hand1)) {
            result = "(W) vs. (L)";
        } else {
            result = "(L) vs. (W)";
        }
        System.out.println(String.format("%-36s %s %s", hand1, result, hand2));
    }

}
