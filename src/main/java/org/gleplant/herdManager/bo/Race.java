package org.gleplant.herdManager.bo;

import com.fasterxml.jackson.annotation.JsonGetter;

public class Race {

	private Integer raceId;
	private String name;

	/**
	 * 
	 */
	public Race() {
	}

	/**
	 * @param raceId
	 * @param name
	 */
	public Race(Integer raceId, String name) {
		this.raceId = raceId;
		this.name = name;
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

	@Override
	public String toString() {
		return "Race [raceId=" + raceId + ", name=" + name + "]";
	}

}
