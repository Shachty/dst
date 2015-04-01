package dst.ass1.jpa.listener;

import dst.ass1.jpa.model.*;
import dst.ass1.jpa.model.impl.Classroom;
import dst.ass1.jpa.model.impl.Lecture;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DefaultListener {

	private static int loadOoperations = 0;
    private static int updateOperations = 0;
    private static int removeOperations = 0;
    private static int persistOperations = 0;
    private static long overallTimeToPersist = 0;

    private Map<IClassroom, Date> classroomPersistTimes = new HashMap<>();
    private Map<IAddress, Date> addressPersistTimes = new HashMap<>();
    private Map<ILecture, Date> lecturePersistTimes = new HashMap<>();
    private Map<ILecturer, Date> lecturerPersistTimes = new HashMap<>();
    private Map<ILectureStreaming, Date> lectureStreamingPersistTimes = new HashMap<>();
    private Map<IMembership, Date> membershipPersistTimes = new HashMap<>();
    private Map<IMetadata, Date> metadataPersistTimes = new HashMap<>();
    private Map<IMOCPlatform, Date> mocPlatformPersistTimes = new HashMap<>();
    private Map<IModerator, Date> moderatorPersistTimes = new HashMap<>();
    private Map<IPerson, Date> personPersistTimes = new HashMap<>();
    private Map<IVirtualSchool, Date> virtualSchoolPersistTimes = new HashMap<>();

	public static int getLoadOperations() {
		return loadOoperations;
	}

	public static int getUpdateOperations() {
		return updateOperations;
	}

	public static int getRemoveOperations() {
		return removeOperations;
	}

	public static int getPersistOperations() {
		return persistOperations;
	}

	public static long getOverallTimeToPersist() {
		return overallTimeToPersist;
	}

	public static double getAverageTimeToPersist() {
		return overallTimeToPersist/persistOperations;
	}

	public static void clear() {
		loadOoperations = 0;
        updateOperations = 0;
        removeOperations = 0;
        persistOperations = 0;
        overallTimeToPersist = 0;
	}

    @PostPersist
   /* private void onPostPersist(IClassroom entity) {
        persistOperations++;

        synchronized (this){
                     classroomPersistTimes.put(entity, new Date());
        }
    }*/


    @PostUpdate
    void onPostUpdate(Object o) {
        updateOperations++;
    }

    @PostRemove
    void onPostRemove(Object o) {
        removeOperations++;
    }

    @PostLoad
    void onPostLoad(Object o) {
        loadOoperations++;
    }
}
