package DB;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mmppppss
 */
public class APIDB {
    private Database DB;
    private Object[] user={"null", false, 0};
    public APIDB() {
        DB = new Database();
        DB.Connect();
    }

    public Object[] getUser() {
        return user;
    }
    
    public boolean login(String username, String passwd){
        String query = "SELECT hash_passwd, admin, id FROM users where username=?;";
        ResultSet res = DB.query(query, new String[]{username});
        try {
            if(res.next()){
                if(res.getString("hash_passwd").equals(hashMD5(passwd))){
                    this.user[0] = username;
                    this.user[1] = res.getBoolean("admin");
                    this.user[2] = res.getInt("id");
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error al logearse");
            Logger.getLogger(APIDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public void createUser(String username, String passwd){
        String hashpasswd= hashMD5(passwd);
        String query = "INSERT INTO users(username, hash_passwd) values(?, ?)";
        DB.query(query, new String[]{username, hashpasswd});
        
    }
    
    public String[][] getArts(){
        String[][] Result=new String[100][7];
        String id, title,  author, views, category, content,date;
        //String query = "SELECT a.*, u.username, v.count, c.name from article a JOIN users u ON u.id = a.id_author LEFT JOIN views v ON v.id_art = a.id LEFT JOIN categories c ON c.id = a.id";
        String query = "SELECT a.id, a.title, a.content, a.date, u.username AS author, v.count,c.name FROM article a, users u, views v, categories c WHERE  u.id = a.id_author AND c.id = a.id_category AND v.id_art = a.id;";
        ResultSet res = DB.query(query);
        try {
            for(int i=0; res.next(); i++){
                id = res.getString("id");
                title = res.getString("title");
                content = res.getString("content");
                date = res.getString("date");
                author = res.getString("author");
                views = res.getString("count");
                category = res.getString("name");
                String[] tupla={id, title, content, date, author, views, category};
                Result[i]=tupla;
            }
        } catch (SQLException ex) {
            Logger.getLogger(APIDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Result;
    }
    public String[] read(String idART){
        String id, title, content, date, author, category;
        String query = "SELECT art.*, author.username, categories.name from article art, users author, categories where author.id = art.id_author and categories.id = art.id_category and art.id="+idART;
        String query2 = "UPDATE views SET count = count + 1 WHERE id_art ="+idART;
        DB.query(query2);
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
    public String[][] getComments(String idART){
        String [][] comments = new String[100][2] ;
        String query = "SELECT username, message from users, comment WHERE id_user = id and id_art = CAST(? AS int) LIMIT 10;";
        ResultSet res = DB.query(query, new String[]{idART});
        try {
            for (int i = 0; res.next(); i++) {
                comments[i]=new String[]{res.getString(1), res.getString(2)};
            }
            return comments;
        } catch (SQLException ex) {
            Logger.getLogger(APIDB.class.getName()).log(Level.SEVERE, null, ex);
            comments[0]= new String[]{"anom", "no hay comentarios"};
            return comments;
        }
    }
    public void delete(String idART){
        String query = "DELETE from article where id="+idART;
        DB.query(query);
    }
    public void create(String[] args){
        String query="INSERT INTO article (title, content, date, id_author, id_category) VALUES(?,?,'now()', CAST(? AS int), CAST(? AS int));";
        DB.query(query, args);
        ResultSet a=DB.query("SELECT id from article order by id desc limit 1");
        try {
            a.next();
            String id=a.getString("id");
            String query3="INSERT INTO views (id_art, count) VALUES ("+id+", 0);";
            DB.query(query3);
        } catch (SQLException ex) {
            Logger.getLogger(APIDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void update(String[] args, String id){
        String query="UPDATE article SET title=?, content=?, date='now()', id_author=CAST(? AS int), id_category=CAST(? AS int) WHERE id="+id;
        DB.query(query,args);
    }
    public String[] stats(){
        String query = "SELECT (SELECT sum(count) FROM views) AS total_views, (SELECT count(*) FROM comment) AS total_comments, (SELECT count(*) FROM article) AS total_arts";
        ResultSet res = DB.query(query);
        try {
            res.next();
            return new String[]{res.getString("total_views"), res.getString("total_comments"), res.getString("total_arts")};
        } catch (SQLException ex) {
            Logger.getLogger(APIDB.class.getName()).log(Level.SEVERE, null, ex);
            return new String[]{"0"};
        }
    }
    public void comment(String message, String idArt){
        String query="INSERT INTO comment values(CAST(? AS int),CAST(? AS int), ?)";
        DB.query(query, new String[]{idArt, ""+user[2], message});
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
