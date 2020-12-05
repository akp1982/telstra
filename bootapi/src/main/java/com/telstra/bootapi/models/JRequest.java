package com.telstra.bootapi.models;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "incoming")
public class JRequest {
	@Id
	private int _id;
	private int id;
	private String findDuplicates;
	private String whiteSpacesGalore;
	private String validateMeOnlyIActuallyShouldBeABoolean;
	private int[] numbersMeetNumbers;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}
	public String getFindDuplicates() {
		return findDuplicates;
	}
	public void setFindDuplicates(String findDuplicates) {
		this.findDuplicates = findDuplicates;
	}
	public String getWhiteSpacesGalore() {
		return whiteSpacesGalore;
	}
	public void setWhiteSpacesGalore(String whiteSpacesGalore) {
		this.whiteSpacesGalore = whiteSpacesGalore;
	}
	public String getValidateMeOnlyIActuallyShouldBeABoolean() {
		return validateMeOnlyIActuallyShouldBeABoolean;
	}
	public void setValidateMeOnlyIActuallyShouldBeABoolean(String validateMeOnlyIActuallyShouldBeABoolean) {
		this.validateMeOnlyIActuallyShouldBeABoolean = validateMeOnlyIActuallyShouldBeABoolean;
	}
	public int[] getNumbersMeetNumbers() {
		return numbersMeetNumbers;
	}
	public void setNumbersMeetNumbers(int[] numbersMeetNumbers) {
		this.numbersMeetNumbers = numbersMeetNumbers;
	}
	@Override
	public String toString() {
		return "JRequest [_id=" + _id + ", id=" + id + ", findDuplicates=" + findDuplicates + ", whiteSpacesGalore="
				+ whiteSpacesGalore + ", validateMeOnlyIActuallyShouldBeABoolean="
				+ validateMeOnlyIActuallyShouldBeABoolean + ", numbersMeetNumbers="
				+ Arrays.toString(numbersMeetNumbers) + "]";
	}
	
	
	
	

}
