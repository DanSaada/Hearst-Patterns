// 208968560 Dan Saada

/**
 * @author Dan Saada
 * @version ass7
 * @since 2022/06/07
 */

import Database.HypernymDatabase;
import Database.HyponymAppearance;
import Database.ReadCorpus;
import java.io.IOException;
import java.rmi.UnexpectedException;

/**
 * Search all the possible hypernyms of the input lemma and print them to the console.
 */
public class DiscoverHypernym {

    /**
     * Main2 - gets a corpus path and a lemma and prints the lemma's hypernyms in the corpus with the
     * number of relation between them for each hypernym.
     *
     * @param args - corpus path and a lemma.
     * @throws IOException - in case of a problem with reading files.
     */
    public static void main(String[] args) throws IOException {
        //Must get corpus path and a lemma.
        if (args.length < 2) {
            throw new UnexpectedException("Must get at least two args!");
        }

        String lemma = args[1];

        //In case the lemma is a few words lemma.
        if (args.length > 2) {
            for (int i = 2; i < args.length; i++) {
                lemma = lemma + " " + args[i];
            }
        }

        HypernymDatabase database = new HypernymDatabase();
        //Get the data of the corpus.
        ReadCorpus.readFolder(args[0], database);
        //Prints the lemma's hypernyms and num of relation appearances of the with the received hyponym.
        HyponymAppearance.findAppearances(lemma, database);
    }
}
