package jp;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World! Ceci est mon projet Maven" );
        App appobj =  new App();
        int maxvalue = appobj.max(4,5);
        
        
        System.out.println( "Le max est : "+ maxvalue);
        
    }
    
    public int max(int a, int b) {
    	//return a > b ? a : b; 
    	return a; // Le stagiaire est passe par la
    }
}
