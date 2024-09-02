package com.demo.springbootpaginationandsorting.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="plantcollection")
public class PlantCollection {
	
	private String id;
	private String name;
	private String scientificName;
	private String family;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getScientificName() {
		return scientificName;
	}
	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	
	

}
