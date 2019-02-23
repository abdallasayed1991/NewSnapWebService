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
import javax.persistence.Lob;
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
@Table(name = "Brand")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Brand.findAll", query = "SELECT b FROM Brand b"),
    @NamedQuery(name = "Brand.findByBrandID", query = "SELECT b FROM Brand b WHERE b.brandID = :brandID"),
    @NamedQuery(name = "Brand.findByBrandName", query = "SELECT b FROM Brand b WHERE b.brandName = :brandName"),
    @NamedQuery(name = "Brand.findByMerchantid", query = "SELECT b FROM Brand b WHERE b.merchantid = :merchantid")})
public class Brand implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Brand_ID")
    private Integer brandID;
    @Size(max = 50)
    @Column(name = "Brand_Name")
    private String brandName;
    @Lob
    @Column(name = "Brand_Logo")
    private byte[] brandLogo;
    @Column(name = "Merchant_id")
    private Integer merchantid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brandid")
    private Collection<Product> productCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brandid")
    private Collection<BrandInterested> brandInterestedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brandid")
    private Collection<BrandCategory> brandCategoryCollection;

    public Brand() {
    }

    public Brand(Integer brandID) {
        this.brandID = brandID;
    }

    public Integer getBrandID() {
        return brandID;
    }

    public void setBrandID(Integer brandID) {
        this.brandID = brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public byte[] getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(byte[] brandLogo) {
        this.brandLogo = brandLogo;
    }

    public Integer getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(Integer merchantid) {
        this.merchantid = merchantid;
    }

    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @XmlTransient
    public Collection<BrandInterested> getBrandInterestedCollection() {
        return brandInterestedCollection;
    }

    public void setBrandInterestedCollection(Collection<BrandInterested> brandInterestedCollection) {
        this.brandInterestedCollection = brandInterestedCollection;
    }

    @XmlTransient
    public Collection<BrandCategory> getBrandCategoryCollection() {
        return brandCategoryCollection;
    }

    public void setBrandCategoryCollection(Collection<BrandCategory> brandCategoryCollection) {
        this.brandCategoryCollection = brandCategoryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (brandID != null ? brandID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Brand)) {
            return false;
        }
        Brand other = (Brand) object;
        if ((this.brandID == null && other.brandID != null) || (this.brandID != null && !this.brandID.equals(other.brandID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Brand[ brandID=" + brandID + " ]";
    }
    
}
