package com.baicimi.bean;

import java.util.List;

public class Categories {
	public String icon_url;
	public String name;
	public int id;	
	public int order;
	public List<Subcategories> subcategories;
	
	public static class Subcategories{
		public String icon_url;
		public String name;
		public int id;	
		public int order;
		public String parent_id;
		public int items_count;
		
	}

	public String getIcon_url() {
		return icon_url;
	}

	public void setIcon_url(String icon_url) {
		this.icon_url = icon_url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public List<Subcategories> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(List<Subcategories> subcategories) {
		this.subcategories = subcategories;
	}
	
	

}
