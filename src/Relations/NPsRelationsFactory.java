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
 * Creates relations using the Factory pattern.
 */
public abstract class NPsRelationsFactory implements Relation {
    private static final String NP = "<np>[^<]*+</np>";


    @Override
    public Pattern getRegex() {
        return Pattern.compile(NP + " ?,? " + this.getString() + " "
                + NP + "( (,? ?" + NP + " ?)*,? ?(or|and)? ?" + NP + ")?");
    }

    @Override
    public void addToDataBase(String string, HypernymDatabase database) {
        //create a np Pattern object.
        Pattern npPattern = Pattern.compile("<np>([^<]*+)</np>");
        //create a np Matcher object with given string.
        Matcher npMatcher = npPattern.matcher(string);

        try {
            String hypernym = null;
            //extract the first np Matcher which is the hypernym.
            if (npMatcher.find()) {
                hypernym = npMatcher.group(1);
            }

            //create a Pattern with everything which is not the np hypernym.
            Pattern hyperPattern = Pattern.compile("^(<np>" + hypernym + "</np>)");
            Matcher hyperMatcher = hyperPattern.matcher(string);
            //remove hypernym from the string.
            String hyponyms = null;
            if (hyperMatcher.find()) {
                hyponyms = hyperMatcher.group(1);
            }

            //while there are matches of the np Matcher (doesn't include the hypernym):
            //add a relation between all the hyponyms from the string with their hypernym.
            while (npMatcher.find()) {
                String currentMatch = new String(npMatcher.group(1));
                database.addRelations(hypernym, currentMatch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
