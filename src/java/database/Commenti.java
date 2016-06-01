/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FSEVERI\scagnellato3082
 */
@Entity
@Table(name = "Commenti")

@NamedQueries({
    @NamedQuery(
        name="tuttiCommenti",
        query="FROM Commenti ORDER BY Voto"
    )
})

public class Commenti implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Comm")
    private Integer idComm;
    @Basic(optional = false)
    @Column(name = "Commento")
    private String commento;
    @Basic(optional = false)
    @Column(name = "Voto")
    private int voto;
    @JoinTable(name = "Art_Eventi", joinColumns = {
        @JoinColumn(name = "id_Comm", referencedColumnName = "id_Comm")}, inverseJoinColumns = {
        @JoinColumn(name = "id_Art", referencedColumnName = "id_Art")})
    @ManyToMany
    private Collection<Artisti> artistiCollection;
    @JoinColumn(name = "Utente", referencedColumnName = "Nickname")
    @ManyToOne(optional = false)
    private Utenti utente;
    @JoinColumn(name = "Evento", referencedColumnName = "id_Evento")
    @ManyToOne(optional = false)
    private Eventi evento;

    public Commenti() {
    }

    public Commenti(Integer idComm) {
        this.idComm = idComm;
    }

    public Commenti(Integer idComm, String commento, int voto) {
        this.idComm = idComm;
        this.commento = commento;
        this.voto = voto;
    }

    public Integer getIdComm() {
        return idComm;
    }

    public void setIdComm(Integer idComm) {
        this.idComm = idComm;
    }

    public String getCommento() {
        return commento;
    }

    public void setCommento(String commento) {
        this.commento = commento;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    @XmlTransient
    public Collection<Artisti> getArtistiCollection() {
        return artistiCollection;
    }

    public void setArtistiCollection(Collection<Artisti> artistiCollection) {
        this.artistiCollection = artistiCollection;
    }

    public Utenti getUtente() {
        return utente;
    }

    public void setUtente(Utenti utente) {
        this.utente = utente;
    }

    public Eventi getEvento() {
        return evento;
    }

    public void setEvento(Eventi evento) {
        this.evento = evento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComm != null ? idComm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commenti)) {
            return false;
        }
        Commenti other = (Commenti) object;
        if ((this.idComm == null && other.idComm != null) || (this.idComm != null && !this.idComm.equals(other.idComm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Commenti[ idComm=" + idComm + " ]";
    }
    
}
