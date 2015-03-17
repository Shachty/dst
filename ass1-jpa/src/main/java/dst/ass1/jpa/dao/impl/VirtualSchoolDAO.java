package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.IVirtualSchoolDAO;
import dst.ass1.jpa.model.IVirtualSchool;

import javax.persistence.EntityManager;
import java.util.List;

public class VirtualSchoolDAO implements IVirtualSchoolDAO {
    public VirtualSchoolDAO(EntityManager em) {

    }

    @Override
    public IVirtualSchool findById(Long id) {
        return null;
    }

    @Override
    public List<IVirtualSchool> findAll() {
        return null;
    }
}
