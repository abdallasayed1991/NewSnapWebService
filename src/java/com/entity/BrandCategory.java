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
@Table(name = "Brand_Category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BrandCategory.findAll", query = "SELECT b FROM BrandCategory b"),
    @NamedQuery(name = "BrandCategory.findByBCid", query = "SELECT b FROM BrandCategory b WHERE b.bCid = :bCid")})
public class BrandCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BC_id")
    private Integer bCid;
    @JoinColumn(name = "Brand_id", referencedColumnName = "Brand_ID")
    @ManyToOne(optional = false)
    private Brand brandid;
    @JoinColumn(name = "Category_id", referencedColumnName = "Category_ID")
    @ManyToOne(optional = false)
    private Category categoryid;

    public BrandCategory() {
    }

    public BrandCategory(Integer bCid) {
        this.bCid = bCid;
    }

    public Integer getBCid() {
        return bCid;
    }

    public void setBCid(Integer bCid) {
        this.bCid = bCid;
    }

    public Brand getBrandid() {
        return brandid;
    }

    public void setBrandid(Brand brandid) {
        this.brandid = brandid;
    }

    public Category getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Category categoryid) {
        this.categoryid = categoryid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bCid != null ? bCid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BrandCategory)) {
            return false;
        }
        BrandCategory other = (BrandCategory) object;
        if ((this.bCid == null && other.bCid != null) || (this.bCid != null && !this.bCid.equals(other.bCid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.BrandCategory[ bCid=" + bCid + " ]";
    }
    
}
