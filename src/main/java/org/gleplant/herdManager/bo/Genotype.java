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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
