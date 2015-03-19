package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.ILectureDAO;
import dst.ass1.jpa.model.ILecture;
import dst.ass1.jpa.model.impl.Lecture;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

public class LectureDAO implements ILectureDAO {

    private EntityManager em;
    private static final String GET_ALL_QUERY = "SELECT l FROM Lecture l";

    public LectureDAO(EntityManager em) {
        this.em = em;
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
    return this.em.find(Lecture.class, id);
    }

    @Override
    public List<ILecture> findAll() {
     return em.createQuery(GET_ALL_QUERY,ILecture.class).getResultList();
    }
}
