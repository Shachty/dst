package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.IMOCPlatformDAO;
import dst.ass1.jpa.model.IMOCPlatform;
import dst.ass1.jpa.model.impl.MOCPlatform;

import javax.persistence.EntityManager;
import java.util.List;

public class MOCPlatformDAO implements IMOCPlatformDAO {

    private EntityManager em;
    private static final String GET_ALL_QUERY = "SELECT m FROM MOCPlatform m";
    public MOCPlatformDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<IMOCPlatform> findByName(String name) {
        return null;
    }

    @Override
    public IMOCPlatform findById(Long id) {
       return this.em.find(MOCPlatform.class, id);
       }

    @Override
    public List<IMOCPlatform> findAll() {
        return em.createQuery(GET_ALL_QUERY,IMOCPlatform.class).getResultList();
    }
}
