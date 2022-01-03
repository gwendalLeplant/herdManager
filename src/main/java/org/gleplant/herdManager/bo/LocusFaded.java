package org.gleplant.herdManager.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonGetter;

@Entity
@Table(name = "locus_faded")
public class LocusFaded {

	private Integer alleleName;
	@Id
	@Column(name = "locus_faded_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer locusFadedId;

	/**
	 * 
	 */
	public LocusFaded() {
	}

	/**
	 * @return the alleleName
	 */
	@JsonGetter("alleleName")
	public Integer getAlleleName() {
		return alleleName;
	}

	/**
	 * @param alleleName the alleleName to set
	 */
	public void setAlleleName(Integer alleleName) {
		this.alleleName = alleleName;
	}

	/**
	 * @return the locusFadedId
	 */
	@JsonGetter("locusFadedId")
	public Integer getLocusFadedId() {
		return locusFadedId;
	}

	/**
	 * @param locusFadedId the locusFadedId to set
	 */
	public void setLocusFadedId(Integer locusFadedId) {
		this.locusFadedId = locusFadedId;
	}

	@Override
	public String toString() {
		return "LocusFaded [alleleName=" + alleleName + ", locusFadedId=" + locusFadedId + "]";
	}

}
