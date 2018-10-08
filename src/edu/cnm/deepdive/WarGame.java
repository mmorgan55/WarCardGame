package edu.cnm.deepdive;

import java.util.ArrayList;

public class WarGame {

  private Deck deck;
  private ArrayList<Card> playerOneDeck;
  private ArrayList<Card> playerTwoDeck;
  private Player playerOne;
  private Player playerTwo;

  public WarGame () {
    deck = new Deck();
    playerOneDeck = new ArrayList<>();
    playerTwoDeck = new ArrayList<>();

    dealHands(deck);

    playerOne = new Player(playerOneDeck);
    playerTwo = new Player(playerTwoDeck);
  }

  private void dealHands(Deck deck) {
    boolean switchHand = true;
    for (Card card : deck.getDeck()) {
      if (switchHand == true) {
        playerOneDeck.add(card);
        switchHand = false;
      } else {
        playerTwoDeck.add(card);
        switchHand = true;
      }
    }
  }


}


