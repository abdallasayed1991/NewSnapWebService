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
@Table(name = "Category_Interested")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoryInterested.findAll", query = "SELECT c FROM CategoryInterested c"),
    @NamedQuery(name = "CategoryInterested.findByUCid", query = "SELECT c FROM CategoryInterested c WHERE c.uCid = :uCid")})
public class CategoryInterested implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "UC_id")
    private Integer uCid;
    @JoinColumn(name = "Category_id", referencedColumnName = "Category_ID")
    @ManyToOne(optional = false)
    private Category categoryid;
    @JoinColumn(name = "User_id", referencedColumnName = "User_ID")
    @ManyToOne(optional = false)
    private Users userid;

    public CategoryInterested() {
    }

    public CategoryInterested(Integer uCid) {
        this.uCid = uCid;
    }

    public Integer getUCid() {
        return uCid;
    }

    public void setUCid(Integer uCid) {
        this.uCid = uCid;
    }

    public Category getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Category categoryid) {
        this.categoryid = categoryid;
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
        hash += (uCid != null ? uCid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoryInterested)) {
            return false;
        }
        CategoryInterested other = (CategoryInterested) object;
        if ((this.uCid == null && other.uCid != null) || (this.uCid != null && !this.uCid.equals(other.uCid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.CategoryInterested[ uCid=" + uCid + " ]";
    }
    
}
