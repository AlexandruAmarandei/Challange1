
package spacecadetsChallange1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.*;


/**
 *
 * @author aas1u16
 */
public class SpaceCadetsChallange1 {

    public static void main(String[] args) throws IOException {
        
        
        BufferedReader reader = null;
        reader = new BufferedReader ( new InputStreamReader(System.in));
       //input ID
        System.out.print("Enter a valid ID:");
        String email_id = reader.readLine();
        
        String web_page = "http://www.ecs.soton.ac.uk/people/";
        //string concatenation
        String web_complete;
        web_complete = web_page.concat(email_id);
        
        
        URL myURL = new URL( web_complete);
        boolean verification_tel = false; //booleans to check if the name 
        boolean verification_name = false;// and telephone was found
        BufferedReader reader_url = new BufferedReader ( new InputStreamReader (myURL.openStream()));
        
        
        String input;
        String name;
        String look_for_name = "property=\"name\">";
        String look_for_tel = "property='telephone'>";
        
        while ((input = reader_url.readLine()) != null && (verification_name == false || verification_tel == false)){
            
            int index = input.indexOf(look_for_name);
            int index_tel = input.indexOf(look_for_tel);
            
            
            if(index != -1 && verification_name ==false){
                verification_name = true;
                name = input.substring( index + look_for_name.length());
                name = name.substring( 0, name.indexOf("<"));
                System.out.println( name );
            
            }
            
            if(index_tel != -1 && verification_tel == false){
                verification_tel = true;
                name = input.substring(index_tel+look_for_tel.length());
                name = name.substring(0, name.indexOf("<"));
                System.out.println( name );
            }
        }
        
        if(verification_name == false) System.out.print("Invalid ID.");
        reader_url.close();
        
        
        
    }
    
}
