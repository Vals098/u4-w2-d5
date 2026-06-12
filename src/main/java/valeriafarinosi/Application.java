package valeriafarinosi;

import valeriafarinosi.entities.BoardGame;
import valeriafarinosi.entities.Collection;
import valeriafarinosi.entities.Game;
import valeriafarinosi.entities.VideoGame;
import valeriafarinosi.enums.Genres;
import valeriafarinosi.enums.Platforms;
import valeriafarinosi.exceptions.InsertedIdNotUniqueException;
import valeriafarinosi.exceptions.PlayersNumberNotValidException;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
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

// -------------------------------- SCELTA AZIONE -----------------------------------
        int scelta;

        while (true) {
            try {
                System.out.println("Inserisci il numero corrispondente all'azione desiderata:");

                System.out.println("1 - Aggiungi un gioco");
                System.out.println("2 - Cerca gioco tramite id");
                System.out.println("3 - Confronto prezzo");
                System.out.println("4 - Ricerca per numero di giocatori");
                System.out.println("5 - Rimozione di un elemento dato id");
                System.out.println("6 - Aggiornamento di un elemento tramite id");
                System.out.println("7 - Statistiche della collezione");

                scelta = Integer.parseInt(scanner.nextLine());

//                verifica numero nei ranghi
                if (scelta < 1 || scelta > 7) {
                    System.out.println("Inserisci un numero valido: da 1 a 7.");
                    continue;
                }

                switch (scelta) {
//    -------------------------------------- CASO 1 ----------------------------------------
                    case 1:
                        boolean isCreated = false;

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

//  --------------------------------- SCELTA TIPOLOGIA DI GIOCO -----------------------------

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

                                        if (type == 1) { //VIDEOGAME

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

                                                    isCreated = true;
                                                    break;
                                                } catch (NumberFormatException e) {
                                                    System.out.println("Inserisci un numero.");
                                                } catch (InsertedIdNotUniqueException e) {
                                                    System.out.println(e.getMessage());

                                                }
                                                ;
                                            }
                                        } else if (type == 2) { //BOARDGAME

                                            System.out.println("--------------------------- BoardGame --------------------------");

                                            int players;
                                            double averageGameplayDuration;

                                            while (true) {
                                                try {
                                                    System.out.println("Inserisci un numero di giocatori tra 2 e 10:");
                                                    players = Integer.parseInt(scanner.nextLine());

                                                    System.out.println("Inserisci la durata di gioco(min):");
                                                    averageGameplayDuration = Double.parseDouble(scanner.nextLine());

//                                    salvo i dati come boardGame
                                                    BoardGame boardGame = new BoardGame(ID, title, date, price, players, averageGameplayDuration);

//                                    aggiungo il nuovo boardGama a collection
                                                    collection.addElement(boardGame);
                                                    System.out.println("BoardGame creato con successo!!");

                                                    isCreated = true;
                                                    break;
                                                } catch (InsertedIdNotUniqueException e) {
                                                    System.out.println(e.getMessage());
                                                } catch (PlayersNumberNotValidException e) {
                                                    System.out.println(e.getMessage());
                                                } catch (NumberFormatException e) {
                                                    System.out.println("Inserisci un numero.");
                                                }
                                            }
                                        }
                                        if (isCreated) {
                                            break;
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Inserisci un numero tra 1 e 2.");

                                    }
                                }
                                ;
                                if (isCreated) {
                                    System.out.println("Nuova collezione: " + collection);
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Inserisci un valore numerico.");
                            }

                        }

//     ----------------------------------- CASO 2 -------------------------------------
                    case 2:
                        while (true) {
                            System.out.println("Inserisci un id da confrontare:");
                            String id = scanner.nextLine();

                            Game givenGame = collection.searchById(id);

                            if (givenGame == null) {
                                System.out.println("Nessun gioco trovato con questo id,");
                                System.out.println("Riprova....");
                                continue;
                            } else
                                System.out.println("Trovato! -> " + givenGame);
                            break;
                        }

//   ------------------------------------ CASO 3 -----------------------------------
                    case 3:
                        while (true) {
                            try {
                                System.out.println("Inserisci un prezzo massimo:");
                                double inputPrice = Double.parseDouble(scanner.nextLine());

                                List<Game> priceLessThanGames = collection.searchByPrice(inputPrice);

                                if (priceLessThanGames.isEmpty()) {
                                    System.out.println("Nessun gioco trovato con prezzo inferiore a: " + inputPrice + ",");
                                    System.out.println("Riprova....");
                                    continue;
                                } else
                                    System.out.println("Lista giochi trovati: " + priceLessThanGames);
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Inserisci un valore numerico.");
                            }
                        }

//   ------------------------------------ CASO 4 ------------------------------------
                    case 4:
                        while (true) {
                            try {

                                System.out.println("Inserisci il numero di giocatori, da 2 a 10:");
                                int inputPlayers = Integer.parseInt(scanner.nextLine());

                                List<BoardGame> gamesWithThosePlayers =
                                        collection.searchByPlayers(inputPlayers);

                                if (gamesWithThosePlayers.isEmpty()) {
                                    System.out.println("Nessun gioco trovato con numero giocatori: " + inputPlayers);
                                    System.out.println("Riprova...");
                                    continue;
                                }
                                System.out.println("Lista giochi trovati:");
                                gamesWithThosePlayers.forEach(System.out::println);
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Inserisci un valore numerico.");
                            }
                        }

//   ------------------------------------ CASO 5 ------------------------------------
//   ------------------------------------ CASO 6 ------------------------------------
//   ------------------------------------ CASO 7 ------------------------------------


                }


//               verifica tipo corretto
            } catch (NumberFormatException e) {
                System.out.println("Inserisci un valore numerico.");
            }
        }


    }
}
