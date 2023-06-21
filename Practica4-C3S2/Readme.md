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
T1:arreglo no nulo
T2:longitud >0
T3:viola T1 y T2 retorna 0;
T4:retorno int;
```
