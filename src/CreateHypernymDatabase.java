// 208968560 Dan Saada

/**
 * @author Dan Saada
 * @version ass7
 * @since 2022/06/07
 */

import Database.CreateDatabase;
import Database.HypernymDatabase;
import Database.ReadCorpus;
import java.io.IOException;
import java.rmi.UnexpectedException;

/**
 * Read all the files in the directory, find and aggregate hypernym relations that match
 * the Hearst patterns using regular expressions, and save them in a txt file.
 */
public class CreateHypernymDatabase {
    /**
     * Main1 - create hypernym database file in the received path argument
     * with the corpus in the received argument path.
     * @param args - corpus path and destination path.
     * @throws IOException - in case of a problem with reading files.
     */
    public static void main(String[] args) throws IOException {
        //Must get corpus path and destination path.
        if (args.length != 2) {
            throw new UnexpectedException("Must get two args!");
        }

        HypernymDatabase database = new HypernymDatabase();
        //Get the data of the corpus.
        ReadCorpus.readFolder(args[0], database);
        //Create the database file.
        CreateDatabase.createFile(args[1], database);
    }
}
