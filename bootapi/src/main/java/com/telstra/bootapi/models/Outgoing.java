package com.telstra.bootapi.models;

import org.springframework.data.annotation.Id;

public class Outgoing {
	@Id
	private int _id;
	private int largestInArray;
	private String dupInString;
	private String removeWhtSpaceString;
	
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public int getLargestInArray() {
		return largestInArray;
	}
	public void setLargestInArray(int largestInArray) {
		this.largestInArray = largestInArray;
	}
	public String getDupInString() {
		return dupInString;
	}
	public void setDupInString(String dupInString) {
		this.dupInString = dupInString;
	}
	public String getRemoveWhtSpaceString() {
		return removeWhtSpaceString;
	}
	public void setRemoveWhtSpaceString(String removeWhtSpaceString) {
		this.removeWhtSpaceString = removeWhtSpaceString;
	}
	
	
	
}
