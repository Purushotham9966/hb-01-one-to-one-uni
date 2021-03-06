package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;



public class DeleteDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().
				addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		try {
			int theId=1;

			session.beginTransaction();
			Instructor tempInstructor=session.get(Instructor.class, theId);
			if(tempInstructor != null) {
				session.delete(tempInstructor);
			}
			session.getTransaction().commit();

			System.out.println("done");

		}finally{
			factory.close();
		}

	}

}
