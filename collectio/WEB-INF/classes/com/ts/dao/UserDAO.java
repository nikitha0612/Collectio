package com.ts.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.rest.dto.Employee;
import com.rest.dto.TweetsDemo2;
import com.rest.dto.UserInfo;
import com.ts.db.HibernateTemplate;

public class UserDAO {

	private SessionFactory factory = null;
	
	public UserInfo getUser(String user1) {

		return (UserInfo)HibernateTemplate.getObjectByUserName(user1);
	}
	public int register(UserInfo user) {
		/*java.util.Date utilDate = new java.sql.Date(user.getTime()); */
		return HibernateTemplate.addObject(user);
	}


	public List<UserInfo> getUsers() {
		List<UserInfo> users=(List)HibernateTemplate.getObjectListByQuery("From UserInfo");
		System.out.println("Inside All Users ..."+users);
		return users;	
	}

	/*public List<TweetsDemo2> getImages() {
		List<TweetsDemo2> images=(List)HibernateTemplate.getObjectListByQuery("From TweetsDemo2");
		System.out.println("Inside All Users ..."+images);
		return images;	
	}
*/
	public UserInfo getUser1(int id) {
		return (UserInfo)HibernateTemplate.getObject(UserInfo.class,id);
	}
}