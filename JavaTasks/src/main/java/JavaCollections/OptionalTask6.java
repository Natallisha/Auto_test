package JavaCollections;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OptionalTask6 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("src/main/java/JavaCollections/fileForOptionalTask");
        Scanner scanner = new Scanner(fileReader);
        List<String> song = new ArrayList<>();
        while (scanner.hasNextLine()){
            song.add(scanner.nextLine());
        }
        fileReader.close();
        Collections.sort(song, (o1, o2)-> o1.compareTo(o2));
        System.out.println(song);
    }
}
