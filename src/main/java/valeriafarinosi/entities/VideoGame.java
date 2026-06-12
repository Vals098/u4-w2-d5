package valeriafarinosi.entities;

import valeriafarinosi.enums.Genres;
import valeriafarinosi.enums.Platforms;

import java.time.LocalDate;

public class VideoGame extends Game {
    private Platforms platform;
    private double gameplayDuration;
    private Genres genre;

    public VideoGame(String ID, String title, LocalDate date, double price, Platforms platform, double gameplayDuration, Genres genre) {
        super(ID, title, date, price);
        this.platform = platform;
        this.gameplayDuration = gameplayDuration;
        this.genre = genre;
    }

    public Platforms getPlatform() {
        return platform;
    }

    public void setPlatform(Platforms platform) {
        this.platform = platform;
    }

    public double getGameplayDuration() {
        return gameplayDuration;
    }

    public void setGameplayDuration(double gameplayDuration) {
        this.gameplayDuration = gameplayDuration;
    }

    public Genres getGenre() {
        return genre;
    }

    public void setGenre(Genres genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "VideoGame{" +
                "title='" + title + '\'' +
                ", platform=" + platform +
                ", gameplayDuration=" + gameplayDuration +
                ", genre=" + genre +
                ", ID='" + ID + '\'' +
                ", date=" + date +
                ", price=" + price +
                '}';
    }
}
