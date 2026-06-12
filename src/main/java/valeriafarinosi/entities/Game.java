package valeriafarinosi.entities;

import valeriafarinosi.exceptions.PriceValueNotPositiveException;

import java.time.LocalDate;

public abstract class Game {
    protected final String ID;
    protected String title;
    protected LocalDate date;
    protected double price;


    protected Game(String ID, String title, LocalDate date, double price) {
        this.ID = ID;
        this.title = title;
        this.date = date;
        setPrice(price);
    }

    public String getId() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new PriceValueNotPositiveException();
        } else {
            this.price = price;
        }
    }
}
