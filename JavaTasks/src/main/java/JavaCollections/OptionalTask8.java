package JavaCollections;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class OptionalTask8 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("src/main/java/JavaCollections/fileForOptionalTask8");
        Scanner scanner = new Scanner(fileReader);
        HashSet<String> uniqueWords = new HashSet<>();
        while (scanner.hasNextLine()){
            uniqueWords.add(scanner.nextLine().toUpperCase(Locale.ROOT));
        }
        fileReader.close();

        Iterator<String> i = uniqueWords.iterator();
        while(i.hasNext())
            System.out.println(i.next());
    }
}
