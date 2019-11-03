import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.lang.String;

public class DuplicateRemover
{
    private Set <String> uniqueWords;
    public void remove(String dataFile) throws FileNotFoundException
    {
        String word;
        uniqueWords = new HashSet<String> ();
        Scanner scnr=new Scanner(new File(dataFile));
        while(scnr.hasNext())
        {
            word=scnr.next();
            uniqueWords.add(word);
        }
        scnr.close();
    }
    public void write(String outputFile) throws IOException
    {
        try {
            File f;
            FileWriter fw = null;
            f = new File(outputFile);
            if (f.exists()) {
                fw = new FileWriter(f, true);
                Iterator unq = uniqueWords.iterator();
                while (unq.hasNext()) {
                    String str = (String) unq.next();
                    fw.write(str + "\n");
                }
                fw.close();
                System.out.println("Check File");
            } else {
                f.createNewFile();
                fw = new FileWriter(f);
                Iterator itr = uniqueWords.iterator();
                while (itr.hasNext()) {
                    String str = (String) itr.next();
                    fw.write(str + "\n");
                }
                fw.close();
                System.out.println("Check File");
            }
        }
        catch (IOException ex) {
            System.out.println("Error");
        }
    }
}

