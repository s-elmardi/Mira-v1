package com.sogeti.mirav1.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "banques")
public class Banque{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bnqId")
    private long bnqId;

    @Column(name = "bnqCode", unique = true, nullable = false)
    private String bnqCode;

    // bi-directional one-to-many association to Agence
    @JsonManagedReference
    @OneToMany(mappedBy = "banque", cascade = CascadeType.ALL)
    List<Agence> agences;

    // Constructors
    public Banque() {
    }

    public Banque(long bnqId, String bnqCode) {
        super();
        this.bnqId = bnqId;
        this.bnqCode = bnqCode;
    }

    // Getters and setters

    public long getBnqId() {
        return bnqId;
    }

    public void setBnqId(long bnqId) {
        this.bnqId = bnqId;
    }

    public String getBnqCode() {
        return bnqCode;
    }

    public void setBnqCode(String bnqCode) {
        this.bnqCode = bnqCode;
    }

    public List<Agence> getAgences() {
        return agences;
    }

    public void setAgences(List<Agence> agences) {
        this.agences = agences;
    }

    @Override
    public String toString() {
        return "Banque{" +
                "bnqId=" + bnqId +
                ", bnqCode='" + bnqCode + '\'' +
                ", agences=" + agences +
                '}';
    }
}