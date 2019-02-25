/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Note;
import bean.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ESIC
 */
public class NoteDao {
    
    public static void insert(Note note) throws SQLException{
        String sql = "INSERT INTO note(contenu, auteur_id, destinataire_id) VALUES(?, ?, ?)";
        Connection connexion = testBd.getConnection();
        PreparedStatement ordre = connexion.prepareStatement(sql);
        ordre.setString(1, note.getContenu());
        ordre.setInt(2, note.getAuteur().getId());
        ordre.setInt(3, note.getDestinataire().getId());
        ordre.execute();
    }
    
    public static List<Note> getAllNote() throws SQLException{
        List<Note> notes = new ArrayList<Note>();
        Connection connexion = testBd.getConnection();
        String sql = "SELECT n.contenu, u1.prenom, u2.prenom FROM note n JOIN user u1 ON n.auteur_id=u1.id JOIN user u2 ON n.destinataire_id=u2.id";
        Statement req = connexion.createStatement();
        ResultSet rs = req.executeQuery(sql);
        while (rs.next()){
            User u1 = new User();
            u1.setNom(rs.getString("nom"));
            u1.setPrenom(rs.getString("prenom"));
            u1.setMail(rs.getString("mail"));
            Note n = new Note();
            n.setContenu(rs.getString("contenu"));
            n.setAuteur(u1);
            /*n.setDestinataire(rs.getString("destinataire"));*/
            
            notes.add(n);
        }
        return notes;
    }
    
}
