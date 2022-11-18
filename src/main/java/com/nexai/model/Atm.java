package com.nexai.model;

import java.util.Set;

public class Atm {

    private int id;
    private String atmAddress;
    private double limitOfAtm = 1000;
    private Set<Card> cards;

    public Atm() {
    }

    public Atm(Set<Card> cards) {
        this.cards = cards;
    }

    public Atm(int id, String atmAddress, double limitOfAtm) {
        this.id = id;
        this.atmAddress = atmAddress;
        this.limitOfAtm = limitOfAtm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAtmAddress() {
        return atmAddress;
    }

    public void setAtmAddress(String atmAddress) {
        this.atmAddress = atmAddress;
    }

    public double getLimitOfAtm() {
        return limitOfAtm;
    }

    public void setLimitOfAtm(double limitOfAtm) {
        this.limitOfAtm = limitOfAtm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Atm atm = (Atm) o;

        if (id != atm.id) return false;
        if (Double.compare(atm.limitOfAtm, limitOfAtm) != 0) return false;
        return atmAddress != null ? atmAddress.equals(atm.atmAddress) : atm.atmAddress == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (atmAddress != null ? atmAddress.hashCode() : 0);
        temp = Double.doubleToLongBits(limitOfAtm);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Atm{");
        sb.append("id=").append(id);
        sb.append(", atmAddress='").append(atmAddress).append('\'');
        sb.append(", limitOfAtm=").append(limitOfAtm);
        sb.append('}');
        return sb.toString();
    }
}
