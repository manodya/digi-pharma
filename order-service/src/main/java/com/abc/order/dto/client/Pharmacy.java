package com.abc.order.dto.client;

public class Pharmacy {
    private Long id;
    private String name;
    private String location;
    private String certificationID;
    private String contact;

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

    public String getLocation() {
        return location;
    }

    public String getCertificationID() {
        return certificationID;
    }

    public String getContact() {
        return contact;
    }
}
