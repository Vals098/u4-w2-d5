package valeriafarinosi.entities;

import valeriafarinosi.exceptions.InsertedIdNotUniqueException;

import java.util.ArrayList;
import java.util.List;

public class Collection {

    private List<Game> games = new ArrayList<>();

    //    addElement
    public void addElement(Game game) {
        boolean idExists = games.stream().anyMatch(currentGame -> currentGame.getId().equals(game.getId()));

        if (idExists) {
            throw new InsertedIdNotUniqueException();
        } else {
            games.add(game);
        }
    }

    @Override
    public String toString() {
        return "Collection{" +
                "games=" + games +
                '}';
    }
}
