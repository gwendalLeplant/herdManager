package org.gleplant.herdManager.bo;

import com.fasterxml.jackson.annotation.JsonGetter;

public class Color {

	private Integer colorId;
	private String name;

	/**
	 * 
	 */
	public Color() {
	}

	/**
	 * @param colorId
	 * @param name
	 */
	public Color(Integer colorId, String name) {
		this.colorId = colorId;
		this.name = name;
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
		return "Color [colorId=" + colorId + ", name=" + name + "]";
	}

}
