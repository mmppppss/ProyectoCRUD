package proyectocrud;

import DB.APIDB;
import DB.Database;

public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        APIDB api = new APIDB();
        //System.out.println(api.hashMD5("222106867mps"));
        //api.login("mmppppss", "222106867mps");
        new Gui(api).setVisible(true);
        
    }
    
}
