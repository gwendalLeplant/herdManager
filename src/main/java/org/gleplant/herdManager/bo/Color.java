package org.gleplant.herdManager.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonGetter;

@Entity
@Table(name = "color")
public class Color {

	@Id
	@Column(name = "color_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer colorId;
	@Column(name = "colorName")
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
