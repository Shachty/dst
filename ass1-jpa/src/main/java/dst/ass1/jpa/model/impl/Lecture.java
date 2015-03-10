package dst.ass1.jpa.model.impl;

import dst.ass1.jpa.model.ILecture;
import dst.ass1.jpa.model.ILectureStreaming;
import dst.ass1.jpa.model.ILecturer;
import dst.ass1.jpa.model.IMetadata;

import javax.persistence.*;

@Entity
@Table(name = "lecture")
public class Lecture implements ILecture {

    @Id
    @GeneratedValue
    private Long id;

    private int attendingStudents;
    private boolean isPaid;
    @ManyToOne
    private ILecturer lecturer;

    @OneToOne
    private ILectureStreaming lectureStreaming;

    @OneToOne
    private IMetadata metadata;
    private Integer streamingTime;

    public Lecture(Long id, boolean isPaid, ILecturer lecturer, ILectureStreaming lectureStreaming, IMetadata Metadata) {
        this.id = id;
        this.isPaid = isPaid;
        this.lecturer = lecturer;
        this.lectureStreaming = lectureStreaming;
        this.metadata = Metadata;

        streamingTime = (int) (Math.abs(lectureStreaming.getStart().getTime() - lectureStreaming.getEnd().getTime()) / 1000);
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
    public Integer getStreamingTime() {
        return streamingTime;
    }

    @Override
    public void setStreamingTime(Integer streamingTime) {
        this.streamingTime = streamingTime;
    }

    @Override
    public Integer getAttendingStudents() {
        return attendingStudents;
    }

    @Override
    public void setAttendingStudents(Integer students) {
        this.attendingStudents = students;
    }

    @Override
    public boolean isPaid() {
        return isPaid;
    }

    @Override
    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    @Override
    public IMetadata getMetadata() {
        return metadata;
    }

    @Override
    public void setMetadata(IMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public ILecturer getLecturer() {
        return this.lecturer;
    }

    @Override
    public void setLecturer(ILecturer lecturer) {
        this.lecturer = lecturer;
    }

    @Override
    public ILectureStreaming getLectureStreaming() {
        return this.lectureStreaming;
    }

    @Override
    public void setLectureStreaming(ILectureStreaming streaming) {
        this.lectureStreaming = streaming;
    }
}
