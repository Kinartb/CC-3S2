package ejemplos;

public class StubWordRepository implements WordRepository{
    @Override
    public String fetchWordByNumber(int wordNumber){
        return "hola";
    }
}
