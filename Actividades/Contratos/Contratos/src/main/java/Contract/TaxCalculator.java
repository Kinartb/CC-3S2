package Contract;
import org.junit.jupiter.api.BeforeAll;
/*
PRECONDICIONES:  no acepta números negativos (value<0)
POSTCONDICIONES: no devuelve números negativos. (texValue<0)
 */
public class TaxCalculator {

    public double calculateTax(double value) {
        if(value < 0) {
            throw new RuntimeException("El valor tiene que ser positivo");
        }

        double taxValue = 0;

        if(taxValue < 0) {
            throw new RuntimeException("El impuesto no puede ser negativo");
        }
        return taxValue;
    }
}
