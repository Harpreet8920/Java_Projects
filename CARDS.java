import java.util.*;

// Card class
enum Suit {
    Spade, Club, Heart, Diamond
}

enum Rank {
    A, _2, _3, _4, _5, _6, _7, _8, _9, _10, J, Q, K
}

class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

// Deck class
class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
        shuffle();
    }

    private void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.size() > 0) {
            Card card = cards.remove(cards.size() - 1);
            return card;
        }
        return null;
    }

    public int deckSize() {
        return cards.size();
    }
}

// Custom Comparator
class CardComparator implements Comparator<Card> {
    @Override
    public int compare(Card c1, Card c2) {
        boolean isColor1Red = isRed(c1.getSuit());
        boolean isColor2Red = isRed(c2.getSuit());

        if (isColor1Red != isColor2Red) {
            return Boolean.compare(isColor1Red, isColor2Red);
        }

        Suit suit1 = c1.getSuit();
        Suit suit2 = c2.getSuit();

        if (suit1 != suit2) {
            return suit1.ordinal() - suit2.ordinal();
        }

        int rank1 = c1.getRank().ordinal();
        int rank2 = c2.getRank().ordinal();

        return rank1 - rank2;
    }

    private boolean isRed(Suit suit) {
        return suit == Suit.Heart || suit == Suit.Diamond;
    }
}

// Test class
public class CARDS {
    public static void main(String[] args) {
        Deck deck = new Deck();
        CardComparator comparator = new CardComparator();

        List<Card> hand = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Card card = deck.drawCard();
            hand.add(card);
        }

        Collections.sort(hand, comparator);

        for (Card card : hand) {
            System.out.println(card);
        }
    }
}