package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.IModeratorDAO;
import dst.ass1.jpa.model.IModerator;
import dst.ass1.jpa.model.IVirtualSchool;
import dst.ass1.jpa.model.impl.Moderator;
import dst.ass1.jpa.model.impl.VirtualSchool;
import dst.ass1.jpa.util.Constants;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ModeratorDAO implements IModeratorDAO {

    private EntityManager em;
    private static final String GET_ALL_QUERY = "SELECT m FROM Moderator m";
    public ModeratorDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public HashMap<IModerator, Date> findNextVirtualSchoolMaintenanceByModerators() {
        List<IModerator> moderators = em.createNamedQuery(Constants.Q_VIRTUALSCHOOLSOFMODERATOR, IModerator.class).getResultList();

        HashMap<IModerator, Date> ret = new HashMap<>();

        for(IModerator moderator : moderators){
            if(!moderator.getAdvisedVirtualSchools().isEmpty()) {
                ret.put(moderator, getNextMaintenanceDate(moderator));
            }
        }

   //     List<VirtualSchool> virtualSchools = em.createNamedQuery("virtualSchoolsByAlex", VirtualSchool.class).getResultList();
        return ret;
    }

    @Override
    public IModerator findById(Long id) {
        return this.em.find(Moderator.class, id);
    }

    @Override
    public List<IModerator> findAll() {
        return em.createQuery(GET_ALL_QUERY,IModerator.class).getResultList();
    }

    private Date getNextMaintenanceDate(IModerator moderator){

        Date date = null;

        for(IVirtualSchool virtualSchool : moderator.getAdvisedVirtualSchools()){
            if(date == null){date = virtualSchool.getNextMaintenance();}
            if(virtualSchool.getNextMaintenance().before(date)){
                date = virtualSchool.getNextMaintenance();
            }
        }
        return date;
    }
}
