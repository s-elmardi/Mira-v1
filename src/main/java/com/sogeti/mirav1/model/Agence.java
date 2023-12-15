package com.sogeti.mirav1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "agences")
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acgId")
    private long agcId;

    @Column(name ="agcCode", unique = true, nullable = false)
    private String agcCode;

    // bi-directional many-to-one association to Banque
    @JsonBackReference
    @JoinColumn(name = "bnqId", nullable = false)
    @ManyToOne
    private Banque banque;

    // bi-directional one-to-many association to Agence
    @JsonManagedReference
    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL)
    List<Conseiller> conseillers;

    // Constructors
    public Agence() {
    }
    public Agence(long agcId, String agcCode, Banque banque) {
        super();
        this.agcId = agcId;
        this.agcCode = agcCode;
        this.banque = banque;
    }

    // Getters and setters
    public long getAgcId() {
        return agcId;
    }

    public void setAgcId(long agcId) {
        this.agcId = agcId;
    }

    public String getAgcCode() {
        return agcCode;
    }

    public void setAgcCode(String agcCode) {
        this.agcCode = agcCode;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public List<Conseiller> getConseillers() {
        return conseillers;
    }

    public void setConseillers(List<Conseiller> conseillers) {
        this.conseillers = conseillers;
    }

    @Override
    public String toString() {
        return "Agence{" +
                "agcId=" + agcId +
                ", agcCode='" + agcCode + '\'' +
                ", banque=" + banque +
                ", conseillers=" + conseillers +
                '}';
    }
}