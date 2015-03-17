package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.IMetadataDAO;
import dst.ass1.jpa.model.IMetadata;

import javax.persistence.EntityManager;
import java.util.List;

public class MetadataDAO implements IMetadataDAO {
    public MetadataDAO(EntityManager em) {

    }

    @Override
    public IMetadata findById(Long id) {
        return null;
    }

    @Override
    public List<IMetadata> findAll() {
        return null;
    }
}
