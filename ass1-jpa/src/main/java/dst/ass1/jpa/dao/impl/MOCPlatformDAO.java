package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.IMOCPlatformDAO;
import dst.ass1.jpa.model.IMOCPlatform;

import javax.persistence.EntityManager;
import java.util.List;

public class MOCPlatformDAO implements IMOCPlatformDAO {

    private EntityManager em;

    public MOCPlatformDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<IMOCPlatform> findByName(String name) {
        return null;
    }

    @Override
    public IMOCPlatform findById(Long id) {
        return null;
    }

    @Override
    public List<IMOCPlatform> findAll() {
        return null;
    }
}
