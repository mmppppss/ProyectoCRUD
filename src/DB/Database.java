package DB;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mmppppss
 */
public class Database {

    private final String host = "motty.db.elephantsql.com",
            db="vamigkmd",
            username="vamigkmd",
            passwd="W5pyEwXY_0CdfIJb-Y-nqr1Tw3w_zEbK",
            url="jdbc:postgresql://"+host+"/"+db;
    private Connection con=null;
    public Database() {
        System.out.println("DB Inicializada");
    }

    public Connection getCon() {
        return con;
    }
    public void Connect(){
        try { 
            Class.forName("org.postgresql.Driver");
            try {
                System.out.println("Intentando conectar a la db");
                con = DriverManager.getConnection(url, username, passwd);
                System.out.println("CONECTADO");
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
        }
    }
    public ResultSet query(String sqlQuery){
        return query(sqlQuery, new String[]{});
    } 
    public ResultSet query(String sqlQuery, String[] args){ 
        try {
            PreparedStatement stmt  = con.prepareStatement(sqlQuery);
            for (int i = 0; i < args.length; i++) {
                System.out.println("Parsing: "+i+" "+args[i]);
                stmt.setString(i+1, args[i]);
            }
            //System.out.println(stmt.toString());
            ResultSet rs = stmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            System.err.println("[ERROR Database]"+ex.getMessage()+" "+ex.getErrorCode());
            return null;
            //Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
