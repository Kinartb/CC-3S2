# 1.

 * @param bits un arreglo de 32 valores true/false
 * @retorna el Boleano AND de todos los valores en el arreglo

boolean andAll(boolean[] bits) {
  boolean result = bits[0];
  for (int i = 1; i < 31; i++) {
    result = result && bits[i];
  }
  return result;
}

¿Cuál es el resultado de cada caso de prueba?

andAll([true, true, true, ..., true, true]) // 32 valores true
Empleando este arreglo el resultado de este caso de prueba es true
andAll([false, true, false, true, ..., false, true]) // 32 valores alternando entre false y true
Empleando este arreglo el resultado de este caso de prueba es false
Sin embargo, notamos que la función no esta utilizando todos los elementos del arreglo de tipo boolean que se le está pasando como parámetro, el error se encuentra en la estructura repetitiva o  bucle for, pues no está considerando el último elemento del arreglo.

Podriamos notar esta falencia con el siguiente caso de prueba:
andAll([true, true, true, true, ..., true, false]) // 31 valores true y un valor false
Empleando este arreglo el resultado de este caso de prueba es true, sin embargo, esto no es cierto, pues el resultado debería ser false
Por lo tanto, tomando la siguiente función corregida:

 * @param bits un arreglo de 32 valores true/false
 * @retorna el Boleano AND de todos los valores en el arreglo

```java
boolean andAll(boolean[] bits) {
  boolean result = bits[0];
  for (int i = 1; i < =31; i++) {
    result = result && bits[i];
  }
  return result;
}
```


Los casos de prueba necesarios para garantizar que la función funcione correctamente serían las siguientes:
andAll([true, true, true, ..., true, true]) // 32 valores true
andAll([false, false, false, false, ..., false, false]) // 32 valores false
andAll([false, true, false, true, ..., false, true]) // 32 valores alternando entre false y true
andAll([true, false, true, flase, ..., true, flase]) // 32 valores alternando entre true y false
andAll([true, true, true, true, ..., true, false]) // 31 valores true y un valor false
andAll([false, false, false, false, ..., false, true]) // 31 valores false y un valor true
andAll([false, true, true, true, ..., true, false]) // 30 valores true y dos valores false
andAll([true, false, false, false, ..., false, true]) // 30 valores false y dos valores true

# 2.

•	El software exhibe un comportamiento discontinuo, a diferencia de muchos sistemas diseñados físicamente.

•	La verificación de tipos estáticos podría haber detectado este error.
El problema había surgido al convertir un número de punto flotante de 64 bits a un número entero con signo de 16 bits.

El tipo de dato se mantiene fijo o estático y al convertir de un tipo de dato a otro podemos tener problemas de desbordamiento, pues sabemos que cada tipo de dato tiene una capacidad mínima y máxima.

También recordemos que las variables de clase o variable miembro de dato estático nos dan información de la evolución del código dentro de un proyecto, es decir podría haber detectado este error debido a la historia que posee este proyecto en relación con su predecesor.

# 3.

•	Todos sus casos de prueba pasan cuando se ejecutan en una implementación legal.

# 4.

•	Pequeña

# 5. 

>Para la partición: x < 0; x >= 0.

Los subdominios son disjuntos, ya que al unirlos abarcan la totalidad del tipo de dato del parámetro de la función, para utilizar la función debemos respetar los tipos de datos de entrada a la función. Sin embargo, no son completos ya que considera el caso donde x no es un cuadrado perfecto, no tendría sentido encontrar el aproximado de la raíz cuadrada de un número no cuadrado perfecto. No forma participación.

>Para la partición x es un cuadrado perfecto; x es > 0 pero no es un cuadrado perfecto.

Los subdominios son disjuntos y adoptan todos los valores correctos posibles para la inicialización de la función. Decimos que son correctos porque están cubiertos por un caso de prueba legal, en este caso, la definición del dominio de la función raíz cuadrada y el resultado de valor entero que tiene que dar como resultante según la función de raíz cuadrada. Forma una buena partición.

>partición: x=0, x=1, x=7, x=16.

Los subdominios son disjuntos, sin embargo, no son completos ya que solo abarcan dichos valores, tampoco son correctos porque el resultante de la raíz cuadrada del número 7 no es de carácter entero. No es partición.

# 6.

> En partición: x e y no son 0.

Es un único subdominio, no está completo porque también deber de tomar el caso donde x e y son 0 para ser rechazados. No es partición.

>partición: x es divisible por y; y es divisible por x; x e y son primeros relativos.

Los subdominios no son disjuntos, si toma el caso donde x=1 e y=1, se intersecan los tres subdominios. No es partición.

# 7.

Se tiene el caso cuando todos los valores de entrada de A son W, cuando los valores de entrada de A son L, cuando los valores de entrada A son una combinación de W y L.

Para que resulte como fracción

1, 0, 0< retorno < 1

# 8.

Nos piden elegir un subconjunto por lo que la respuesta generalizada para este caso seria es particin en a: 0, positivo, negativo.

# 9.

Para cubrir cada subdominio de las tres particiones solo necesitaríamos 3 valores. Necesariamente los valores donde a=0, a=1, el último donde a es algún número negativo grande.

# 10.

Solo se necesitarían 4 casos de prueba, cuando A=0 y B=0, cuando A=positivo, cuando B=negativo, cuando A=negativo y B positivo. Cuando A=negativo y B= negativo o bien cuando A=positivo y B=positivo.