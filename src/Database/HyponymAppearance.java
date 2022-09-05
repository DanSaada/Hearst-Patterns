package Database;
// 208968560 Dan Saada

/**
 * @author Dan Saada
 * @version ass7
 * @since 2022/06/07
 */

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * HyponymAppearance gets a hyponym and a database and prints the hyponym's hypernyms and the number
 * of appearances in each of them.
 */
public class HyponymAppearance {

    /**
     * gets a hyponym and a database and prints the hyponym's hypernyms and the number
     * of appearances in each of them.
     * @param hyponym - the hyponym we want to get it's hypernyms.
     * @param database - the database of the hypernyms and hyponyms.
     */
    public static void findAppearances(String hyponym, HypernymDatabase database) {
        //In case the hyponym doesn't exist.
        if (!database.isHyponymExist(hyponym)) {
            System.out.println("The lemma doesn't appear in the corpus.");
        }

        TreeMap<String, Integer> map = new TreeMap<>();

        //Put all the hyponym's hypernyms in a map with it's number of appearances.
        for (String hyper:database.getMap().keySet()) {
            if (database.getMap().get(hyper).containsKey(hyponym)) {
                map.put(hyper, database.getMap().get(hyper).get(hyponym));
            }
        }
        printAppearancesByOrder(map);
    }

    /**
     * Prints the map in descending order by values.
     * @param map - the map we want to print.
     */
    private static void printAppearancesByOrder(TreeMap<String, Integer> map) {
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        //Sort in descending order by value.
        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEachOrdered(
                x -> sortedMap.put(x.getKey(), x.getValue()));

        //Prints the map.
        for (String hyper:sortedMap.keySet()) {
            System.out.println(hyper + ": (" + map.get(hyper) + ")");
        }
    }
}
