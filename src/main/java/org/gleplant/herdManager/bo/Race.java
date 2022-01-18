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
@Table(name = "race")
public class Race {

	@Id
	@Column(name = "race_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer raceId;
	@Column(name = "raceName")
	private String name;

}
