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

    private static Map<Object, Date> persistTimes = new HashMap<>();
    private static Map<Object, Date> updateTimes = new HashMap<>();
    private static Map<Object, Date> removeTimes = new HashMap<>();


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
		return overallTimeToPersist/ (double)persistOperations;
	}

	public static void clear() {
		loadOoperations = 0;
        updateOperations = 0;
        removeOperations = 0;
        persistOperations = 0;
        overallTimeToPersist = 0;
	}

    @PrePersist
    private void onPrePersist(Object o) {

        synchronized (persistTimes){
            persistTimes.put(o, new Date());
        }

    }
    @PreUpdate
    private void onPreUpdate(Object o) {

        synchronized (updateTimes){
            updateTimes.put(o, new Date());
        }

    }
    @PreRemove
    private void onPreDelete(Object o) {

        synchronized (removeTimes){
            removeTimes.put(o, new Date());
        }

    }


    @PostPersist
    private void onPostPersist(Object o) {


        synchronized (persistTimes){
            if(persistTimes.containsKey(o)){
                overallTimeToPersist += new Date().getTime() - persistTimes.get(o).getTime();
                persistTimes.remove(o);
                persistOperations++;
            }
        }

    }


    @PostUpdate
    void onPostUpdate(Object o) {

        synchronized (updateTimes){
            if(updateTimes.containsKey(o)){
                overallTimeToPersist += new Date().getTime() - updateTimes.get(o).getTime();
                updateTimes.remove(o);
                updateOperations++;
            }
        }
    }

    @PostRemove
    void onPostRemove(Object o) {

        synchronized (removeTimes){
            if(removeTimes.containsKey(o)){
                overallTimeToPersist += new Date().getTime() - removeTimes.get(o).getTime();
                removeTimes.remove(o);
                removeOperations++;
            }
        }
    }

    @PostLoad
    void onPostLoad(Object o) {
        loadOoperations++;
    }
}
