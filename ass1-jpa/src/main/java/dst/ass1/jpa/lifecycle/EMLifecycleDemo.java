package dst.ass1.jpa.lifecycle;

import java.security.NoSuchAlgorithmException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transaction;

import dst.ass1.jpa.dao.impl.LectureDAO;
import dst.ass1.jpa.model.*;
import dst.ass1.jpa.model.impl.Lecture;
import dst.ass1.jpa.model.impl.LectureStreaming;
import dst.ass1.jpa.model.impl.Lecturer;
import dst.ass1.jpa.model.impl.Metadata;

public class EMLifecycleDemo {

	private EntityManager em;
	private ModelFactory modelFactory;

    private ILecturer lecturer;
    private IMetadata metadata;
    private ILecture lecture;
    private ILectureStreaming lectureStreaming;
    private long lectureID;

	public EMLifecycleDemo(EntityManager em, ModelFactory modelFactory) {
		this.em = em;
		this.modelFactory = modelFactory;
	}

	/**
	 * Method to illustrate the persistence lifecycle. EntityManager is opened
	 * and closed by the Test-Environment! You have to use at least the
	 * following methods (listed in alphabetical order) provided by the EntityManager:
	 * - clear(..)
	 * - flush(..)
	 * - merge(..)
	 * - persist(..)
	 * - remove(..)
	 * 
	 * Keep in mind that this is not necessarily the correct order!
	 * 
	 * @throws NoSuchAlgorithmException
	 */
	public void demonstrateEntityMangerLifecycle()
			throws NoSuchAlgorithmException {

        long lectureID;
        boolean lectureIsManaged;

        //Lecture
        this.lecture = modelFactory.createLecture();
        lecture.setAttendingStudents(50);
        lecture.setPaid(true);
        lecture.setStreamingTime(50000);

        //Lecturer
        this.lecturer = modelFactory.createLecturer();
        lecturer.setAccountNo("809437509");
        lecturer.setBankCode("123");
        lecturer.setLecturerName("Lecturer");
        lecturer.addLecture(lecture);
        lecturer.setPassword(new byte[]{123});
        lecturer.setFirstName("Max");
        lecturer.setLastName("Lektor");

        //Lecturestreaming
        this.lectureStreaming = modelFactory.createLectureStreaming();
        lecture.setLectureStreaming(modelFactory.createLectureStreaming());

        //Metadata
        this. metadata = modelFactory.createMetadata();
        lecture.setMetadata(metadata);

        lecture.setLecturer(lecturer);


        this.persistDemo();
        this.clearDemo();
        this.mergeDemo();
        this.flushDemo();
        this.removeDemo();

    }

    private void persistDemo(){
        em.getTransaction().begin();

        em.persist(lecturer);
        em.persist(metadata); //has to be done in because of the unidirectional association
     
        em.getTransaction().commit();

        this.lectureID = lecture.getId();

    }

    private void clearDemo(){
        em.getTransaction().begin();

        System.out.println("lecture is managed: " + em.contains(lecture));

        em.clear(); //detaches all items

        System.out.println("lecture is managed: " + em.contains(lecture));

        em.getTransaction().commit();
    }

    private void flushDemo(){

        System.out.println("Flush Demo");

        ILecture lecture1 = em.find(Lecture.class, lectureID);


        em.getTransaction().begin();

        lecture.setAttendingStudents(80);

        System.out.println("lecture1 attending students:" + lecture1.getAttendingStudents());

        em.flush();

   lecture1 = em.find(Lecture.class, lectureID);

        System.out.println("lecture1 attending students:" + lecture1.getAttendingStudents());


        em.getTransaction().commit();


    }

    private void mergeDemo(){

        System.out.println("Merge Demo");

        em.getTransaction().begin();


        lecture.setAttendingStudents(65);
        lecturer.setFirstName("Martha");

        System.out.println("lecture is managed: " + em.contains(lecture));
        System.out.println("attendingStudents: " + em.find(Lecture.class, lectureID).getAttendingStudents());

        System.out.println("lecturer is managed: " + em.contains(lecture));
        System.out.println("firstname of lecturer: " + em.createQuery("SELECT l from Lecturer l", ILecturer.class).getSingleResult().getFirstName());

        em.merge(lecture);

        System.out.println("lecture is managed: " + em.contains(lecture));
        System.out.println("attendingStudents: " + em.find(Lecture.class, lectureID).getAttendingStudents());

        System.out.println("lecturer is managed: " + em.contains(lecture));
        System.out.println("firstname of lecturer: " + em.createQuery("SELECT l from Lecturer l", ILecturer.class).getSingleResult().getFirstName());

        em.getTransaction().commit();

    }

    private void removeDemo(){

        ILecture lecture1 = em.find(Lecture.class, lectureID);

        em.getTransaction().begin();

        System.out.println(em.find(Lecture.class, lectureID));
        em.remove(lecture1);
        em.remove(em.createQuery("SELECT l from Lecturer l", ILecturer.class).getSingleResult());

        System.out.println(em.find(Lecture.class, lectureID));
        em.getTransaction().commit();

    }

}
