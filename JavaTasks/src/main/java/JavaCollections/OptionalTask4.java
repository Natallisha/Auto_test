//The bells of spring are ringing,
//
//        Are ringing loud and gay.
//
//          To hills and forests they are bringing
//
//                Sweet melody today.
//
//        The bells of spring are ringing,
//
//        Are ringing far and wide.
//
//        Nice days they are bringing
//
//        To people and the countryside.

package JavaCollections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OptionalTask4 {
    private static final String POEM = "The bells of spring are ringing,\n" +
            "Are ringing loud and gay.\n" +
            "To hills and forests they are bringing\n" +
            "Sweet melody today.\n" +
            "The bells of spring are ringing,\n" +
            "Are ringing far and wide.\n" +
            "Nice days they are bringing\n" +
            "To people and the countryside.";

    public static void main(String[] args) {

        List<String> poem = Arrays.asList(POEM.split("\n"));
        Collections.sort(poem, (o1, o2) -> o1.length() - o2.length());
        System.out.println(poem);
    }
}
