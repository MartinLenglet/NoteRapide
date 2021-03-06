/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import bean.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ESIC
 */
public class UserDao {
    
    public static User getByLoginPass(String login, String mdp) throws SQLException {
        
        User result = null;
        
        String sql = "SELECT * FROM user WHERE mail=? AND mdp=?" ;
        
        Connection connect = testBd.getConnection();
        
        PreparedStatement requette = connect.prepareStatement(sql);
        requette.setString(1, login);
        requette.setString(2, mdp);

        ResultSet rs = requette.executeQuery();
        
        if (rs.next()){
            result = new User(rs.getString("nom"), rs.getString("prenom"), rs.getString("mail")) ;
            result.setId(rs.getInt("id"));
        }
        
        return result;
    }
    
        public static void inscription(String nom, String prenom, String mail, String mdp) throws SQLException {
        
        String sql = "INSERT INTO user (nom, prenom, mail, mdp) VALUES (?,?,?,?)";
        
        Connection connect = testBd.getConnection();
        
        PreparedStatement ordre = connect.prepareStatement(sql);
        ordre.setString(1, nom);
        ordre.setString(2, prenom);
        ordre.setString(3, mail);
        ordre.setString(4, mdp);

        ordre.execute();
     
    }
        
            
    public static List<User> getAllMember() throws SQLException {
        
        List<User> users = new ArrayList<User>();
        
        String sql = "SELECT u.nom, u.prenom, u.mail, u.id FROM user u";

        Connection connect = testBd.getConnection();
        
        Statement requete = connect.createStatement();
        ResultSet rs = requete.executeQuery(sql);
        
        while (rs.next()) {            
            User u = new User();
            u.setNom(rs.getString("nom"));
            u.setPrenom(rs.getString("prenom"));
            u.setMail(rs.getString("mail"));
            u.setId(rs.getInt("id"));
            
            users.add(u);
        }
        
        return users;
    }
    
    
}
