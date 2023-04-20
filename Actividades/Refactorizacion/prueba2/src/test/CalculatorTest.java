package test;

import org.junit.jupiter.api.Test;
import prueba.Calculadora;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void whenCalculatorInitializedThenReturnTrue() {
        Calculadora calculadora = new Calculadora();

        assertTrue(calculadora.getStatus());
    }
    @Test
    public void whenAdditionTwoNumberThenReturnCorrectAnswer() {
        Calculadora calculadora = new Calculadora();

        assertEquals( 5, calculadora.addition(2,3));
    }
    @Test
    public void whenRestTwoNumberThenReturnCorrectAnswer() {
        Calculadora calculadora = new Calculadora();

        assertEquals( 2, calculadora.rest(4,2));
    }
    @Test
    public void whenDivisionThenReturnCorrectAnswer() {
        Calculadora calculadora = new Calculadora();
        assertEquals(2, calculadora.division(8, 4));
    }
    @Test
    public void whenDivisionByZeroThenThrowException() {
        Calculadora calculadora = new Calculadora();
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadora.division(5, 0);
        });
        assertEquals("No se puede dividir por cero", exception.getMessage());
    }
    //tests de las nuevas implementaciones
    @Test
    public void whenMultiplicationTwoNumberThenReturnCorrectAnswer() {
        Calculadora calculadora = new Calculadora();
        assertEquals( 0, calculadora.multiplication(4,0));
    }
    @Test
    public void whenPowerTwoNumberIntThenReturnCorrectAnswer() {
        Calculadora calculadora = new Calculadora();
        assertEquals( 1, calculadora.power(1,-2));
    }
    @Test
    public void whenPower0With1negativeThenThrowException() {
        Calculadora calculadora = new Calculadora();
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadora.power(0, -1);
        });
        assertEquals("No se puede dividir por cero", exception.getMessage());
    }
    @Test
    public void whenSquareNumberIntThenReturnCorrectAnswer() {
        Calculadora calculadora = new Calculadora();
        assertEquals( 2, calculadora.square(4));
    }
    @Test
    public void whenSquareNegativeNumberThenThrowException() {
        Calculadora calculadora = new Calculadora();
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadora.square(-1);
        });
        assertEquals("No es posible la raiz cuadrada de un numero negativo", exception.getMessage());
    }
    @Test
    public void whenLogNumberIntThenReturnCorrectAnswer() {
        Calculadora calculadora = new Calculadora();
        assertEquals( 0, calculadora.log(1));
    }
    @Test
    public void whenLogNumberIntIs0orNegativeThenThrowException() {
        Calculadora calculadora = new Calculadora();
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadora.log(-1);
        });
        assertEquals("No se puede realiza la funcion logaritmo con dicho numero", exception.getMessage());
    }
    @Test
    public void whenSinNumberIntThenReturnCorrectAnswer() {
        Calculadora calculadora = new Calculadora();
        assertEquals( 0, calculadora.sin(0));
    }
    @Test
    public void whenCosNumberIntThenReturnCorrectAnswer() {
        Calculadora calculadora = new Calculadora();
        assertEquals( 1, calculadora.cos(0));
    }
    @Test
    public void whenTanNumberIntThenReturnCorrectAnswer() {
        Calculadora calculadora = new Calculadora();
        assertEquals( 0, calculadora.tan(0));
    }
    @Test
    public void whenLogNumberIntIsNot90PlusN180ThenThrowException() {
        Calculadora calculadora = new Calculadora();
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadora.tan(90);
        });
        assertEquals("La expresion es no definida", exception.getMessage());
    }

}