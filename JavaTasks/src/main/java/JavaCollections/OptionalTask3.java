package JavaCollections;

import javax.xml.catalog.Catalog;
import java.io.File;
import java.io.FilenameFilter;
import java.util.*;

public class OptionalTask3 {

    public void listFiles(String starDir){
        File dir = new File(starDir);
        File[] files = dir.listFiles();

        if (files != null && files.length > 0){
            for (File file:files){
                if (file.isDirectory()){
                    listFiles(file.getAbsolutePath());
                } else{
                    System.out.println(file.getName());
                }
            }
        }

    }
    public static void main(String[] args) {
        OptionalTask3 optionalTask3 = new OptionalTask3();
        String file = ("C:/data");
        optionalTask3.listFiles(file);
    }
}
