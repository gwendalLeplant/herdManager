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
@Table(name = "locus_brown")
public class LocusBrown {

	@Column(name = "allele_name")
	private String alleleName;
	@Id
	@Column(name = "locus_brown_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer locusBrownId;
}
