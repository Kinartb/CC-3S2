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
