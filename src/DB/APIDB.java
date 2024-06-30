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
    private Object[] user={"null", false};
    public APIDB() {
        DB = new Database();
        DB.Connect();
    }

    public Object[] getUser() {
        return user;
    }
    
    public boolean login(String username, String passwd){
        String query = "SELECT \"hashPasswd\", admin FROM users where username=?;";
        ResultSet res = DB.query(query, new String[]{username});
        try {
            res.next();
            if(res.getString("hashPasswd").equals(hashMD5(passwd))){
               this.user[0] = username;
               this.user[1] = res.getBoolean("admin");
               return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al logearse");
            Logger.getLogger(APIDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public String[][] getArts(){
        String[][] Result=new String[10][4];
        String id, title, content, date, author;
        String query = "SELECT a.*, u.username from \"Article\" a, users u where u.\"ID\" = a.\"ID_Author\";";
        ResultSet res = DB.query(query);
        try {
            for(int i=0; res.next(); i++){
                id = res.getString("id");
                title = res.getString("title");
                content = res.getString("content");
                date = res.getString("date");
                author = res.getString("username");
                String[] tupla={id, title, content, date, author};
                Result[i]=tupla;
            }
        } catch (SQLException ex) {
            Logger.getLogger(APIDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Result;
    }
    public String[] read(String idART){
        String id, title, content, date, author, category;
        String query = "SELECT art.*, author.username, categories.name from \"Article\" art, users author, categories where author.\"ID\" = art.\"ID_Author\" and categories.id = art.\"ID_category\" and art.\"ID\"="+idART;
        ResultSet res = DB.query(query);
        try {
            res.next();
            id = res.getString("id");
            title = res.getString("title");
            content = res.getString("content");
            date = res.getString("date");
            author = res.getString("username");
            category =  res.getString("name");
            String[] tupla={id, title, content, date, author, category};
            return tupla;
        } catch (SQLException ex) {
            String[] tupla={"-1", "NOT FOUND", "El articulo no existe", "00-00-00", "null"};
            return tupla;
        }
        
    }
    public void delete(String idART){
        String query = "DELETE from \"Article\" where \"ID\"="+idART;
        DB.query(query);
    }
    public void create(String[] args){
        String query="INSERT INTO \"Article\" (title, content, date, \"ID_Author\", \"ID_category\") VALUES(?,?,'now()', CAST(? AS int), CAST(? AS int));";
        DB.query(query, args);
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
