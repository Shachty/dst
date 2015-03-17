package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.IClassroomDAO;
import dst.ass1.jpa.model.IClassroom;
import dst.ass1.jpa.model.IMOCPlatform;

import java.util.List;

public class ClassroomDAO implements IClassroomDAO {
    @Override
    public List<IClassroom> findByPlatform(IMOCPlatform platform) {
        return null;
    }

    @Override
    public IClassroom findById(Long id) {
        return null;
    }

    @Override
    public List<IClassroom> findAll() {
        return null;
    }
}
