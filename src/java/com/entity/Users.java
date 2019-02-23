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
@Table(name = "Users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUserID", query = "SELECT u FROM Users u WHERE u.userID = :userID"),
    @NamedQuery(name = "Users.findByUserName", query = "SELECT u FROM Users u WHERE u.userName = :userName"),
    @NamedQuery(name = "Users.findByUserAddress", query = "SELECT u FROM Users u WHERE u.userAddress = :userAddress"),
    @NamedQuery(name = "Users.findByUserEmail", query = "SELECT u FROM Users u WHERE u.userEmail = :userEmail"),
    @NamedQuery(name = "Users.findByUserPassword", query = "SELECT u FROM Users u WHERE u.userPassword = :userPassword"),
    @NamedQuery(name = "Users.findByUserAge", query = "SELECT u FROM Users u WHERE u.userAge = :userAge"),
    @NamedQuery(name = "Users.findByUserType", query = "SELECT u FROM Users u WHERE u.userType = :userType"),
    @NamedQuery(name = "Users.findByUserState", query = "SELECT u FROM Users u WHERE u.userState = :userState"),
    @NamedQuery(name = "Users.findByUserlastLog", query = "SELECT u FROM Users u WHERE u.userlastLog = :userlastLog"),
    @NamedQuery(name = "Users.findByUserPhone", query = "SELECT u FROM Users u WHERE u.userPhone = :userPhone")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "User_ID")
    private Integer userID;
    @Size(max = 50)
    @Column(name = "User_Name")
    private String userName;
    @Size(max = 100)
    @Column(name = "User_Address")
    private String userAddress;
    @Size(max = 50)
    @Column(name = "User_Email")
    private String userEmail;
    @Size(max = 50)
    @Column(name = "User_Password")
    private String userPassword;
    @Column(name = "User_Age")
    private Integer userAge;
    @Lob
    @Column(name = "User_Image")
    private byte[] userImage;
    @Column(name = "User_Type")
    private Integer userType;
    @Column(name = "User_State")
    private Integer userState;
    @Size(max = 50)
    @Column(name = "User_lastLog")
    private String userlastLog;
    @Column(name = "User_Phone")
    private Long userPhone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Comment> commentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<CategoryInterested> categoryInterestedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<ProductSnapping> productSnappingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<BrandInterested> brandInterestedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Complain> complainCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<UserInteract> userInteractCollection;

    public Users() {
    }

    public Users(Integer userID) {
        this.userID = userID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public byte[] getUserImage() {
        return userImage;
    }

    public void setUserImage(byte[] userImage) {
        this.userImage = userImage;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    public String getUserlastLog() {
        return userlastLog;
    }

    public void setUserlastLog(String userlastLog) {
        this.userlastLog = userlastLog;
    }

    public Long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Long userPhone) {
        this.userPhone = userPhone;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    @XmlTransient
    public Collection<CategoryInterested> getCategoryInterestedCollection() {
        return categoryInterestedCollection;
    }

    public void setCategoryInterestedCollection(Collection<CategoryInterested> categoryInterestedCollection) {
        this.categoryInterestedCollection = categoryInterestedCollection;
    }

    @XmlTransient
    public Collection<ProductSnapping> getProductSnappingCollection() {
        return productSnappingCollection;
    }

    public void setProductSnappingCollection(Collection<ProductSnapping> productSnappingCollection) {
        this.productSnappingCollection = productSnappingCollection;
    }

    @XmlTransient
    public Collection<BrandInterested> getBrandInterestedCollection() {
        return brandInterestedCollection;
    }

    public void setBrandInterestedCollection(Collection<BrandInterested> brandInterestedCollection) {
        this.brandInterestedCollection = brandInterestedCollection;
    }

    @XmlTransient
    public Collection<Complain> getComplainCollection() {
        return complainCollection;
    }

    public void setComplainCollection(Collection<Complain> complainCollection) {
        this.complainCollection = complainCollection;
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
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Users[ userID=" + userID + " ]";
    }
    
}
