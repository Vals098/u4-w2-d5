package valeriafarinosi.exceptions;

public class CouldNotFindGameException extends RuntimeException {
    public CouldNotFindGameException() {
        super("Gioco non trovato! Inserisci un altro id");
    }
}
