package Pruebas;

import Produccion.TicTacToe;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestPosicionamientoEnTablero {
    private TicTacToe tictactoe;

    public void setUp() throws Exception {
        tictactoe = new TicTacToe();
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void WhenRealizamosUnMovimientoFueraDeEspacioEnX() {
        tictactoe = new TicTacToe();
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            tictactoe.movimiento(4, 2);
        });
        assertNotNull(exception);
    }
    @Test
    public void WhenRealizamosUnMovimientoFueraDeEspacioEnY(){
        tictactoe = new TicTacToe();
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            tictactoe.movimiento(4, 2);
        });
        assertNotNull(exception);
    }
    //para realizar esta prueba era necesario crear el metodo TicTacToe y el metodo inicializartablero
    //
    /*
    @Test
    public void WhenElEspacioEstaOcupado(){
        tictactoe = new TicTacToe();
        tictactoe.movimiento(2, 2);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            tictactoe.jugar(2, 2);
        });
        assertNotNull(exception);
    }*/
    @Test
    public void WhenXJuegaPrimero(){
        tictactoe = new TicTacToe();
        assertEquals('x',tictactoe.proximoJugador());
    }
    @Test
    public void ThenOJuegaSiguiente(){
        tictactoe = new TicTacToe();
        tictactoe.cambio();
        assertEquals('o',tictactoe.proximoJugador());
    }
    @Test
    public void ThenXJuegaSiguiente(){
        tictactoe = new TicTacToe();
        tictactoe.cambio();
        tictactoe.cambio();
        assertEquals('x',tictactoe.proximoJugador());
    }

    @Test
    public void GivenNoHayGanador(){
        tictactoe =new TicTacToe();
        assertEquals('N',tictactoe.ganador());
    }
    @Test
    public void WhenGanadorHorizontal(){
        tictactoe = new TicTacToe();
        tictactoe.movimiento(2, 0);
        tictactoe.movimiento(1, 1);
        tictactoe.movimiento(2, 1);
        tictactoe.movimiento(0, 2);
        tictactoe.movimiento(2, 2);
        assertEquals('x',tictactoe.ganador());
    }
    @Test
    public void WhenGanadorVertical(){
        tictactoe = new TicTacToe();
        tictactoe.movimiento(0, 2);
        tictactoe.movimiento(1, 1);
        tictactoe.movimiento(1, 2);
        tictactoe.movimiento(0, 2);
        tictactoe.movimiento(2, 2);
        assertEquals('x',tictactoe.ganador());
    }
    @Test
    public void WhenGanadorDiagonalDeSuperiorIzquierdaAInferiorDerecha(){
        tictactoe = new TicTacToe();
        tictactoe.movimiento(0, 0);
        tictactoe.movimiento(1, 0);
        tictactoe.movimiento(1, 1);
        tictactoe.movimiento(0, 2);
        tictactoe.movimiento(2, 2);
        assertEquals('x',tictactoe.ganador());
    }
    @Test
    public void WhenGanadorDiagonalDeInferiorIzquierdaASuperiorDerecha(){
        tictactoe = new TicTacToe();

        tictactoe.movimiento(0, 0);
        tictactoe.cambio();
        tictactoe.movimiento(0, 1);
        tictactoe.cambio();
        tictactoe.movimiento(0, 2);
        tictactoe.cambio();
        tictactoe.movimiento(1, 0);
        tictactoe.cambio();
        tictactoe.movimiento(1, 2);
        tictactoe.cambio();
        tictactoe.movimiento(1, 1);
        tictactoe.cambio();
        tictactoe.movimiento(2, 1);
        tictactoe.cambio();
        tictactoe.movimiento(2, 2);
        tictactoe.cambio();
        tictactoe.movimiento(2, 0);
        assertEquals('D',tictactoe.ganador());
    }

}
