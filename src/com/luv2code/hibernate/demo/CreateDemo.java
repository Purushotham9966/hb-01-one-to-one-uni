package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;



public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure().
				addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		try {
			
//			Instructor tempInstructor=new Instructor("purushotham","reddy","kpr123@gmail.com");
//			
//			InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.lovetocode.com/youtube","love to code");
			
			Instructor tempInstructor=new Instructor("Ravi","reddy","ravi123@gmail.com");
			
			InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.telusko.com/youtube","cricket");
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			session.beginTransaction();
			
			System.out.println("saving instructor:"+tempInstructor);
			session.save(tempInstructor);
			
			session.getTransaction().commit();
			
			System.out.println("done");
			
		}finally{
			factory.close();
		}

	}

}
