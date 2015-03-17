package dst.ass1.jpa.model.impl;

import dst.ass1.jpa.model.ILecturer;
import dst.ass1.jpa.model.IMembership;
import dst.ass1.jpa.model.IMembershipKey;

import javax.persistence.*;
import java.util.Date;

@Entity
@AssociationOverrides({
        @AssociationOverride(name ="membershipKey.lecturer", joinColumns = @JoinColumn(name ="lecturer_id")),
        @AssociationOverride(name ="membershipKey.mocPlatform", joinColumns = @JoinColumn(name ="mocPlatform_id"))
})
public class Membership implements IMembership {

    @EmbeddedId
    private MembershipKey membershipKey;

    private Date registration;
    private double discount;

    @Override
    public IMembershipKey getId() {
        return this.membershipKey;
    }

    @Override
    public void setId(IMembershipKey id) {
        this.membershipKey = (MembershipKey) id;
    }

    @Override
    public Date getRegistration() {
        return this.registration;
    }

    @Override
    public void setRegistration(Date registration) {
        this.registration = registration;
    }

    @Override
    public Double getDiscount() {
        return this.discount;
    }

    @Override
    public void setDiscount(Double discount) {
        this.discount = discount;
    }



}
