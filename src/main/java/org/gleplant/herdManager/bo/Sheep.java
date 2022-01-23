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

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sheep")
public class Sheep {

	@ManyToOne
	@JoinColumn(name = "color_id", foreignKey = @ForeignKey(name = "sheep_FK_1"))
	private Color color;
	@ManyToOne
	@JoinColumn(name = "race_id", foreignKey = @ForeignKey(name = "sheep_FK"))
	private Race race;
	private Integer gender;
	@Column(name = "birth_date")
	private String birthDate;
	private String comments;
	@Column(name = "nom")
	private String name;
	@Column(name = "registration_number")
	private String registrationNumber;
	@Column(name = "mother_registration_number")
	private String motherRegistrationNumber;
	@Column(name = "father_registration_number")
	private String fatherRegistrationNumber;
	@Column(name = "photo_number")
	private Integer photoNumber;
	@Column(name = "photo_name")
	@Getter(AccessLevel.NONE)
	private String photoName;
	@Column(name = "firstname")
	private String alias;
	@Column(name = "birth_year")
	private Integer birthYear;
	@Column(name = "death_date")
	private String deathDate;
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

	public String getPhotoName() {
		String res = null;
		if(this.photoName==null) {
			if(this.photoNumber==null) {
				return null;
			}else {
				String[] extension = {"JPG","jpg","bmp"};
				String path = "../../../../images/"+this.photoNumber+"-0.";
				for(String ext : extension) {
					if(getClass().getResource(path+ext)!=null) {
						String[] reslist = getClass().getResource(path+ext).getPath().split("/");
						res = reslist[reslist.length-1];
						break;
					}
				}				
			}
		}else {
			res = this.photoName;
		}
		return res;
	}
}
