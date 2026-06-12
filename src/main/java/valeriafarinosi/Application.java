package valeriafarinosi;

import valeriafarinosi.entities.BoardGame;
import valeriafarinosi.entities.Collection;
import valeriafarinosi.entities.VideoGame;
import valeriafarinosi.enums.Genres;
import valeriafarinosi.enums.Platforms;

import java.time.LocalDate;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Collection collection = new Collection();

        VideoGame zelda = new VideoGame(
                "j45hsao",
                "Zelda - BOTW",
                LocalDate.of(2017, 3, 3),
                67.90,
                Platforms.SWITCH,
                140,
                Genres.ADVENTURE
        );

        VideoGame minecraft = new VideoGame(
                "7adf8749",
                "Minecraft",
                LocalDate.of(2011, 11, 18),
                29.99,
                Platforms.PC,
                500,
                Genres.ADVENTURE
        );

        BoardGame labyrinth = new BoardGame(
                "s8s98bs5",
                "Labyrinth",
                LocalDate.of(1986, 1, 1),
                29.99,
                4,
                30
        );

        collection.addElement(zelda);
        collection.addElement(minecraft);
        collection.addElement(labyrinth);

        Scanner scanner = new Scanner(System.in);

        int scelta;

        while (true) {
            try {
                System.out.println("Inserisci il numero corrispondente all'azione desiderata:");

                System.out.println("1 - Aggiungi un gioco");

                scelta = Integer.parseInt(scanner.nextLine());

//                verifica numero nei ranghi
                if (scelta < 1 || scelta > 8) {
                    System.out.println("Scelta non valida.");
                    continue;
                }

                switch (scelta) {
                    case 1:
                        while (true) {
                            System.out.println("Di che tipologia di gioco si tratta?");
                            System.out.println("1 - VideoGame");
                            System.out.println("2 - BoardGame");

                            int type = Integer.parseInt(scanner.nextLine());

                            if (type == 1) {
//                            videogame
                                System.out.println("videogame");
                                break;
                            } else if (type == 2) {
//                            boardgame
                                System.out.println("boardgame");
                                break;
                            } else
                                System.out.println("Numero scelto non valido");
                            ;
                        }

                }


//               verifica tipo corretto
            } catch (NumberFormatException e) {
                System.out.println("Inserisci un valore numerico.");
            }
        }


    }
}
