package org.gleplant.herdManager.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonGetter;

@Entity
@Table(name = "locus_agouti")
public class LocusAgouti {

	private Integer alleleName;
	@Id
	@Column(name = "locus_agouti_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer locusAgoutId;

	/**
	 * 
	 */
	public LocusAgouti() {
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
	 * @return the locusAgoutId
	 */
	@JsonGetter("locusAgoutId")
	public Integer getLocusAgoutId() {
		return locusAgoutId;
	}

	/**
	 * @param locusAgoutId the locusAgoutId to set
	 */
	public void setLocusAgoutId(Integer locusAgoutId) {
		this.locusAgoutId = locusAgoutId;
	}

	@Override
	public String toString() {
		return "LocusAgouti [alleleName=" + alleleName + ", locusAgoutId=" + locusAgoutId + "]";
	}

}
