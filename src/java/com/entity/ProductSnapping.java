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
import javax.persistence.Lob;
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
@Table(name = "Product_Snapping")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductSnapping.findAll", query = "SELECT p FROM ProductSnapping p"),
    @NamedQuery(name = "ProductSnapping.findByPUSid", query = "SELECT p FROM ProductSnapping p WHERE p.pUSid = :pUSid"),
    @NamedQuery(name = "ProductSnapping.findBySnapDate", query = "SELECT p FROM ProductSnapping p WHERE p.snapDate = :snapDate")})
public class ProductSnapping implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PUS_id")
    private Integer pUSid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "Snap_Date")
    private String snapDate;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "Snap_Image")
    private byte[] snapImage;
    @JoinColumn(name = "Product_id", referencedColumnName = "Product_ID")
    @ManyToOne(optional = false)
    private Product productid;
    @JoinColumn(name = "User_id", referencedColumnName = "User_ID")
    @ManyToOne(optional = false)
    private Users userid;

    public ProductSnapping() {
    }

    public ProductSnapping(Integer pUSid) {
        this.pUSid = pUSid;
    }

    public ProductSnapping(Integer pUSid, String snapDate, byte[] snapImage) {
        this.pUSid = pUSid;
        this.snapDate = snapDate;
        this.snapImage = snapImage;
    }

    public Integer getPUSid() {
        return pUSid;
    }

    public void setPUSid(Integer pUSid) {
        this.pUSid = pUSid;
    }

    public String getSnapDate() {
        return snapDate;
    }

    public void setSnapDate(String snapDate) {
        this.snapDate = snapDate;
    }

    public byte[] getSnapImage() {
        return snapImage;
    }

    public void setSnapImage(byte[] snapImage) {
        this.snapImage = snapImage;
    }

    public Product getProductid() {
        return productid;
    }

    public void setProductid(Product productid) {
        this.productid = productid;
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
        hash += (pUSid != null ? pUSid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductSnapping)) {
            return false;
        }
        ProductSnapping other = (ProductSnapping) object;
        if ((this.pUSid == null && other.pUSid != null) || (this.pUSid != null && !this.pUSid.equals(other.pUSid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.ProductSnapping[ pUSid=" + pUSid + " ]";
    }
    
}
