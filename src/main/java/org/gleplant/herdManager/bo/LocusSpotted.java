package org.gleplant.herdManager.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "locus_spotted")
public class LocusSpotted {

	@Column(name = "allele_name")
	private Integer alleleName;
	@Id
	@Column(name = "locus_spotted_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer locusSpottedId;

}
