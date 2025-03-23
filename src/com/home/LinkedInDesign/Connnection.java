package com.home.LinkedInDesign;

import java.sql.Timestamp;
import java.util.Date;

public class Connnection {

    private final User user;
    private final Timestamp connectionDate;
    ConnectionStatus status;
    
	public Connnection(User user) {
		super();
		this.user = user;
		this.connectionDate = new Timestamp(System.currentTimeMillis());
		this.status = ConnectionStatus.PENDING;
	}

	public ConnectionStatus getStatus() {
		return status;
	}

	public void setStatus(ConnectionStatus status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public Timestamp getConnectionDate() {
		return connectionDate;
	}
}
