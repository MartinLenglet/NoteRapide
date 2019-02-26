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
        String sql = "INSERT INTO note(contenu, auteur_id) VALUES(?, ?)";
        Connection connexion = testBd.getConnection();
        PreparedStatement ordre = connexion.prepareStatement(sql);
        ordre.setString(1, note.getContenu());
        ordre.setInt(2, note.getAuteur().getId());
        ordre.execute();
    }
    
    public static List<Note> getAllNote(User utilisateur) throws SQLException{
        List<Note> notes = new ArrayList<Note>();
        Connection connexion = testBd.getConnection();
        String sql = "SELECT n.id, n.contenu, u1.prenom AS prenomAuteur, u1.nom AS nomAuteur, u1.mail AS mailAuteur"
                + " FROM note n JOIN user u1 ON n.auteur_id=u1.id"
                + " WHERE n.destinataire_id=" + utilisateur.getId();
        Statement req = connexion.createStatement();
        ResultSet rs = req.executeQuery(sql);
        while (rs.next()){
            User auteur = new User();
            auteur.setNom(rs.getString("nomAuteur"));
            auteur.setPrenom(rs.getString("prenomAuteur"));
            auteur.setMail(rs.getString("mailAuteur"));
            
                
            Note n = new Note();
            n.setId(rs.getInt("id"));
            n.setContenu(rs.getString("contenu"));
            n.setAuteur(auteur);
            n.setDestinataire(utilisateur);
                
            notes.add(n);
            }
  
        connexion = testBd.getConnection();
        sql = "SELECT n.id, n.contenu, u.prenom AS prenomAuteur, u.nom AS nomAuteur, u.mail AS mailAuteur"
                + " FROM note n"
                + " JOIN user u"
                + " ON n.auteur_id=u.id"               
                + " WHERE n.destinataire_id IS null";
        req = connexion.createStatement();
        rs = req.executeQuery(sql);
        while (rs.next()){
            User auteur = new User();
            auteur.setNom(rs.getString("nomAuteur"));
            auteur.setPrenom(rs.getString("prenomAuteur"));
            auteur.setMail(rs.getString("mailAuteur"));
 
            User destinataire = new User();
            destinataire.setNom("Publique");
            destinataire.setPrenom("Note");
            
            Note n = new Note();
            n.setId(rs.getInt("id"));
            n.setContenu(rs.getString("contenu"));
            n.setAuteur(auteur);
            n.setDestinataire(destinataire);
            
            notes.add(n);
            }
            
        
        return notes;
    }
    
    public static List<Note> getMyNote(User utilisateur) throws SQLException{
        List<Note> notes = new ArrayList<Note>();
        
        Connection connexion = testBd.getConnection();
        String sql = "SELECT n.contenu, u.prenom AS prenomDestinataire, u.nom AS nomDestinataire, u.mail AS mailDestinataire"
                + " FROM note n JOIN user u ON n.destinataire_id=u.id WHERE n.auteur_id=" + utilisateur.getId();
        Statement req = connexion.createStatement();
        ResultSet rs = req.executeQuery(sql);
        while (rs.next()){         
            User destinataire = new User();
            destinataire.setNom(rs.getString("nomDestinataire"));
            destinataire.setPrenom(rs.getString("prenomDestinataire"));
            destinataire.setMail(rs.getString("mailDestinataire"));
            
            Note n = new Note();
            n.setContenu(rs.getString("contenu"));
            n.setAuteur(utilisateur);
            n.setDestinataire(destinataire);
            
            
            notes.add(n);
        }
        
        connexion = testBd.getConnection();
        sql = "SELECT *"
                + " FROM note n JOIN user u ON n.auteur_id=u.id WHERE (n.destinataire_id IS null AND n.auteur_id=" + utilisateur.getId() + ")";
        req = connexion.createStatement();
        rs = req.executeQuery(sql);
        while (rs.next()){         
            User destinataire = new User();
            destinataire.setNom("Publique");
            destinataire.setPrenom("Note");
            
            Note n = new Note();
            n.setContenu(rs.getString("contenu"));
            n.setAuteur(utilisateur);
            n.setDestinataire(destinataire);
            
            
            notes.add(n);
        }
        return notes;
    }
    
    /*public static boolean deleteNote(Note note) throws SQLException{
        
    }*/
}
