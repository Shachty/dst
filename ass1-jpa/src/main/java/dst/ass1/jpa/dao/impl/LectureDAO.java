package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.ILectureDAO;
import dst.ass1.jpa.model.ILecture;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

public class LectureDAO implements ILectureDAO {
    public LectureDAO(EntityManager em) {

    }

    @Override
    public List<ILecture> findLecturesForLecturerAndCourse(String lecturerName, String course) {
        return null;
    }

    @Override
    public List<ILecture> findLecturesForStatusFinishedStartandFinish(Date start, Date finish) {
        return null;
    }

    @Override
    public ILecture findById(Long id) {
        return null;
    }

    @Override
    public List<ILecture> findAll() {
        return null;
    }
}
