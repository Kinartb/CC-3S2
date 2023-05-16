package Produccion;

import java.util.Scanner;

public class TicTacToe {
    private TicTacToe tictactoe;
    private char[][] tablero;
    private char jugador;
    private boolean terminar;

    public TicTacToe(){
        tablero= new char[3][3];
        jugador='x';
        terminar=false;
        inicializartablero();
    }
    public void inicializartablero(){
        for( int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                tablero[i][j]='v';
            }
        }
    }
    private void imprimirtablero(){
        System.out.println("Imprimiendo el tablero");
        for( int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.println(tablero[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void cambio(){
        jugador=(jugador=='x')? 'o' : 'x';
    }
    public char proximoJugador(){
        return jugador;
    }
    public void movimiento(int x,int y){
        tablero[x][y]=jugador;
    }
    public boolean jugar( int x, int y){

        if(x<1||x>3||y<1||y>3||tablero[x][y]!='v'){
            return false;
        }else{
            return true;
        }
    }
    public char ganador() {
        //horizontal
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador) {
                terminar = true;
                System.out.println("El jugador " + jugador + " es el ganador");
                return jugador;
            }
        }
        //vertical
        for (int i = 0; i < 3; i++) {
            if (tablero[0][i] == jugador && tablero[1][i] == jugador && tablero[2][i] == jugador) {
                terminar = true;
                System.out.println("El jugador " + jugador + " es el ganador");
                return jugador;
            }
        }
        //DiagonalDeSuperiorIzquierdaAInferiorDerecha
        if (tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador) {
            terminar = true;
            System.out.println("El jugador " + jugador + " es el ganador");
            return jugador;
        }
        //DiagonalDeInferiorIzquierdaASuperiorDerecha
        if (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador) {
            terminar = true;
            System.out.println("El jugador " + jugador + " es el ganador");
            return jugador;
        }

        boolean empate=true;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(tablero[i][j]=='v'){
                    empate=false;
                    break;
                }
            }
            if(!empate){
                break;
            }
        }
        if (empate){
            terminar=true;
            System.out.println("Empate");
            return 'D';
        }
        return 'N';
    }
    public void play(){
        Scanner scanner=new Scanner(System.in);
        while(!terminar){
            imprimirtablero();
            System.out.println("Turno de jugador " + jugador);
            int x=scanner.nextInt();
            int y=scanner.nextInt();

            if(jugar(x,y)){
                movimiento(x,y);
                ganador();
                cambio();
            }else{
                System.out.println("Movimiento invalido");
            }
        }
        if(terminar){
            System.out.println("NoGanador");
        }
        imprimirtablero();
    }
    public static void main(String[] args){
        TicTacToe juego= new TicTacToe();
        juego.play();
    }


}
