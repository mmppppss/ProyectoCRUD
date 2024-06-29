package DB;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mmppppss
 */
public class APIDB {
    private Database DB;

    public APIDB() {
        DB = new Database();
        DB.Connect();
    }
    
    public boolean login(String username, String passwd){
        String query = "SELECT \"hashPasswd\" FROM users where username=?;";
        ResultSet res = DB.query(query, new String[]{username});
        try {
            res.next();
            return res.getString("hashPasswd").equals(hashMD5(passwd));
        } catch (SQLException ex) {
            System.out.println("Error al logearse");
            Logger.getLogger(APIDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public String[][] getArts(){
        String[][] Result=new String[10][4];
        String title, content, date, author;
        String query = "SELECT a.*, u.username from \"Article\" a, users u where u.\"ID\" = a.\"ID_Author\";";
        ResultSet res = DB.query(query);
        try {
            for(int i=0; res.next(); i++){
                title = res.getString("title");
                content = res.getString("content");
                date = res.getString("date");
                author = res.getString("username");
                String[] tupla={title, content, date, author};
                Result[i]=tupla;
            }
        } catch (SQLException ex) {
            Logger.getLogger(APIDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Result;
    }
    
    public String hashMD5(String input){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
