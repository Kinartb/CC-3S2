package prueba;
import java.lang.Math;
import org.junit.jupiter.api.BeforeAll;

import static java.lang.Boolean.TRUE;

public class Calculadora {
    private static Calculadora calculadora;
    private boolean status;

    @BeforeAll
    public static void init() {
        calculadora = new Calculadora();
    }

    public Calculadora() {
        this.status = true;
    }

    public boolean getStatus() {
        return status;
    }

    public int addition(int a, int b) {
        return a + b;
    }

    public int rest(int a, int b) {
        return a - b;
    }

    public int division(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } else {
            return a / b;
        }
    }

    //seccion de nuevas implementaciones
    public int multiplication(int a, int b) {
        return a * b;
    }

    public double power(int a, int b) {
        if (a == 0 && b <= -1) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } else {
            return Math.pow(a, b);
        }
    }

    public double square(int a) {
        if (a <= -1) {
            throw new IllegalArgumentException("No es posible la raiz cuadrada de un numero negativo");
        } else {
            return Math.sqrt(a);
        }
    }

    public double log(int a){
        if (a <= 0) {
            throw new IllegalArgumentException("No se puede realiza la funcion logaritmo con dicho numero");
        } else {
            return Math.log(a);
        }
    }
    public double sin(int a){
        return Math.sin(a);
    }
    public double cos(int a){
        return Math.cos(a);
    }
    public double tan(int a){
        if (((a-90) % 180 )==0) {
            throw new IllegalArgumentException("La expresion es no definida");
        } else {
            return Math.tan(a);
        }
    }
}
