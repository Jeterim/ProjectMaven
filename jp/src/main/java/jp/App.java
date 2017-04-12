package jp;

import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.*;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException
    {
        System.out.println( "Hello World! Ceci est mon projet Maven" );
        App appobj =  new App(); //Instanciation d'objet ou utlisation de static sur la méthode max'
        int maxvalue = appobj.max(4,5);
        
        
        System.out.println( "Le max est : "+ maxvalue);
        
        int monmax = 0;
        try{

            CSVReader reader = new CSVReader(new FileReader("data.csv")); 
            List<String[]> myEntries = reader.readAll();

            CSVWriter writer = new CSVWriter(new FileWriter("data-filtered.csv"));

            for(String[] entryL : myEntries) {
                List<String> list = Arrays.asList(entryL);

                Vector<String> out = new Vector<String>();
                CollectionUtils.select(list, new Predicate() {
                    @Override
                    public boolean evaluate(Object object) {
                        return Integer.parseInt((String) object) < 50;
                    }
                }, out);
                System.out.println("OUT:" + out);

                writer.writeNext(out.toArray(new String[0]), false);

                for (int i=0; i < out.size(); i++) {
                    int nbread = Integer.parseInt(out.get(i));
                    monmax = appobj.max(monmax, nbread);
                    System.out.println("Nombre lu : " + nbread);
                }

            }
            writer.close();
            System.out.println("Nombre max : " + monmax);
        }
        catch(IOException e){
            System.out.println("Probleme de lecture du fichier csv");
        }
        
    }
    
    public int max(int a, int b) {
    	return a > b ? a : b; 
    	//return a; // Le stagiaire est passe par la
    }
}
