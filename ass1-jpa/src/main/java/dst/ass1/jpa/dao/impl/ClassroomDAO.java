package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.IClassroomDAO;
import dst.ass1.jpa.model.IClassroom;
import dst.ass1.jpa.model.IMOCPlatform;
import dst.ass1.jpa.model.impl.Classroom;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import java.util.List;

public class ClassroomDAO implements IClassroomDAO {

    private static String GET_BY_ID_QUERY_NAME = "GetByIdClassroom";
    private EntityManager em;

    public ClassroomDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<IClassroom> findByPlatform(IMOCPlatform platform) {
        return null;
    }

    @Override
    public IClassroom findById(Long id) {
        return this.em.createNamedQuery(GET_BY_ID_QUERY_NAME, Classroom.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public List<IClassroom> findAll() {
        return null;
    }
}
