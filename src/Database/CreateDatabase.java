package Database;

/**
 * @author Dan Saada
 * @version ass7
 * @since 2022/06/07
 */

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.File;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * A class used to create a database file to the giving address from the given database.
 */
public class CreateDatabase {

    /**
     * Creates a text file of the given data base at the given address.
     * For every hypernym with more than 3 hyponym, prints the hypernym in a lexicographic order
     * and than the hyponym in decreasing order that is determined by the number of times the hyponyms
     * appear in the context of the hypernym.
     *
     * @param address  - address which the file will be created at.
     * @param database - the data base that will be printed on the file.
     * @throws IOException - in case of problem when creating file.
     */
    public static void createFile(String address, HypernymDatabase database) throws IOException {
        File file = new File(address + "\\hypernym_db.txt");
        TreeMap<String, TreeMap<String, Integer>> map = database.getMap();
        PrintWriter out = null;
        boolean isFirst = true;

        try {
            out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file)));
            //For every hypernym with more than 3 hyponym, prints it to the file.
            for (String hyper : map.keySet()) {
                if (database.numOfHypernyms(hyper) > 2) {
                    out.print(hyper + ":");

                    LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();

                    //Sort the map in decreasing order.
                    map.get(hyper).entrySet().stream().sorted(Map.Entry.comparingByValue(
                            Comparator.reverseOrder())).forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

                    //Prints the sorted hyponyms.
                    isFirst = true;
                    for (String hyponym : sortedMap.keySet()) {
                        if (!isFirst) {
                            out.print(",");
                        } else {
                            isFirst = false;
                        }
                        out.print(" " + hyponym + " (" + sortedMap.get(hyponym) + ")");
                    }
                    out.println();
                }
            }

        } catch (IOException e) {
            System.out.println("Something went wrong while writing!");
            e.printStackTrace();
        } finally {

            //Close the stream.
            if (out != null) {
                out.close();
            }
        }

    }
}

