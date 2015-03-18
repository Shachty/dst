package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.IModeratorDAO;
import dst.ass1.jpa.model.IModerator;
import dst.ass1.jpa.model.impl.Moderator;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ModeratorDAO implements IModeratorDAO {

    private EntityManager em;

    public ModeratorDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public HashMap<IModerator, Date> findNextVirtualSchoolMaintenanceByModerators() {
        return null;
    }

    @Override
    public IModerator findById(Long id) {
        return this.em.find(Moderator.class, id);
    }

    @Override
    public List<IModerator> findAll() {
        return null;
    }
}
