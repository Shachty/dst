package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.IClassroomDAO;
import dst.ass1.jpa.model.IClassroom;
import dst.ass1.jpa.model.IMOCPlatform;
import dst.ass1.jpa.model.impl.Classroom;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import java.util.List;

public class ClassroomDAO implements IClassroomDAO {
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
       return this.em.find(Classroom.class, id);
    }

    @Override
    public List<IClassroom> findAll() {
        return null;
    }
}
