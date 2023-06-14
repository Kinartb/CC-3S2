package proyecto.ejecucion;

import javax.swing.*;

public class ClassMovimiento {
    private int fila;
    private int columna;
    private String letter;
    private int turn;
    //////////////////////////
    private ClassPlayer player;

    public ClassMovimiento(ClassPlayer player, int fila, int columna, String letra) {
        this.player=player;
        this.fila = fila;
        this.columna = columna;
        this.letter = letra;
    }

    public int getFila() {
        return fila;
    }
    public int getColumna() {
        return columna;
    }
    public String getLetter() {
        return letter;
    }

}
