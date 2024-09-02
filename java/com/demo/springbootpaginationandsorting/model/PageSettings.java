package com.demo.springbootpaginationandsorting.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;

@Slf4j
@Data
public class PageSettings {

    private int page = 0;

    private int elementPerPage = 2;

    private String direction = "dsc";

    private String key="name";
    
    

    public int getPage() {
		return page;
	}



	public void setPage(int page) {
		this.page = page;
	}



	public int getElementPerPage() {
		return elementPerPage;
	}



	public void setElementPerPage(int elementPerPage) {
		this.elementPerPage = elementPerPage;
	}



	public String getDirection() {
		return direction;
	}



	public void setDirection(String direction) {
		this.direction = direction;
	}



	public String getKey() {
		return key;
	}



	public void setKey(String key) {
		this.key = key;
	}



	public Sort buildSort() {
        switch (direction) {
            case "dsc":
                return Sort.by(key).descending();
            case "asc":
                return Sort.by(key).ascending();
            default:
               
                return Sort.by(key).descending();
        }
    }
}
