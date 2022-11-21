package com.nexai.model;

import com.nexai.reader.DataReader;

import java.util.List;

public class Bank {
    private static Bank instance = new Bank();
    private List<Card> cards;

    public static Bank getInstance() {
        return instance;
    }

    {
        cards = DataReader.getCards();
    }


    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bank bank = (Bank) o;

        return cards != null ? cards.equals(bank.cards) : bank.cards == null;
    }

    @Override
    public int hashCode() {
        return cards != null ? cards.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bank{");
        sb.append("cards=").append(cards);
        sb.append('}');
        return sb.toString();
    }
}
