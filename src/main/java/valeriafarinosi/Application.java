package valeriafarinosi;

import valeriafarinosi.entities.BoardGame;
import valeriafarinosi.entities.Collection;
import valeriafarinosi.entities.VideoGame;
import valeriafarinosi.enums.Genres;
import valeriafarinosi.enums.Platforms;
import valeriafarinosi.exceptions.PlayersNumberNotValidException;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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
//scalta azione
        int scelta;

        while (true) {
            try {
                System.out.println("Inserisci il numero corrispondente all'azione desiderata:");

                System.out.println("1 - Aggiungi un gioco");

                scelta = Integer.parseInt(scanner.nextLine());

//                verifica numero nei ranghi
                if (scelta < 1 || scelta > 8) {
                    System.out.println("Inserisci un numero valido: da 1 a 8.");
                    continue;
                }

                switch (scelta) {
                    case 1:
                        while (true) {
                            try {
                                System.out.println("Inserisci un ID:");
                                String ID = scanner.nextLine();

                                System.out.println("Inserisci un titolo:");
                                String title = scanner.nextLine();

                                LocalDate date;

                                while (true) {
                                    try {
                                        System.out.println("Inserisci una data di uscita (YYYY-MM-DD):");
                                        date = LocalDate.parse(scanner.nextLine());
                                        break;

                                    } catch (DateTimeParseException e) {
                                        System.out.println("Formato data non valido. Usa YYYY-MM-DD");
                                    }
                                }

                                System.out.println("Inserisci il prezzo:");
                                double price = Double.parseDouble(scanner.nextLine());
                                while (true) {
                                    try {
                                        System.out.println("Di che tipologia di gioco si tratta?");
                                        System.out.println("1 - VideoGame");
                                        System.out.println("2 - BoardGame");

                                        int type = Integer.parseInt(scanner.nextLine());

//                verifica numero nei ranghi
                                        if (type < 1 || type > 2) {
                                            System.out.println("Inserisci un numero tra 1 e 2.");
                                            continue;
                                        }

                                        if (type == 1) {
//                            videogame

                                            Platforms platform;
                                            double gameplayDuration;
                                            Genres genre;

                                            System.out.println("--------------------------- VideoGame --------------------------");
                                            while (true) {
                                                try {
                                                    System.out.println("Inserisci una piattaforma tra:");
                                                    System.out.println("PC,PS4,PS5,XBOX,VR_HEADSET,SWITCH,WII,OTHER");
                                                    platform = Platforms.valueOf(scanner.nextLine().toUpperCase());

                                                    System.out.println("Inserisci una durata di gioco (h):");
                                                    gameplayDuration = Double.parseDouble(scanner.nextLine());

                                                    System.out.println("Inserisci un genere tra:");
                                                    System.out.println("ACTION,ADVENTURE,SHOOTER,CHILDREN,SPORT,ARCADE,STRATEGY,OTHER");
                                                    genre = Genres.valueOf(scanner.nextLine().toUpperCase());


//                                    salvo i dati come videogioco
                                                    VideoGame videoGame = new VideoGame(
                                                            ID, title, date, price, platform, gameplayDuration, genre
                                                    );
//                                    aggiungo il nuovo videoGame a collection
                                                    collection.addElement(videoGame);
                                                    System.out.println("VideoGioco creato con successo!!");

                                                    break;
                                                } catch (NumberFormatException e) {
                                                    System.out.println("Inserisci un numero.");
                                                }
                                                ;
                                            }
                                        } else if (type == 2) {
//                            boardgame
                                            System.out.println("--------------------------- BoardGame --------------------------");

                                            int players;
                                            double averageGameplayDuration;

                                            while (true) {
                                                try {
                                                    System.out.println("Inserisci un numero di giocatori tra 2 e 10:");
                                                    players = Integer.parseInt(scanner.nextLine());

                                                    if (players < 2 || players > 10) {
                                                        throw new PlayersNumberNotValidException();
                                                    }

                                                    System.out.println("Inserisci la durata di gioco(min):");
                                                    averageGameplayDuration = Double.parseDouble(scanner.nextLine());

//                                    salvo i dati come boardGame
                                                    BoardGame boardGame = new BoardGame(ID, title, date, price, players, averageGameplayDuration);

//                                    aggiungo il nuovo boardGama a collection
                                                    collection.addElement(boardGame);
                                                    System.out.println("BoardGame creato con successo!!");

                                                    break;
                                                } catch (PlayersNumberNotValidException e) {
                                                    System.out.println(e.getMessage());
                                                } catch (NumberFormatException e) {
                                                    System.out.println("Inserisci un numero.");
                                                }
                                            }
                                            break;
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Inserisci un numero tra 1 e 2.");

                                    }
                                }
                                ;
                            } catch (NumberFormatException e) {
                                System.out.println("Inserisci un valore numerico.");
                            }
                        }
                }


//               verifica tipo corretto
            } catch (NumberFormatException e) {
                System.out.println("Inserisci un valore numerico.");
            }
        }


    }
}
