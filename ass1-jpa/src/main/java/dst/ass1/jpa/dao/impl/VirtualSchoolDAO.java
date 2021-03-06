package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.IVirtualSchoolDAO;
import dst.ass1.jpa.model.IVirtualSchool;
import dst.ass1.jpa.model.impl.VirtualSchool;

import javax.persistence.EntityManager;
import java.util.List;

public class VirtualSchoolDAO implements IVirtualSchoolDAO {

    private EntityManager em;
    private static final String GET_ALL_QUERY = "SELECT v FROM VirtualSchool v";
    public VirtualSchoolDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public IVirtualSchool findById(Long id) {
        System.out.println(this.getClass().toString() + " : findById");
        return this.em.find(VirtualSchool.class, id);
    }

    @Override
    public List<IVirtualSchool> findAll() {
        System.out.println(this.getClass().toString() + " : findAll");
        return em.createQuery(GET_ALL_QUERY,IVirtualSchool.class).getResultList();
    }
}
