package proyectocrud;

import DB.APIDB;
import DB.Database;

public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        APIDB api = new APIDB();
        new Gui(api).setVisible(true);
        
    }
    
}
