package ejemplos;

public class Word {
    private final String word;
    private WordRepository repository;
    public Word(String correctWord) {
        this.word = correctWord;
    }
    public Score guess(String attempt) {
        var score = new Score(word);

        score.assess(0, attempt);
        return score;
    }
}
