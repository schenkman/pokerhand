package com.cbschenk.ea.poker.fivecarddraw;

public class FiveCardDraw {

    public static void main(String[] args) {


    }

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

}
