package dst.ass1.jpa.model.impl;

import dst.ass1.jpa.model.IClassroom;
import dst.ass1.jpa.model.ILectureStreaming;
import dst.ass1.jpa.model.IVirtualSchool;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "classroom")
public class Classroom implements IClassroom {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    private int studenCapacity;
    private String region;
    private Date activated;
    private Date lastUpdated;

    @ManyToOne
    private IVirtualSchool virtualSchool;

    @ManyToMany
    private  List<ILectureStreaming> lectureStreamings;

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
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getStudentCapacity() {
        return studenCapacity;
    }

    @Override
    public void setStudentCapacity(Integer studentCapacity) {
        this.studenCapacity = studentCapacity;
    }

    @Override
    public String getRegion() {
        return region;
    }

    @Override
    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public Date getActivated() {
        return activated;
    }

    @Override
    public void setActivated(Date activated) {
        this.activated = activated;
    }

    @Override
    public Date getLastUpdate() {
        return lastUpdated;
    }

    @Override
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdated = lastUpdate;
    }

    @Override
    public IVirtualSchool getVirtualSchool() {
        return virtualSchool;
    }

    @Override
    public void setVirtualSchool(IVirtualSchool virtualSchool) {
        this.virtualSchool = virtualSchool;
    }

    @Override
    public List<ILectureStreaming> getLectureStreamings() {
        return lectureStreamings;
    }

    @Override
    public void setLectureStreamings(List<ILectureStreaming> streamings) {
            this.lectureStreamings = streamings;
    }

    @Override
    public void addLectureStreaming(ILectureStreaming streaming) {
            this.lectureStreamings.add(streaming);
    }
}
