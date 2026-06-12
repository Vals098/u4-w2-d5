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

    //    ricerca per id
    public Game searchById(String ID) {
        return games.stream().filter(game -> game.getId().equals(ID)).findAny().orElse(null);
    }

    @Override
    public String toString() {
        return "Collection{" +
                "games=" + games +
                '}';
    }

    //    ricerca per prezzo
    public List<Game> searchByPrice(double inputPrice) {
        return games.stream().filter(game -> game.getPrice() < inputPrice).toList();
    }

    ;


}
