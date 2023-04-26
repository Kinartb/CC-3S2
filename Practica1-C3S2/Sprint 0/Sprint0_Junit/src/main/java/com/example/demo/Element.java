package com.example.demo;

public class Element {
    private int weight;
    private int benefit;

    public Element(int weight, int benefit) {
        this.weight = weight;
        this.benefit = benefit;
    }

    public int getWeight() {
        return weight;
    }


    public int getBenefit() {
        return benefit;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Element other = (Element) obj;
        if (this.weight != other.weight) {
            return false;
        }
        if (this.benefit != other.benefit) {
            return false;
        }
        return true;
    }

}
