import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        IMDB imdb = new IMDB();
        MediaReader mediaReader = new MediaReader();
        ArrayList<Media> mediaArrayList = mediaReader.leesBestandUit();
        boolean runProgram = true;
        while (runProgram) {
            Scanner inputChoice = new Scanner(System.in);
            System.out.println("1. \uD83C\uDFAC Selecteer media\n" +
                    "2. \uD83D\uDDC3️ Filteren media \n" +
                    "3.  Afsluiten");
            int nummer = inputChoice.nextInt();
            if (nummer == 1) {
                int index = 1;
                for (Media media : mediaArrayList) {
                    System.out.println("-------------------------");
                    System.out.println("Nummer: " + index);
                    imdb.weergevenMedia(media);
                    index++;
                }
                System.out.println("\nVoer het nummer in van de film/serie die je wilt selecteren:");
                int mediaIndex = inputChoice.nextInt() - 1;
                System.out.println(mediaArrayList.get(mediaIndex).getNaam());
                System.out.println("\nKies wat je wilt doen met de gekozen film" +
                        "\n1. ⭐ Geef een rating" +
                        "\n2. Weergeef de beschrijving" +
                        "\n3. App afsluiten"
                        );
                int userChoice = inputChoice.nextInt();
                System.out.println("");
                switch(userChoice){
                    case(1):
                        Scanner floatScanner = new Scanner(System.in);
                        imdb.weergevenMedia(mediaArrayList.get(mediaIndex));
                        System.out.println("\nWelke rating geef je deze " +
                                mediaArrayList.get(mediaIndex).getType() + "?");
                        float userRating = floatScanner.nextFloat();
                        imdb.ratingGevenEnPrint(mediaArrayList.get(mediaIndex), userRating);
                }
            } else if (nummer == 2) {
                System.out.println("Waar wil je op filteren?");
                System.out.println("1. \uD83C\uDFAC Film\n" +
                        "2. \uD83D\uDDC3 Serie \n" +
                        "3. ⭐ Genre");
                int keuze = inputChoice.nextInt();

                switch (keuze) {
                    case (1):
                        imdb.filterenMedia(mediaArrayList, keuze, GenreType.DRAMA);
                        break;
                    case (2):
                        imdb.filterenMedia(mediaArrayList, keuze, GenreType.COMEDY);
                        break;
                    case (3):
                        System.out.println("Kies een genre om op te filteren:");
                        int index = 1;
                        for (GenreType value : GenreType.values()) {
                            System.out.println(index + ": " + value);
                            index++;
                        }
                        int genreKeuze = inputChoice.nextInt() - 1;
                        imdb.filterenMedia(mediaArrayList, 3, GenreType.values()[genreKeuze]);
                }
            } else if (nummer == 3) {
                runProgram = false;
            } else {
                System.out.println("Ongeldige invoer");
            }
        }
    }
}