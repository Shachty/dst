package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.IVirtualSchoolDAO;
import dst.ass1.jpa.model.IVirtualSchool;
import dst.ass1.jpa.model.impl.VirtualSchool;

import javax.persistence.EntityManager;
import java.util.List;

public class VirtualSchoolDAO implements IVirtualSchoolDAO {

    private static String GET_BY_ID_QUERY_NAME = "GetByIdVirtualSchool";
    private EntityManager em;

    public VirtualSchoolDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public IVirtualSchool findById(Long id) {

       return this.em.createNamedQuery(GET_BY_ID_QUERY_NAME, VirtualSchool.class).setParameter("id", id).getSingleResult();

    }

    @Override
    public List<IVirtualSchool> findAll() {
        return null;
    }
}
