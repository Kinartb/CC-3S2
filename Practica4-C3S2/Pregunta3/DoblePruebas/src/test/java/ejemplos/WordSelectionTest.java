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
    /*
    @Test
    public void reportsWordNotFound() {
        repository = mock(WordRepository.class);
        WordSelection selection;
        selection = new WordSelection(repository);

        doThrow(new WordRepositoryException())
                .when(repository)
                .fetchWordByNumber(anyInt());

        assertThatExceptionOfType(WordSelectionException.class)
                .isThrownBy(() -> selection.Aleatorio())
                .withMessage("No se obitene palabra");
    }*/



