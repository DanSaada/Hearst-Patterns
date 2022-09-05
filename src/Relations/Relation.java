package Relations;
// 208968560 Dan Saada

/**
 * @author Dan Saada
 * @version ass7
 * @since 2022/06/07
 */

import java.util.regex.Pattern;
import Database.HypernymDatabase;

/**
 * This interface describes the relation between a hypernym and its hyponym.
 */
public interface Relation {

    /**
     * Getter for the string of the relation.
     * @return the string of the relation.
     */
    String getString();

    /**
     * Getter for the regex of the relation.
     * @return the regex of the relation.
     */
    Pattern getRegex();

    /**
     * This method receives a string of a sentence that contains a relation, extract the
     * relation from it and adds it to the received database.
     * @param string - sentence that contain the relation.
     * @param database - database to add the relation to.
     */
    void addToDataBase(String string, HypernymDatabase database);
}
