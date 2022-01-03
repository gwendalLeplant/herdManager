package org.gleplant.herdManager.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonGetter;

@Entity
@Table(name = "locus_brown")
public class LocusBrown {

	private Integer alleleName;
	@Id
	@Column(name = "locus_brown_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer locusBrownId;

	/**
	 * 
	 */
	public LocusBrown() {
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
	 * @return the locusBrownId
	 */
	@JsonGetter("locusBrownId")
	public Integer getLocusBrownId() {
		return locusBrownId;
	}

	/**
	 * @param locusBrownId the locusBrownId to set
	 */
	public void setLocusBrownId(Integer locusBrownId) {
		this.locusBrownId = locusBrownId;
	}

	@Override
	public String toString() {
		return "LocusBrown [alleleName=" + alleleName + ", locusBrownId=" + locusBrownId + "]";
	}

}
