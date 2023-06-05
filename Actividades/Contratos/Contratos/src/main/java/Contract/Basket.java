package Contract;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class Basket {
    private BigDecimal totalValue = BigDecimal.ZERO;
    private Map<Product, Integer> basket = new HashMap< >();

    public void add(Product product, int qtyToAdd) {
        //PRECONDICION: No se puede agregar un producto inexistente(product != null)
        //La cantidad que se AGREGA es mayor a 0 (qtyToAddz>0)
        //POSTCONDICION: Retorno aseveracion se ha realizado la agregacion.
        //el nuevo valor total debe ser mayor que el valor total anterior
        //(totalValue <= qtyToAdd + totalValue)
        if(product == null ){
            throw new RuntimeException("Tiene que haber un producto");
        }
        if(qtyToAdd <=0){
            throw new RuntimeException("Tiene que agregar una cantidad positiva");
        }


    }
    public void remove(Product product) {
        //PRECONDICION: Tiene que estar dicho producto (product!=null)
        //POSTCONDICION: Retorno aseveracion se ha realizado la agregacion.
        // El producto una vez removido, ya no tiene que existir (product==null)
 
    }
    private boolean invariant() {
        //Como se utiliza la misma instruccion tanto en add como en remove entonces
        //es conveniente realizar un metodo para no sobreescribir codigo
        return totalValue.compareTo(BigDecimal.ZERO) >= 0;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public int quantityOf(Product product) {
        assert basket.containsKey(product);
        return basket.get(product);
    }

    public Set<Product> products() {
        return Collections.unmodifiableSet(basket.keySet());
    }
    @Override
    public String toString() {
        return "BasketCase{" +
                "totalValue=" + totalValue +
                ", basket=" + basket +
                '}';
    }
}
