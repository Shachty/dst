package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.IMembershipDAO;
import dst.ass1.jpa.model.ILecturer;
import dst.ass1.jpa.model.IMOCPlatform;
import dst.ass1.jpa.model.IMembership;
import dst.ass1.jpa.model.impl.Membership;

import javax.persistence.EntityManager;
import java.util.List;

public class MembershipDAO implements IMembershipDAO {
    private EntityManager em;
    private static final String GET_ALL_QUERY = "SELECT m FROM Membership m";

    public MembershipDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<IMembership> findByLecturerAndPlatform(ILecturer lecturer, IMOCPlatform platform) {
        return null;
    }

    @Override
    public IMembership findById(Long id) {
        System.out.println(this.getClass().toString() + " : findById");
        return this.em.find(Membership.class, id);
    }

    @Override
    public List<IMembership> findAll() {
        System.out.println(this.getClass().toString() + " : findAll");
        return em.createQuery(GET_ALL_QUERY,IMembership.class).getResultList();
    }
}
