package career08.oop;

import java.util.ArrayList;
import java.util.List;

public class Exam_8_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

enum Suit {
	Club(0), Diamond(1), Heart(2), Spade(3);
	private int value;

	private Suit(int v) {
		this.value = v;
	};

	public int getValue() {
		return this.value;
	}
}

class Deck<T extends Card> {
	private List<T> cards;
	private int dealtIndex = 0;

	public void setDeckOfCards(List<T> deckOfCards) {
		this.cards = deckOfCards;
	}

	public void shuffle() {

	}

	public int remainingCards() {
		return this.cards.size() - this.dealtIndex;
	}

	public T[] dealHand(int number) {
		// to do
		return null;
	}

	public T dealCard() {
		// to do
		return null;
	}

}

abstract class Card {
	private boolean available = true;
	protected int faceValue;
	protected Suit suit;

	public Card(int faceValue, Suit suit) {
		this.faceValue = faceValue;
		this.suit = suit;
	}

	public abstract int value();

	public Suit suit() {
		return this.suit;
	}

	public boolean isAvailable() {
		return available;
	}

	public void markAvailable() {
		this.available = true;
	}

	public void markUnavailable() {
		this.available = false;
	}

}

class Hand<T extends Card> {
	protected List<T> cards = new ArrayList<T>();

	public int score() {
		int score = 0;
		for (T c : cards) {
			score += c.value();
		}
		return score;
	}

	public void addCard(T card) {
		this.cards.add(card);
	}
}

class BlackJackHand extends Hand<BlackJackCard> {

	public int score() {
		List<Integer> scores = this.possibleScores();
		int maxUder = Integer.MIN_VALUE;
		int minOver = Integer.MAX_VALUE;
		for (Integer s : scores) {
			if (s > 21 && s < minOver) {
				minOver = s;
			}
			if (s <= 21 && s > maxUder) {
				maxUder = s;
			}
		}
		return maxUder != Integer.MIN_VALUE ? maxUder : minOver;

	}

	private List<Integer> possibleScores() {
		// to do
		return null;
	}

	public boolean busted() {
		return this.score() > 21;
	}

	public boolean is21() {
		return this.score() == 21;
	}

	public boolean isBlackJack() {
		// to do
		return true;
	}
}

class BlackJackCard extends Card {

	public BlackJackCard(int faceValue, Suit suit) {
		super(faceValue, suit);
	}

	@Override
	public int value() {
		if (this.isAce())
			return 1;
		else if (this.isFaceCard())
			return 10;
		return faceValue;
	}

	public int minValue() {
		if (this.isAce())
			return 1;
		return value();
	}

	public int maxValue() {
		if (this.isAce())
			return 11;
		return value();
	}

	public boolean isAce() {
		return this.faceValue == 1;
	}

	public boolean isFaceCard() {
		return this.faceValue >= 11 && this.faceValue <= 13;
	}

}
