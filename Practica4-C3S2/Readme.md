Prueba 1 (8 puntos)

Pregunta 1 (2 puntos)

Escribe una implementacion del problema dado sin tenen en cuenta los requisitos. Queremos lograr, digamos, el 100% de cobertura de ramas.

A continuacion se muestra el desarrollo del programa sin requisitos.

```
public class Main {
    public static void main(String[] args) {
        int retorno;
        int[] nums = {0,0,0, 1, 1,3,3, 2, 2, 2,2};
        retorno=countClumps(nums);
        System.out.println(retorno);
    }
    public static int countClumps(int[] nums){
        int acumulador=0;
        boolean identificador=false;
        boolean cambio=false;
        for( int i=0; i<nums.length-1; i++){
            if (nums[i]==nums[i+1]){
                identificador=true;
            }else if(nums[i]!=nums[i+1]){
                cambio=true;
            }
            if (identificador == true && cambio==true){
                identificador=false;
                cambio=false;
                acumulador++;
            }
        }
        if(nums[0]==nums[1]){
            return acumulador+1;
        }
        return acumulador;
    }
}
```

Pregunta 2 (1 puntos)

Escribimos las implementaciones

pre-condicion: arreglo debe ser no nula y la longitud > 0;

post-condicion: si se viola la pre-condicion el programa retorna 0, el programa devuelve un numero entero;

```
T1:arreglo nulo
T2:longitud es 0 o vacia
T3:longitud es 1
T4:longitud mayor a 1 (cualquier cadena)
```

```
package Ejecucion;

public class Prueba1 {
    public static void main(String[] args) {
        int retorno;
        int[] nums = {0,0,0, 1, 1,3,3, 2, 2, 2,2};
        retorno=countClumps(nums);
        System.out.println(retorno);
    }
    public static int countClumps(int[] nums){
        //T1,T2
        if (nums==null || nums.length==0 || nums.length==1){
            return 0;
        }
        int acumulador=0;
        boolean identificador=false;
        boolean cambio=false;
        for( int i=0; i<nums.length-1; i++){
            if (nums[i]==nums[i+1]){
                identificador=true;
            }else if(nums[i]!=nums[i+1]){
                cambio=true;
            }
            if (identificador == true && cambio==true){
                identificador=false;
                cambio=false;
                acumulador++;
            }
        }
        if(nums[0]==nums[1]){
            return acumulador+1;
        }
        return acumulador;
    }
}
```
Pregunta 3 (2 puntos)

Escribimos las pruebas como casos de pruebas automatizadas (JUnir y ejecutamos la herramienta de cobertura de codigo favorita.

Sea para las pruebas:

```
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
}
```

Se tiene el 100% de pruebas cubiertas en la siguiente imagen

![Test de Prueba 1](https://github.com/Kinartb/CC-3S2/blob/main/Practica4-C3S2/imagenes/prueba1.png)

Pregunta 4 (3 puntos)

Al agregar dicha pruebas donde se experimenta con el último clump en el último elemento del arreglo o con un conjunto que tiene un clump que comienza en la primera posición.

```
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
```
Ejecutamos las pruebas

![](https://github.com/Kinartb/CC-3S2/blob/main/Practica4-C3S2/imagenes/prueba1test.png)

Para el de cobertura

![](https://github.com/Kinartb/CC-3S2/blob/main/Practica4-C3S2/imagenes/prueba1coverage.png)

Se obtiene un error de prueba, pero nos indica un 100% de cobertura. Es decir que la prueba de cobertura nos indica que estamos probando todo el conjunto de pruebas pero no nos indica si esta es una prueba erronea o verdadera. 

Esto se soluciona con una implementacion en nuestro codigo de ejecucion
```
package Ejecucion;

public class Prueba1 {
    public static void main(String[] args) {
        int retorno;
        int[] nums = {0,0,0, 1, 1,3,3, 2, 2, 2,2};
        retorno=countClumps(nums);
        System.out.println(retorno);
    }
    public static int countClumps(int[] nums){
        //T1,T2
        if (nums==null || nums.length==0 || nums.length==1){
            return 0;
        }
        int acumulador=0;
        boolean identificador=false;
        boolean cambio=false;
        for( int i=0; i<nums.length-1; i++){
            if (nums[i]==nums[i+1]){
                identificador=true;
            }else if(nums[i]!=nums[i+1]){
                cambio=true;
            }
            if (identificador == true && cambio==true && nums[i]==nums[i+1]){
                identificador=false;
                cambio=false;
                acumulador++;
            }
        }
        if(nums[0]==nums[1]){
            return acumulador+1;
        }
        return acumulador;
    }
}
```
Ejecutamos las pruebas nuevamente

![](https://github.com/Kinartb/CC-3S2/blob/main/Practica4-C3S2/imagenes/prueba1test2.png)

Tambien visualizamos la cobertura

![](https://github.com/Kinartb/CC-3S2/blob/main/Practica4-C3S2/imagenes/prueba1coverage2.png)
Nuestro codigo puede estar cubierto al 100% pero eso no quiere decir que la implementacion de nuestro programa este del todo correcto por lo que al realizar un programa es necesario un mayor analisis.

