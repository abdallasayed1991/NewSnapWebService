/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "Offer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Offer.findAll", query = "SELECT o FROM Offer o"),
    @NamedQuery(name = "Offer.findByOfferID", query = "SELECT o FROM Offer o WHERE o.offerID = :offerID"),
    @NamedQuery(name = "Offer.findByOfferdiscount", query = "SELECT o FROM Offer o WHERE o.offerdiscount = :offerdiscount"),
    @NamedQuery(name = "Offer.findByOfferstartDate", query = "SELECT o FROM Offer o WHERE o.offerstartDate = :offerstartDate"),
    @NamedQuery(name = "Offer.findByOfferendDate", query = "SELECT o FROM Offer o WHERE o.offerendDate = :offerendDate"),
    @NamedQuery(name = "Offer.findByOfferDescription", query = "SELECT o FROM Offer o WHERE o.offerDescription = :offerDescription")})
public class Offer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Offer_ID")
    private Integer offerID;
    @Column(name = "Offer_discount")
    private Integer offerdiscount;
    @Size(max = 500)
    @Column(name = "Offer_startDate")
    private String offerstartDate;
    @Size(max = 500)
    @Column(name = "Offer_endDate")
    private String offerendDate;
    @Size(max = 500)
    @Column(name = "Offer_Description")
    private String offerDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "offerid")
    private Collection<Product> productCollection;

    public Offer() {
    }

    public Offer(Integer offerID) {
        this.offerID = offerID;
    }

    public Integer getOfferID() {
        return offerID;
    }

    public void setOfferID(Integer offerID) {
        this.offerID = offerID;
    }

    public Integer getOfferdiscount() {
        return offerdiscount;
    }

    public void setOfferdiscount(Integer offerdiscount) {
        this.offerdiscount = offerdiscount;
    }

    public String getOfferstartDate() {
        return offerstartDate;
    }

    public void setOfferstartDate(String offerstartDate) {
        this.offerstartDate = offerstartDate;
    }

    public String getOfferendDate() {
        return offerendDate;
    }

    public void setOfferendDate(String offerendDate) {
        this.offerendDate = offerendDate;
    }

    public String getOfferDescription() {
        return offerDescription;
    }

    public void setOfferDescription(String offerDescription) {
        this.offerDescription = offerDescription;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (offerID != null ? offerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Offer)) {
            return false;
        }
        Offer other = (Offer) object;
        if ((this.offerID == null && other.offerID != null) || (this.offerID != null && !this.offerID.equals(other.offerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Offer[ offerID=" + offerID + " ]";
    }
    
}
