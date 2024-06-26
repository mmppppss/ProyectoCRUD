package proyectocrud;

import DB.APIDB;
import DB.Database;

public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Gui().setVisible(true);
        APIDB a = new APIDB();
        a.login("mmppppss", "222106867mps");
        for (String[] b: a.getArts()) {
            if(b.toString().equals(null))
                break;
            for (String string : b) {
                if(string==null)
                    break;
                System.out.print(string+" ");
                
            }
            System.out.println();
        }
    }
    
}
