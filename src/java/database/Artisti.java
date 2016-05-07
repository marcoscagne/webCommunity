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
@Table(name = "Artisti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artisti.findAll", query = "SELECT a FROM Artisti a"),
    @NamedQuery(name = "Artisti.findByIdArt", query = "SELECT a FROM Artisti a WHERE a.idArt = :idArt"),
    @NamedQuery(name = "Artisti.findByNomeArte", query = "SELECT a FROM Artisti a WHERE a.nomeArte = :nomeArte")})
public class Artisti implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Art")
    private Integer idArt;
    @Basic(optional = false)
    @Column(name = "nomeArte")
    private String nomeArte;
    @ManyToMany(mappedBy = "artistiCollection")
    private Collection<Commenti> commentiCollection;

    public Artisti() {
    }

    public Artisti(Integer idArt) {
        this.idArt = idArt;
    }

    public Artisti(Integer idArt, String nomeArte) {
        this.idArt = idArt;
        this.nomeArte = nomeArte;
    }

    public Integer getIdArt() {
        return idArt;
    }

    public void setIdArt(Integer idArt) {
        this.idArt = idArt;
    }

    public String getNomeArte() {
        return nomeArte;
    }

    public void setNomeArte(String nomeArte) {
        this.nomeArte = nomeArte;
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
        hash += (idArt != null ? idArt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artisti)) {
            return false;
        }
        Artisti other = (Artisti) object;
        if ((this.idArt == null && other.idArt != null) || (this.idArt != null && !this.idArt.equals(other.idArt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Artisti[ idArt=" + idArt + " ]";
    }
    
}
