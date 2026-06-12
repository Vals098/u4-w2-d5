package valeriafarinosi.exceptions;

public class PlayersNumberNotValidException extends RuntimeException {
    public PlayersNumberNotValidException() {
        super("Il numero di giocatori deve essere compreso tra 2 e 10");
    }

    public PlayersNumberNotValidException(String string) {
        super(string);
    }
}
