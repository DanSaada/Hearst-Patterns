package Relations;

/**
 * @author Dan Saada
 * @version ass7
 * @since 2022/06/07
 */

import Database.HypernymDatabase;
import java.util.regex.Pattern;

/**
 * As is a relation which connects between two NP.
 * The form: NP as NP...
 * For example: "There where several industrial country who didn't except that ** as ** the US."
 */
public class As extends NPsRelationsFactory {
    @Override
    public String getString() {
        return "as";
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

