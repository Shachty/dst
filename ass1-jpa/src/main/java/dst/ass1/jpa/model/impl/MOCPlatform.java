package dst.ass1.jpa.model.impl;

import dst.ass1.jpa.model.ILecturer;
import dst.ass1.jpa.model.IMOCPlatform;
import dst.ass1.jpa.model.IMembership;
import dst.ass1.jpa.model.IVirtualSchool;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "moc_platform")
public class MOCPlatform implements IMOCPlatform {

    @Id
    @GeneratedValue
    private Long id;

    @Column( unique = true)
    private String name;

    private  String url;

    private  BigDecimal costsPerStudent;

    @OneToMany
    private List<IVirtualSchool> virtualSchools;

    @ManyToMany
    private List<ILecturer> lecturers;

    private List<IMembership> memberships;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getUrl() {
        return this.url;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public BigDecimal getCostsPerStudent() {
        return this.costsPerStudent;
    }

    @Override
    public void setCostsPerStudent(BigDecimal costsPerStudent) {
        this.costsPerStudent = costsPerStudent;
    }

    @Override
    public List<IMembership> getMemberships() {
        return this.memberships;
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
    public List<IVirtualSchool> getVirtualSchools() {
        return this.virtualSchools;
    }

    @Override
    public void setVirtualSchools(List<IVirtualSchool> virtualSchools) {
        this.virtualSchools = virtualSchools;
    }

    @Override
    public void addVirtualSchool(IVirtualSchool virtualSchool) {
        this.virtualSchools.add(virtualSchool);
    }
}
