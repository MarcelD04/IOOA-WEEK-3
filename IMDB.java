import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class IMDB {
    public void weergevenMedia(Media media){
            System.out.println(
                    "Titel: " + media.getNaam() +
                            "\nType: " + media.getType() +
                            "\nGenre: " + media.getGenre() +
                            "\nRating: " + media.getRating()
            );
            if (media.getEpisodes() != 0) {
                System.out.println("Afleveringen: " + media.getEpisodes());
            }
    }

    public void filterenMedia(ArrayList<Media> mediaLijst, int keuze, GenreType genre){
        int index = 1;
        for (Media media : mediaLijst) {
            if(keuze == 1 && media.getType() == MediaType.values()[0]) {
                System.out.println("-------------------------\n" +
                        "Nummer: " + index);
                weergevenMedia(media);
                index++;
            }
            if(keuze == 2 && media.getType() == MediaType.values()[1]) {
                System.out.println("-------------------------\n" +
                        "Nummer: " + index);
                weergevenMedia(media);
                index++;
            }
            if(keuze == 3 && media.getGenre() == genre) {
                System.out.println("-------------------------\n" +
                        "Nummer: " + index);
                weergevenMedia(media);
                index++;
            }
        }
    }

    public void ratingGevenEnPrint(Media media, float userRating){
        media.setRating((float) ((media.getRating() * media.getRatingCount() + userRating) / media.getRatingCount() + 1));
        System.out.print("De nieuwe rating van de " + media.getType());
        System.out.printf(" is %.1f", media.getRating());
        System.out.print("\n");
    }

    public void opvragenBeschrijving(Media media) {
        System.out.println(media.getBeschrijving());
    }

    public void mediaToevoegen(Media media){
    }

    public void mediaVewijderen(Media media){
    }
}
