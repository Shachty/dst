package dst.ass1.jpa.model.impl;

import dst.ass1.jpa.model.ILecturer;
import dst.ass1.jpa.model.IMOCPlatform;
import dst.ass1.jpa.model.IMembershipKey;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class MembershipKey implements IMembershipKey {

    @OneToOne
    private ILecturer lecturer;

    @OneToOne
    private IMOCPlatform mocPlatform;


    @Override
    public ILecturer getLecturer() {
        return this.lecturer;
    }

    @Override
    public void setLecturer(ILecturer lecturer) {
        this.lecturer = lecturer;
    }

    @Override
    public IMOCPlatform getMOCPlatform() {
        return this.mocPlatform;
    }

    @Override
    public void setMOCPlatform(IMOCPlatform platform) {
        this.mocPlatform = platform;
    }
}
