package com.simple.vo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Transient;

import com.simple.domain.po.AreaProject;

public class AreaProjectVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3803914034214386844L;

	private String Name;
	
	private String id;
	
	@Transient
	private List<AreaProject> areaProjects;
	
	public List<AreaProject> getAreaProjects() {
		return areaProjects;
	}
	public void setAreaProjects(List<AreaProject> areaProjects) {
		this.areaProjects = areaProjects;
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
