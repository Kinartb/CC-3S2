package Contract;

public class TaxCalculator1 {
    // TaxCalculator con pre- y post-conditions implementado via asserts
    public double calculateTax(double value) {
        assert value >= 0 : " el valor no puede ser negativo";

        double taxValue = 0;

        assert taxValue >= 0 : " el valor no puede ser negativo";

        return taxValue;
    }
}
