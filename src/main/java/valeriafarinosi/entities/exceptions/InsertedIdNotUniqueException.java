package valeriafarinosi.entities.exceptions;

public class InsertedIdNotUniqueException extends RuntimeException {
    public InsertedIdNotUniqueException() {
        super("L'id inserito non è disponibile");
    }

    public InsertedIdNotUniqueException(String string) {
        super(string);
    }
}
