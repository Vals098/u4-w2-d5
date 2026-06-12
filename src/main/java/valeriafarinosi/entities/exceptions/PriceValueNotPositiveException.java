package valeriafarinosi.entities.exceptions;

public class PriceValueNotPositiveException extends RuntimeException {
    public PriceValueNotPositiveException() {
        super("Il prezzo deve essere un valore > 0 !");
    }

    public PriceValueNotPositiveException(String string) {
        super(string);
    }

}
