package dst.ass1.jpa.model.impl;

import dst.ass1.jpa.model.*;
import dst.ass1.jpa.util.Constants;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = Constants.Q_MOSTACTIVELECTURER, query = "SELECT l from Lecturer l ")
@Table( uniqueConstraints = @UniqueConstraint(columnNames = {"accountNo","bankCode"}))
public class Lecturer extends Person implements ILecturer {

    @Column(unique = true, nullable = false)
    private String lecturerName;

    private byte[] password;

    private String accountNo;

    private String bankCode;


    @OneToMany(targetEntity = Lecture.class)
    private List<ILecture> lectures;

    @OneToMany(targetEntity = Membership.class, mappedBy = "membershipKey.lecturer")
    private List<IMembership> memberships;

    @Override
    public String getLecturerName() {
        return lecturerName;
    }


    @Override
    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    @Override
    public byte[] getPassword() {
        return this.password;
    }

    @Override
    public void setPassword(byte[] password) {
        this.password = password;
    }

    @Override
    public String getAccountNo() {
        return this.accountNo;
    }

    @Override
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    @Override
    public String getBankCode() {
        return this.bankCode;
    }

    @Override
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    @Override
    public List<ILecture> getLectures() {
        return this.lectures;
    }

    @Override
    public void setLectures(List<ILecture> lectures) {
        this.lectures = lectures;
    }

    @Override
    public void addLecture(ILecture lecture) {

        if(this.lectures == null){
            this.lectures = new ArrayList<ILecture>();
        }

        this.lectures.add(lecture);
    }

    @Override
    public List<IMembership> getMemberships() {
        return memberships;
    }

    @Override
    public void setMemberships(List<IMembership> memberships) {
        this.memberships = memberships;
    }

    @Override
    public void addMembership(IMembership membership) {

        if(this.memberships == null){
            this.memberships = new ArrayList<IMembership>();
        }

        this.memberships.add(membership);
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
