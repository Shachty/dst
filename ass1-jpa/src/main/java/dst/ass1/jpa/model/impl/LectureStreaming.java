package dst.ass1.jpa.model.impl;

import dst.ass1.jpa.model.IClassroom;
import dst.ass1.jpa.model.ILecture;
import dst.ass1.jpa.model.ILectureStreaming;
import dst.ass1.jpa.model.LectureStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class LectureStreaming implements ILectureStreaming {

    @Id
    @GeneratedValue
    private Long id;

    private Date start;
    private  Date end;
    private LectureStatus lectureStatus;

    @ManyToMany(targetEntity = Classroom.class)
    @JoinTable(name = "streaming_classroom", joinColumns = {@JoinColumn(name = "lecturestreamings_id")}
            ,inverseJoinColumns = {@JoinColumn(name = "classrooms_id")})
    private List<IClassroom> classrooms;

    @OneToOne(targetEntity = Lecture.class)
    private  ILecture lecture;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Date getStart() {
        return start;
    }

    @Override
    public void setStart(Date start) {
            this.start = start;
    }

    @Override
    public Date getEnd() {
        return end;
    }

    @Override
    public void setEnd(Date end) {
        this.end = end;
    }

    @Override
    public LectureStatus getStatus() {
        return lectureStatus;
    }

    @Override
    public void setStatus(LectureStatus status) {
        this.lectureStatus = status;
    }

    @Override
    public List<IClassroom> getClassrooms() {
        return null;
    }

    @Override
    public void setClassrooms(List<IClassroom> list) {
        this.classrooms = list;
    }

    @Override
    public void addClassroom(IClassroom classroom) {

        if(this.classrooms == null){
            this.classrooms = new ArrayList<IClassroom>();
        }

        this.classrooms.add(classroom);
    }

    @Override
    public ILecture getLecture() {
        return lecture;
    }

    @Override
    public void setLecture(ILecture lecture) {
        this.lecture = lecture;
    }
}
