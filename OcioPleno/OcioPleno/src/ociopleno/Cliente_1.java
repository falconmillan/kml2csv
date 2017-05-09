/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ociopleno;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author jcfalcon
 */
@Entity
@Table(name = "cliente", catalog = "ociopleno", schema = "")
@NamedQueries({
    @NamedQuery(name = "Cliente_1.findAll", query = "SELECT c FROM Cliente_1 c"),
    @NamedQuery(name = "Cliente_1.findByIdc", query = "SELECT c FROM Cliente_1 c WHERE c.idc = :idc"),
    @NamedQuery(name = "Cliente_1.findByNick", query = "SELECT c FROM Cliente_1 c WHERE c.nick = :nick"),
    @NamedQuery(name = "Cliente_1.findByFnacimiento", query = "SELECT c FROM Cliente_1 c WHERE c.fnacimiento = :fnacimiento"),
    @NamedQuery(name = "Cliente_1.findBySexo", query = "SELECT c FROM Cliente_1 c WHERE c.sexo = :sexo"),
    @NamedQuery(name = "Cliente_1.findByLugar", query = "SELECT c FROM Cliente_1 c WHERE c.lugar = :lugar"),
    @NamedQuery(name = "Cliente_1.findByPass", query = "SELECT c FROM Cliente_1 c WHERE c.pass = :pass"),
    @NamedQuery(name = "Cliente_1.findByEmail", query = "SELECT c FROM Cliente_1 c WHERE c.email = :email")})
public class Cliente_1 implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idc")
    private Integer idc;
    @Column(name = "nick")
    private String nick;
    @Column(name = "fnacimiento")
    @Temporal(TemporalType.DATE)
    private Date fnacimiento;
    @Column(name = "sexo")
    private Character sexo;
    @Column(name = "lugar")
    private String lugar;
    @Column(name = "pass")
    private String pass;
    @Column(name = "email")
    private String email;

    public Cliente_1() {
    }

    public Cliente_1(Integer idc) {
        this.idc = idc;
    }

    public Integer getIdc() {
        return idc;
    }

    public void setIdc(Integer idc) {
        Integer oldIdc = this.idc;
        this.idc = idc;
        changeSupport.firePropertyChange("idc", oldIdc, idc);
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        String oldNick = this.nick;
        this.nick = nick;
        changeSupport.firePropertyChange("nick", oldNick, nick);
    }

    public Date getFnacimiento() {
        return fnacimiento;
    }

    public void setFnacimiento(Date fnacimiento) {
        Date oldFnacimiento = this.fnacimiento;
        this.fnacimiento = fnacimiento;
        changeSupport.firePropertyChange("fnacimiento", oldFnacimiento, fnacimiento);
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        Character oldSexo = this.sexo;
        this.sexo = sexo;
        changeSupport.firePropertyChange("sexo", oldSexo, sexo);
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        String oldLugar = this.lugar;
        this.lugar = lugar;
        changeSupport.firePropertyChange("lugar", oldLugar, lugar);
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        String oldPass = this.pass;
        this.pass = pass;
        changeSupport.firePropertyChange("pass", oldPass, pass);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idc != null ? idc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente_1)) {
            return false;
        }
        Cliente_1 other = (Cliente_1) object;
        if ((this.idc == null && other.idc != null) || (this.idc != null && !this.idc.equals(other.idc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ociopleno.Cliente_1[ idc=" + idc + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
