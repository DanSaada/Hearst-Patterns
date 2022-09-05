package Database;

/**
 * @author Dan Saada
 * @version ass7
 * @since 2022/06/07
 */

import Relations.Relation;
import Relations.SuchAs;
import Relations.Including;
import Relations.Especially;
import Relations.As;
import Relations.WhichIs;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.regex.Matcher;

/**
 * ReadCorpus create HypernymDatabase database from the files in the revived address.
 */
public class ReadCorpus {
    /**
     * Read the files from the received path address and store the hypernym-hyponym relations in
     * the received database.
     *
     * @param address  - address of folder with files to be read.
     * @param database - the database which we want to store.
     * @throws IOException - in case the files reading didn't work.
     */
    public static void readFolder(String address, HypernymDatabase database) throws IOException {
        File folder = new File(address);
        //get a list of files in the directory.
        File[] folderFiles = folder.listFiles();
        //read each file in the folder
        if (folderFiles != null) {
            for (File file : folderFiles) {
                readFile(file, database);
            }
        }
    }

    /**
     * Read received file and store the hypernym-hyponym relations in the received HypernymDatabase database.
     *
     * @param file     - the file with the sentences that contains hypernym-hyponym relations.
     * @param database - the database to store the data in.
     * @throws IOException - in case of problem at reading file.
     */
    private static void readFile(File file, HypernymDatabase database) throws IOException {
        //create an array of all the relations.
        Relation[] relations = {new SuchAs(), new As(), new Including(), new Especially(), new WhichIs()};
        BufferedReader in = null;

        in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line;
        try {
            while ((line = in.readLine()) != null) {
                if (!(line.contains("which is") || line.contains("such")
                        || line.contains("including") || line.contains("especially"))) {
                    continue;
                }
                //Check for each relation if it appears in the lines of the file and add to database accordingly.
                for (Relation relation : relations) {
                    Matcher matcher = relation.getRegex().matcher(line);
                    //As long the relation appears on the line, add it to the database.
                    while (matcher.find()) {
                        relation.addToDataBase(matcher.group(), database);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Something went wrong while reading!");
            e.printStackTrace();
        }
    }

}

