package org.gleplant.herdManager.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonGetter;

@Entity
@Table(name = "locus_spotted")
public class LocusSpotted {

	private Integer alleleName;
	@Id
	@Column(name = "locus_spotted_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer locusSpottedId;

	/**
	 * 
	 */
	public LocusSpotted() {
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
	 * @return the locusSpottedId
	 */
	@JsonGetter("locusSpottedId")
	public Integer getLocusSpottedId() {
		return locusSpottedId;
	}

	/**
	 * @param locusSpottedId the locusSpottedId to set
	 */
	public void setLocusSpottedId(Integer locusSpottedId) {
		this.locusSpottedId = locusSpottedId;
	}

	@Override
	public String toString() {
		return "LocusSpotted [alleleName=" + alleleName + ", locusSpottedId=" + locusSpottedId + "]";
	}

}
