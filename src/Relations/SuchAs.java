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
 * SuchAs is a relation which connects between two NP.
 * The form: NP such as NP...
 * For example: "There where several industrial country who didn't except that ** such as ** the US."
 */
public class SuchAs extends NPsRelationsFactory {
    @Override
    public String getString() {
        return "such as";
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
