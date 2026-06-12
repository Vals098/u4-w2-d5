package valeriafarinosi.exceptions;

public class NumberNotInRangeException extends RuntimeException {
    public NumberNotInRangeException() {
        super("Numero non accettabile.");
    }

    public NumberNotInRangeException(String string) {
        super(string);
    }
}
