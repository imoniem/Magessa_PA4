import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

    public class DuplicateCounter
    {
        private Map <String, Integer> counter;
        public DuplicateCounter()
        {
            this.counter = new HashMap<String, Integer>();
        }
        public void count(String dataFile)  throws FileNotFoundException
        {
            Scanner readLine = new Scanner(new File(dataFile));
            while (readLine.hasNext())
            {
                String line = readLine.next();
                Integer wordCounter = counter.get(line);
                if (wordCounter == null)
                {
                    wordCounter = 1;
                }
                else
                {
                    wordCounter = wordCounter + 1;
                }
                counter.put(line, wordCounter);
            }
            readLine.close();
        }
        public void write(String outputFile) throws IOException
        {
            try
            {
                FileWriter fw=new FileWriter(new File(outputFile));
                for(Entry<String, Integer> entry : counter.entrySet())
                     {
                         fw.write(entry.getKey() + " = " + entry.getValue()+"\n");
                     }
                fw.close();
                System.out.println("Check File");
            }
            catch (IOException ex) {
                System.out.println("Error");
            }
        }
    }