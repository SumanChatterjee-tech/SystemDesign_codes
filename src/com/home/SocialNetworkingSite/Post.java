package com.home.SocialNetworkingSite;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Post {
	private final String id;
	private final String userId;
	private final String content;
	private final List<String> imageUrls;
	private final List<String> videoUrls;
	private final Timestamp timestamp;
	private final List<String> likes;
	private final List<Comment> comments;

	public Post(String id, String userId, String content, List<String> imageUrls, List<String> videoUrls,
			Timestamp timestamp) {
		this.id = id;
		this.userId = userId;
		this.content = content;
		this.imageUrls = imageUrls;
		this.videoUrls = videoUrls;
		this.timestamp = timestamp;
		this.likes = new ArrayList<>();
		this.comments = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public String getUserId() {
		return userId;
	}

	public String getContent() {
		return content;
	}

	public List<String> getImageUrls() {
		return imageUrls;
	}

	public List<String> getVideoUrls() {
		return videoUrls;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public List<String> getLikes() {
		return likes;
	}

	public List<Comment> getComments() {
		return comments;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", userId=" + userId + ", content=" + content + ", imageUrls=" + imageUrls
				+ ", videoUrls=" + videoUrls + ", likes=" + likes + "]";
	}
}
