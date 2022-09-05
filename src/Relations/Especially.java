package Relations;
// 208968560 Dan Saada

/**
 * @author Dan Saada
 * @version ass7
 * @since 2022/06/07
 */

import Database.HypernymDatabase;
import java.util.regex.Pattern;

/**
 * Especially is a relation which connects between two NP.
 * The form: NP especially NP...
 * For example: "There where several industrial country who didn't except that ** especially ** the US."
 */
public class Especially extends NPsRelationsFactory {
    @Override
    public String getString() {
        return "especially";
    }

    @Override
    public Pattern getRegex() {
        return super.getRegex();
    }

    @Override
    public void addToDataBase(String string, HypernymDatabase database) {
        super.addToDataBase(string, database);
    }
}
