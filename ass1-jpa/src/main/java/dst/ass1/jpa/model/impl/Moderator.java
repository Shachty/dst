package dst.ass1.jpa.model.impl;

import dst.ass1.jpa.model.IAddress;
import dst.ass1.jpa.model.IModerator;
import dst.ass1.jpa.model.IVirtualSchool;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Moderator extends Person implements IModerator {


    @OneToMany(targetEntity = VirtualSchool.class, mappedBy = "moderator")
    private List<IVirtualSchool> advisedVirtualSchools;

    @Override
    public List<IVirtualSchool> getAdvisedVirtualSchools() {
        return this.advisedVirtualSchools;
    }

    @Override
    public void setAdvisedVirtualSchools(List<IVirtualSchool> virtualSchools) {
        this.advisedVirtualSchools = virtualSchools;
    }

    @Override
    public void addAdvisedVirtualSchool(IVirtualSchool virtualSchool) {

        if(this.advisedVirtualSchools == null){
            this.advisedVirtualSchools = new ArrayList<IVirtualSchool>();
        }

        this.advisedVirtualSchools.add(virtualSchool);
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public IAddress getAddress() {
        return this.address;
    }

    @Override
    public void setAddress(IAddress address) {
        super.setAddress(address);
    }
}
