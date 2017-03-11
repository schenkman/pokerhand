package com.cbschenk.ea.poker;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Card implements Comparable<Card> {
    public static final int SUIT_SPADES = 0;
    public static final int SUIT_HEARTS= 1;
    public static final int SUIT_DIAMONDS = 2;
    public static final int SUIT_CLUBS = 3;

    public static final int CARD_2 = 2;
    public static final int CARD_3 = 3;
    public static final int CARD_4 = 4;
    public static final int CARD_5 = 5;
    public static final int CARD_6 = 6;
    public static final int CARD_7 = 7;
    public static final int CARD_8 = 8;
    public static final int CARD_9 = 9;
    public static final int CARD_10 = 10;
    public static final int CARD_JACK = 11;
    public static final int CARD_QUEEN = 12;
    public static final int CARD_KING = 13;
    public static final int CARD_ACE = 14;

    private static final Map<Integer, String> names = generateNameMap();
    private static final Map<Integer, String> suits = generateSuitMap();

    private static Map<Integer, String> generateNameMap() {
        Map<Integer, String> hm = new HashMap<>();
        hm.put(2, "2");
        hm.put(3, "3");
        hm.put(4, "4");
        hm.put(5, "5");
        hm.put(6, "6");
        hm.put(7, "7");
        hm.put(8, "8");
        hm.put(9, "9");
        hm.put(10, "10");
        hm.put(11, "J");
        hm.put(12, "Q");
        hm.put(13, "K");
        hm.put(14, "A");
        return hm;
    }
    private static Map<Integer, String> generateSuitMap() {
        Map<Integer, String> hm = new HashMap<>();
//        hm.put(0, "\u2660"); //Spade
//        hm.put(1, "\u2665"); //Heart
//        hm.put(2, "\u2666"); //Diamond
//        hm.put(3, "\u2667"); //Club
        hm.put(0, "S");
        hm.put(1, "H");
        hm.put(2, "D");
        hm.put(3, "C");
//        hm.put(0, "Spades");
//        hm.put(1, "Hearts");
//        hm.put(2, "Diamonds");
//        hm.put(3, "Clubs");
        return hm;
    }

    public final int suit;
    public final int value;

    public Card(int suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%2s%s", names.get(this.value), suits.get(this.suit));
    }

    /**
     * Compares two cards together to determine ordering first by value, then by suit
     * where suit is ordered lexicographically: Clubs, Diamonds, Hearts, Spades
     * @param other Card to compare to
     * @return -1 if less than other card, 0 if equal, 1 if greater than other card
     */
    @Override
    public int compareTo(Card other) {
        //Check if card value is greater first
        //Then check if suit is greater as secondary sort
        int ret;
        if(this.value < other.value) {
            ret = -1;
        } else if(this.value > other.value) {
            ret = 1;
        } else if(this.suit < other.suit) {
            ret = -1;
        } else if(this.suit > other.suit) {
            ret = 1;
        } else {
            ret = 0;
        }
        return ret;
    }

    /**
     * Tests if this card is equal to another based on suit and value
     * @param other Card to compare to
     * @return true if suit and value match, otherwise false
     */
    @Override
    public boolean equals(Object other) {
        if(this == other)
            return true;
        if(other == null)
            return false;
        if(other.getClass() != other.getClass())
            return false;
        Card c = (Card) other;
        return this.suit == c.suit && this.value == c.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value, this.suit);
    }
}

