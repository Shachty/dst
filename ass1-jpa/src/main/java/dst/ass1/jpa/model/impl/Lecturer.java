package dst.ass1.jpa.model.impl;

import dst.ass1.jpa.model.*;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import java.util.List;

@Entity
@Table (name = "lecturer")
public class Lecturer implements ILecturer {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String lecturerName;
    private byte[] password;

    @Column(unique = true)
    private String accountNo;

    @Column(unique = true)
    private String bankCode;


    @OneToOne(targetEntity = Address.class)
    @PrimaryKeyJoinColumn
    private IAddress address;

    @OneToMany(targetEntity = Lecture.class, mappedBy = "lecturer")
    private List<ILecture> lectures;

    @ManyToMany(targetEntity = MOCPlatform.class)
    private List<IMOCPlatform> mocPlatforms;

    @ManyToOne(targetEntity = Membership.class)
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
        this.address = address;
    }
}
