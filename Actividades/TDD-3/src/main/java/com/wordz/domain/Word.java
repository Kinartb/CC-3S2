package com.wordz.domain;
    //word almacena la palabra que suponemos a adivinar
//hemos inicializado un constructor publico guess para crear un nuevo objeto llamado score
    //decidimos tambien agregar un metodo score llamado assess que tiene la responsabilidad de puntuar la adivinacion
    //es un indice 0 para la letra y la palabra que deseamos evaluar una puntuacion, es la suposicion de cual podria ser la palabra
public class Word {
    private final String word;
    public Word(String correctWord) {
        this.word = correctWord;
    }
    public Score guess(String attempt) {
        var score = new Score(word);
        score.assess(  attempt );
        return score;
    }
}
