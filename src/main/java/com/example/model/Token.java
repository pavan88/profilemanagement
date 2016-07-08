package com.example.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Token extends BasicEntity {

	private String token;

	private Date tokenExpiryTime;

	/**
	 * @return the tokenExpiryTime
	 */
	public Date getTokenExpiryTime() {
		return tokenExpiryTime;
	}

	/**
	 * @param tokenExpiryTime
	 *            the tokenExpiryTime to set
	 */
	public void setTokenExpiryTime(Date tokenExpiryTime) {
		this.tokenExpiryTime = tokenExpiryTime;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token
	 *            the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

}
