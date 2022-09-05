package Relations;
// 208968560 Dan Saada

/**
 * @author Dan Saada
 * @version ass7
 * @since 2022/06/07
 */

import Database.HypernymDatabase;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * WhichIS is a relation which connects between two NP.
 * The form: NP which is NP...
 * Note that WhichIs is a special relation because the hyponym appearance comes before the hypernym.
 * For example: "The US which is a country."
 */
public class WhichIs extends NPsRelationsFactory {
    private static final String NP = "<np>[^<]*+</np>";

    @Override
    public String getString() {
        return "which is";
    }

    @Override
    public Pattern getRegex() {
        return Pattern.compile(NP + "( ,)? " + getString()
                + " ((an example |a kind |a class )?of )?" + NP);
    }

    @Override
    public void addToDataBase(String string, HypernymDatabase database) {
        //create a np Pattern object.
        Pattern npPattern = Pattern.compile("<np>(.*?)</np>");
        //create a np Matcher object with given string.
        Matcher npMatcher = npPattern.matcher(string);

        try {
            String hyponym = null;
            //extract the first np Matcher which is the hyponym.
            if (npMatcher.find()) {
                hyponym = npMatcher.group(1);
            }
            String hypernym = null;
            //extract the second np Matcher which is the hypernym.
            if (npMatcher.find()) {
                hypernym = npMatcher.group(1);
            }
            //Add the relation to the database.
            database.addRelations(hypernym, hyponym);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
