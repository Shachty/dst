package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.ILectureStreamingDAO;
import dst.ass1.jpa.model.ILectureStreaming;
import dst.ass1.jpa.model.LectureStatus;
import dst.ass1.jpa.model.impl.LectureStreaming;

import javax.persistence.EntityManager;
import java.util.List;

public class LectureStreamingDAO implements ILectureStreamingDAO {
    private EntityManager em;
    private static final String GET_ALL_QUERY = "SELECT l FROM LectureStreaming l";
    public LectureStreamingDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<ILectureStreaming> findByStatus(LectureStatus status) {
        return null;
    }

    @Override
    public ILectureStreaming findById(Long id) {

        System.out.println(this.getClass().toString() + " : findById");
        return this.em.find(LectureStreaming.class, id);
    }

    @Override
    public List<ILectureStreaming> findAll() {
        System.out.println(this.getClass().toString() + " : findAll");
        return em.createQuery(GET_ALL_QUERY,ILectureStreaming.class).getResultList();
    }
}
