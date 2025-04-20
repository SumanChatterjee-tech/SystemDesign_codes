package com.home.SocialNetworkingSite;

import java.util.ArrayList;
import java.util.List;

public class User implements Observer{
    private final String id;
    private final String name;
    private final String email;
    private final String password;
    private final String profilePicture;
    private final String bio;
    private final List<String> friends;
    private final List<Post> posts;
    
	public User(String id, String name, String email, String password, String profilePicture, String bio) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.profilePicture = profilePicture;
		this.bio = bio;
		this.friends = new ArrayList<>();
		this.posts =  new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public String getBio() {
		return bio;
	}

	public List<String> getFriends() {
		return friends;
	}

	public List<Post> getPosts() {
		return posts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", profilePicture="
				+ profilePicture + ", bio=" + bio + ", friends=" + friends + "]";
	}

	@Override
	public void updateNotification(Notification notification) {
		System.out.println(this.name +" has been notified from "+ notification.getUserId() +" about "+ notification.getType());
	}
}
