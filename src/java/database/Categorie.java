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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FSEVERI\scagnellato3082
 */
@Entity
@Table(name = "Categorie")
@NamedQueries(
        {
            @NamedQuery(
                    name = "tutteCategorie",
                    query = "FROM Categorie"
            )
        }
)

public class Categorie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Cat")
    private Integer idCat;
    @Basic(optional = false)
    @Column(name = "Descrizione")
    private String descrizione;
    @ManyToMany(mappedBy = "categorieCollection")
    private Collection<Utenti> utentiCollection;

    public Categorie() {
    }

    public Categorie(Integer idCat) {
        this.idCat = idCat;
    }

    public Categorie(Integer idCat, String descrizione) {
        this.idCat = idCat;
        this.descrizione = descrizione;
    }

    public Integer getIdCat() {
        return idCat;
    }

    public void setIdCat(Integer idCat) {
        this.idCat = idCat;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @XmlTransient
    public Collection<Utenti> getUtentiCollection() {
        return utentiCollection;
    }

    public void setUtentiCollection(Collection<Utenti> utentiCollection) {
        this.utentiCollection = utentiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCat != null ? idCat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorie)) {
            return false;
        }
        Categorie other = (Categorie) object;
        if ((this.idCat == null && other.idCat != null) || (this.idCat != null && !this.idCat.equals(other.idCat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Categorie[ idCat=" + idCat + " ]";
    }
    
}
