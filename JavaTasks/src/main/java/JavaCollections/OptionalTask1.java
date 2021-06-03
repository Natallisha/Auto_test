//1.   Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.

package JavaCollections;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OptionalTask1 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("src/main/java/JavaCollections/fileForOptionalTask");
        Scanner scanner = new Scanner(fileReader);
        List<String> song = new ArrayList<>();

        while (scanner.hasNextLine()){
            song.add(scanner.nextLine());
        }
        fileReader.close();

        FileWriter fileWriter = new FileWriter("src/main/java/JavaCollections/fileForOptionalTask");
        for (int i = song.size() -1; i>=0; i--){
            fileWriter.write(song.get(i)+ "\n");
        }
        fileWriter.close();
    }

}
