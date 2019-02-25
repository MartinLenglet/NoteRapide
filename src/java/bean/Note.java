/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author ESIC
 */
public class Note {
    private int id;
    private String contenu;
    private User auteur;
    private User destinataire;

    public Note(){
        
    }
    public Note(int id, String text, User auteur, User destinataire) {
        this.id = id;
        this.contenu = text;
        this.auteur = auteur;
        this.destinataire = destinataire;
    }

    public Note(String text, User auteur, User destinataire) {
        this.contenu = text;
        this.auteur = auteur;
        this.destinataire = destinataire;
    }
    
    public int getId() {
        return id;
    }

    public String getContenu() {
        return contenu;
    }

    public User getAuteur() {
        return auteur;
    }

    public User getDestinataire() {
        return destinataire;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContenu(String text) {
        this.contenu = text;
    }

    public void setAuteur(User auteur) {
        this.auteur = auteur;
    }

    public void setDestinataire(User destinataire) {
        this.destinataire = destinataire;
    }

    public String infoNote() {
        return "Note{" + "id=" + id + ", contenu=" + contenu + ", auteur=" + auteur + ", destinataire=" + destinataire + '}';
    }
    
    
}
