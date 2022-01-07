package org.gleplant.herdManager.bo;

import java.time.LocalDateTime;

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
@Table(name = "sheep")
public class Sheep {

	@ManyToOne
	@JoinColumn(name = "color_id", foreignKey = @ForeignKey(name = "sheep_FK_1"))
	private Color color;
	@ManyToOne
	@JoinColumn(name = "race_id", foreignKey = @ForeignKey(name = "sheep_FK"))
	private Race race;
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
	private LocalDateTime deathDate;
	@ManyToOne
	@JoinColumn(name = "breeder_id", foreignKey = @ForeignKey(name = "sheep_FK_2"))
	private Person breeder;
	@ManyToOne
	@JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "sheep_FK_3"))
	private Person owner;
	@ManyToOne
	@JoinColumn(name = "genotype_id", foreignKey = @ForeignKey(name = "sheep_FK_4"))
	private Genotype genotype;
	@ManyToOne
	@JoinColumn(name = "carrier_of", foreignKey = @ForeignKey(name = "sheep_FK_5"))
	private Color carrierOf;
	@Id
	@Column(name = "sheep_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sheepId;

	/**
	 * 
	 */
	public Sheep() {
	}

	/**
	 * @return the carrierOf
	 */
	@JsonGetter("carrierOf")
	public Color getCarrierOf() {
		return carrierOf;
	}

	/**
	 * @param carrierOf the carrierOf to set
	 */
	public void setCarrierOf(Color carrierOf) {
		this.carrierOf = carrierOf;
	}

	/**
	 * @return the deathDate
	 */
	@JsonGetter("deathDate")
	public LocalDateTime getDeathDate() {
		return deathDate;
	}

	/**
	 * @param deathDate the deathDate to set
	 */
	public void setDeathDate(LocalDateTime deathDate) {
		this.deathDate = deathDate;
	}

	/**
	 * @return the breeder
	 */
	@JsonGetter("breeder")
	public Person getBreeder() {
		return breeder;
	}

	/**
	 * @param breeder the breeder to set
	 */
	public void setBreeder(Person breeder) {
		this.breeder = breeder;
	}

	/**
	 * @return the owner
	 */
	@JsonGetter("owner")
	public Person getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(Person owner) {
		this.owner = owner;
	}

	/**
	 * @return the genotype
	 */
	@JsonGetter("genotype")
	public Genotype getGenotype() {
		return genotype;
	}

	/**
	 * @param genotype the genotype to set
	 */
	public void setGenotype(Genotype genotype) {
		this.genotype = genotype;
	}

	/**
	 * @return the color
	 */
	@JsonGetter("color")
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * @return the race
	 */
	@JsonGetter("race")
	public Race getRace() {
		return race;
	}

	/**
	 * @param race the race to set
	 */
	public void setRace(Race race) {
		this.race = race;
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
		return "Sheep [color=" + color + ", race=" + race + ", gender=" + gender + ", birthDate=" + birthDate
				+ ", comments=" + comments + ", name=" + name + ", registationNumber=" + registationNumber
				+ ", motherRegistrationNumber=" + motherRegistrationNumber + ", fatherRegistrationNumber="
				+ fatherRegistrationNumber + ", photoNumber=" + photoNumber + ", alias=" + alias + ", birthYear="
				+ birthYear + ", deathDate=" + deathDate + ", breeder=" + breeder + ", owner=" + owner + ", genotype="
				+ genotype + ", carrierOf=" + carrierOf + ", sheepId=" + sheepId + "]";
	}

}
