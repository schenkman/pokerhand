# Poker Hand Comparison

This code compares two 5 card draw poker hands together to determine a win/loss or a tie with the caveats of:

1. A single 52-card deck, so that means no one can have the same three or four-of-a-kind
2. Aces are not allowed as a low card
3. Ties are allows as no tie-breakers are done with suits

# Run it

This is a Java 1.8, Maven 3.2 project, so clone, install your maven dependencies, and `mvn test`.

```bash
git clone git@github.com:schenkman/pokerhand.git
mvn install
mvn -q clean test
mvn exec:java -q -Dexec.mainClass="com.cbschenk.poker.fivecarddraw.FiveCardDraw"
```

## Tests

[FiveCardDrawTest.java](src/test/java/com/cbschenk/poker/fivecarddraw/FiveCardDrawTest.java) contains all of the
"acceptance" tests which plays each hand type against one another, resulting in roughly `n(n-1)/2` games,
and I also include some edge cases for my own sake (i.e. where a three-of-a-kind appears in the sorted hand).

Additional unit tests for my own uses are under
[com.cbschenk.poker.fivecarddraw](src/test/java/com/cbschenk/poker/fivecarddraw).


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
         Hand        Bits  Type  Tie Breaker values
  9) Straight Flush   10   1000  c5v
                           nnnn  nnnn
  8) Four of a Kind    8   0111  c4v
                           nnnn  nnnn
  7) Full House        8   0110  c3v
                           nnnn  nnnn
  6) Flush            24   0101  c5v  c4v  c3v  c2v  c1v
                           nnnn  nnnn nnnn nnnn nnnn nnnn
  5) Straight         24   0100  c5v  c4v  c3v  c2v  c1v
                           nnnn  nnnn nnnn nnnn nnnn nnnn
  4) Three of a Kind   4   0011  c3v
                           nnnn  nnnn
  3) Two Pair         16   0010  hpv  lpv  rcv
                           nnnn  nnnn nnnn nnnn
  2) One Pair         20   0001  lpv  rc3v rc2v rc1v
                           nnnn  nnnn nnnn nnnn nnnn
  1) High Card        24   0000  c5v  c4v  c3v  c2v  c1v
                           nnnn  nnnn nnnn nnnn nnnn nnnn
```
In summary, our max encoding length is 24 bits long, which fits into an integer.

Once computed, a simple integer comparison is all that is required to determine a winner or a loser or a tie
(See class [FiveCardDraw](src/main/java/com/cbschenk/poker/fivecarddraw/FiveCardDraw.java)).

## Time and Space Considerations

* N inserts into the Hand (TreeSet) are worst-case `O(n**2)` time as is standard for a binary search tree,
but we're only dealing with 5 cards.
* Computing the hand type is `O(n)` as the code iterates over each card only once. Constant space is required
to save the last card seen and a few other interesting values depending on the hand type (See private Card
members on [Hand](/src/main/java/com/cbschenk/poker/fivecarddraw/Hand.java)).
* Computing the rank either requires `O(n)` or `O(1)` time depending on the hand type, so the algorithm
overall runs in `O(n)` time and space.


# License

This software is licensed under the MIT license. See the [LICENSE](LICENSE) file.

Copyright 2017 Chris Schenk

> "Poker, I didn't even know her!" - *Someone*