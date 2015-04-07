package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.ILectureDAO;
import dst.ass1.jpa.model.ILecture;
import dst.ass1.jpa.model.LectureStatus;
import dst.ass1.jpa.model.impl.Lecture;
import dst.ass1.jpa.model.impl.LectureStreaming;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

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

        Criteria criteria = em.unwrap(org.hibernate.Session.class).createCriteria(ILecture.class, "lecture").createCriteria("lecture.metadata", "metadata").createCriteria("lecture.lecturer", "lecturer");

        if(lecturerName != null){
            criteria.add(Restrictions.eq("lecturer.lecturerName", lecturerName));
        }

        if(course != null){
            criteria.add(Restrictions.eq("metadata.course", course));
        }

      //  criteria.add(lecturerName == null ? Restrictions.isNull("lecturer.lecturerName") : Restrictions.eq("lecturer.lecturerName", lecturerName));
      //  criteria.add(course == null ? Restrictions.isNull("metadata.course") : Restrictions.eq("metadata.course", course));
        List<ILecture> lectures = criteria.list();


        return lectures;
    }

    @Override
    public List<ILecture> findLecturesForStatusFinishedStartandFinish(Date start, Date finish) {

        LectureStreaming lectureStreaming = new LectureStreaming();
        lectureStreaming.setStatus(LectureStatus.FINISHED);

        if(start != null){
            lectureStreaming.setStart(start);
        }

        if(finish != null){
            lectureStreaming.setEnd(finish);
        }

        ILecture lecture = new Lecture();
        lecture.setLectureStreaming(lectureStreaming);

        Example example =   Example.create(lecture).excludeZeroes().excludeProperty("isPaid");


        List<ILecture> lectures = em.unwrap(org.hibernate.Session.class).createCriteria(ILecture.class, "lecture").add(
                example).createCriteria("lectureStreaming").add(Example.create(lecture.getLectureStreaming())).list();

        return lectures;
    }

    @Override
    public ILecture findById(Long id) {
        System.out.println(this.getClass().toString() + " : findById");
        return this.em.find(Lecture.class, id);
    }

    @Override
    public List<ILecture> findAll() { System.out.println(this.getClass().toString() + " : findByAll");
        return em.createQuery(GET_ALL_QUERY, ILecture.class).getResultList();
    }
}
