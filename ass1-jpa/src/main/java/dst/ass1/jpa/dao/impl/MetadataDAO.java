package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.IMetadataDAO;
import dst.ass1.jpa.model.IMetadata;
import dst.ass1.jpa.model.impl.Metadata;

import javax.persistence.EntityManager;
import java.util.List;

public class MetadataDAO implements IMetadataDAO {

    private static String GET_BY_ID_QUERY_NAME = "GetByIdMetadata";
    private EntityManager em;

    public MetadataDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public IMetadata findById(Long id) {

        return this.em.createNamedQuery(GET_BY_ID_QUERY_NAME, Metadata.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public List<IMetadata> findAll() {
        return null;
    }
}
