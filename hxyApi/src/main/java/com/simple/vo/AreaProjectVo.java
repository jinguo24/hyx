package com.simple.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Transient;

public class AreaProjectVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3803914034214386844L;

	private String Name;
	
	private String id;
	
	@Transient
	private List<String> projectIds;
	
	public List<String> getProjectIds() {
		return projectIds;
	}
	public void setProjectIds(List<String> projectIds) {
		this.projectIds = projectIds;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
