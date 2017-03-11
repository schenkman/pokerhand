package com.cbschenk.poker.fivecarddraw;

import com.cbschenk.poker.Card;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Hand {
    public static final int HAND_STRAIGHT_FLUSH = 8;
    public static final int HAND_FOUR_OF_A_KIND = 7;
    public static final int HAND_FULL_HOUSE = 6;
    public static final int HAND_FLUSH = 5;
    public static final int HAND_STRAIGHT = 4;
    public static final int HAND_THREE_OF_A_KIND = 3;
    public static final int HAND_TWO_PAIR = 2;
    public static final int HAND_ONE_PAIR = 1;
    public static final int HAND_HIGH_CARD = 0;

    private static final Map<Integer, String> names = generateNameMap();
    private static Map<Integer, String> generateNameMap() {
        Map<Integer, String> hm = new HashMap<>();
        hm.put(HAND_STRAIGHT_FLUSH, "Straight Flush");
        hm.put(HAND_FOUR_OF_A_KIND, "Four of a Kind");
        hm.put(HAND_FULL_HOUSE, "Full House");
        hm.put(HAND_FLUSH, "Flush");
        hm.put(HAND_STRAIGHT, "Straight");
        hm.put(HAND_THREE_OF_A_KIND, "Three of a Kind");
        hm.put(HAND_TWO_PAIR, "Two Pair");
        hm.put(HAND_ONE_PAIR, "One Pair");
        hm.put(HAND_HIGH_CARD, "High Card");
        return hm;
    }

    private NavigableSet<Card> cards = new TreeSet<>();

    private int rank = 0;
    private int handType = 0;
    private Card firstPairCard = null;
    private Card secondPairCard = null;
    private Card threeOfAKindCard = null;
    private Card fourOfAKindCard = null;
    private Card fourOfAKindOffCard = null;
    private Card highCard = null;

    public int getRank() {
        return rank;
    }
    public int getHandType() {
        return handType;
    }

    public Card getFirstPairCard() {
        return firstPairCard;
    }
    public Card getSecondPairCard() {
        return secondPairCard;
    }
    public Card getThreeOfAKindCard() {
        return threeOfAKindCard;
    }
    public Card getFourOfAKindCard() {
        return fourOfAKindCard;
    }
    public Card getFourOfAKindOffCard() {
        return fourOfAKindOffCard;
    }
    public Card getHighCard() {
        return highCard;
    }

    /**
     * Adds a card to the hand. Cards must be unique and the total number of cards cannot exceed 5.
     * @param card Card to be added to hand
     */
    public void addCard(Card card) {
        if(cards.size() == 5) {
            throw new IllegalArgumentException("Hand already has 5 cards");
        } else if(cards.contains(card)) {
            throw new IllegalArgumentException(String.format("Card %s already present in hand %s", card, this));
        }
        cards.add(card);
        //Compute our rank if we have a full hand
        if (cards.size() == 5) {
            computeRank();
        }
    }

    /**
     * Computes the hand type for the given cards while also tracking pertinent
     * information as instance attributes for each type of hand.
     *
     * Straight flush - high card
     * Four of a kind - one of four of a kind card
     * Full house - one of three of a kind card
     * Flush - high card
     * Straight - n/a
     * Three of a kind - one of three of a kind card
     * Two pair - one card of both pairs
     * One pair - one card of pair
     * High card - high card
     * @return int representing the top-level hand type
     */
    private int computeHandType() {
        int curHandType = HAND_HIGH_CARD;

        int flushRun = 0;
        int straightRun = 0;
        int kindRun = 0;
        Card lastCard = null;

        //Iterate over each card and build the hand, high-card, and suit rankings
        for(Card card : cards) {
            //if this is the first card we see, we're starting everything
            if(lastCard == null) {
                flushRun += 1;
                straightRun += 1;
                kindRun += 1;
            } else {
                //Track run of card value (straight)
                if(card.value == lastCard.value + 1) {
                    straightRun += 1;
                }
                //Track run of card suit (flush)
                if(card.suit == lastCard.suit) {
                    flushRun += 1;
                }
                //Track N-of-a-kind
                if(card.value == lastCard.value) {
                    kindRun += 1;

                    //Process last card if we're on it
                    if(card.equals(cards.last())) {
                        if(kindRun == 2) {
                            if(curHandType == HAND_HIGH_CARD) {
                                curHandType = HAND_ONE_PAIR;
                                firstPairCard = card;
                            } else if(curHandType == HAND_ONE_PAIR) {
                                curHandType = HAND_TWO_PAIR;
                                secondPairCard = card;
                            } else if(curHandType == HAND_THREE_OF_A_KIND) {
                                curHandType = HAND_FULL_HOUSE;
                                firstPairCard = card;
                            }
                        } else if(kindRun == 3) {
                            if(curHandType == HAND_HIGH_CARD) {
                                curHandType = HAND_THREE_OF_A_KIND;
                                threeOfAKindCard = card;
                            } else if(curHandType == HAND_ONE_PAIR) {
                                curHandType = HAND_FULL_HOUSE;
                                threeOfAKindCard = card;
                            }
                        } else if(kindRun == 4) {
                            curHandType = HAND_FOUR_OF_A_KIND;
                            fourOfAKindCard = card;
                            fourOfAKindOffCard = cards.first();
                        }
                    }
                } else {
                    if(kindRun == 2) {
                        //Moving from high card to single pair
                        if(curHandType == HAND_HIGH_CARD) {
                            curHandType = HAND_ONE_PAIR;
                            firstPairCard = lastCard;
                        } else if (curHandType == HAND_ONE_PAIR) {
                            //moving from one pair to two pair
                            curHandType = HAND_TWO_PAIR;
                            secondPairCard = lastCard;
                        }
                    } else if(kindRun == 3) {
                        //Moving from high card to three of a kind
                        if(curHandType == HAND_HIGH_CARD) {
                            curHandType = HAND_THREE_OF_A_KIND;
                            threeOfAKindCard = lastCard;
                        }
                    } else if(kindRun == 4) {
                        //Moving from high card to four of a kind
                        if(curHandType == HAND_HIGH_CARD) {
                            curHandType = HAND_FOUR_OF_A_KIND;
                            fourOfAKindCard = lastCard;
                            fourOfAKindOffCard = card;
                        }
                    }
                    //Reset run value
                    kindRun = 1;
                }
            }
            //Assign card for next loop
            lastCard = card;
        }
        //Set high card
        highCard = lastCard;

        //Check flush and straight
        if(straightRun == 5 && flushRun == 5) {
            curHandType = HAND_STRAIGHT_FLUSH;
        } else if(flushRun == 5) {
            curHandType = HAND_FLUSH;
        } else if(straightRun == 5) {
            curHandType = HAND_STRAIGHT;
        }

        return curHandType;
    }

    /**
     * Computes an encoded rank value for each hand type
     * Hand types are most significant, followed by information required to break a tie
     * NOTE: This encoding assumes a single 52-card deck with no wildcards/jokers, resulting in 9 hand types
     * Bit Encodings are as follows:
     *   Hands:  4 bits to handle 9 types
     *   Values: 4 bits to handle 13 values
     * Tie breaker cases are handled in least-significant bits, and only matter to the type of hand.
     * Cases are as follows:
     *   - c1 is smallest card and c5 is largest
     *   - 'hp'/'lp' is high pair/low pair
     *   - 'rc' is remaining card
     *   - 'v' is value (4 bits)
     *
     *          Hand        Bits  Type  Tie Breaker values
     *
     *   9) Straight Flush   10   1000  c5v
     *                            nnnn  nnnn
     *   8) Four of a Kind    8   0111  c4v
     *                            nnnn  nnnn
     *   7) Full House        8   0110  c3v
     *                            nnnn  nnnn
     *   6) Flush            24   0101  c5v  c4v  c3v  c2v  c1v
     *                            nnnn  nnnn nnnn nnnn nnnn nnnn
     *   5) Straight         24   0100  c5v  c4v  c3v  c2v  c1v
     *                            nnnn  nnnn nnnn nnnn nnnn nnnn
     *   4) Three of a Kind   4   0011  c3v
     *                            nnnn  nnnn
     *   3) Two Pair         16   0010  hpv  lpv  rcv
     *                            nnnn  nnnn nnnn nnnn
     *   2) One Pair         20   0001  lpv  rc3v rc2v rc1v
     *                            nnnn  nnnn nnnn nnnn nnnn
     *   1) High Card        24   0000  c5v  c4v  c3v  c2v  c1v
     *                            nnnn  nnnn nnnn nnnn nnnn nnnn
     *
     * In summary, our max encoding length is 24 bits long, which fits into a regular ol' integer.
     * @return Encoded form of the hand in binary format as an int
     */
    private int computeRank() {
        this.handType = computeHandType();
        //Start our rank with the hand type shifted into position
        this.rank = handType << 20;

        if(handType == HAND_STRAIGHT_FLUSH) {
            //Compare max card value
            rank += getHighCard().value << 16;
        } else if (handType == HAND_FOUR_OF_A_KIND) {
            rank += getFourOfAKindCard().value << 16;
        } else if (handType == HAND_FULL_HOUSE) {
            rank += getThreeOfAKindCard().value << 16;
        } else if (handType == HAND_FLUSH
                || handType == HAND_STRAIGHT
                || handType == HAND_HIGH_CARD) {
            //Add all five card values shifted appropriately
            int index = 0;
            for(Card card : cards) {
                int value = card.value << (index * 4);
//            System.out.println(String.format(" %3s value %24s", card, Integer.toBinaryString(value)));
                rank += value;
                index += 1;
            }
        } else if (handType == HAND_THREE_OF_A_KIND) {
            rank += getThreeOfAKindCard().value << 16;
        } else if (handType == HAND_TWO_PAIR) {
            int firstPairValue = getFirstPairCard().value;
            int secondPairValue = getSecondPairCard().value;
            int remainingCardValue = cards.stream()
                    .filter(c -> c.value != firstPairValue && c.value != secondPairValue)
                    .findFirst().get().value;
            rank += (secondPairValue << 16) +
                    (firstPairValue << 12) +
                    (remainingCardValue << 8);
//            System.out.println(String.format(" %3s value %24s", this, Integer.toBinaryString(rank)));
        } else { //if (handType == HAND_ONE_PAIR)
            int firstPairValue = getFirstPairCard().value;
            rank += firstPairValue << 16;
            //Add in other three card values
            int index = 0;
            for(Card card : cards) {
                if (card.value == firstPairValue) {
                    continue;
                }
                rank += card.value << (index * 4 + 4);
                index += 1;
            }
        }

        //Return final ranking value
        return rank;
    }


    /**
     * Formats the hand in human-readable format
     * @return String of cards in hand
     */
    @Override
    public String toString() {
        return cards.stream()
                .map(s -> s.toString())
                .reduce((str1, str2) -> str1 + ' ' + str2)
                .get() + " - " + names.get(getHandType());
    }

}
