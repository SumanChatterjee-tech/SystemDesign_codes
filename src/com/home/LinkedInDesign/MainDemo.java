package com.home.LinkedInDesign;

import java.sql.Timestamp;
import java.util.Arrays;

public class MainDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedInServceDemo demo = new LinkedInServceDemo();
		User user1 = new User(1, "John Doe", "john@example.com", "password", new Profile());
		User user2 = new User(2, "Jane Smith", "jane@example.com", "password", new Profile());

		demo.registerUser(user1);
		demo.registerUser(user2);

		// User login
		User loggedInUser = demo.loginUser("john@example.com", "password");
		if (loggedInUser != null) {
			System.out.println("User logged in: " + loggedInUser.getName());
		} else {
			System.out.println("Invalid email or password.");
		}
		
		// Update user profile
        Profile profile = new Profile();
        profile.setHeadline("Software Engineer");
        profile.setSummary("Passionate about coding and problem-solving.");
        loggedInUser.setProfile(profile);
        demo.updateUserProfile(loggedInUser);
        
        //sending a connection
        demo.sendConnectrionRequest(user1, user2);
        
        //accept Connection
        Connnection connection = new Connnection(user1);
        demo.acceptConnectionRequest(user2, connection);
        //demo.DeniedConnectionRequest(user, connection);
        
        //post a job
        JobPosting jobPosting = new JobPosting("1", "Software Developer", "We are hiring!", Arrays.asList("Java", "Python"), "San Francisco", new Timestamp(System.currentTimeMillis()), user1);
        demo.postJobListing(jobPosting);
        
        demo.sendMessage(user2, user1, "Jane Smith sends hi to John Doe");
	}

}
