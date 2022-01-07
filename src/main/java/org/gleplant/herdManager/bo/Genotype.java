package org.gleplant.herdManager.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonGetter;

@Entity
@Table(name = "genotype")
public class Genotype {

	@ManyToOne
	@JoinColumn(name = "locus_spotted_1_id", foreignKey = @ForeignKey(name = "gentoype_FK_6"))
	private LocusSpotted locusSpotted1Id;
	@ManyToOne
	@JoinColumn(name = "locus_spotted_2_id", foreignKey = @ForeignKey(name = "gentoype_FK_7"))
	private LocusSpotted locusSpotted2Id;
	@ManyToOne
	@JoinColumn(name = "locus_brown_1_id", foreignKey = @ForeignKey(name = "gentoype_FK_2"))
	private LocusBrown locusBrown1Id;
	@ManyToOne
	@JoinColumn(name = "locus_brown_2_id", foreignKey = @ForeignKey(name = "gentoype_FK_3"))
	private LocusBrown locusBrown2Id;
	@ManyToOne
	@JoinColumn(name = "locus_agouti_1_id", foreignKey = @ForeignKey(name = "gentoype_FK"))
	private LocusAgouti locusAgouti1Id;
	@ManyToOne
	@JoinColumn(name = "locus_agouti_2_id", foreignKey = @ForeignKey(name = "gentoype_FK_1"))
	private LocusAgouti locusAgouti2Id;
	@ManyToOne
	@JoinColumn(name = "locus_faded_1_id", foreignKey = @ForeignKey(name = "gentoype_FK_4"))
	private LocusFaded locusFaded1Id;
	@ManyToOne
	@JoinColumn(name = "locus_faded_2_id", foreignKey = @ForeignKey(name = "gentoype_FK_5"))
	private LocusFaded locusFaded2Id;
	@Id
	@Column(name = "genotype_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer genotypeId;

	/**
	 * 
	 */
	public Genotype() {
	}

	/**
	 * @return the locusSpotted1Id
	 */
	@JsonGetter("locusSpotted1Id")
	public LocusSpotted getLocusSpotted1Id() {
		return locusSpotted1Id;
	}

	/**
	 * @param locusSpotted1Id the locusSpotted1Id to set
	 */
	public void setLocusSpotted1Id(LocusSpotted locusSpotted1Id) {
		this.locusSpotted1Id = locusSpotted1Id;
	}

	/**
	 * @return the locusSpotted2Id
	 */
	@JsonGetter("locusSpotted2Id")
	public LocusSpotted getLocusSpotted2Id() {
		return locusSpotted2Id;
	}

	/**
	 * @param locusSpotted2Id the locusSpotted2Id to set
	 */
	public void setLocusSpotted2Id(LocusSpotted locusSpotted2Id) {
		this.locusSpotted2Id = locusSpotted2Id;
	}

	/**
	 * @return the locusBrown1Id
	 */
	@JsonGetter("locusBrown1Id")
	public LocusBrown getLocusBrown1Id() {
		return locusBrown1Id;
	}

	/**
	 * @param locusBrown1Id the locusBrown1Id to set
	 */
	public void setLocusBrown1Id(LocusBrown locusBrown1Id) {
		this.locusBrown1Id = locusBrown1Id;
	}

	/**
	 * @return the locusBrown2Id
	 */
	@JsonGetter("locusBrown2Id")
	public LocusBrown getLocusBrown2Id() {
		return locusBrown2Id;
	}

	/**
	 * @param locusBrown2Id the locusBrown2Id to set
	 */
	public void setLocusBrown2Id(LocusBrown locusBrown2Id) {
		this.locusBrown2Id = locusBrown2Id;
	}

	/**
	 * @return the locusAgouti1Id
	 */
	@JsonGetter("locusAgouti1Id")
	public LocusAgouti getLocusAgouti1Id() {
		return locusAgouti1Id;
	}

	/**
	 * @param locusAgouti1Id the locusAgouti1Id to set
	 */
	public void setLocusAgouti1Id(LocusAgouti locusAgouti1Id) {
		this.locusAgouti1Id = locusAgouti1Id;
	}

	/**
	 * @return the locusAgouti2Id
	 */
	@JsonGetter("locusAgouti2Id")
	public LocusAgouti getLocusAgouti2Id() {
		return locusAgouti2Id;
	}

	/**
	 * @param locusAgouti2Id the locusAgouti2Id to set
	 */
	public void setLocusAgouti2Id(LocusAgouti locusAgouti2Id) {
		this.locusAgouti2Id = locusAgouti2Id;
	}

	/**
	 * @return the locusFaded1Id
	 */
	@JsonGetter("locusFaded1Id")
	public LocusFaded getLocusFaded1Id() {
		return locusFaded1Id;
	}

	/**
	 * @param locusFaded1Id the locusFaded1Id to set
	 */
	public void setLocusFaded1Id(LocusFaded locusFaded1Id) {
		this.locusFaded1Id = locusFaded1Id;
	}

	/**
	 * @return the locusFaded2Id
	 */
	@JsonGetter("locusFaded2Id")
	public LocusFaded getLocusFaded2Id() {
		return locusFaded2Id;
	}

	/**
	 * @param locusFaded2Id the locusFaded2Id to set
	 */
	public void setLocusFaded2Id(LocusFaded locusFaded2Id) {
		this.locusFaded2Id = locusFaded2Id;
	}

	/**
	 * @return the genotypeId
	 */
	@JsonGetter("genotypeId")
	public Integer getGenotypeId() {
		return genotypeId;
	}

	/**
	 * @param genotypeId the genotypeId to set
	 */
	public void setGenotypeId(Integer genotypeId) {
		this.genotypeId = genotypeId;
	}

	@Override
	public String toString() {
		return "Genotype [locusSpotted1Id=" + locusSpotted1Id + ", locusSpotted2Id=" + locusSpotted2Id
				+ ", locusBrown1Id=" + locusBrown1Id + ", locusBrown2Id=" + locusBrown2Id + ", locusAgouti1Id="
				+ locusAgouti1Id + ", locusAgouti2Id=" + locusAgouti2Id + ", locusFaded1Id=" + locusFaded1Id
				+ ", locusFaded2Id=" + locusFaded2Id + ", genotypeId=" + genotypeId + "]";
	}

}
