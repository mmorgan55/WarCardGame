package edu.cnm.deepdive;

import java.util.ArrayList;

public class Player {

  private ArrayList<Card> playerHand;
  private int cardRank = 0;
  private int cardCount;

  public Player (ArrayList playerHand) {
    this.playerHand = playerHand;
    cardCount = 0;
  }

  public int playCard() {
    Card card;
    int cardRank;

    card = playerHand.remove(playerHand.size() - 1);

    cardRank = card.getRank().getValue();
    return  cardRank;
  }

}
