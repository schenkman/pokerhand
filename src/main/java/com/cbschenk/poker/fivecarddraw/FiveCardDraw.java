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

        //Flush high
        Hand flushHigh = new Hand();
        flushHigh.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_3));
        flushHigh.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_5));
        flushHigh.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        flushHigh.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        flushHigh.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_KING));
        //Flush low
        Hand flushLow = new Hand();
        flushLow.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_3));
        flushLow.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_4));
        flushLow.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_8));
        flushLow.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_9));
        flushLow.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_KING));

        //One Pair
        Hand onePair = new Hand();
        onePair.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_7));
        onePair.addCard(new Card(Card.SUIT_SPADES, Card.CARD_8));
        onePair.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_8));
        onePair.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_9));
        onePair.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_10));
        //High Card
        Hand highCard = new Hand();
        highCard.addCard(new Card(Card.SUIT_CLUBS, Card.CARD_3));
        highCard.addCard(new Card(Card.SUIT_SPADES, Card.CARD_6));
        highCard.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_7));
        highCard.addCard(new Card(Card.SUIT_DIAMONDS, Card.CARD_9));
        highCard.addCard(new Card(Card.SUIT_HEARTS, Card.CARD_ACE));


        //Play
        playAndPrintResult(straightFlush, fourOfAKind);
        playAndPrintResult(fullHouse, fourOfAKind);
        playAndPrintResult(flushHigh, flushLow);
        playAndPrintResult(onePair, highCard);
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
        String hand1Prefix = "", hand2Prefix = "";
        if (winner == null) {
            hand1Prefix = "TIE";
            hand2Prefix = "TIE";
        } else if (winner.equals(hand1)) {
            hand1Prefix = "WIN";
        } else {
            hand2Prefix = "WIN";
        }
        System.out.println("***************************************************************************************");
        System.out.println(" Result       Cards              Hand          Integer   Hand   Tie Breaker");
        printHand(hand1Prefix, hand1, true);
        printHand(hand2Prefix, hand2, false);
    }

    /**
     * Prints a hand with decoded rank either above or below for better visualization
     * @param resultPrefix 3-character max string stating win/loss/tie in some manner
     * @param hand Hand to be printed
     * @param top display decoded rank either above or below hand row
     */
    private static void printHand(String resultPrefix, Hand hand, boolean top) {
        String handRow = String.format("  %-3s  %-37s %10d  %s", resultPrefix, hand, hand.getRank(), formatBits(hand.getRank()));
        String rankRow = String.format("%87s", decodeInt(hand.getRank()));
        if (top) {
            System.out.println(rankRow);
            System.out.println(handRow);
        } else {
            System.out.println(handRow);
            System.out.println(rankRow);
        }
    }

    /**
     * Pretty-printing of rank value to visualize the encoding
     * @param rank
     * @return Binary representation of rank with spaces every 4 bits
     */
    private static String formatBits(int rank) {
        char[] bits = String.format("%24s", Integer.toBinaryString(rank)).replace(' ', '0').toCharArray();
        //Add spaces every four bits
        StringBuffer sb = new StringBuffer(24/4 - 1);
        for(int i = 0; i < bits.length; i++) {
            sb.append(bits[i]);
            if ((i+1) % 4 == 0) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    /**
     * Creates a string representation of the integer values for every 4 bits
     * i.e.
     *      0010 1001 1000 1010 0000 0000
     *        2    9    8   10    0    0
     */
    private static String decodeInt(int rank) {
        StringBuffer sb = new StringBuffer(29);
        for(int i = 20; i >= 0; i -= 4) {
            int value = (rank >> i) & 0xF;
            sb.append(String.format("%3d  ", value));
        }
        return sb.toString();
    }

}
