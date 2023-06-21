package ejemplos;

public class Score {
    private final String correct;
    private Letter resultado = Letter.INCORRECT ;
    public Score(String correct) {
        this.correct = correct;
    }
    public Letter letter(int position) {
        return resultado;
    }
    public void assess(int position, String attempt) {
        if (correct.charAt(position) == attempt.charAt(position)) {
            resultado = Letter.CORRECT;
        }
    }
}
