package com.nexai.model;

public class Card {
    private String cardNumber;
    private String pinCode;
    private int balance;
    private boolean block;

    public Card() {
    }

    public Card(String cardNumber, String pinCode, int balance, boolean block) {
        this.cardNumber = cardNumber;
        this.pinCode = pinCode;
        this.balance = balance;
        this.block = block;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (balance != card.balance) return false;
        if (block != card.block) return false;
        if (cardNumber != null ? !cardNumber.equals(card.cardNumber) : card.cardNumber != null) return false;
        return pinCode != null ? pinCode.equals(card.pinCode) : card.pinCode == null;
    }

    @Override
    public int hashCode() {
        int result = cardNumber != null ? cardNumber.hashCode() : 0;
        result = 31 * result + (pinCode != null ? pinCode.hashCode() : 0);
        result = 31 * result + balance;
        result = 31 * result + (block ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Card{");
        sb.append("cardNumber='").append(cardNumber).append('\'');
        sb.append(", pinCode='").append(pinCode).append('\'');
        sb.append(", balance=").append(balance);
        sb.append(", block=").append(block);
        sb.append('}');
        return sb.toString();
    }
}
