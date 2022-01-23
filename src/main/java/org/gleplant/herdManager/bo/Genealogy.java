package org.gleplant.herdManager.bo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Genealogy {
	private Sheep mother;
	private Sheep father;
}
