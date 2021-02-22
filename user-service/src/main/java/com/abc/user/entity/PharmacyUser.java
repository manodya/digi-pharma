package com.abc.user.entity;

import javax.persistence.*;

@Entity
@Table(name = "pharmacy_user_tbl")
public class PharmacyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "pharmacy_id")
    private Long pharmacyId;
    @Column(name = "user_name")
    private String userName;
    private String password;

    @ManyToOne
    @JoinColumn(name = "pharmacy_id", nullable = false, insertable = false, updatable = false)
    private Pharmacy pharmacy;

    public PharmacyUser() {
    }

    public PharmacyUser(Long pharmacyId, String userName, String password) {
        this.pharmacyId = pharmacyId;
        this.userName = userName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(Long pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
}
