package dst.ass1.jpa.model.impl;

import dst.ass1.jpa.model.IAddress;

import javax.persistence.*;

@Embeddable
@Table(name = "address")
public class Address implements IAddress {

    private String street;
    private String city;
    private String zipCode;


    @Override
    public String getStreet() {
        return this.street;
    }

    @Override
    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String getCity() {
        return this.city;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String getZipCode() {
        return this.zipCode;
    }

    @Override
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
