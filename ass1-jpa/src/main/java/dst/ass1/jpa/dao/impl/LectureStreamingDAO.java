package dst.ass1.jpa.dao.impl;

import dst.ass1.jpa.dao.ILectureStreamingDAO;
import dst.ass1.jpa.model.ILectureStreaming;
import dst.ass1.jpa.model.LectureStatus;

import java.util.List;

public class LectureStreamingDAO implements ILectureStreamingDAO {
    @Override
    public List<ILectureStreaming> findByStatus(LectureStatus status) {
        return null;
    }

    @Override
    public ILectureStreaming findById(Long id) {
        return null;
    }

    @Override
    public List<ILectureStreaming> findAll() {
        return null;
    }
}
