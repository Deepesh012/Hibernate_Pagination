package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.ProjectWithMaven.Student;

public class HQLPagination {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Query query = session.createQuery("from Student");
		
		//implements pagination using hibernate
		query.setFirstResult(6);
		query.setMaxResults(6);
		
		List<Student> list = query.list();
		for (Student student : list) {
			System.out.println(student.getId()+" : "+student.getName()+" : "+student.getCity());
		}
		
		
		
		session.close();
		factory.close();
	}
	
}
