package com.nexai.model;

public class Atm {

    private static final double limitOfAtm = 1000.0;
    private static final Atm instance = new Atm(limitOfAtm, 500);
    private int availableCash;

    public Atm(double limitOfAtm, int availableCash) {
        this.availableCash = availableCash;
    }

    public static Atm getInstance() {
        return instance;
    }

    public int getAvailableCash() {
        return availableCash;
    }

    public void setAvailableCash(int availableCash) {
        this.availableCash = availableCash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Atm atm = (Atm) o;

        return availableCash == atm.availableCash;
    }

    @Override
    public int hashCode() {
        return availableCash;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Atm{");
        sb.append("availableCash=").append(availableCash);
        sb.append('}');
        return sb.toString();
    }
}
