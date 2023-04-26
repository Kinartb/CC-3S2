package com.example.demo;

public class Knapsack {
    private int maximumWeight;
    private Element[] elements;

    private int weight;
    private int benefit;

    public Knapsack(int maximumWeight, int numElements) {
        this.maximumWeight = maximumWeight;
        this.elements = new Element[numElements];
        this.benefit = 0;
        this.weight = 0;
    }

    /**
     * Añade un elemento a la mochila
     * @param e
     */
    public void addElement(Element e) {

        for (int i = 0; i< this.elements.length; i++) {
            if (this.elements[i] == null) {
                this.elements[i] = e; //lo añade
                this.benefit+=e.getBenefit(); // aumenta el beneficio
                this.weight+=e.getWeight(); // Aumenta el peso
                break;
            }
        }

    }



    /**
     * Elimina elemento dado
     * @param e
     */
    public void deleteElement(Element e) {
        for (int i = 0; i < this.elements.length; i++) {
            if (this.elements[i].equals(e)) {
                this.elements[i] = null; //el elemento fuera
                this.weight-=e.getWeight(); //Reduce el peso
                this.benefit-=e.getBenefit(); // reduce el beneficio
                break;
            }
        }
    }


    /**
     * Indica si existe un elemento
     * @param e
     * @return
     */
    public boolean existElement(Element e) {
        for (int i = 0; i < this.elements.length; i++) {
            if (this.elements[i] != null && this.elements[i].equals(e)) {
                return true;
            }
        }
        return false;
    }
}
