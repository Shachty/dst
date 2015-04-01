package dst.ass1.jpa.listener;

import dst.ass1.jpa.model.IClassroom;
import dst.ass1.jpa.model.impl.Classroom;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@EntityListeners(value=Classroom.class)
public class ClassroomListener {

    @PrePersist
	public void setFields(IClassroom classroom){

        classroom.setActivated(classroom.getActivated());
        classroom.setLastUpdate(classroom.getLastUpdate());



    }

    @PreUpdate
    public void updateField(IClassroom classroom){

        classroom.setLastUpdate(classroom.getLastUpdate());
    }
	
}
