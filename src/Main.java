import Media.*;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ElementoMultimediale[] player = new ElementoMultimediale[5];
        String input;
        int nMedia = 0;

        System.out.println("Inserisci nel player 5 Media a tua scelta!");

        while (nMedia < player.length) {
            System.out.println("Cosa vuoi inserire nel player?");
            System.out.println("1 = Immagine");
            System.out.println("2 = Registrazione Audio");
            System.out.println("3 = Video");
            input = scanner.nextLine();
            String title;
            int l, d, v;
            switch (input) {
                case "1":
                    System.out.println("Immagine! Titolo immagine:");
                    title = scanner.nextLine();
                    l = lControl(scanner);
                    player[nMedia] = new Immagine(title, l);
                    nMedia++;
                    break;
                case "2":
                    System.out.println("Registrazione Audio! Titolo Audio:");
                    title = scanner.nextLine();
                    v = vControl(scanner);
                    d = dControl(scanner);
                    player[nMedia] = new Registrazione(title, v, d);
                    nMedia++;
                    break;
                case "3":
                    System.out.println("Video! Titolo Video:");
                    title = scanner.nextLine();
                    l = lControl(scanner);
                    v = vControl(scanner);
                    d = dControl(scanner);
                    player[nMedia] = new Video(title, l, v, d);
                    nMedia++;
                    break;
                default:
                    System.out.println("Numero non valido, prova ad inserire 1 o 2 o 3");
            }
        }
        input = "";
        System.out.println("Media inseriti correttamente! Cosa vuoi fare ora?");
        while (!input.equals("0")) {
            System.out.println("0 Esci dal player (e perdi tutti i Media creati in precedenza)");
            System.out.println("1 Modifica Media");
            System.out.println("2 Vedi Media");
            input = scanner.nextLine();
            switch (input) {
                case "0":
                    break;
                case "1":
                    System.out.println("Quale Media vuoi modificare?");
                    for (int i = 0; i < player.length; i++) {
                        System.out.println((i + 1) + " " + getType(player[i]) + ": " + player[i].getTitolo());
                    }
                    int in = Integer.parseInt(scanner.nextLine());
                    modifica(in, player, scanner);
                    break;
                case "2":
                    System.out.println("Quale Media vuoi riprodurre o vedere?");
                    for (int i = 0; i < player.length; i++) {
                        System.out.println((i + 1) + " " + getType(player[i]) + ": " + player[i].getTitolo());
                    }
                    while (true) {
                        try {
                            int index = Integer.parseInt(scanner.nextLine());
                            if (getType(player[index - 1]).equals("Immagine")) {
                                Immagine immagine = (Immagine) player[index - 1];
                                immagine.show();
                            } else if (getType(player[index - 1]).equals("Audio")) {
                                Registrazione audio = (Registrazione) player[index - 1];
                                audio.play();
                            } else {
                                Video video = (Video) player[index - 1];
                                video.play();
                            }
                            break;
                        } catch (ArrayIndexOutOfBoundsException ignored) {
                        }
                    }
                    break;
                default:
                    System.out.println("Numero non valido, prova ad inserire 1 o 2 o 0");
                    break;
            }
        }
        System.out.println("Arrivederci!");
    }

    private static int lControl(Scanner scanner) {
        int l = 0;
        while (l < 1 || l > 10) {
            System.out.println("Seleziona la luminosità (Da 1 e 10)");
            l = Integer.parseInt(scanner.nextLine());
            if (l < 1 || l > 10) {
                System.out.println("Numero non valido, prova ad inserire un numero intero compreso tra 1 e 10");
            }
        }
        return l;
    }

    private static int dControl(Scanner scanner) {
        int d = 0;
        while (d < 1 || d > 60) {
            System.out.println("Seleziona la durata (Da 1 a 60)");
            d = Integer.parseInt(scanner.nextLine());
            if (d < 1 || d > 60) {
                System.out.println("Numero non valido, prova ad inserire un numero intero compreso tra 1 e 60");
            }
        }
        return d;
    }

    private static int vControl(Scanner scanner) {
        int v = -1;
        while (v < 0 || v > 10) {
            System.out.println("Seleziona il volume (Da 0 a 10)");
            v = Integer.parseInt(scanner.nextLine());
            if (v < -1 || v > 10)
                System.out.println("Numero non valido, prova ad inserire un numero intero compreso tra 0 e 10");
        }
        return v;
    }

    @NotNull
    private static String getType(ElementoMultimediale m) {
        if (m instanceof ElementoConLuminosita && m instanceof ElementoConVolumeEDurata) {
            return "Video";
        } else if (m instanceof ElementoConLuminosita) {
            return "Immagine";
        } else return "Audio";
    }

    private static void modifica(int input, ElementoMultimediale[] player, Scanner scanner) {
        if (input >= 1 && input <= 5) {
            String type = getType(player[input - 1]);
            String s = "";
            int m;
            System.out.println("Cosa vuoi fare?");
            switch (type) {
                case "Video":
                    Video video = (Video) player[input - 1];
                    while (!s.equals("1") && !s.equals("2") && !s.equals("3") && !s.equals("4")) {
                        System.out.println("1 Aumenta Volume");
                        System.out.println("2 Abbassa Volume");
                        System.out.println("3 Aumenta Luminosità");
                        System.out.println("4 Abbassa Luminosità");
                        s = scanner.nextLine();
                        switch (s) {
                            case "1":
                                System.out.println("Quanto vuoi aumentare il volume? Attuale: " + video.getVol() + " (max: 10)");
                                m = Integer.parseInt(scanner.nextLine());
                                video.alzaVol(m);
                                break;
                            case "2":
                                System.out.println("Quanto vuoi abbassare il volume? Attuale: " + video.getVol() + " (min: 0)");
                                m = Integer.parseInt(scanner.nextLine());
                                video.abbassaVol(m);
                                break;
                            case "3":
                                System.out.println("Quanto vuoi alzare la luminosità? Attuale: " + video.getLum() + " (max: 10)");
                                m = Integer.parseInt(scanner.nextLine());
                                video.aumentaLum(m);
                                break;
                            case "4":
                                System.out.println("Quanto vuoi abbassare la luminosità? Attuale: " + video.getLum() + " (min: 1)");
                                m = Integer.parseInt(scanner.nextLine());
                                video.diminuisciLum(m);
                                break;
                            default:
                                System.out.println("Numero non valido, prova ad inserire 1 o 2 o 3 o 4");
                                break;
                        }
                    }
                    break;
                case "Immagine":
                    Immagine immagine = (Immagine) player[input - 1];
                    while (!s.equals("1") && !s.equals("2")) {
                        System.out.println("1 Aumenta Luminosità");
                        System.out.println("2 Abbassa Luminosità");
                        s = scanner.nextLine();
                        switch (s) {
                            case "1":
                                System.out.println("Quanto vuoi alzare la luminosità? Attuale: " + immagine.getLum() + " (max: 10)");
                                m = Integer.parseInt(scanner.nextLine());
                                immagine.aumentaLum(m);
                                break;
                            case "2":
                                System.out.println("Quanto vuoi abbassare la luminosità? Attuale: " + immagine.getLum() + " (min: 1)");
                                m = Integer.parseInt(scanner.nextLine());
                                immagine.diminuisciLum(m);
                                break;
                            default:
                                System.out.println("Numero non valido, prova ad inserire 1 o 2");
                                break;
                        }
                    }
                    break;
                case "Audio":
                    Registrazione audio = (Registrazione) player[input - 1];
                    while (!s.equals("1") && !s.equals("2")) {
                        System.out.println("1 Aumenta Volume");
                        System.out.println("2 Abbassa Volume");
                        s = scanner.nextLine();
                        switch (s) {
                            case "1":
                                System.out.println("Quanto vuoi aumentare il volume? Attuale: " + audio.getVol() + " (max: 10)");
                                m = Integer.parseInt(scanner.nextLine());
                                audio.alzaVol(m);
                                break;
                            case "2":
                                System.out.println("Quanto vuoi abbassare il volume? Attuale: " + audio.getVol() + " (min: 0)");
                                m = Integer.parseInt(scanner.nextLine());
                                audio.abbassaVol(m);
                                break;
                            default:
                                System.out.println("Numero non valido, prova ad inserire 1 o 2");
                                break;
                        }
                    }
                    break;
                default:
                    break;
            }
        } else System.out.println("Numero non valido, prova ad inserire 1 o 2 o 3 o 4 o 5");
    }

}