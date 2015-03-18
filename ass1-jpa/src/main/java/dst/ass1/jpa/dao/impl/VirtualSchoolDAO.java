package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.IVirtualSchoolDAO;
import dst.ass1.jpa.model.IVirtualSchool;
import dst.ass1.jpa.model.impl.VirtualSchool;

import javax.persistence.EntityManager;
import java.util.List;

public class VirtualSchoolDAO implements IVirtualSchoolDAO {

    private EntityManager em;

    public VirtualSchoolDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public IVirtualSchool findById(Long id) {
        return this.em.find(VirtualSchool.class, id);
    }

    @Override
    public List<IVirtualSchool> findAll() {
        return null;
    }
}
