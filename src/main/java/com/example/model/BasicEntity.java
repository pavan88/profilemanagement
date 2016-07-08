/**
 * 
 */
package com.example.model;

import org.springframework.data.annotation.Id;

/**
 * @author PAVAN
 *
 */
public abstract class BasicEntity {

	@Id
	private String id;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
}
