package valeriafarinosi.entities;

import valeriafarinosi.exceptions.PlayersNumberNotValidException;

import java.time.LocalDate;

public class BoardGame extends Game {
    private int players;
    private double gameplayDurationMin;


    protected BoardGame(String ID, String title, LocalDate date, double price, int players, double gameplayDurationMin
    ) {
        super(ID, title, date, price);
        setPlayers(players);
        this.gameplayDurationMin = gameplayDurationMin;
    }

    public int getPlayers() {
        return players;
    }

    public void setPlayers(int players) {
        if (players < 2 || players > 8) {
            throw new PlayersNumberNotValidException();
        } else
            this.players = players;
    }

    public double getGameplayDurationMin() {
        return gameplayDurationMin;
    }

    public void setGameplayDurationMin(double gameplayDurationMin) {
        this.gameplayDurationMin = gameplayDurationMin;
    }
}
