package dst.ass1.jpa.model.impl;

import dst.ass1.jpa.model.IClassroom;
import dst.ass1.jpa.model.IMOCPlatform;
import dst.ass1.jpa.model.IModerator;
import dst.ass1.jpa.model.IVirtualSchool;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class VirtualSchool implements IVirtualSchool {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    private  Date lastMaintenance;
    private Date nextMaintenance;

    @ManyToMany(targetEntity = VirtualSchool.class)
    @JoinTable(name = "composed_of",
    joinColumns = {@JoinColumn(name = "partOf_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "composedOf_id", referencedColumnName = "id")})
    private List<IVirtualSchool> composedOf;

    @ManyToOne(targetEntity = Moderator.class)
    private IModerator moderator;

    @ManyToMany(targetEntity = VirtualSchool.class, mappedBy = "composedOf")
    private List <IVirtualSchool> partOf;

    @ManyToOne(targetEntity = MOCPlatform.class)
    private  IMOCPlatform mocPlatform;

    @OneToMany(targetEntity = Classroom.class)
    private List<IClassroom> classrooms;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Date getLastMaintenance() {
        return lastMaintenance;
    }

    @Override
    public void setLastMaintenance(Date lastMaintenance) {
        this.lastMaintenance = lastMaintenance;
    }

    @Override
    public Date getNextMaintenance() {
        return nextMaintenance;
    }

    @Override
    public void setNextMaintenance(Date nextMaintenance) {
        this.nextMaintenance = nextMaintenance;
    }

    @Override
    public List<IVirtualSchool> getComposedOf() {
        return composedOf;
    }

    @Override
    public void setComposedOf(List<IVirtualSchool> composedOf) {
        this.composedOf = composedOf;
    }

    @Override
    public void addComposedOf(IVirtualSchool virtualSchool) {

        if(composedOf == null){
            composedOf = new ArrayList<IVirtualSchool>();
        }
        this.composedOf.add(virtualSchool);
    }

    @Override
    public List<IVirtualSchool> getPartOf() {
        return partOf;
    }

    @Override
    public void setPartOf(List<IVirtualSchool> partOf) {
        this.partOf = partOf;
    }

    @Override
    public void addPartOf(IVirtualSchool virtualSchool) {

        if(this.partOf == null){
            this.partOf = new ArrayList<IVirtualSchool>();
        }

        this.partOf.add(virtualSchool);
    }

    @Override
    public List<IClassroom> getClassrooms() {
        return classrooms;
    }

    @Override
    public void setClassrooms(List<IClassroom> classrooms) {
        this.classrooms = classrooms;
    }

    @Override
    public void addClassroom(IClassroom classroom) {

        if(this.classrooms == null){
            this.classrooms = new ArrayList<IClassroom>();
        }

        this.classrooms.add(classroom);
    }

    @Override
    public IModerator getModerator() {
        return moderator;
    }

    @Override
    public void setModerator(IModerator moderator) {
        this.moderator = moderator;
    }

    @Override
    public IMOCPlatform getMOCPlatform() {
        return mocPlatform;
    }

    @Override
    public void setMOCPlatform(IMOCPlatform platform) {
        this.mocPlatform = platform;
    }
}
