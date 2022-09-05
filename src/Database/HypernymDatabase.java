package Database;

/**
 * @author Dan Saada
 * @version ass7
 * @since 2022/06/07
 */

import java.util.TreeMap;

/**
 * Database.HypernymDatabase is a map containing all hypernyms with their hyponyms and counters.
 */
public class HypernymDatabase {
    private TreeMap<String, TreeMap<String, Integer>> map;

    /**
     * Constructor.
     * <p>
     * CASE_INSENSITIVE_ORDER - A Comparator that orders String objects as by compareToIgnoreCase,
     * meaning it makes no difference while comparing between uppercase and lowercase letters.
     * </p>
     */
    public HypernymDatabase() {
        this.map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    }

    /**
     * Return the map of the database.
     *
     * @return the map of the database.
     */
    public TreeMap<String, TreeMap<String, Integer>> getMap() {
        return this.map;
    }

    /**
     * Adds a relation to the map.
     * <p>
     * The method adds the received hyponym to the received hypernym's relation, and
     * add one to the counter of that relation.
     * If the current hypernym doesn't exist in the map the method creates a new
     * hypernym in the map and add the relation similarly to what is described above.
     * </p>
     *
     * @param hypernym - the hypernym of the relation.
     * @param hyponym  - the hyponym of the relation.
     */
    public void addRelations(String hypernym, String hyponym) {
        hypernym = hypernym.toLowerCase();
        hyponym = hyponym.toLowerCase();
        //The current hypernym doesn't exist in the map.
        if (!this.map.containsKey(hypernym)) {
            TreeMap<String, Integer> map = new TreeMap<>();
            map.put(hyponym, 1);
            this.map.put(hypernym, map);
            return;
        }
        //The current hypernym & hyponym are already related.
        if (this.map.get(hypernym).containsKey(hyponym)) {
            int current = this.map.get(hypernym).get(hyponym);
            this.map.get(hypernym).put(hyponym, current + 1);
        } else {
            this.map.get(hypernym).put(hyponym, 1);
        }
    }

    /**
     * Returns the number of hyponyms the received hypernym has.
     *
     * @param hypernym - the hypernym we want to know how much hyponyms he has.
     * @return the number of hyponyms the received hypernym has. if it dosent exist in the database,
     * returns -1.
     */
    public int numOfHypernyms(String hypernym) {
        if (this.map.containsKey(hypernym)) {
            return this.map.get(hypernym).size();
        }
        return -1;
    }


    /**
     * Returns true if the received hyponym exist in the database.
     *
     * @param hyponym - the hyponym we want to know if exist.
     * @return true if the hyponym exist in the database and false otherwise.
     */
    public boolean isHyponymExist(String hyponym) {
        for (String hyper : this.map.keySet()) {
            for (String currentHyponym : this.map.get(hyper).keySet()) {
                if (currentHyponym.equals(hyponym)) {
                    return true;
                }
            }
        }
        return false;
    }
}
