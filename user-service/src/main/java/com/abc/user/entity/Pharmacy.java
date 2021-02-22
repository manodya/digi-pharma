package com.abc.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "pharmacy_tbl")
public class Pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String location;
    @Column(name = "iso_certification")
    private String certificationID;
    @Column
    private String contact;

    @OneToMany(mappedBy = "pharmacy")
    @JsonIgnore
    private Set<PharmacyUser> users;

    public Pharmacy() {
    }

    public Pharmacy(String name, String location, String certificationID, String contact) {
        this.name = name;
        this.location = location;
        this.certificationID = certificationID;
        this.contact = contact;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCertificationID() {
        return certificationID;
    }

    public void setCertificationID(String certificationID) {
        this.certificationID = certificationID;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Set<PharmacyUser> getUsers() {
        return users;
    }

    public void setUsers(Set<PharmacyUser> users) {
        this.users = users;
    }
}
