/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Note;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ESIC
 */
public class NoteDao {
    
    public static void insert(Note note) throws SQLException{
        String sql = "INSERT INTO note(contenu, idAuteur, idDestinataire) VALUES(?, ?, ?)";
        /*Connection connexion = testBd.getConnection();
        PreparedStatement ordre = connexion.prepareStatement(sql);
        ordre.setString(1, note.getContenu());
        ordre.setString(2, note.getAuteur().getId());
        ordre.setString(3, note.getDestinataire().getId());
        ordre.execute();*/
    }
}
