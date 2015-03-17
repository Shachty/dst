package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.IMembershipDAO;
import dst.ass1.jpa.model.ILecturer;
import dst.ass1.jpa.model.IMOCPlatform;
import dst.ass1.jpa.model.IMembership;

import javax.persistence.EntityManager;
import java.util.List;

public class MembershipDAO implements IMembershipDAO {
    public MembershipDAO(EntityManager em) {

    }

    @Override
    public List<IMembership> findByLecturerAndPlatform(ILecturer lecturer, IMOCPlatform platform) {
        return null;
    }

    @Override
    public IMembership findById(Long id) {
        return null;
    }

    @Override
    public List<IMembership> findAll() {
        return null;
    }
}
