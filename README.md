# Poker Hand Comparison

This code compares two 5 card draw poker hands together to determine a win/loss or a tie with the caveats of:

1. A single 52-card deck, so that means no one can have the same three or four-of-a-kind
2. Aces are not allowed as a low card
3. Ties are allowed after some reasonable attempts at tie-breaking (suits are not used)
4. No wildcards/jokers

# Run it

This is a Java 1.8, Maven 3.2 project, so clone, install your maven dependencies, and `mvn test`.

```bash
git clone git@github.com:schenkman/pokerhand.git
cd pokerhand
mvn install
mvn -q clean test
mvn exec:java -q -Dexec.mainClass="com.cbschenk.poker.fivecarddraw.FiveCardDraw"
```

## Tests

[FiveCardDrawTest.java](src/test/java/com/cbschenk/poker/fivecarddraw/FiveCardDrawTest.java) contains all of the
"acceptance" tests which plays each hand type against one another, resulting in roughly 45 games
(`n(n+1)/2` where `n` is 9 types of hands), and I also include some edge cases for my own sake
(i.e. end-of-loop counting, tie-breaker cases, etc.).

[HandTest.java](src/test/java/com/cbschenk/poker/fivecarddraw/HandTest.java) verifies the bit encodings for hands as well as the hand types.

[CardTest.java](src/test/java/com/cbschenk/poker/CardTest.java) verifies the comparator created for sorting in the TreeMap.


# Process

1. Add cards to a Hand
    - Cards are added to a sorted set to iterate over them in order later
2. Hand type and rank are computed when 5 cards reached
    1. Iterate over cards in order and compute hand type
    2. Generate Hand rank encoded as an integer
3. Play hands against each other comparing rank values as integers


## Hand Bit Encodings

The algorithm generates a bit encoding representing the hand as well as any pertinent information to
perform tie-breakers when facing an equivalent hand from your opponent. Encodings are generated in the Hand
as soon as 5 cards are available. The breakdown of bits required for each hand type is as follows:

* Hands - 9 types encoded in 4 bits
* Cards - 13 values encoded in 4 bits

Hands are encoded to the most-significant bits and tie-breakers are handled in the least-significant bits.
Tie-breakers only matter when battling a hand of the same type.

```
Cases are as follows:
  - c1 is smallest card and c5 is largest
  - 'hp'/'lp' is high pair/low pair
  - 'rc' is remaining card
  - 'v' is value (4 bits)
  E.g. 'c5v' is 'card 5 value'
       'lpv' is 'low-pair value'
       'rc1v' is 'remaining card 1 value' (least-significant)
  
         Hand        Bits  Type  Tie Breaker values
  8) Straight Flush   10   1000  c5v
                           nnnn  nnnn
  7) Four of a Kind    8   0111  c4v
                           nnnn  nnnn
  6) Full House        8   0110  c3v
                           nnnn  nnnn
  5) Flush            24   0101  c5v  c4v  c3v  c2v  c1v
                           nnnn  nnnn nnnn nnnn nnnn nnnn
  4) Straight         24   0100  c5v  c4v  c3v  c2v  c1v
                           nnnn  nnnn nnnn nnnn nnnn nnnn
  3) Three of a Kind   4   0011  c3v
                           nnnn  nnnn
  2) Two Pair         16   0010  hpv  lpv  rcv
                           nnnn  nnnn nnnn nnnn
  1) One Pair         20   0001  lpv  rc3v rc2v rc1v
                           nnnn  nnnn nnnn nnnn nnnn
  0) High Card        24   0000  c5v  c4v  c3v  c2v  c1v
                           nnnn  nnnn nnnn nnnn nnnn nnnn
```
In summary, our max encoding length is 24 bits long, which fits into an integer.

Once computed, a simple integer comparison is all that is required to determine a winner or a loser or a tie
(See class [FiveCardDraw](src/main/java/com/cbschenk/poker/fivecarddraw/FiveCardDraw.java#L7-L19)).

In the examples below, you can see how the card values map to the tie-breaker values in the encoded representation.
Note that `11 == Jack`, `12 == Queen`, `13 == King`, and `14 == Ace`.

### Example - Straight Flush vs Four of a Kind

```
 Result       Cards              Hand          Integer   Hand   Tie Breaker
                                                           8    6    0    0    0    0 
  WIN   2D  3D  4D  5D  6D - Straight Flush     8781824  1000 0110 0000 0000 0000 0000
        2C 10S 10H 10D 10C - Four of a Kind     7995392  0111 1010 0000 0000 0000 0000
                                                           7   10    0    0    0    0 
```

### Example - Flush vs Flush (second-lowest card position wins)

```
 Result       Cards              Hand          Integer   Hand   Tie Breaker
                                                           5   13    9    8    5    3 
  WIN   3H  5H  8H  9H  KH - Flush              6133843  0101 1101 1001 1000 0101 0011
        3C  4C  8C  9C  KC - Flush              6133827  0101 1101 1001 1000 0100 0011
                                                           5   13    9    8    4    3 
```

### Example - One Pair vs High Card

```
 Result       Cards              Hand          Integer   Hand   Tie Breaker
                                                           1    8   10    9    7    0 
  WIN   7D  8S  8H  9H 10D - One Pair           1616240  0001 1000 1010 1001 0111 0000
        3C  6S  7H  9D  AH - High Card           956259  0000 1110 1001 0111 0110 0011
                                                           0   14    9    7    6    3 
```

## Time and Space Considerations

* N inserts into the Hand (TreeSet) in the average case are `O(nlog n)` (worst case is `O(n**2)` if the cards are
pre-sorted but we're only dealing with 5 cards).
* Computing the hand type is `O(n)` as the code iterates over each card only once. Constant space is required
to save the last card seen and a few other interesting values depending on the hand type (See private Card
members on [Hand](/src/main/java/com/cbschenk/poker/fivecarddraw/Hand.java)).
* Computing the rank either requires `O(n)` or `O(1)` time depending on the hand type, so the algorithm
overall runs in `O(n)` time and space once the cards are sorted.


# License

This software is licensed under the MIT license. See the [LICENSE](LICENSE) file.

Copyright 2017 Chris Schenk

> "Poker, I didn't even know her!" - *Someone*