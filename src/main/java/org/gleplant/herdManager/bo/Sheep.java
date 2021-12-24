package org.gleplant.herdManager.bo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonGetter;

public class Sheep {

	private Integer colorId;
	private Integer raceId;
	private Integer gender;
	private LocalDateTime birthDate;
	private String comments;
	private String name;
	private String registationNumber;
	private String motherRegistrationNumber;
	private String fatherRegistrationNumber;
	private Integer photoNumber;
	private String alias;
	private Integer birthYear;
	private Integer sheepId;

	/**
	 * 
	 */
	public Sheep() {
	}

	/**
	 * @param colorId
	 * @param raceId
	 * @param gender
	 * @param birthDate
	 * @param comments
	 * @param name
	 * @param registationNumber
	 * @param motherRegistrationNumber
	 * @param fatherRegistrationNumber
	 * @param photoNumber
	 * @param alias
	 * @param birthYear
	 */
	public Sheep(Integer colorId, Integer raceId, Integer gender, LocalDateTime birthDate, String comments, String name,
			String registationNumber, String motherRegistrationNumber, String fatherRegistrationNumber,
			Integer photoNumber, String alias, Integer birthYear) {
		this.colorId = colorId;
		this.raceId = raceId;
		this.gender = gender;
		this.birthDate = birthDate;
		this.comments = comments;
		this.name = name;
		this.registationNumber = registationNumber;
		this.motherRegistrationNumber = motherRegistrationNumber;
		this.fatherRegistrationNumber = fatherRegistrationNumber;
		this.photoNumber = photoNumber;
		this.alias = alias;
		this.birthYear = birthYear;
	}

	/**
	 * @param colorId
	 * @param raceId
	 * @param gender
	 * @param birthDate
	 * @param comments
	 * @param name
	 * @param registationNumber
	 * @param motherRegistrationNumber
	 * @param fatherRegistrationNumber
	 * @param photoNumber
	 * @param alias
	 * @param birthYear
	 * @param sheepId
	 */
	public Sheep(Integer colorId, Integer raceId, Integer gender, LocalDateTime birthDate, String comments, String name,
			String registationNumber, String motherRegistrationNumber, String fatherRegistrationNumber,
			Integer photoNumber, String alias, Integer birthYear, Integer sheepId) {
		this.colorId = colorId;
		this.raceId = raceId;
		this.gender = gender;
		this.birthDate = birthDate;
		this.comments = comments;
		this.name = name;
		this.registationNumber = registationNumber;
		this.motherRegistrationNumber = motherRegistrationNumber;
		this.fatherRegistrationNumber = fatherRegistrationNumber;
		this.photoNumber = photoNumber;
		this.alias = alias;
		this.birthYear = birthYear;
		this.sheepId = sheepId;
	}

	/**
	 * @return the colorId
	 */
	@JsonGetter("colorId")
	public Integer getColorId() {
		return colorId;
	}

	/**
	 * @param colorId the colorId to set
	 */
	public void setColorId(Integer colorId) {
		this.colorId = colorId;
	}

	/**
	 * @return the raceId
	 */
	@JsonGetter("raceId")
	public Integer getRaceId() {
		return raceId;
	}

	/**
	 * @param raceId the raceId to set
	 */
	public void setRaceId(Integer raceId) {
		this.raceId = raceId;
	}

	/**
	 * @return the gender
	 */
	@JsonGetter("gender")
	public Integer getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(Integer gender) {
		this.gender = gender;
	}

	/**
	 * @return the birthDate
	 */
	@JsonGetter("birthDate")
	public LocalDateTime getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(LocalDateTime birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the comments
	 */
	@JsonGetter("comments")
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * @return the name
	 */
	@JsonGetter("name")
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the registationNumber
	 */
	@JsonGetter("registationNumber")
	public String getRegistationNumber() {
		return registationNumber;
	}

	/**
	 * @param registationNumber the registationNumber to set
	 */
	public void setRegistationNumber(String registationNumber) {
		this.registationNumber = registationNumber;
	}

	/**
	 * @return the motherRegistrationNumber
	 */
	@JsonGetter("motherRegistrationNumber")
	public String getMotherRegistrationNumber() {
		return motherRegistrationNumber;
	}

	/**
	 * @param motherRegistrationNumber the motherRegistrationNumber to set
	 */
	public void setMotherRegistrationNumber(String motherRegistrationNumber) {
		this.motherRegistrationNumber = motherRegistrationNumber;
	}

	/**
	 * @return the fatherRegistrationNumber
	 */
	@JsonGetter("fatherRegistrationNumber")
	public String getFatherRegistrationNumber() {
		return fatherRegistrationNumber;
	}

	/**
	 * @param fatherRegistrationNumber the fatherRegistrationNumber to set
	 */
	public void setFatherRegistrationNumber(String fatherRegistrationNumber) {
		this.fatherRegistrationNumber = fatherRegistrationNumber;
	}

	/**
	 * @return the photoNumber
	 */
	@JsonGetter("photoNumber")
	public Integer getPhotoNumber() {
		return photoNumber;
	}

	/**
	 * @param photoNumber the photoNumber to set
	 */
	public void setPhotoNumber(Integer photoNumber) {
		this.photoNumber = photoNumber;
	}

	/**
	 * @return the alias
	 */
	@JsonGetter("alias")
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * @return the birthYear
	 */
	@JsonGetter("birthYear")
	public Integer getBirthYear() {
		return birthYear;
	}

	/**
	 * @param birthYear the birthYear to set
	 */
	public void setBirthYear(Integer birthYear) {
		this.birthYear = birthYear;
	}

	/**
	 * @return the sheepId
	 */
	@JsonGetter("sheepId")
	public Integer getSheepId() {
		return sheepId;
	}

	/**
	 * @param sheepId the sheepId to set
	 */
	public void setSheepId(Integer sheepId) {
		this.sheepId = sheepId;
	}

	@Override
	public String toString() {
		return "Sheep [colorId=" + colorId + ", raceId=" + raceId + ", gender=" + gender + ", birthDate=" + birthDate
				+ ", comments=" + comments + ", name=" + name + ", registationNumber=" + registationNumber
				+ ", motherRegistrationNumber=" + motherRegistrationNumber + ", fatherRegistrationNumber="
				+ fatherRegistrationNumber + ", photoNumber=" + photoNumber + ", alias=" + alias + ", birthYear="
				+ birthYear + ", sheepId=" + sheepId + "]";
	}

}
