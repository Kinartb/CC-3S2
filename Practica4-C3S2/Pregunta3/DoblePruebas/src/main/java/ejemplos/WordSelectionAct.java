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

