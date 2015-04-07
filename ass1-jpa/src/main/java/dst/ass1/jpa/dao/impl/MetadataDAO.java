package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.IMetadataDAO;
import dst.ass1.jpa.model.IMetadata;
import dst.ass1.jpa.model.impl.Metadata;

import javax.persistence.EntityManager;
import java.util.List;

public class MetadataDAO implements IMetadataDAO {

    private EntityManager em;
    private static final String GET_ALL_QUERY = "SELECT m FROM Metadata m";

    public MetadataDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public IMetadata findById(Long id) {

        System.out.println(this.getClass().toString() + " : findById");
        return this.em.find(Metadata.class, id);
    }

    @Override
    public List<IMetadata> findAll() {

        System.out.println(this.getClass().toString() + " : findAll");
        return em.createQuery(GET_ALL_QUERY,IMetadata.class).getResultList();
    }
}
