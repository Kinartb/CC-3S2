Se realiza el siguiente codigo donde se agrega la interface WordRepository

```
package ejemplos;
public interface WordRepository{
    String fetchWordByNumber(int rannum);
}
```
2. Indica los pasos Act y Assert de la prueba.
   
Para la clase WordSelection se implementa el siguiente codigo de caso Act, es decir primero tenemos que dejar que actue, para este caso solo va a regresar numeros.

```
package ejemplos;

import java.util.random.RandomGenerator;
public class WordSelectionAct {
    private final int TotalPalabras=3;
    private final RandomGenerator word=RandomGenerator.getDefault();
    public String Aleatorio(){
        int numberrandom= word.nextInt(TotalPalabras)+1;
        return String.format("Palabra: ",numberrandom);
    }
}

```

Es casi imposible corrobar un valor esperado cuando se utiliza salida de datos de forma aleatoria por lo que es necesario el uso de herramientas adicionales para su evaluacion al momento de realizar las pruebas.

1. Construye el SUT , completa y explica el código de prueba generado.

Se construye el SUT de nombre StubWordRepository

```
package ejemplos;

public class StubWordRepository implements WordRepository{
    @Override
    public String fetchWordByNumber(int wordNumber){
        return "hola";
    }
}
```
Lo que realiza este SUT en este caso es implementar un falso pivot, es decir introduce un parametro el cual en este caso va a regresar el valor de hola, de este modo, al momento de realizar una prueba con aleatoriedad podemos indicar que el valor espero es "hola" por lo cual la ejecucion de una prueba sera verde.

No solamente es implementar un Stub, sino tambien realizar cambios en el codigo principal, entonces para la clase WordSelection se realiza:

```
package ejemplos;

import java.util.Random;

public class WordSelection {
    private final int TotalPalabras=3;
    private final WordRepository wordRepo;
    public WordSelection(WordRepository w){
        this.wordRepo = w;
    }
    public String Aleatorio(){
        Random rand = new Random();
        int numberrandom= rand.nextInt(TotalPalabras)+1;
        String word;
        word = wordRepo.fetchWordByNumber(numberrandom);
        return "Palabra: "+ word;
    }
}
```
Se realiza una prueba para visualizar si nuestra implementacion es correcta, entonces para el campo de pruebas se codifica:

```
package ejemplos;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WordSelectionTest {

    @Mock
    private WordRepository repository;

    @Test
    void reportsWordFund() {
        var stub = new StubWordRepository();
        var elegido = new WordSelection(stub);
        var actual = elegido.Aleatorio();
        assertThat(actual).isEqualTo("Palabra: hola");
    }
}
```

El cual nos da una respuesta en verde para la prueba realizada

!()[https://github.com/Kinartb/CC-3S2/blob/main/Practica4-C3S2/imagenes/prueba2test1.png]

Con un coverage de casi el 33% 

!()[https://github.com/Kinartb/CC-3S2/blob/main/Practica4-C3S2/imagenes/prueba2coverage1.png]
