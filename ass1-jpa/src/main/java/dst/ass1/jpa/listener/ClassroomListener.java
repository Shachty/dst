package dst.ass1.jpa.listener;

import dst.ass1.jpa.model.IClassroom;
import dst.ass1.jpa.model.impl.Classroom;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;


public class ClassroomListener {

    @PrePersist
	public void setFields(Classroom classroom){

        System.out.println(this.getClass().toString() + " : prePersist : Fields are getting set with new Date");

        classroom.setActivated(new Date());
        classroom.setLastUpdate(new Date());



    }

    @PreUpdate
    public void updateField(Classroom classroom){

        System.out.println(this.getClass().toString() + " : preUpdate : Field is getting updated with new Date");

        classroom.setLastUpdate(new Date());
    }
	
}
