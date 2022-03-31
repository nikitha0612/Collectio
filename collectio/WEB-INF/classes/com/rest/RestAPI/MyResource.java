package com.rest.RestAPI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.dto.TweetsDemo2;
import com.rest.dto.UserInfo;
import com.ts.dao.UserDAO;

import twitter4j.MediaEntity;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Path("myresource")
public class MyResource {
	@Path("hi")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hi() {
		return "Hi Service!";
	}

	@Path("hello")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "Hello Service!";
	}

	/*@Path("getEmployee")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Employee getEmployee() {
        Employee employee = new Employee(100,"PASHA",9999.99);
    	return employee;
    }*/

	@Path("getUserJ")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public UserInfo getUserJ() {
		//Employee employee = new Employee(100,"PASHA",9999.99);
		return null;
	}
	/*@Path("getAllUrls")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TweetsDemo2> getAllUrls() {
		TweetsDAO tweetsDAO = new TweetsDAO();
		List <TweetsDemo2> imagesList = tweetsDAO.getAllUrls();

		return imagesList;
	}*/
	

	
	@Path("getUsers")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserInfo> getUsers() {
		/* Employee employee1 = new Employee();
        employee1.setEmpId(100);
        employee1.setEmpName("PASHA");
        employee1.setSalary(9999.99);

        Department dept = new Department();
        dept.setDeptId(10);
        dept.setDeptName("ACCOUNTS");
        dept.setLocation("HYDERABAD");
        employee1.setDepartment(dept);

        Employee employee2 = new Employee();
        employee2.setEmpId(101);
        employee2.setEmpName("VENKAT");
        employee2.setSalary(8888.88);
        employee2.setDepartment(dept);

        Employee employee3 = new Employee();
        employee3.setEmpId(102);
        employee3.setEmpName("HARSHA");
        employee3.setSalary(5555.55);

        Department dept2 = new Department();
        dept2.setDeptId(20);
        dept2.setDeptName("COMPUTERS");
        dept2.setLocation("GACHIBOWLI");
        employee3.setDepartment(dept2);

        Employee employee4 = new Employee();
        employee4.setEmpId(104);
        employee4.setEmpName("GOPI");
        employee4.setSalary(3333.33);
        employee4.setDepartment(dept2);

       	empList.add(employee1);
        empList.add(employee2);
        empList.add(employee3);
        empList.add(employee4);
		 */

		UserDAO userDAO = new UserDAO();
		List <UserInfo> userList = userDAO.getUsers();

		return userList;
	}

	/*@Path("getDepartments")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Department> getDepartments() {
	 */   
	/*Department dept1 = new Department();
        dept1.setDeptId(1);
        dept1.setDeptName("ACCOUNTS");
        dept1.setLocation("HYDERABAD");

        Department dept2 = new Department();
        dept2.setDeptId(2);
        dept2.setDeptName("COMPUTERS");
        dept2.setLocation("GACHIBOWLI");

    	Employee employee1 = new Employee();
        employee1.setEmpId(100);
        employee1.setEmpName("PASHA");
        employee1.setSalary(9999.99);
        employee1.setDepartment(dept1);

        Employee employee2 = new Employee();
        employee2.setEmpId(101);
        employee2.setEmpName("VENKAT");
        employee2.setSalary(8888.88);
        employee2.setDepartment(dept1);

        Employee employee3 = new Employee();
        employee3.setEmpId(102);
        employee3.setEmpName("HARSHA");
        employee3.setSalary(8989.89);
        employee3.setDepartment(dept2);

        Employee employee4 = new Employee();
        employee4.setEmpId(103);
        employee4.setEmpName("GOPI");
        employee4.setSalary(7777.77);
        employee4.setDepartment(dept2);


        dept1.getEmpList().add(employee1);
        dept1.getEmpList().add(employee2);
        dept2.getEmpList().add(employee3);
        dept2.getEmpList().add(employee4);

        List <Department> deptList = new ArrayList<Department>();
        deptList.add(dept1);
        deptList.add(dept2);
	 */        
	
	/* DeptDAO deptDao = new DeptDAO();
    	List <Department> deptList = deptDao.getAllDepts();
         return deptList;
    }
	 */

	@Path("register")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void register(@FormParam("userId") int userId,@FormParam("email") String email,@FormParam("firstName") String firstName,@FormParam("lastName") String lastName,@FormParam("setPassword") String setPassword,@FormParam("confirmPassword") String confirmPassword) {
		System.out.println(userId+" "+email+" "+firstName+" "+lastName+" "+setPassword+" "+confirmPassword);

	}

	@Path("registerJ")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void registerJ(UserInfo user) {
		System.out.println("Inside REST...");
		UserDAO userDAO = new UserDAO();
		userDAO.register(user); //send to database code 
		System.out.println(user.getUserId()+" "+user.getEmail()+" "+user.getFirstName()+" "+user.getLastName()+" "+user.getSetPassword()+" "+user.getConfirmPassword());
	}


	@Path("tweetSearch/{hashTag}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
public ArrayList<MediaEntity> tweetSearch(@PathParam("hashTag") String hashTag) {
		System.out.println("Inside REST "+hashTag);
		ArrayList<MediaEntity> a = new ArrayList<MediaEntity>();
		TweetsDemo2 t = new TweetsDemo2();
		try {
			a = searchTweets(getTwitterInstance(), "#"+hashTag);
		} catch (TwitterException e) {
			System.out.println("Exception ...occurred..");
			// TODO Auto-gen3erated catch block
			e.printStackTrace();
		}
		return a; 
	}

	public static Twitter getTwitterInstance() {
		System.out.println("REST Called....");
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		.setOAuthConsumerKey("5rcI37xurBl17PBezmHAJTcL3")
		.setOAuthConsumerSecret("BUtdYINYImznyLOa0Z0goXMQku96EqJzKA7GuSvy0u9XEBQKP2")
		.setOAuthAccessToken("1082907901218443265-IQHmbQdtjrsge59NkZ5ug8hZaeRy6N")
		.setOAuthAccessTokenSecret( "qJcPbZ4mtL1kEzfgnkdQ1qFwEh00tewLjiigG4YXgsjc0");

		TwitterFactory tf = new TwitterFactory(cb.build());
		return tf.getInstance();
	}
	
	static ArrayList<MediaEntity> searchTweets(Twitter twitter, String searchTerm) throws TwitterException {
		
		ArrayList<MediaEntity> a = new ArrayList<MediaEntity>();
		   Query query = new Query("source:" + searchTerm);
		   //System.out.println(query.toString());
		   QueryResult result = twitter.search(query);
		  // ArrayList<MediaEntity> a = new ArrayList<MediaEntity>();
		   for (Status status : result.getTweets()) {
		MediaEntity[] media = status.getMediaEntities();
		for(MediaEntity m : media){
			a.add(m);
		}

		   }
		   System.out.println(a);
		return a;
	}

	
	/*
	@POST
	@Path("/uploadImage")
	@Consumes({MediaType.MULTIPART_FORM_DATA})
	public void uploadImage(@FormDataParam("Image") InputStream fileInputStream, @FormDataParam("Image") FormDataContentDisposition 
    formDataContentDisposition, @FormDataParam("ImageCaption") String caption) throws IOException {
		int read = 0;
	    byte[] bytes = new byte[1024];
	 System.out.println("METHOD CALLED...."+caption);
	    FileOutputStream out = new FileOutputStream(new File("C:/Users/tsuser/RESTAPI_9pm/RestAPI/src/main/webapp/image/", formDataContentDisposition.getFileName()));
	    while ((read = fileInputStream.read(bytes)) != -1) {
	    	out.write(bytes, 0, read);
	    }
	    out.flush();
	    out.close();
	 */
	/*
	    Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setFile(formDataContentDisposition.getFileName());

		students.add(student); 
	 */
	//return Response.ok("Data Submitted Successfully.").build();	    

}


