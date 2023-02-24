import java.io.File;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class MediaReader {

    public ArrayList<Media> leesBestandUit() {
        File text = new File("C:\\Users\\marce\\IdeaProjects\\Week 3 imdb\\src\\films.txt");
        ArrayList<Media> mediaArrayList = new ArrayList<Media>();

        try{
            Scanner scanner = new Scanner(text);

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] lineSplit = line.split("~");
                Media media = new Media(lineSplit[0], MediaType.valueOf(lineSplit[1].toUpperCase()),
                        GenreType.valueOf(lineSplit[2].toUpperCase()), Float.parseFloat(lineSplit[3]),
                        Integer.parseInt(lineSplit[4]), Integer.parseInt(lineSplit[5]), lineSplit[6]);
                mediaArrayList.add(media);
            }

        } catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
        return mediaArrayList;

    }

}
