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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "Brand_Interested")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BrandInterested.findAll", query = "SELECT b FROM BrandInterested b"),
    @NamedQuery(name = "BrandInterested.findByBIid", query = "SELECT b FROM BrandInterested b WHERE b.bIid = :bIid")})
public class BrandInterested implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BI_id")
    private Integer bIid;
    @JoinColumn(name = "Brand_id", referencedColumnName = "Brand_ID")
    @ManyToOne(optional = false)
    private Brand brandid;
    @JoinColumn(name = "User_id", referencedColumnName = "User_ID")
    @ManyToOne(optional = false)
    private Users userid;

    public BrandInterested() {
    }

    public BrandInterested(Integer bIid) {
        this.bIid = bIid;
    }

    public Integer getBIid() {
        return bIid;
    }

    public void setBIid(Integer bIid) {
        this.bIid = bIid;
    }

    public Brand getBrandid() {
        return brandid;
    }

    public void setBrandid(Brand brandid) {
        this.brandid = brandid;
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
        hash += (bIid != null ? bIid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BrandInterested)) {
            return false;
        }
        BrandInterested other = (BrandInterested) object;
        if ((this.bIid == null && other.bIid != null) || (this.bIid != null && !this.bIid.equals(other.bIid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.BrandInterested[ bIid=" + bIid + " ]";
    }
    
}
