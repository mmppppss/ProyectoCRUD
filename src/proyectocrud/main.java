package proyectocrud;

import javax.swing.UIManager;

/**
 *
 * @author meli
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        UIManager.LookAndFeelInfo[] lafinfo = UIManager.getInstalledLookAndFeels();
        for (int i=0;i<lafinfo.length;i++){
            System.out.println(lafinfo[i].getClassName());
        }
    }
    
}
