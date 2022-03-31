package com.ts.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.rest.dto.Employee;
import com.rest.dto.TweetsDemo2;
import com.ts.db.HibernateTemplate;

public class TweetsDAO {

	private SessionFactory factory = null;
	
	public TweetsDemo2 getImages(String url) {

		return (TweetsDemo2)HibernateTemplate.getObjectByUserName(url);
	}

	public int register(TweetsDemo2 tweets) {
		/*java.util.Date utilDate = new java.sql.Date(employee.getJoinDate().getTime()); */
		return HibernateTemplate.addObject(tweets);
	}

	public List<TweetsDemo2> getAllUrls() {
		List<TweetsDemo2> images=(List)HibernateTemplate.getObjectListByQuery("From TweetsDemo2");
		System.out.println("Inside All Employees ..."+images);
		return images;	
	}

	/*public TweetsDemo2 getTweets(int id) {
		return (Employee)HibernateTemplate.getObject(Employee.class,id);
	}*/
}
