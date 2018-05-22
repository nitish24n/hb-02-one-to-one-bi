package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create a session
		Session session = factory.getCurrentSession();
		
		try {
			//create the objects
			//Instructor tempInstructor = new Instructor("Geeta", "Wisvas", "Geeta@luv2code.com");
			//InstructorDetail instructorDetail = new InstructorDetail("https://www.luv2code.com/youtube","Love to code");
			
			Instructor tempInstructor = new Instructor("Karan", "Prakash", "myname@luv2code.com");
			InstructorDetail instructorDetail = new InstructorDetail("https://www.mynewchannel.com/youtube","Guitar");
			
			//associate the objects
			tempInstructor.setInstructorDetail(instructorDetail);

			
			// start a transaction
			session.beginTransaction();
			
			//save the instructor
			//
			// Note : this will also save the details object
			// because of CascadeType.ALL
			System.out.println("Saving Instructor : "+tempInstructor);
			session.save(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
		
	}

}
