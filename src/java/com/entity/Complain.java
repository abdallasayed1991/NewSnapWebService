/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "Complain")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Complain.findAll", query = "SELECT c FROM Complain c"),
    @NamedQuery(name = "Complain.findByComplainID", query = "SELECT c FROM Complain c WHERE c.complainID = :complainID"),
    @NamedQuery(name = "Complain.findByComplainText", query = "SELECT c FROM Complain c WHERE c.complainText = :complainText"),
    @NamedQuery(name = "Complain.findByComplainDate", query = "SELECT c FROM Complain c WHERE c.complainDate = :complainDate"),
    @NamedQuery(name = "Complain.findByRespondName", query = "SELECT c FROM Complain c WHERE c.respondName = :respondName"),
    @NamedQuery(name = "Complain.findByRespondDate", query = "SELECT c FROM Complain c WHERE c.respondDate = :respondDate"),
    @NamedQuery(name = "Complain.findByRespondText", query = "SELECT c FROM Complain c WHERE c.respondText = :respondText")})
public class Complain implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Complain_ID")
    private Integer complainID;
    @Size(max = 500)
    @Column(name = "Complain_Text")
    private String complainText;
    @Size(max = 500)
    @Column(name = "Complain_Date")
    private String complainDate;
    @Size(max = 100)
    @Column(name = "Respond_Name")
    private String respondName;
    @Size(max = 500)
    @Column(name = "Respond_Date")
    private String respondDate;
    @Size(max = 500)
    @Column(name = "Respond_Text")
    private String respondText;
    @JoinColumn(name = "User_id", referencedColumnName = "User_ID")
    @ManyToOne(optional = false)
    private Users userid;

    public Complain() {
    }

    public Complain(Integer complainID) {
        this.complainID = complainID;
    }

    public Integer getComplainID() {
        return complainID;
    }

    public void setComplainID(Integer complainID) {
        this.complainID = complainID;
    }

    public String getComplainText() {
        return complainText;
    }

    public void setComplainText(String complainText) {
        this.complainText = complainText;
    }

    public String getComplainDate() {
        return complainDate;
    }

    public void setComplainDate(String complainDate) {
        this.complainDate = complainDate;
    }

    public String getRespondName() {
        return respondName;
    }

    public void setRespondName(String respondName) {
        this.respondName = respondName;
    }

    public String getRespondDate() {
        return respondDate;
    }

    public void setRespondDate(String respondDate) {
        this.respondDate = respondDate;
    }

    public String getRespondText() {
        return respondText;
    }

    public void setRespondText(String respondText) {
        this.respondText = respondText;
    }

    public Users getUserid() {
        return userid;
    }

    public void setUserid(Users userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (complainID != null ? complainID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Complain)) {
            return false;
        }
        Complain other = (Complain) object;
        if ((this.complainID == null && other.complainID != null) || (this.complainID != null && !this.complainID.equals(other.complainID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Complain[ complainID=" + complainID + " ]";
    }
    
}
