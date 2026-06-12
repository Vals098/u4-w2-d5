package valeriafarinosi.entities;

import valeriafarinosi.exceptions.PlayersNumberNotValidException;

import java.time.LocalDate;

public class BoardGame extends Game {
    private int players;
    private double averageGameplayDuration;


    public BoardGame(String ID, String title, LocalDate date, double price, int players, double averageGameplayDuration
    ) {
        super(ID, title, date, price);
        setPlayers(players);
        this.averageGameplayDuration = averageGameplayDuration;
    }

    public int getPlayers() {
        return players;
    }

    public void setPlayers(int players) {
        if (players < 2 || players > 10) {
            throw new PlayersNumberNotValidException();
        } else
            this.players = players;
    }

    public double getAverageGameplayDuration() {
        return averageGameplayDuration;
    }

    public void setAverageGameplayDuration(double averageGameplayDuration) {
        this.averageGameplayDuration = averageGameplayDuration;
    }
}
