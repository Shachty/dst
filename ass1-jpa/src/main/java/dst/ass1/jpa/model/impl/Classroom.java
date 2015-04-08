package dst.ass1.jpa.model.impl;

import dst.ass1.jpa.listener.ClassroomListener;
import dst.ass1.jpa.model.IClassroom;
import dst.ass1.jpa.model.ILectureStreaming;
import dst.ass1.jpa.model.IVirtualSchool;
import dst.ass1.jpa.validator.StudentCapacity;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static dst.ass1.jpa.util.Constants.I_STREAMING;

@Entity
@EntityListeners(ClassroomListener.class)
public class Classroom implements IClassroom {

    private Long id;

    @Column(unique = true)
    @Size(min = 5, max = 25)
    private String name;

    @StudentCapacity(min = 40 , max = 80)
    private int studentCapacity;

    @Pattern(regexp = "[A-Z]{3}-[A-Z]{3}@\\d{4,}")
    private String region;

    @Past
    private Date activated;
    @Past
    private Date lastUpdated;

    private IVirtualSchool virtualSchool;


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
        return studentCapacity;
    }

    @Override
    public void setStudentCapacity(Integer studentCapacity) {
        this.studentCapacity = studentCapacity;
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
        if(this.lectureStreamings == null){
            this.lectureStreamings = new ArrayList<ILectureStreaming>();
        }

            this.lectureStreamings.add(streaming);
    }
}
