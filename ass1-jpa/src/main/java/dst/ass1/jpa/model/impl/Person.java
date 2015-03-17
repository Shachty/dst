package dst.ass1.jpa.model.impl;

import dst.ass1.jpa.model.IAddress;
import dst.ass1.jpa.model.IPerson;

import javax.persistence.GeneratedValue;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person implements IPerson{

    @Id
    @GeneratedValue
    protected Long id;

    protected String firstName;
    protected String lastName;

    @Embedded
    protected Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public IAddress getAddress() {
        return this.address;
    }

    @Override
    public void setAddress(IAddress address) {
        this.address = (Address) address;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
