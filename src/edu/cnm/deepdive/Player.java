package edu.cnm.deepdive;

import java.util.ArrayList;

public class Player {

  private ArrayList<Card> playerHand;
  private int cardCount;

  public Player(ArrayList playerHand) {
    this.playerHand = playerHand;
    cardCount = 0;
  }

  public int playCard() {
    Card card;
    int cardRank;

    card = playerHand.get(playerHand.size() - 1);

    cardRank = card.getRank().getValue();
    return cardRank;
  }

  public void removeTop() {
    playerHand.remove(playerHand.size()-1);
  }

  public void addToCardCount (int n) {
    cardCount += n;
  }

  public ArrayList<Card> getPlayerHand() {
    return playerHand;
  }

  public int getCardCount() {
    return cardCount;
  }
}
