package edu.cnm.deepdive;

import java.util.ArrayList;

public class WarGame {

  private ArrayList<Card> playerOneDeck;
  private ArrayList<Card> playerTwoDeck;
  private Player playerOne;
  private Player playerTwo;

  public WarGame() {
    Deck deck = new Deck();
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

  public void playGame() {
    boolean gameOver = false;

    while (!gameOver) {
      int wonCards = 0;

      if (playerOne.playCard() > playerTwo.playCard()) {
        wonCards += 2;
        playerOne.addToCardCount(wonCards);
        playerOne.removeTop();
        playerTwo.removeTop();
      } else if (playerTwo.playCard() > playerOne.playCard()) {
        wonCards += 2;
        playerTwo.addToCardCount(wonCards);
        playerOne.removeTop();
        playerTwo.removeTop();
      } else if (playerTwo.playCard() == playerOne.playCard()) {
        do {
          wonCards += 2;
          playerOne.removeTop();
          playerTwo.removeTop();
        } while (playerOne.playCard() == playerTwo.playCard());

        if (playerOne.playCard() > playerTwo.playCard()) {
          wonCards += 2;
          playerOne.addToCardCount(wonCards);
          playerOne.removeTop();
          playerTwo.removeTop();
        } else {
          wonCards += 2;
          playerTwo.addToCardCount(wonCards);
          playerOne.removeTop();
          playerTwo.removeTop();
        }
      }

      if (playerOne.getPlayerHand().size() == 0
          || playerTwo.getPlayerHand().size() == 0) {
        gameOver = true;
      }
    }

    System.out.println(playerOne.getCardCount());
    System.out.println(playerTwo.getCardCount());

    if (playerOne.getCardCount() > playerTwo.getCardCount()) {
      System.out.println("Player One Wins!");
    } else if (playerTwo.getCardCount() > playerOne.getCardCount()) {
      System.out.println("Player Two Wins!");
    } else {
      System.out.println("It's a draw!");
    }
  }
}


