package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.ILecturerDAO;
import dst.ass1.jpa.model.ILecturer;
import dst.ass1.jpa.model.impl.Lecturer;

import javax.persistence.EntityManager;
import java.util.List;

public class LecturerDAO implements ILecturerDAO {

    private EntityManager em;
    private static final String GET_ALL_QUERY = "SELECT l FROM Lecturer l";
    public LecturerDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<ILecturer> findByName(String lecturerName) {
        return null;
    }

    @Override
    public ILecturer findById(Long id) {
        System.out.println(this.getClass().toString() + " : findById");
     return this.em.find(Lecturer.class, id);
    }

    @Override
    public List<ILecturer> findAll() {
        System.out.println(this.getClass().toString() + " : findAll");

        return em.createQuery(GET_ALL_QUERY,ILecturer.class).getResultList();
    }
}
