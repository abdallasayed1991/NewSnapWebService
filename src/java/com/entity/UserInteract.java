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
@Table(name = "User_Interact")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserInteract.findAll", query = "SELECT u FROM UserInteract u"),
    @NamedQuery(name = "UserInteract.findByUIid", query = "SELECT u FROM UserInteract u WHERE u.uIid = :uIid"),
    @NamedQuery(name = "UserInteract.findByEmotionType", query = "SELECT u FROM UserInteract u WHERE u.emotionType = :emotionType")})
public class UserInteract implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "UI_id")
    private Integer uIid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Emotion_Type")
    private int emotionType;
    @JoinColumn(name = "Product_id", referencedColumnName = "Product_ID")
    @ManyToOne(optional = false)
    private Product productid;
    @JoinColumn(name = "User_id", referencedColumnName = "User_ID")
    @ManyToOne(optional = false)
    private Users userid;

    public UserInteract() {
    }

    public UserInteract(Integer uIid) {
        this.uIid = uIid;
    }

    public UserInteract(Integer uIid, int emotionType) {
        this.uIid = uIid;
        this.emotionType = emotionType;
    }

    public Integer getUIid() {
        return uIid;
    }

    public void setUIid(Integer uIid) {
        this.uIid = uIid;
    }

    public int getEmotionType() {
        return emotionType;
    }

    public void setEmotionType(int emotionType) {
        this.emotionType = emotionType;
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
        hash += (uIid != null ? uIid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserInteract)) {
            return false;
        }
        UserInteract other = (UserInteract) object;
        if ((this.uIid == null && other.uIid != null) || (this.uIid != null && !this.uIid.equals(other.uIid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.UserInteract[ uIid=" + uIid + " ]";
    }
    
}
