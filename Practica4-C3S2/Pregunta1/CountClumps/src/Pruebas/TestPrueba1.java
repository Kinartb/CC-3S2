package Pruebas;

import Ejecucion.Prueba1;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPrueba1 {
    //T1: arreglo nulo
    @Test
    public void ArregloNulo(){
        assertEquals(0,Prueba1.countClumps(null));
    }
    //T2: tamano igual a 0 o vacia
    @Test
    public void Longitud0(){
        int[] testnum={};
        assertEquals(0,Prueba1.countClumps(testnum));
    }
    //T3: tamano igual a 1
    @Test
    public void Longitud1(){
        int[] testnum={1};
        assertEquals(0,Prueba1.countClumps(testnum));
    }
    //T4: tamano mayor a 1
    @Test
    public void Longitudmayora1(){
        int[] testnum={1,1,2,2};
        assertEquals(2,Prueba1.countClumps(testnum));
    }
    @Test
    public void UltimoClumpEnElUltimoElementoDelArreglo(){
        int[] testnum={0,1,2,1,3,2,2};
        assertEquals(1,Prueba1.countClumps(testnum));
    }
    @Test
    public void ClumpQueComienzaEnPrimeraPosicion(){
        int[] testnum={1,1,2,3,2,4,2,5};
        assertEquals(1,Prueba1.countClumps(testnum));
    }
}
