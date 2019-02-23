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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "Product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProductID", query = "SELECT p FROM Product p WHERE p.productID = :productID"),
    @NamedQuery(name = "Product.findByProductName", query = "SELECT p FROM Product p WHERE p.productName = :productName"),
    @NamedQuery(name = "Product.findByProductPrice", query = "SELECT p FROM Product p WHERE p.productPrice = :productPrice"),
    @NamedQuery(name = "Product.findByProductDetailes", query = "SELECT p FROM Product p WHERE p.productDetailes = :productDetailes"),
    @NamedQuery(name = "Product.findByProductCode", query = "SELECT p FROM Product p WHERE p.productCode = :productCode"),
    @NamedQuery(name = "Product.findByProductColor", query = "SELECT p FROM Product p WHERE p.productColor = :productColor"),
    @NamedQuery(name = "Product.findByProductState", query = "SELECT p FROM Product p WHERE p.productState = :productState"),
    @NamedQuery(name = "Product.findByProductGroup", query = "SELECT p FROM Product p WHERE p.productGroup = :productGroup")})
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Product_ID")
    private Integer productID;
    @Size(max = 50)
    @Column(name = "Product_Name")
    private String productName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Product_Price")
    private Double productPrice;
    @Size(max = 500)
    @Column(name = "Product_Detailes")
    private String productDetailes;
    @Column(name = "Product_Code")
    private Integer productCode;
    @Size(max = 50)
    @Column(name = "Product_Color")
    private String productColor;
    @Lob
    @Column(name = "Product_Image")
    private byte[] productImage;
    @Column(name = "Product_State")
    private Integer productState;
    @Size(max = 50)
    @Column(name = "Product_Group")
    private String productGroup;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productid")
    private Collection<Comment> commentCollection;
    @JoinColumn(name = "Brand_id", referencedColumnName = "Brand_ID")
    @ManyToOne(optional = false)
    private Brand brandid;
    @JoinColumn(name = "Merchant_id", referencedColumnName = "Merchant_ID")
    @ManyToOne(optional = false)
    private Merchant merchantid;
    @JoinColumn(name = "Offer_id", referencedColumnName = "Offer_ID")
    @ManyToOne(optional = false)
    private Offer offerid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productid")
    private Collection<ProductSnapping> productSnappingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productid")
    private Collection<UserInteract> userInteractCollection;

    public Product() {
    }

    public Product(Integer productID) {
        this.productID = productID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDetailes() {
        return productDetailes;
    }

    public void setProductDetailes(String productDetailes) {
        this.productDetailes = productDetailes;
    }

    public Integer getProductCode() {
        return productCode;
    }

    public void setProductCode(Integer productCode) {
        this.productCode = productCode;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public byte[] getProductImage() {
        return productImage;
    }

    public void setProductImage(byte[] productImage) {
        this.productImage = productImage;
    }

    public Integer getProductState() {
        return productState;
    }

    public void setProductState(Integer productState) {
        this.productState = productState;
    }

    public String getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(String productGroup) {
        this.productGroup = productGroup;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    public Brand getBrandid() {
        return brandid;
    }

    public void setBrandid(Brand brandid) {
        this.brandid = brandid;
    }

    public Merchant getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(Merchant merchantid) {
        this.merchantid = merchantid;
    }

    public Offer getOfferid() {
        return offerid;
    }

    public void setOfferid(Offer offerid) {
        this.offerid = offerid;
    }

    @XmlTransient
    public Collection<ProductSnapping> getProductSnappingCollection() {
        return productSnappingCollection;
    }

    public void setProductSnappingCollection(Collection<ProductSnapping> productSnappingCollection) {
        this.productSnappingCollection = productSnappingCollection;
    }

    @XmlTransient
    public Collection<UserInteract> getUserInteractCollection() {
        return userInteractCollection;
    }

    public void setUserInteractCollection(Collection<UserInteract> userInteractCollection) {
        this.userInteractCollection = userInteractCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productID != null ? productID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productID == null && other.productID != null) || (this.productID != null && !this.productID.equals(other.productID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Product[ productID=" + productID + " ]";
    }
    
}
