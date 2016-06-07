/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FSEVERI\scagnellato3082
 */
@Entity
@Table(name = "Utenti")


public class Utenti implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Nickname")
    private String nickname;
    @Basic(optional = false)
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "Cognome")
    private String cognome;
    @Column(name = "Email")
    private String email;
    @Column(name = "Password")
    private String password;
    @JoinTable(name = "Ut_Cat", joinColumns = {
        @JoinColumn(name = "nickname_Utente", referencedColumnName = "Nickname")}, inverseJoinColumns = {
        @JoinColumn(name = "id_Cat", referencedColumnName = "id_Cat")})
    @ManyToMany
    private Collection<Categorie> categorieCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utente")
    private Collection<Eventi> eventiCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utente")
    private Collection<Commenti> commentiCollection;

    public Utenti() {
    }

    public Utenti(String nickname) {
        this.nickname = nickname;
    }

    public Utenti(String nickname, String nome, String cognome,String password) {
        this.nickname = nickname;
        this.nome = nome;
        this.cognome = cognome;
        this.password= password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPswd() {
        return password;
    }

    public void setPswd(String password) {
        this.password = password;
    }

    
    @XmlTransient
    public Collection<Categorie> getCategorieCollection() {
        return categorieCollection;
    }

    public void setCategorieCollection(Collection<Categorie> categorieCollection) {
        this.categorieCollection = categorieCollection;
    }

    @XmlTransient
    public Collection<Eventi> getEventiCollection() {
        return eventiCollection;
    }

    public void setEventiCollection(Collection<Eventi> eventiCollection) {
        this.eventiCollection = eventiCollection;
    }

    @XmlTransient
    public Collection<Commenti> getCommentiCollection() {
        return commentiCollection;
    }

    public void setCommentiCollection(Collection<Commenti> commentiCollection) {
        this.commentiCollection = commentiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nickname != null ? nickname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utenti)) {
            return false;
        }
        Utenti other = (Utenti) object;
        if ((this.nickname == null && other.nickname != null) || (this.nickname != null && !this.nickname.equals(other.nickname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Utenti[ nickname=" + nickname + " ]";
    }
    
}
