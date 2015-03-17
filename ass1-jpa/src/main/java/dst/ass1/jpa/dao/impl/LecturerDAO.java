package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.ILecturerDAO;
import dst.ass1.jpa.model.ILecturer;

import javax.persistence.EntityManager;
import java.util.List;

public class LecturerDAO implements ILecturerDAO {
    public LecturerDAO(EntityManager em) {

    }

    @Override
    public List<ILecturer> findByName(String lecturerName) {
        return null;
    }

    @Override
    public ILecturer findById(Long id) {
        return null;
    }

    @Override
    public List<ILecturer> findAll() {
        return null;
    }
}
