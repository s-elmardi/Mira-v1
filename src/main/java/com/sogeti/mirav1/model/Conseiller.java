package com.sogeti.mirav1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "conseillers")
public class Conseiller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consId")
    private long consId;

    @Column(name = "consCivile", nullable = false)
    private String consCivile;

    @Column(name = "consName", nullable = false)
    private String consName;

    @Column(name = "consPrenom", nullable = false)
    private String consPrenom;

    @Column(name = "consDateNaissance", nullable = false)
    private LocalDate consDateNaissance;

    @Column(name = "consTelPro", nullable = false)
    private String consTelPro;

    @Column(name = "consEmailPro", unique = true, nullable = false)
    private String consEmailPro;

    @Column(name = "consLogin", unique = true, nullable = false)
    private String consLogin;

    @Column(name = "consPassword", nullable = false)
    private String consPassword;

    @Column(name = "consAdmin", nullable = false)
    private boolean consAdmin;

    // bi-directional many-to-one association to Agence
    @JsonBackReference
    @JoinColumn(name = "agcId", nullable = false)
    @ManyToOne
    private Agence agence;

    // Constructors
    public Conseiller() {
    }

    public Conseiller(long consId, String consCivile, String consName, String consPrenom, LocalDate consDateNaissance, String consTelPro, String consEmailPro, String consLogin, String consPassword, boolean consAdmin, Agence agence) {
        super();
        this.consId = consId;
        this.consCivile = consCivile;
        this.consName = consName;
        this.consPrenom = consPrenom;
        this.consDateNaissance = consDateNaissance;
        this.consTelPro = consTelPro;
        this.consEmailPro = consEmailPro;
        this.consLogin = consLogin;
        this.consPassword = consPassword;
        this.consAdmin = consAdmin;
        this.agence = agence;
    }

    // Getters and setters

    public long getConsId() {
        return consId;
    }

    public void setConsId(long consId) {
        this.consId = consId;
    }

    public String getConsCivile() {
        return consCivile;
    }

    public void setConsCivile(String consCivile) {
        this.consCivile = consCivile;
    }

    public String getConsName() {
        return consName;
    }

    public void setConsName(String consName) {
        this.consName = consName;
    }

    public String getConsPrenom() {
        return consPrenom;
    }

    public void setConsPrenom(String consPrenom) {
        this.consPrenom = consPrenom;
    }

    public LocalDate getConsDateNaissance() {
        return consDateNaissance;
    }

    public void setConsDateNaissance(LocalDate consDateNaissance) {
        this.consDateNaissance = consDateNaissance;
    }

    public String getConsTelPro() {
        return consTelPro;
    }

    public void setConsTelPro(String consTelPro) {
        this.consTelPro = consTelPro;
    }

    public String getConsEmailPro() {
        return consEmailPro;
    }

    public void setConsEmailPro(String consEmailPro) {
        this.consEmailPro = consEmailPro;
    }

    public String getConsLogin() {
        return consLogin;
    }

    public void setConsLogin(String consLogin) {
        this.consLogin = consLogin;
    }

    public String getConsPassword() {
        return consPassword;
    }

    public void setConsPassword(String consPassword) {
        this.consPassword = consPassword;
    }

    public boolean getConsAdmin() {
        return consAdmin;
    }

    public void setConsAdmin(boolean consAdmin) {
        this.consAdmin = consAdmin;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

       @Override
    public String toString() {
        return "Conseiller{" +
                "consId=" + consId +
                ", consCivile='" + consCivile + '\'' +
                ", consName='" + consName + '\'' +
                ", consPrenom='" + consPrenom + '\'' +
                ", consDateNaissance=" + consDateNaissance +
                ", consTelPro='" + consTelPro + '\'' +
                ", consEmailPro='" + consEmailPro + '\'' +
                ", consLogin='" + consLogin + '\'' +
                ", consPassword='" + consPassword + '\'' +
                ", consAdmin=" + consAdmin +
                ", agence=" + agence +
                '}';
    }
}